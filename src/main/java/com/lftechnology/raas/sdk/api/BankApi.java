package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Bank;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.BankApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class BankApi {

    private RequestApi requestApi;

    public BankApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public Bank getById(String id) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        BankApiService service = retrofit.create(BankApiService.class);
        Call<Bank> call = service.get(id);
        return executeApiCall(call);
    }

    public ListResponse<Bank> list() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        BankApiService service = retrofit.create(BankApiService.class);
        Call<ListResponse<Bank>> call = service.list();
        try {
            Response<ListResponse<Bank>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    private Bank executeApiCall(Call<Bank> call) {
        try {
            Response<Bank> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

}
