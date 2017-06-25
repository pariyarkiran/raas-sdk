package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.Sender;
import com.lftechnology.raas.sdk.exception.ApiException;
import com.lftechnology.raas.sdk.pojo.ListResponse;
import com.lftechnology.raas.sdk.util.ApiUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class SenderApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() throws IOException{
        //Given
        SenderApi senderApi = new SenderApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        senderApi.getById(getSenderId());
    }

    @Test
    public void testGetById() throws IOException{
        //Given
        SenderApi senderApi = new SenderApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Sender sender = senderApi.getById(getSenderId());

        //Then
        Assert.assertNotNull(sender);
    }

    @Test
    public void testList() throws IOException{
        //Given
        SenderApi senderApi = new SenderApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<Sender> senders = senderApi.list();

        //Then
        Assert.assertNotNull(senders);
    }

    @Test
    public void testCreate() throws IOException{
        //Given
        SenderApi senderApi = new SenderApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Sender sender = senderApi.create(buildSender());
        System.out.println("sender" + sender.toString());

        //Then
        Assert.assertNotNull(sender);
    }


    private Map<String,String> getInvalidHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQSe");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }

    private UUID getSenderId(){
        return UUID.fromString("ea27c788-579b-48f8-a17e-756c9a93699f");
    }

    private Sender buildSender(){
        Sender sender = new Sender();
        sender.setEmail("hello@example2.com");
        sender.setFirstName("hello");
        sender.setMiddleName("");
        sender.setLastName("example");
        sender.setState("TX");
        return sender;
    }
}