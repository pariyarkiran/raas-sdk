package com.lftechnology.raas.sdk.api;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import com.lftechnology.raas.sdk.dto.Recipient;
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
public class RecipientApiTest {

    private String baseUrl = "https://qa.raas.lftechnology.com/v1/";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowApiExceptionWhenForInvalidCredentials() throws IOException{
        //Given
        RecipientApi recipientApi = new RecipientApi(this.baseUrl, getInvalidHeader());

        //When-Then
        thrown.expect(ApiException.class);
        recipientApi.getById(getSenderId(),getRecipientId());
    }

    @Test
    public void testGetById() throws IOException{
        //Given
        RecipientApi recipientApi = new RecipientApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Recipient recipient = recipientApi.getById(getSenderId(),getRecipientId());

        //Then
        Assert.assertNotNull(recipient);
    }

    @Test
    public void testList() throws IOException{
        //Given
        RecipientApi recipientApi = new RecipientApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        ListResponse<Recipient> recipients = recipientApi.list(getSenderId());
        System.out.println(recipients.getResults());

        //Then
        Assert.assertNotNull(recipients);
    }

    @Test
    public void testCreate() throws IOException{
        //Given
        RecipientApi recipientApi = new RecipientApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Recipient recipient = recipientApi.create(getSenderId(),buildRecipient());

        //Then
        Assert.assertNotNull(recipient);
    }

    @Test
    public void testUpdate() throws IOException{
        //Given
        RecipientApi recipientApi = new RecipientApi(this.baseUrl, ApiUtil.getDefaultHeader());

        //When
        Recipient recipient = recipientApi.update(getSenderId(),getRecipientId(),buildRecipient());

        //Then
        Assert.assertNotNull(recipient);
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

    private Recipient buildRecipient(){
        Recipient recipient = new Recipient();
        recipient.setEmail("hello@example2.com");
        recipient.setFirstName("hello");
        recipient.setMiddleName("");
        recipient.setCity("hello korea");
        recipient.setLastName("example");
        recipient.setCountry("KOR");
        recipient.setAddressLine1("address1");
        recipient.setAddressLine2("address2");
        recipient.setPostalCode("12345");
        recipient.setProvince("province");
        recipient.setHomePhone("123456");
        recipient.setWorkPhone("123456");
        recipient.setMobilePhone("123456");
        recipient.setDateOfBirth("1993-07-20");
        recipient.setOccupation("doctor");
        recipient.setSenderRelationship("brother");
        return recipient;
    }
}