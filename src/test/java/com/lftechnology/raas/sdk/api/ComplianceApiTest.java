package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.TransactionLimit;
import com.lftechnology.raas.sdk.exception.ApiException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ComplianceApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        ComplianceApi complianceApi = new ComplianceApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        complianceApi.getById(getSenderId());
    }

    @Test
    public void testGetById() {
        //Given
        ComplianceApi complianceApi = new ComplianceApi(this.baseUrl, getHeader());

        //When
        TransactionLimit transactionLimit = complianceApi.getById(getSenderId());

        //Then
        Assert.assertNotNull(transactionLimit);
    }

    private Map<String,String> getHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "abcdefg12345");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "abcdefg123456");
        return headers;
    }

    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }

    private UUID getSenderId(){
        return UUID.fromString("36f1e870-f535-4d8f-b05b-6484f226c7c8");
    }
}