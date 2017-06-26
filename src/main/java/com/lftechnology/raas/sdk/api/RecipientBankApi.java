package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.RecipientBank;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.RecipientBankApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class RecipientBankApi {

    private RequestApi requestApi;

    public RecipientBankApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public RecipientBank getById(UUID senderId,UUID recipientId,UUID bankId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientBankApiService service = retrofit.create(RecipientBankApiService.class);
        Call<RecipientBank> call = service.get(senderId,recipientId,bankId);
        return executeApiCall(call);
    }

    public ListResponse<RecipientBank> list(UUID senderId,UUID recipientId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientBankApiService service = retrofit.create(RecipientBankApiService.class);
        Call<ListResponse<RecipientBank>> call = service.list(senderId,recipientId);
        try {
            Response<ListResponse<RecipientBank>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    public RecipientBank create(UUID senderId,UUID recipientId,RecipientBank recipientBank) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientBankApiService service = retrofit.create(RecipientBankApiService.class);
        Call<RecipientBank> call = service.create(senderId,recipientId,recipientBank);
        return executeApiCall(call);
    }

    public RecipientBank update(UUID senderId,UUID recipientId,UUID bankId,RecipientBank recipientBank) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        RecipientBankApiService service = retrofit.create(RecipientBankApiService.class);
        Call<RecipientBank> call = service.update(senderId,recipientId,bankId,recipientBank);
        return executeApiCall(call);
    }

    private RecipientBank executeApiCall(Call<RecipientBank> call) {
        try {
            Response<RecipientBank> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
