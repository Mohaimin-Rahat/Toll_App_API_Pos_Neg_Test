package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import com.google.gson.Gson;
import io.restassured.response.Response;
import utility.GetCurrentDate;
import utility.URL;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class CreateUserRequest {

    static String userID= "Unique"+ GetCurrentDate.getCurrentTimeStamp();
    static String emailAdd="unique"+GetCurrentDate.getCurrentTimeStamp()+"@gmail.com";
    public static Response createUserAPI()  {
        String url= URL.getEndPoint("/cognito-create-user");

        String bearerToken = "Bearer " + GetToken.getToken();

        Properties properties = PayloadProcessor.getValueFromPropertiesFile();

        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);




        payloadInMap.put("username", userID);
        payloadInMap.put("email", emailAdd);

        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);

        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);

        System.out.println(payloadInString);

        return responseBody;

    }
    public static Response createUserAPINegativeTesting(){
        String url= URL.getEndPoint("/cognito-create-user");
        String bearerToken = "Bearer " + GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);
        payloadInMap.put("username", userID);
        payloadInMap.put("email", emailAdd);
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);
        System.out.println(payloadInString);
        return responseBody;

    }
    public static Response createUserWithWrongEndpoint(){
        String url= URL.getEndPoint("/cognito-create");
        String bearerToken = "Bearer " + GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);
        payloadInMap.put("username", userID);
        payloadInMap.put("email", emailAdd);
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);
        System.out.println(payloadInString);
        return responseBody;
    }
    public static Response createUserWithWrongToken(){
        String url= URL.getEndPoint("/cognito-create-user");
        String bearerToken = "Bearer" + GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);
        payloadInMap.put("username", userID);
        payloadInMap.put("email", emailAdd);
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);
        System.out.println(payloadInString);
        return responseBody;
    }
    public static Response createUserWithWrongEmailID(){
        String url= URL.getEndPoint("/cognito-create-user");
        String bearerToken = "Bearer " + GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);
        payloadInMap.put("username","xyz");
        payloadInMap.put("email", "abc");
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);
        System.out.println(payloadInString);
        return responseBody;
    }
    public static Response createUserWithWrongPasswordFormat(){
        String url= URL.getEndPoint("/cognito-create-user");
        String bearerToken = "Bearer " + GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("CreateUser.json", properties);
        payloadInMap.put("username",userID);
        payloadInMap.put("email", emailAdd);
        payloadInMap.put("password","AMRahatMOHAIMIN");
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response responseBody = Base.POSTRequest(url, payloadInString, bearerToken);
        System.out.println(payloadInString);
        return responseBody;
    }

}
