package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.City;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.CityApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class CityApi {

    private RequestApi requestApi;

    public CityApi(String baseUrl, Map<String,String> headerMap){
        this.requestApi = new RequestApi(baseUrl,headerMap);
    }


    public ListResponse<City> list(Long countryId, Long stateId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        CityApiService service = retrofit.create(CityApiService.class);
        Call<ListResponse<City>> call = service.list(countryId, stateId);
        try {
            Response<ListResponse<City>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
