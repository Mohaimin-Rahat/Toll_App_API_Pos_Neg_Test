package com.izaan.api;

import base.Base;
import base.GetToken;
import base.PayloadProcessor;
import io.restassured.response.Response;
import utility.GetCurrentDate;
import utility.URL;

import java.util.Map;
import java.util.Properties;

public class SubmitTollRequest {
    public  static Response submitToll(){
        String url = URL.getEndPoint("/tollcollection");
        String bearerToken= "Bearer "+GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("SubmitToll.json", properties);
        payloadInMap.put("tagNumber","RX 788");
        payloadInMap.put("vehicleType","Hybrid Vehicles");
        payloadInMap.put("tollCollectionMethod","Card");
        payloadInMap.put("tollRate","99");
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response re= Base.POSTRequest(url,payloadInString,bearerToken);
        return re;
    }
    public  static Response submitTollWithInvalidURL(){
        String url = URL.getEndPoint("/tollcollection-submit");
        String bearerToken= "Bearer "+GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("SubmitToll.json", properties);
        payloadInMap.put("tagNumber","RX 788");
        payloadInMap.put("vehicleType","Hybrid Vehicles");
        payloadInMap.put("tollCollectionMethod","Card");
        payloadInMap.put("tollRate","99");
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response re= Base.POSTRequest(url,payloadInString,bearerToken);
        return re;
    }
    public  static Response submitTollWithWrongResponseMethod(){
        String url = URL.getEndPoint("/tollcollection-submit");
        String bearerToken= "Bearer "+GetToken.getToken();
        Properties properties = PayloadProcessor.getValueFromPropertiesFile();
        Map<String, Object> payloadInMap = PayloadProcessor.getProcessedPayloadInJson("SubmitToll.json", properties);
        payloadInMap.put("tagNumber","RX 788");
        payloadInMap.put("vehicleType","Hybrid Vehicles");
        payloadInMap.put("tollCollectionMethod","Card");
        payloadInMap.put("tollRate","99");
        String payloadInString = PayloadProcessor.payloadFromMapToString(payloadInMap);
        Response re= Base.GETRequest(url,bearerToken);
        return re;
    }
}
