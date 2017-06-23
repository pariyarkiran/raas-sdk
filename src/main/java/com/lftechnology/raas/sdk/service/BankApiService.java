package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Bank;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface BankApiService {

    @GET("banks/{id}")
    Call<Bank> get(@Path("id") String id);

    @GET("banks")
    Call<ListResponse<Bank>> list();
}

