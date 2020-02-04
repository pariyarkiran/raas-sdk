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
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class RequestApi {

    private String baseUrl;
    private Headers headers;

    public RequestApi(Map<String,String> headerMap){
        this.baseUrl = "https://qa.raas.lftechnology.com/v1/";
        this.headers = ApiUtil.buildHeader(headerMap);
    }

    public RequestApi(String baseUrl,Map<String,String> headerMap){
        this.baseUrl = baseUrl;
        this.headers = ApiUtil.buildHeader(headerMap);
    }

    public Retrofit getRetrofitObject(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = getUnsafeOkHttpClient();
        httpClient.connectTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES);
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

        httpClient.addInterceptor(interceptor);

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

    public Retrofit getRetrofitObjectCIP(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = getUnsafeOkHttpClient();
        httpClient.connectTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES);
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

        httpClient.addInterceptor(interceptor);

        Gson gson = new GsonBuilder()
                .create();

        return new Retrofit
                .Builder()
                .baseUrl(this.baseUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    // TODO Need to refactor code : remove deprecated method and handle exception properly
    // Method for requesting server without ssl
    private OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws
                                CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
