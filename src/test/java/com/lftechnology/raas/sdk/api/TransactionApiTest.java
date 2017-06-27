package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.Transaction;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.util.ApiUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class TransactionApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        TransactionApi transactionApi = new TransactionApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        transactionApi.getById(getSenderId(),getTransactionId());
    }

    @Test
    public void testGetById() {
        //Given
        TransactionApi transactionApi = new TransactionApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Transaction transaction = transactionApi.getById(getSenderId(),getTransactionId());

        //Then
        Assert.assertNotNull(transaction);
    }

    @Test
    public void testListBySender() {
        //Given
        TransactionApi transactionApi = new TransactionApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<Transaction> transactions = transactionApi.listBySender(getSenderId());

        //Then
        Assert.assertNotNull(transactions);
    }

    @Test
    public void testListAll() {
        //Given
        TransactionApi transactionApi = new TransactionApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<Transaction> transactions = transactionApi.listAll();

        //Then
        Assert.assertNotNull(transactions);
    }

    @Test
    public void testCreate() {
        //Given
        TransactionApi transactionApi = new TransactionApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Transaction transaction = transactionApi.create(getSenderId(),buildTransaction());

        //Then
        Assert.assertNotNull(transaction);
    }

    @Test
    public void testDelete() {
        //Given
        TransactionApi transactionApi = new TransactionApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        transactionApi.delete(getSenderId(),getTransactionId());
    }


    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }

    private UUID getSenderId(){
        return UUID.fromString("d0b31b2f-e8ca-48eb-9c42-829b7dc0fed8");
    }

    private UUID getTransactionId(){
        return UUID.fromString("4eecbf92-b383-4f55-8745-4f6e856acab7");
    }

    private Transaction buildTransaction(){
        Transaction transaction = new Transaction();
        transaction.setSenderAmount(BigDecimal.valueOf(500));
        transaction.setExchangeRate(BigDecimal.valueOf(1010.1));
        transaction.setRecipientAmount(BigDecimal.valueOf(50000));
        transaction.setFeeAmount(BigDecimal.valueOf(2));
        transaction.setRecipientCurrency("KRW");
        transaction.setSenderBankId("83d7743c-fdb1-4712-8c62-39b3b147f639");
        transaction.setRecipientId("6620de40-287b-4e5c-9875-f6456e9b05d3");
        transaction.setRecipientBankId("ba619906-ebea-4f4d-ab82-f4d681d6a91c");
        transaction.setNote("hello");
        transaction.setRemittancePurpose("home maintenance");
        transaction.setIpAddress("127.1.1.0");
        return transaction;
    }
}