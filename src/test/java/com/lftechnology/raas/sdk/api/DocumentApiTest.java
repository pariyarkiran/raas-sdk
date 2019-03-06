package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.Document;
import com.lftechnology.raas.sdk.exception.ApiException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DocumentApiTest {
    private String baseUrl = "https://sandbox.api.machpay.com/v1/";

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
        DocumentApi documentApi = new DocumentApi(this.baseUrl,getInvalidHeader());

        Document document = documentApi.getInvoiceLink(UUID.fromString("3728a857-acb8-4399-b70b-faba4929b9af")
                ,UUID.fromString("975caded-476c-413b-ac5e-fd393ca6e0e6"));

        System.out.println(document.toString());
        //Then
        Assert.assertNotNull(document);
    }

    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "wiselyid");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "wiselysecret");
        return headers;
    }
}
