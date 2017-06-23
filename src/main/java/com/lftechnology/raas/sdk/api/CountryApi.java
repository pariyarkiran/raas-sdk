package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Country;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.restrofit.CountryApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class CountryApi {

    private RequestApi requestApi;

    public CountryApi(String baseUrl,Map<String,String> headerMap){
        this.requestApi = new RequestApi(baseUrl,headerMap);
    }

    public Country getById(String id) throws IOException{
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        CountryApiService service = retrofit.create(CountryApiService.class);
        Call<Country> call = service.get(id);
        Response<Country> response = call.execute();
        if(!response.isSuccessful()){
            throw new ApiException(response.errorBody().string());
        }
        return response.body();
    }

    public List<Country> list() throws IOException {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        CountryApiService service = retrofit.create(CountryApiService.class);
        Call<ListResponse<Country>> call = service.list();
        Response<ListResponse<Country>> response = call.execute();
        if(!response.isSuccessful()){
            throw new ApiException(response.errorBody().string());
        }
        return response.body().getResults();
    }
}
