package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.RecipientBank;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.util.ApiUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class RecipientBankApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        RecipientBankApi recipientBankApi = new RecipientBankApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        recipientBankApi.getById(getSenderId(),getRecipientId(),getRecipientBankId());
    }

    @Test
    public void testGetById() {
        //Given
        RecipientBankApi recipientBankApi = new RecipientBankApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        RecipientBank recipientBank = recipientBankApi.getById(getSenderId(),   getRecipientId(), getRecipientBankId());

        //Then
        Assert.assertNotNull(recipientBank);
    }

    @Test
    public void testList() {
        //Given
        RecipientBankApi recipientBankApi = new RecipientBankApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<RecipientBank> recipientBanks = recipientBankApi.list(getSenderId(),getRecipientId());

        //Then
        Assert.assertNotNull(recipientBanks);
    }

    @Test
    public void testCreate() {
        //Given
        RecipientBankApi recipientBankApi = new RecipientBankApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        RecipientBank recipientBank = recipientBankApi.create(getSenderId(),getRecipientId(),buildRecipientBank());

        //Then
        Assert.assertNotNull(recipientBank);
    }

    @Test
    public void testUpdate() {
        //Given
        RecipientBankApi recipientBankApi = new RecipientBankApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        RecipientBank recipientBank = recipientBankApi.update(getSenderId(),getRecipientId(),getRecipientBankId(),buildRecipientBank());

        //Then
        Assert.assertNotNull(recipientBank);
    }

    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }

    private UUID getSenderId(){
        return UUID.fromString("2db83428-9527-44a5-9400-db0c94d8e5f5");
    }

    private UUID getRecipientId(){
        return UUID.fromString("f9d6e5df-e035-416a-9866-3e94b91b7fd1");
    }

    private UUID getRecipientBankId(){
        return UUID.fromString("6995fd2d-d52c-44df-aee4-ffbcd0a9aec3");
    }


    private RecipientBank buildRecipientBank(){
        RecipientBank recipientBank = new RecipientBank();
        recipientBank.setAccountNumber("123456745123123");
        recipientBank.setAccountType("Savings");
        recipientBank.setBranchId(1L);
        return recipientBank;
    }
}