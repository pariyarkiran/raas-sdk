package com.lftechnology.raas.sdk.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lftechnology.raas.sdk.util.ApiUtil;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class RequestApi {

    private String baseUrl;
    private Headers headers;

    public RequestApi(Map<String,String> headerMap){
        this.baseUrl = this.baseUrl = "https://qa.raas.lftechnology.com/v1/";
        this.headers = ApiUtil.buildHeader(headerMap);
    }

    public RequestApi(String baseUrl,Map<String,String> headerMap){
        this.baseUrl = baseUrl;
        this.headers = ApiUtil.buildHeader(headerMap);
    }

    public Retrofit getRetrofitObject(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .headers(headers);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        return new Retrofit
                .Builder()
                .baseUrl(this.baseUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
