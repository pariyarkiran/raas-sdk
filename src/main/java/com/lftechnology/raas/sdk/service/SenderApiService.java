package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.Sender;
import com.lftechnology.raas.sdk.dto.SenderWidget;
import com.lftechnology.raas.sdk.dto.SenderWidgetResponse;
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
public interface SenderApiService {

    @GET("senders/{id}")
    Call<Sender> get(@Path("id") UUID id);

    @GET("senders")
    Call<ListResponse<Sender>> list();

    @POST("senders")
    Call<Sender> create(@Body Sender sender);

    @PUT("senders/{id}/initiate-cip")
    Call<SenderWidgetResponse> cip(@Path("id")UUID id, @Body SenderWidget senderWidget);
}

