package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.CreateUserRequest;
import com.izaan.api.SubmitTollRequest;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class SubmitTollRequestTest {
    private static ExtentReports extent;
    private static ExtentTest testLog;
    @BeforeMethod
    public void beforeTests(){
        extent = ReportManager.getInstance();
        testLog = extent.createTest("Validate Submit Toll Test");
    }
    @AfterMethod
    public void afterTests(){
        extent.flush();
    }
    @Test (priority = 1,groups = "acceptenceTests")
    public void validateSubmitToll(){
        Response response = SubmitTollRequest.submitToll();
        BaseAssertion.verifyStatusCode(response, 200);
        BaseAssertion.verifySpecificMessage(response, "message", "success");
    }
    @Test (priority = 2)
    public void submitTollWithWrongURL(){
        Response response = SubmitTollRequest.submitTollWithInvalidURL();
        BaseAssertion.verifyStatusCode(response, 403);
    }
    @Test (priority = 3)
    public void submitTollWithWrongResponseMethod(){
        Response response = SubmitTollRequest.submitTollWithWrongResponseMethod();
        BaseAssertion.verifyStatusCode(response, 403);
    }
}
