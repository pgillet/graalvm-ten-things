package weather.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.OptionSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParseResult;
import weather.cli.api.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.Set;

import static picocli.CommandLine.Help.Visibility.ALWAYS;
import static picocli.CommandLine.Help.Visibility.NEVER;

@Command(name = "weather", description = "Returns current or forecast weather conditions",
        mixinStandardHelpOptions = true)
public class WeatherCommand implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherCommand.class);

    @Inject
    private GeocodingClient geocodingClient;

    @Inject
    private WeatherClient weatherClient;

    @CommandLine.Spec
    protected CommandLine.Model.CommandSpec spec;

    private Integer nbDays;

    @Option(names = {"-f", "--forecast"},
            description = "Number of forecast days to fetch (between 1 and 16).",
            defaultValue = "1",
            showDefaultValue = NEVER)
    public void setForecast(int nbDays) {
        if (nbDays < 1 || nbDays > 16) {
            throw new CommandLine.ParameterException(
                    spec.commandLine(),
                    "Forecast must be between 1 and 16 days");
        }
        this.nbDays = nbDays;
    }

    @Option(names = {"--city"},
            description = "A city name. If not specified, the location is automatically detected.")
    private String city;

    private static final String DEFAULT_COUNTRY_CODE = "FR";
    private static final Set<String> ISO_COUNTRIES = Set.of(Locale.getISOCountries());

    private String country;

    @Option(names = {"--country"},
            description = "A 2-letter country code as defined in ISO 3166.",
            defaultValue = DEFAULT_COUNTRY_CODE,
            showDefaultValue = ALWAYS)
    public void setCountry(String country) {
        if (!ISO_COUNTRIES.contains(country)) {
            throw new CommandLine.ParameterException(
                    spec.commandLine(),
                    "Country parameter must be a 2-letter country code as defined in ISO 3166");
        }
        this.country = country;
    }

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(WeatherCommand.class, args);
    }

    public void run() {

        ParseResult pr = spec.commandLine().getParseResult();

        try {
            if (!pr.hasMatchedOption("--city")) {
                // Geocoding
                String ipAddress = getExternalIPAddress();

                GeocodingResponse geocodingResponse = geocodingClient.getIPInfo(ipAddress);
                city = geocodingResponse.getCity();
                country = geocodingResponse.getCountryCode();

                LOG.info("Location detected: {}, {}", city, country);
            }

            if (pr.hasMatchedOption("--forecast")) {
                // Forecast
                ForecastResponse forecastResponse = weatherClient.forecastByCityName(city, country, nbDays);
                System.out.println(forecastResponse);
            } else {
                // Current weather
                WeatherResponse weatherResponse = weatherClient.currentWeatherByCityName(city, country);
                weatherResponse.getData().stream().forEach(obs -> System.out.println(obs));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getExternalIPAddress() throws IOException {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        String ip = in.readLine();
        LOG.info("IP address is {}", ip);

        return ip;
    }

}
