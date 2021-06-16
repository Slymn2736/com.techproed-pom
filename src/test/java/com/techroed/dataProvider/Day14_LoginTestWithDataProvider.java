package com.techroed.dataProvider;

import com.techroed.pages.Day11_DefaultPage;
import com.techroed.pages.Day11_LoginPage;
import com.techroed.utilities.ConfigReader;
import com.techroed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day14_LoginTestWithDataProvider {

    @DataProvider
    public Object[][] getData(){
        String [][] managerProfile={
                {"manager","Manager1!"},
                {"manager2","Manager2!"},
                {"manager3","Manager3!"}
        };

        return managerProfile;
    }
    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;

    public void  setUp(){
        loginPage=new Day11_LoginPage();
        defaultPage=new Day11_DefaultPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
    }

    @Test(dataProvider = "getData")
    public void managerLoginTest(String userName,String password){
        setUp();
        loginPage.userName.sendKeys(userName);
        loginPage.password.sendKeys(password);
        loginPage.logInButton.click();
        Assert.assertEquals(defaultPage.userID.getText(),userName);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
