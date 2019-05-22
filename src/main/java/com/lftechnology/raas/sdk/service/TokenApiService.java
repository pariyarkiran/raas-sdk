package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Token;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface TokenApiService {

    @GET("senders/{senderId}/widget-token")
    Call<Token> get(@Path("senderId") UUID senderId);

}

