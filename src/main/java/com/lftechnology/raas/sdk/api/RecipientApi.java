package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Recipient;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.RecipientApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class RecipientApi {

    private RequestApi requestApi;

    public RecipientApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public Recipient getById(UUID senderId,UUID recipientId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientApiService service = retrofit.create(RecipientApiService.class);
        Call<Recipient> call = service.get(senderId,recipientId);
        return executeApiCall(call);
    }

    public ListResponse<Recipient> list(UUID senderId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientApiService service = retrofit.create(RecipientApiService.class);
        Call<ListResponse<Recipient>> call = service.list(senderId);
        try {
            Response<ListResponse<Recipient>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    public Recipient create(UUID senderId,Recipient recipient) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientApiService service = retrofit.create(RecipientApiService.class);
        Call<Recipient> call = service.create(senderId,recipient);
        return executeApiCall(call);
    }

    public Recipient update(UUID senderId,UUID recipientId,Recipient recipient) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientApiService service = retrofit.create(RecipientApiService.class);
        Call<Recipient> call = service.update(senderId,recipientId,recipient);
        return executeApiCall(call);
    }

    private Recipient executeApiCall(Call<Recipient> call) {
        try {
            Response<Recipient> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
