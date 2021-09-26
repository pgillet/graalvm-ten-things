package weather.cli.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${weather.api.url}")
public interface WeatherClient {
    @Get("/current?key=${weather.api.key}")
    WeatherResponse currentWeatherByLatLon(@QueryValue Double lat,
                                           @QueryValue Double lon);

    @Get("/current?key=${weather.api.key}")
    WeatherResponse currentWeatherByCityName(@QueryValue String city,
                                             @QueryValue String country);

    @Get("/forecast/daily?key=${weather.api.key}")
    ForecastResponse forecastByLatLon(@QueryValue Double lat,
                                      @QueryValue Double lon,
                                      @QueryValue(defaultValue = "1") int days);

    @Get("/forecast/daily?key=${weather.api.key}")
    ForecastResponse forecastByCityName(@QueryValue String city,
                                        @QueryValue String country,
                                        @QueryValue(defaultValue = "1") int days);
}
