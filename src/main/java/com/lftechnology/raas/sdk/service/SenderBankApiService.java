package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.SenderBank;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface SenderBankApiService {

    @GET("senders/{senderId}/banks/{bankId}")
    Call<SenderBank> get(@Path("senderId") UUID senderId, @Path("bankId") UUID bankId);

    @GET("senders/{senderId}/banks")
    Call<ListResponse<SenderBank>> list(@Path("senderId") UUID senderId);

    @DELETE("senders/{senderId}/banks/{bankId}")
    Call<Void> delete(@Path("senderId") UUID senderId, @Path("bankId") UUID bankId);
}

