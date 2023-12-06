package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class ResetPasswordRequest {
    public static Response resetPassword(){
        String token="Bearer "+ GetToken.getToken();
        String url= URL.getEndPoint("/cognito-admin-set-user-password");
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("ResetPassword.json", properties);
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response response= Base.POSTRequest(url,payloadInString,token);
        return  response;
    }
    public static Response resetPasswordInvalidPasswordFormat(){
        String token="Bearer "+ GetToken.getToken();
        String url= URL.getEndPoint("/cognito-admin-set-user-password");
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("ResetPassword.json", properties);
        payloadInMap.put("password","manager");
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response response= Base.POSTRequest(url,payloadInString,token);
        return  response;
    }
}
