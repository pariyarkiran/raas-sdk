package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.State;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.StateApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class StateApi {

    private RequestApi requestApi;

    public StateApi(String baseUrl,Map<String,String> headerMap){
        this.requestApi = new RequestApi(baseUrl,headerMap);
    }

    public State getById(String id) throws IOException{
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        StateApiService service = retrofit.create(StateApiService.class);
        Call<State> call = service.get(id);
        return executeApiCall(call);
    }

    public ListResponse<State> list() throws IOException {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        StateApiService service = retrofit.create(StateApiService.class);
        Call<ListResponse<State>> call = service.list();
        try {
            Response<ListResponse<State>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    private State executeApiCall(Call<State> call) {
        try {
            Response<State> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
