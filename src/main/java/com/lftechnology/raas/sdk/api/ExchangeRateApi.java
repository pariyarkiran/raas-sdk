package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.ExchangeRate;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.ExchangeRateApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ExchangeRateApi {

    private RequestApi requestApi;

    public ExchangeRateApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public ListResponse<ExchangeRate> list() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        ExchangeRateApiService service = retrofit.create(ExchangeRateApiService.class);
        Call<ListResponse<ExchangeRate>> call = service.list();
        try {
            Response<ListResponse<ExchangeRate>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    public ExchangeRate create(ExchangeRate exchangeRate) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        ExchangeRateApiService service = retrofit.create(ExchangeRateApiService.class);
        Call<ExchangeRate> call = service.create(exchangeRate);
        return executeApiCall(call);
    }

    private ExchangeRate executeApiCall(Call<ExchangeRate> call) {
        try {
            Response<ExchangeRate> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
