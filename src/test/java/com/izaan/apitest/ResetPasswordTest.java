package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.ResetPasswordRequest;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class ResetPasswordTest {
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
    public void resetTestSuccess(){
        Response re= ResetPasswordRequest.resetPassword();
        BaseAssertion.verifySpecificMessage(re,"statusCode","200");
        BaseAssertion.verifySpecificMessage(re,"message","Password set successfully!");
    }
    @Test(priority = 2)
    public void resetTestFail(){
        Response re= ResetPasswordRequest.resetPasswordInvalidPasswordFormat();
        BaseAssertion.verifySpecificMessage(re,"statusCode","400");
        BaseAssertion.verifySpecificMessage(re,"message","Password does not conform to policy: Password not long enough");
    }
}
