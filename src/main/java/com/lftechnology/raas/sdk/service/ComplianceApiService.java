package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.TransactionLimit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface ComplianceApiService {

    @GET("senders/{senderId}/transaction-limit")
    Call<TransactionLimit> get(@Path("senderId") UUID senderId);
}
