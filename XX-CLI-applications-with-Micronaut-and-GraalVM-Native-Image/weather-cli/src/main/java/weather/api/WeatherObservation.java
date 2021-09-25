package weather.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.util.Map;

@Introspected
public class WeatherObservation {

    private String cityName;
    private String countryCode;
    private String stateCode;
    private String sunrise;
    private String sunset;
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
        this.sunrise = sunrise;
        this.sunset = sunset;
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

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
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
        return cityName + ", " + countryCode + "\n\"" +
                weatherDescription + "\"\n" +
                "Temp: " + temperature + "°C (felt " + apparentTemperature + " °C)\n" +
                "Wind: " + windSpeed + " km/h to " + windDirection + "\n" +
                "Cloud coverage: " + cloudCoverage + " %\n" +
                "Precip: " + precipitation + " mm/hr\n" +
                "Sunrise: " + sunrise + ", Sunset: " + sunset;
    }
}