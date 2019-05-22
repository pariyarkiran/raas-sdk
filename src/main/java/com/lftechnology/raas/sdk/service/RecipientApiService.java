package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Recipient;
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
public interface RecipientApiService {

    @GET("senders/{senderId}/recipients/{recipientId}")
    Call<Recipient> get(@Path("senderId") UUID senderId, @Path("recipientId") UUID recipientId);

    @GET("senders/{senderId}/recipients")
    Call<ListResponse<Recipient>> list(@Path("senderId") UUID senderId);

    @POST("senders/{senderId}/recipients")
    Call<Recipient> create(@Path("senderId") UUID senderId, @Body Recipient recipient);

    @PUT("senders/{senderId}/recipients/{recipientId}")
    Call<Recipient> update(@Path("senderId") UUID senderId, @Path("recipientId") UUID recipientId, @Body Recipient recipient);
}

