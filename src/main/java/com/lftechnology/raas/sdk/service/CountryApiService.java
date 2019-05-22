package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Country;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface CountryApiService {

    @GET("countries/{id}")
    Call<Country> get(@Path("id") String id);

    @GET("countries")
    Call<ListResponse<Country>> list();
}

