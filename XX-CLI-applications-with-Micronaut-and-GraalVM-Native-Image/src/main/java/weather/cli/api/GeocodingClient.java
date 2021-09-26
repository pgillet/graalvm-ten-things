package weather.cli.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;

@Client("${geocoding.api.url}")
public interface GeocodingClient {

    @Get
    GeocodingResponse getIPInfo(@PathVariable String ipAddress);

}