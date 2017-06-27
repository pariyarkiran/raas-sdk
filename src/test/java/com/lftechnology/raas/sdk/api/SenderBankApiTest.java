package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.SenderBank;
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
public class SenderBankApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        SenderBankApi senderBankApi = new SenderBankApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        senderBankApi.getById(getSenderId(), getSenderBankId());
    }

    @Test
    public void testGetById() {
        //Given
        SenderBankApi senderBankApi = new SenderBankApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        SenderBank senderBank = senderBankApi.getById(getSenderId(), getSenderBankId());

        //Then
        Assert.assertNotNull(senderBank);
    }

    @Test
    public void testList() {
        //Given
        SenderBankApi senderBankApi = new SenderBankApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<SenderBank> senderBanks = senderBankApi.list(getSenderId());

        //Then
        Assert.assertNotNull(senderBanks);
    }

    @Test
    public void testDelete() {
        //Given
        SenderBankApi senderBankApi = new SenderBankApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        senderBankApi.delete(getSenderId(),getSenderBankId());

    }

    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }

    private UUID getSenderId(){
        return UUID.fromString("051e9cab-fdb1-4423-9e13-68d96b4010ce");
    }

    private UUID getSenderBankId(){
        return UUID.fromString("0c095c08-9a5f-45e9-9d94-05a7c5841c27");
    }
}