package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Fee;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface FeeApiService {

    @GET("feesets")
    Call<ListResponse<Fee>> list();
}

