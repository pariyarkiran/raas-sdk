package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.ExchangeRate;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface ExchangeRateApiService {

    @GET("exchangerates")
    Call<ListResponse<ExchangeRate>> list();

    @POST("exchangerates")
    Call<ExchangeRate> create(@Body ExchangeRate exchangeRate);
}

