package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Transaction;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface TransactionApiService {

    @GET("senders/{senderId}/transactions/{transactionId}")
    Call<Transaction> get(@Path("senderId") UUID senderId, @Path("transactionId") UUID transactionId);

    @GET("senders/{senderId}/transactions")
    Call<ListResponse<Transaction>> listBySender(@Path("senderId") UUID senderId);

    @GET("transactions")
    Call<ListResponse<Transaction>> listAll();

    @POST("senders/{senderId}/transactions")
    Call<Transaction> create(@Path("senderId") UUID senderId, @Body Transaction transaction);

    @DELETE("senders/{senderId}/transactions/{transactionId}")
    Call<Void> delete(@Path("senderId") UUID senderId, @Path("transactionId") UUID transactionId);
}

