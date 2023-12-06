package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.GetTollCollectionList;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class GetTollCollectionListTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;

    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User list test");
    }
    @AfterClass
    public void aftertests(){
        extent.flush();
    }
    @Test(priority = 1)
    public void getTollCollectionListTest(){
        Response re= GetTollCollectionList.getTollCollectionList();
        BaseAssertion.verifyStatusCode(re,200);
        BaseAssertion.verifySpecificMessage(re,"message","success");
    }
    @Test(priority = 2)
    public void getTollCollectionListTestWithInvalidUrl(){
        Response re= GetTollCollectionList.getTollCollectionListWithInvalidUrl();
        BaseAssertion.verifyStatusCode(re,403);
    }
    @Test(priority = 3)
    public void getTollCollectionListTestWithInvalidToken(){
        Response re= GetTollCollectionList.getTollCollectionListWithInvalidToken();
        BaseAssertion.verifyStatusCode(re,401);
        BaseAssertion.verifySpecificMessage(re,"message","Unauthorized");
    }

}
