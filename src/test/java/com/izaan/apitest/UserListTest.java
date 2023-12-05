package com.izaan.apitest;

import base.BaseAssertion;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.izaan.api.UserList;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ReportManager;

public class UserListTest {
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
    @Test (priority = 1,groups = "acceptenceTests")
    public void validateUserList(){
        Response rs= UserList.getUserList();
        BaseAssertion.verifyStatusCode(rs,200);
        BaseAssertion.verifySpecificMessage(rs,"message","User List!");
    }
    @Test (priority = 2,groups = "acceptenceTests")
    public void validateUserListWithInvalidURL(){
        Response rs= UserList.getUserListwithInvalidURL();
        BaseAssertion.verifyStatusCode(rs,403);
    }
    @Test (priority = 3,groups = "acceptenceTests")
    public void validateUserListWithInvalidResponseMethod(){
        Response rs= UserList.getUserListwithWrongMethod();
        BaseAssertion.verifyStatusCode(rs,403);
    }
}
