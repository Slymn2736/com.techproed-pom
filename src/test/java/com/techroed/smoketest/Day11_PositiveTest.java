package com.techroed.smoketest;

import com.techroed.pages.Day11_DefaultPage;
import com.techroed.pages.Day11_LoginPage;
import com.techroed.pages.Day11_MainPage;
import com.techroed.utilities.ConfigReader;
import com.techroed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Day11_PositiveTest {
    Day11_MainPage mainPage;
    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;
    @BeforeMethod
    public void setUp(){
//      Go to teh application URL
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
    }
    @Test
    public void positiveTest(){
//      Go to the login page
        mainPage = new Day11_MainPage();
        mainPage.mainPageLoginLink.click();

//      Send username password, click on login button
        loginPage = new Day11_LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.logInButton.click();

//      Find a core object in the default login page And verify if the log in successful
        defaultPage = new Day11_DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
