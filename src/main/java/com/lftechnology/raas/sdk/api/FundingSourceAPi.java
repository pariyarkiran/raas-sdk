package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.FundingSource;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.FundingSourceApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class FundingSourceAPi {

    private RequestApi requestApi;

    public FundingSourceAPi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public FundingSource getById(UUID senderId, UUID bankId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        FundingSourceApiService service = retrofit.create(FundingSourceApiService.class);
        Call<FundingSource> call = service.get(senderId,bankId);
        return executeApiCall(call);
    }

    public ListResponse<FundingSource> list(UUID senderId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        FundingSourceApiService service = retrofit.create(FundingSourceApiService.class);
        Call<ListResponse<FundingSource>> call = service.list(senderId);
        try {
            Response<ListResponse<FundingSource>> response = call.execute();
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
        FundingSourceApiService service = retrofit.create(FundingSourceApiService.class);
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

    private FundingSource executeApiCall(Call<FundingSource> call) {
        try {
            Response<FundingSource> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
