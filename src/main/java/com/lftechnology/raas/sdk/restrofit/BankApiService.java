package com.lftechnology.raas.sdk.restrofit;

import com.lftechnology.raas.sdk.dto.Bank;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface BankApiService {

    @GET("banks/{id}")
    Call<Bank> get(@Path("id") String id);

    @GET("banks")
    Call<ListResponse<Bank>> list();
}

