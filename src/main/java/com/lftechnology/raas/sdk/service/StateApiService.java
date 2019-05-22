package com.lftechnology.raas.sdk.service;

import com.lftechnology.raas.sdk.dto.State;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public interface StateApiService {

    @GET("states/{id}")
    Call<State> get(@Path("id") String id);

    @GET("states")
    Call<ListResponse<State>> list();
}

