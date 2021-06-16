package com.techroed.smoketest;

import com.techroed.pages.Day11_LoginPage;
import com.techroed.utilities.ConfigReader;
import com.techroed.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_NegativeTest {
    Day11_LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
    }

    @Test
    public void invalidPassword(){
//        When user enters wrong password
        loginPage = new Day11_LoginPage();
        loginPage.userName.sendKeys("admin");
        loginPage.password.sendKeys("Techproed123");
        loginPage.logInButton.click();

//        Then verify the error message includes “Wrong password”

//        String errorMassageText=Driver.getDriver().findElement(By.id("divMessageResult")).getText();
//        System.out.println(errorMassageText);
        String errorMessageText = loginPage.errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Wrong password"));
    }

    @Test
    public void invalidId(){
//        When user enters wrong id but correct pass
        loginPage = new Day11_LoginPage();
        loginPage.userName.sendKeys("manager");
        loginPage.password.sendKeys("Techproed123!");
        loginPage.logInButton.click();

//        Then verify the error message includes “Try again please”
        String errorMessageText = loginPage.errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Try again please"));
    }

    @Test
    public void invalidIDAndPassword(){
//        When user enters wrong id and wrong password
        loginPage = new Day11_LoginPage();
        loginPage.userName.sendKeys("manager");
        loginPage.password.sendKeys("Manage!");
        loginPage.logInButton.click();

//        Then verify the error message includes “Username or password is incorrect, please correct them and try again”
        String errorMessageText = loginPage.errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Username or password is incorrect, please correct them and try again"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
