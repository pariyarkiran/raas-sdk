package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.FundingSource;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface FundingSourceApiService {

    @GET("senders/{senderId}/funding-sources/{bankId}")
    Call<FundingSource> get(@Path("senderId") UUID senderId, @Path("bankId") UUID bankId);

    @GET("senders/{senderId}/funding-sources")
    Call<ListResponse<FundingSource>> list(@Path("senderId") UUID senderId);

    @DELETE("senders/{senderId}/funding-sources/{bankId}")
    Call<Void> delete(@Path("senderId") UUID senderId, @Path("bankId") UUID bankId);
}

