package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Sender;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.SenderApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class SenderApi {

    private RequestApi requestApi;

    public SenderApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public Sender getById(UUID id) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        SenderApiService service = retrofit.create(SenderApiService.class);
        Call<Sender> call = service.get(id);
        return executeApiCall(call);
    }

    public ListResponse<Sender> list() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        SenderApiService service = retrofit.create(SenderApiService.class);
        Call<ListResponse<Sender>> call = service.list();
        try {
            Response<ListResponse<Sender>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    public Sender create(Sender sender) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        SenderApiService service = retrofit.create(SenderApiService.class);
        Call<Sender> call = service.create(sender);
        return executeApiCall(call);
    }

    private Sender executeApiCall(Call<Sender> call) {
        try {
            Response<Sender> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
