package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.Token;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.util.ApiUtil;
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
public class TokenApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        TokenApi tokenApi = new TokenApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        tokenApi.getToken(getSenderId());
    }

    @Test
    public void testGetToken() {
        //Given
        TokenApi tokenApi = new TokenApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Token token = tokenApi.getToken(getSenderId());

        //Then
        Assert.assertNotNull(token);
    }

    private UUID getSenderId(){
        return UUID.fromString("ea27c788-579b-48f8-a17e-756c9a93699f");
    }

    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }
}