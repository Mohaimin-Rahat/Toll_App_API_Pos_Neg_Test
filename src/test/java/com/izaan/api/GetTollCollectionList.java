package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class GetTollCollectionList {
    public static Response getTollCollectionList(){
        String token="Bearer "+ GetToken.getToken();
        String url= URL.getEndPoint("/toll-collection-list");
        Response responseBody= Base.GETRequest(url,token);
        return  responseBody;
    }
    public static Response getTollCollectionListWithInvalidUrl(){
        String token="Bearer "+ GetToken.getToken();
        String url= URL.getEndPoint("/tollcollectionlist");
        Response responseBody= Base.GETRequest(url,token);
        return  responseBody;
    }
    public static Response getTollCollectionListWithInvalidToken(){
        String token="Be"+ GetToken.getToken();
        String url= URL.getEndPoint("/toll-collection-list");
        Response responseBody= Base.GETRequest(url,token);
        return  responseBody;
    }
}
