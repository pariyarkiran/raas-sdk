package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.Token;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.service.TokenApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class TokenApi {

    private RequestApi requestApi;

    public TokenApi(String baseUrl,Map<String,String> headerMap){
        this.requestApi = new RequestApi(baseUrl,headerMap);
    }

    public Token getToken(UUID senderId) throws IOException{
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TokenApiService service = retrofit.create(TokenApiService.class);
        Call<Token> call = service.get(senderId);
        return executeApiCall(call);
    }

    private Token executeApiCall(Call<Token> call) {
        try {
            Response<Token> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
