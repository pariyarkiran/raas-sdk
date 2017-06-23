package com.lftechnology.raas.sdk.util;

import com.lftechnology.raas.sdk.constants.CommonConstant;
import okhttp3.Headers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kiran Pariyar <kiranpariyar@lftechnology.com>
 */
public class ApiUtil {

    public static Map<String,String> getDefaultHeader(){
        Map<String,String> headers = new HashMap<>();
        headers.put(CommonConstant.HTTP_CLIENT_ID, "R0SbAYpVieJ7BNQS");
        headers.put(CommonConstant.HTTP_CLIENT_SECRET, "04DYQmXqzmBbyJvN");
        return headers;
    }

    public static Headers buildHeader(Map<String,String> headerMap){
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }
}
