package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Document;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.service.DocumentApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class DocumentApi {
    private RequestApi requestApi;

    public DocumentApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public Document getInvoiceLink(UUID senderId, UUID transactionId){
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        DocumentApiService service = retrofit.create(DocumentApiService.class);
        Call<Document> call = service.get(senderId,transactionId);
        return executeApiCall(call);
    }

    private Document executeApiCall(Call<Document> call) {
        try {
            Response<Document> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
