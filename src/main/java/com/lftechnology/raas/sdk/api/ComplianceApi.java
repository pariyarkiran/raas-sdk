package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.TransactionLimit;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.service.ComplianceApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ComplianceApi {

    private RequestApi requestApi;

    public ComplianceApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public TransactionLimit getById(UUID senderId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        ComplianceApiService service = retrofit.create(ComplianceApiService.class);
        Call<TransactionLimit> call = service.get(senderId);
        return executeApiCall(call);
    }

    private TransactionLimit executeApiCall(Call<TransactionLimit> call) {
        try {
            Response<TransactionLimit> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
