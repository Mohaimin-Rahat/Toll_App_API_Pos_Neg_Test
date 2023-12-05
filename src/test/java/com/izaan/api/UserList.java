package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class UserList {
    public static Response getUserList()  {
        String url= URL.getEndPoint("/cognito-user-list");
        String bearerToken = "Bearer " + GetToken.getToken();
        Response responseBody = Base.GETRequest(url, bearerToken);
        return responseBody;
    }
    public static Response getUserListwithInvalidURL()  {
        String url= URL.getEndPoint("/cognito-user-");
        String bearerToken = "Bearer " + GetToken.getToken();
        Response responseBody = Base.GETRequest(url, bearerToken);
        return responseBody;
    }
    public static Response getUserListwithWrongMethod()  {
        String url= URL.getEndPoint("/cognito-user-");
        String bearerToken = "Bearer " + GetToken.getToken();
        Response responseBody = Base.POSTRequest(url, bearerToken);
        return responseBody;
    }
}
