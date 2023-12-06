package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class LoginRequest {
    public static Response loginRequest(){
        String url= URL.getEndPoint("/cognito-login");
        String token="Bearer "+ GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();

        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("Login.json", properties);

        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response responseBody = Base.POSTRequest(url, payloadInString, token);

        System.out.println(payloadInString);
        return responseBody;
    }
    public static Response loginWithInvalidUser(){
        String url= URL.getEndPoint("/cognito-login");
        String token="Bearer "+ GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();

        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("Login.json", properties);

        payloadInMap.put("username","asdfghj");

        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response responseBody = Base.POSTRequest(url, payloadInString, token);

        System.out.println(payloadInString);
        return responseBody;
    }
}
