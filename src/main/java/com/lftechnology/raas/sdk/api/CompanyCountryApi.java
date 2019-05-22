package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.CompanyCountry;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.CompanyCountryApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class CompanyCountryApi {

    private RequestApi requestApi;

    public CompanyCountryApi(String baseUrl,Map<String,String> headerMap){
        this.requestApi = new RequestApi(baseUrl,headerMap);
    }

    public ListResponse<CompanyCountry> list() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        CompanyCountryApiService service = retrofit.create(CompanyCountryApiService.class);
        Call<ListResponse<CompanyCountry>> call = service.list();
        try {
            Response<ListResponse<CompanyCountry>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
