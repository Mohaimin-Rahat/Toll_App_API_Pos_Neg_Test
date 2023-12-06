package com.izaan.api;

import base.Base;
import base.GetToken;
import io.restassured.response.Response;
import utility.URL;

public class GetTollListByCollectionPoint {
    public static Response getTollListByCollectionPoint(){
        String url= URL.getEndPoint("/toll-collection-list");
        String token="Bearer "+ GetToken.getToken();
        String key="collectionPointId";
        String value="NY088734";
        Response re= Base.GETRequest(url,token,key,value);
        return re;
    }
    public static Response getTollListByCollectionPointWithInvalidToken(){
        String url= URL.getEndPoint("/toll-collection-list");
        String token="Bearer_is_Wrong"+ GetToken.getToken();
        String key="collectionPointId";
        String value="NY088734";
        Response re= Base.GETRequest(url,token,key,value);
        return re;
    }
}
