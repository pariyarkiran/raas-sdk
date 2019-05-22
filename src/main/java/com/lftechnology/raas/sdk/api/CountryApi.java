package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Country;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.CountryApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class CountryApi {

    private RequestApi requestApi;

    public CountryApi(String baseUrl,Map<String,String> headerMap){
        this.requestApi = new RequestApi(baseUrl,headerMap);
    }

    public Country getById(String id) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        CountryApiService service = retrofit.create(CountryApiService.class);
        Call<Country> call = service.get(id);
        return executeApiCall(call);
    }

    public ListResponse<Country> list() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        CountryApiService service = retrofit.create(CountryApiService.class);
        Call<ListResponse<Country>> call = service.list();
        try {
            Response<ListResponse<Country>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    private Country executeApiCall(Call<Country> call) {
        try {
            Response<Country> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
