package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.CreateUserRequest;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

import java.io.IOException;

public class CreateUserRequestTest {
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
    @Test (priority = 1,groups = "acceptenceTests")
    public void validateUserCreation(){
        Response response = CreateUserRequest.createUserAPI();
        BaseAssertion.verifyStatusCode(response, 200);
        BaseAssertion.verifySpecificMessage(response, "message", "User Created successfully!");
    }
    @Test(priority = 2)
    public void validateUserCreationWithExistingUsername(){
        Response response = CreateUserRequest.createUserAPINegativeTesting();
        BaseAssertion.verifyStatusCode(response, 200);
        BaseAssertion.verifySpecificMessage(response, "statusCode", "400");
        BaseAssertion.verifySpecificMessage(response, "message", "User account already exists");
    }
    @Test(priority = 3)
    public void validateUserCreationWithInvalidURL(){
        Response response = CreateUserRequest.createUserWithWrongEndpoint();
        BaseAssertion.verifyStatusCode(response, 403);

    }
    @Test(priority = 4)
    public void validateUserCreationWithInvalidToken(){
        Response response = CreateUserRequest.createUserWithWrongToken();
        BaseAssertion.verifyStatusCode(response, 401);

    }
    @Test(priority = 5)
    public void validateUserCreationWithInvalidEmailID(){
        Response response = CreateUserRequest.createUserWithWrongEmailID();
        BaseAssertion.verifySpecificMessage(response,"statusCode","400");
        BaseAssertion.verifySpecificMessage(response,"message","Invalid email address format.");
        BaseAssertion.verifySpecificMessage(response,"IsSuccess","No");
    }
    @Test(priority = 6)
    public void validateUserCreationWithInvalidPasswordFormat(){
        Response response = CreateUserRequest.createUserWithWrongPasswordFormat();
        BaseAssertion.verifySpecificMessage(response,"statusCode","400");
        BaseAssertion.verifySpecificMessage(response,"IsSuccess","No");
        BaseAssertion.verifySpecificMessage(response,"message","Password did not conform with password policy: Password must have symbol characters");
    }

    }

