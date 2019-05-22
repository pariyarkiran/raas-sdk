package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.dto.DeliveryRequest;
import com.lftechnology.raas.sdk.dto.Transaction;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.service.TransactionApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class TransactionApi {

    private RequestApi requestApi;

    public TransactionApi(String baseUrl, Map<String, String> headerMap) {
        this.requestApi = new RequestApi(baseUrl, headerMap);
    }

    public Transaction getById(UUID senderId,UUID transactionId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);
        Call<Transaction> call = service.get(senderId,transactionId);
        return executeApiCall(call);
    }

    public ListResponse<Transaction> listBySender(UUID senderId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);
        Call<ListResponse<Transaction>> call = service.listBySender(senderId);
        return executeListApiCall(call);
    }

    public ListResponse<Transaction> listAll() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);
        Call<ListResponse<Transaction>> call = service.listAll();
        return executeListApiCall(call);
    }

    public Transaction create(UUID senderId,Transaction transaction) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);
        Call<Transaction> call = service.create(senderId,transaction);
        return executeApiCall(call);
    }

    public void delete(UUID senderId,UUID transactionId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);
        Call<Void> call = service.delete(senderId,transactionId);
        try {
            Response<Void> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
        } catch (IOException e) {
            throw new ApiException("Could not delete transaction. Error in Raas SDK.");
        }
    }

    public void requestTransactionDelivery(UUID senderId, UUID transactionId, DeliveryRequest deliveryRequest){
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);
        Call<Void> call = service.requestTransactionDelivery(senderId,transactionId, deliveryRequest);
        try {
            Response<Void> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
        } catch (IOException e) {
            throw new ApiException("Could not request Transaction delivery. Error in Raas SDK.");
        }

    }

    private Transaction executeApiCall(Call<Transaction> call) {
        try {
            Response<Transaction> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }

    private ListResponse<Transaction> executeListApiCall(Call<ListResponse<Transaction>> call){
        try {
            Response<ListResponse<Transaction>> response = call.execute();
            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }
            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
