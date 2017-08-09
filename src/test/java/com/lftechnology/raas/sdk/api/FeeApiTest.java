package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.Fee;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.util.ApiUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class FeeApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        FeeApi feeApi = new FeeApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        feeApi.list();
    }

    @Test
    public void testList() {
        //Given
        FeeApi feeApi = new FeeApi(this.baseUrl, getHeader());

        //When
        ListResponse<Fee> fees = feeApi.list();
        System.out.println(fees.getResults().get(0).getSourceCountry());
        System.out.println(fees.getResults().get(0).getFeeSetDestinations());

        //Then
        Assert.assertNotNull(fees);
    }

    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "jaksdlf");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "jskadfk");
        return headers;
    }

    private Map<String,String> getHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "abcdefg12345");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "abcdefg123456");
        return headers;
    }

}