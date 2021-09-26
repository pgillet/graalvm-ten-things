package weather.cli.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.util.List;
import java.util.stream.Collectors;

@Introspected
public class ForecastResponse {
    private String cityName;
    private String countryCode;
    private String stateCode;
    private List<ForecastObservation> data;

    public ForecastResponse(@JsonProperty("city_name") String cityName,
                            @JsonProperty("country_code") String countryCode,
                            @JsonProperty("state_code") String stateCode,
                            @JsonProperty("data") List<ForecastObservation> data) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.data = data;
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

    public List<ForecastObservation> getData() {
        return data;
    }

    @Override
    public String toString() {
        String header = data.size() + " Day Weather Forecast at " + cityName + ", " + countryCode + "\n";
        String forecasts = data.stream().map(Object::toString).collect(Collectors.joining("\n\n"));
        String result = String.join("\n", header, forecasts);

        return result;
    }
}
