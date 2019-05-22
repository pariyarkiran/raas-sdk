package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.RecipientBank;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface RecipientBankApiService {

    @GET("senders/{senderId}/recipients/{recipientId}/banks/{bankId}")
    Call<RecipientBank> get(@Path("senderId") UUID senderId, @Path("recipientId") UUID recipientId, @Path("bankId") UUID bankId);

    @GET("senders/{senderId}/recipients/{recipientId}/banks")
    Call<ListResponse<RecipientBank>> list(@Path("senderId") UUID senderId, @Path("recipientId") UUID recipientId);

    @POST("senders/{senderId}/recipients/{recipientId}/banks")
    Call<RecipientBank> create(@Path("senderId") UUID senderId,  @Path("recipientId") UUID recipientId,@Body RecipientBank recipientBank);

    @PUT("senders/{senderId}/recipients/{recipientId}/banks/{bankId}")
    Call<RecipientBank> update(@Path("senderId") UUID senderId, @Path("recipientId") UUID recipientId, @Path("bankId") UUID bankId, @Body RecipientBank recipientBank);
}

