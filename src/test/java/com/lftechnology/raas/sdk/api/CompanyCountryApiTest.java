package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.CompanyCountry;
import com.lftechnology.raas.sdk.dto.Country;
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
public class CompanyCountryApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        CompanyCountryApi companyCountryApi = new CompanyCountryApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        companyCountryApi.list();
    }

    @Test
    public void testList() {
        //Given
        CompanyCountryApi companyCountryApi = new CompanyCountryApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<CompanyCountry> countries = companyCountryApi.list();

        //Then
        Assert.assertNotNull(countries);
    }

    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }
}