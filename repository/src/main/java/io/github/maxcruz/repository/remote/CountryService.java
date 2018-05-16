package io.github.maxcruz.repository.remote;

import java.util.List;

import io.github.maxcruz.repository.remote.dto.Country;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Rest country service by ISO 4217 currency code.
 * https://restcountries.eu/#api-endpoints-currency
 */
public interface CountryService {

    String URL = "https://restcountries.eu/rest/v2/";

    @GET("currency/{code}")
    Observable<List<Country>> getCountry(@Path("code") String code);
}
