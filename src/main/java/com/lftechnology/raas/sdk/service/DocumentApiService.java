package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Document;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

public interface DocumentApiService {

    @GET("senders/{senderId}/transactions/{transactionId}/invoice")
    Call<Document> get(@Path("senderId") UUID senderId, @Path("transactionId") UUID transactionId);
}
