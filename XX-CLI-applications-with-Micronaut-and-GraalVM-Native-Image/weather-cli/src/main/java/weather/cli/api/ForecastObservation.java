package weather.cli.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Introspected
public class ForecastObservation {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, d LLL");

    private LocalDate forecastDate;
    private double windSpeed;
    private String windDirection;
    private double avgTemparature;
    private double minTemperature;
    private double maxTemperature;
    private double precipitationProbability;
    private double avgCloudCoverage;
    private String weatherDescription;

    public ForecastObservation(@JsonProperty("valid_date") String forecastDate,
                               @JsonProperty("wind_spd") double windSpeed,
                               @JsonProperty("wind_cdir_full") String windDirection,
                               @JsonProperty("temp") double avgTemparature,
                               @JsonProperty("min_temp") double minTemperature,
                               @JsonProperty("max_temp") double maxTemperature,
                               @JsonProperty("pop") double precipitationProbability,
                               @JsonProperty("clouds") double avgCloudCoverage,
                               @JsonProperty("weather") Map<String, Object> weather) {
        this.forecastDate = LocalDate.parse(forecastDate);
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.avgTemparature = avgTemparature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.precipitationProbability = precipitationProbability;
        this.avgCloudCoverage = avgCloudCoverage;
        this.weatherDescription = (String) weather.get("description");
    }

    public LocalDate getForecastDate() {
        return forecastDate;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public double getAvgTemparature() {
        return avgTemparature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getPrecipitationProbability() {
        return precipitationProbability;
    }

    public double getAvgCloudCoverage() {
        return avgCloudCoverage;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String toString() {
        return dateTimeFormatter.format(forecastDate) + "\n\"" +
                weatherDescription + "\"\n" +
                "Avg temp: " + avgTemparature + "°C (Min " + minTemperature + " °C, Max " + maxTemperature + " °C)\n" +
                "Wind: " + windSpeed + " km/h to " + windDirection + "\n" +
                "Cloud coverage: " + avgCloudCoverage + " %\n" +
                "Probability of precipitation: " + precipitationProbability + " %";
    }
}
