package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.SenderBank;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.SenderBankApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class SenderBankApi {

    private RequestApi requestApi;

    public SenderBankApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public SenderBank getById(UUID senderId,UUID bankId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        SenderBankApiService service = retrofit.create(SenderBankApiService.class);
        Call<SenderBank> call = service.get(senderId,bankId);
        return executeApiCall(call);
    }

    public ListResponse<SenderBank> list(UUID senderId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        SenderBankApiService service = retrofit.create(SenderBankApiService.class);
        Call<ListResponse<SenderBank>> call = service.list(senderId);
        try {
            Response<ListResponse<SenderBank>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    public void delete(UUID senderId,UUID bankId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        SenderBankApiService service = retrofit.create(SenderBankApiService.class);
        Call<Void> call = service.delete(senderId,bankId);
        try {
            Response<Void> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
        } catch (IOException e) {
            throw new ApiException("Could not delete Sender Bank. Error in Raas SDK.");
        }
    }

    private SenderBank executeApiCall(Call<SenderBank> call) {
        try {
            Response<SenderBank> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
