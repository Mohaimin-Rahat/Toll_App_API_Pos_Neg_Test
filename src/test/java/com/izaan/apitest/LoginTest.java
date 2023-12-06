package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.LoginRequest;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class LoginTest {
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
    public void loginTest(){
        Response re= LoginRequest.loginRequest();
        BaseAssertion.verifyStatusCode(re,200);
        BaseAssertion.verifySpecificMessage(re,"message","Log in successfully!");
    }
    @Test(priority = 2)
    public void loginTestWithInvalidUser(){
        Response re= LoginRequest.loginWithInvalidUser();
        BaseAssertion.verifyStatusCode(re,200);
        BaseAssertion.verifySpecificMessage(re,"statusCode","400");
        BaseAssertion.verifySpecificMessage(re,"message","Incorrect username or password.");
    }

}
