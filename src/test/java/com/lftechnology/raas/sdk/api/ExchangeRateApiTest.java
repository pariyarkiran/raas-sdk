package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.ExchangeRate;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.util.ApiUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ExchangeRateApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() {
        //Given
        ExchangeRateApi exchangeRateApi = new ExchangeRateApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        exchangeRateApi.create(buildExchangeRate());
    }

    @Test
    public void testList() {
        //Given
        ExchangeRateApi exchangeRateApi = new ExchangeRateApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<ExchangeRate> exchangeRates = exchangeRateApi.list();

        //Then
        Assert.assertNotNull(exchangeRates);
    }

    @Test
    public void testCreate() {
        //Given
        ExchangeRateApi exchangeRateApi = new ExchangeRateApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ExchangeRate exchangeRate = exchangeRateApi.create(buildExchangeRate());
        System.out.println("exchangeRate" + exchangeRate.toString());

        //Then
        Assert.assertNotNull(exchangeRate);
    }


    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }

    private ExchangeRate buildExchangeRate(){
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setSourceCurrency("USD");
        exchangeRate.setDestinationCurrency("KRW");
        exchangeRate.setRate(BigDecimal.valueOf(500.5));
        return exchangeRate;
    }
}