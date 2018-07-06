package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.City;
import com.lftechnology.raas.sdk.dto.State;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface CityApiService {

    @GET("cities")
    Call<ListResponse<City>> list(@Query("countryId") Long countryId, @Query("stateId") Long stateId);
}

