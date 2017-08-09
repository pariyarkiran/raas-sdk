package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Fee;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.FeeApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class FeeApi {

    private RequestApi requestApi;

    public FeeApi(String baseUrl,Map<String,String> headerMap){
        this.requestApi = new RequestApi(baseUrl,headerMap);
    }

    public ListResponse<Fee> list() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        FeeApiService service = retrofit.create(FeeApiService.class);
        Call<ListResponse<Fee>> call = service.list();
        try {
            Response<ListResponse<Fee>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    private Fee executeApiCall(Call<Fee> call) {
        try {
            Response<Fee> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
