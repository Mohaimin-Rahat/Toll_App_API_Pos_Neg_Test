package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.GetTollListByCollectionPoint;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class GetTollListByCollectionPointTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;
    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate User Creation Test");
    }
    @AfterMethod
    public void afterTests(){
        extent.flush();
    }
    @Test(priority = 1)
    public void getTollListBYCollectionTestSuccess(){
        Response re= GetTollListByCollectionPoint.getTollListByCollectionPoint();
        BaseAssertion.verifyStatusCode(re,200);
    }
    @Test(priority = 2)
    public void getTollListBYCollectionTestFail(){
        Response re= GetTollListByCollectionPoint.getTollListByCollectionPointWithInvalidToken();
        BaseAssertion.verifySpecificMessage(re,"message","Unauthorized");
        BaseAssertion.verifyStatusCode(re,401);
    }
}
