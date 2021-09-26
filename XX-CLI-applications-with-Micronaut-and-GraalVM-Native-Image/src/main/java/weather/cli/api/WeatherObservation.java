package weather.cli.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Introspected
public class WeatherObservation {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, d LLL");

    private String cityName;
    private String countryCode;
    private String stateCode;
    private LocalTime sunrise;
    private LocalTime sunset;
    private double windSpeed;
    private String windDirection;
    private double temperature;
    private double apparentTemperature;
    private double cloudCoverage;
    private double precipitation;
    private String weatherDescription;

    @JsonCreator
    public WeatherObservation(@JsonProperty("city_name") String cityName,
                              @JsonProperty("country_code") String countryCode,
                              @JsonProperty("state_code") String stateCode,
                              @JsonProperty("sunrise") String sunrise,
                              @JsonProperty("sunset") String sunset,
                              @JsonProperty("wind_spd") double windSpeed,
                              @JsonProperty("wind_cdir_full") String windDirection,
                              @JsonProperty("temp") double temperature,
                              @JsonProperty("app_temp") double apparentTemperature,
                              @JsonProperty("clouds") double cloudCoverage,
                              @JsonProperty("precip") double precipitation,
                              @JsonProperty("weather") Map<String, Object> weather) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.sunrise = LocalTime.parse(sunrise).plusHours(2); // TODO: Use OffsetTime instead?
        this.sunset = LocalTime.parse(sunset).plusHours(2);
        this.windSpeed = windSpeed * 3.6;
        this.windDirection = windDirection;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.cloudCoverage = cloudCoverage;
        this.precipitation = precipitation;
        this.weatherDescription = (String) weather.get("description");
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public double getCloudCoverage() {
        return cloudCoverage;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String toString() {
        return dateTimeFormatter.format(LocalDate.now()) + " at " + cityName + ", " + countryCode + "\n\"" +
                weatherDescription + "\"\n" +
                "Temp: " + temperature + "°C (felt " + apparentTemperature + " °C)\n" +
                "Wind: " + windSpeed + " km/h to " + windDirection + "\n" +
                "Cloud coverage: " + cloudCoverage + " %\n" +
                "Precip: " + precipitation + " mm/hr\n" +
                "Sunrise: " + sunrise + ", Sunset: " + sunset;
    }
}