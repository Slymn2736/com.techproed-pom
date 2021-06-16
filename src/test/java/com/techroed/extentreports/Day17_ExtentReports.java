package com.techroed.extentreports;

import com.techroed.pages.Day11_DefaultPage;
import com.techroed.pages.Day11_LoginPage;
import com.techroed.utilities.ConfigReader;
import com.techroed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17_ExtentReports extends TestBase {
    Day11_LoginPage loginPage=new Day11_LoginPage();
    Day11_DefaultPage defaultPage=new Day11_DefaultPage();
    @Test
    public void extentReports(){
        extentTest.pass("Entering manager username");
        loginPage.userName.sendKeys(ConfigReader.getProperty("invalid_manager_id"));
        extentTest.pass("Entering password");
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        extentTest.pass("Clicking on login button");
        loginPage.logInButton.click();
        extentTest.pass("Manager log in is successful");
        Assert.assertEquals(defaultPage.userID.getText(),ConfigReader.getProperty("manager_username"));
    }

}
