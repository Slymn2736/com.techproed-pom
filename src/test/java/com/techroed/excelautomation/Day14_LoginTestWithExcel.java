package com.techroed.excelautomation;

import com.techroed.pages.Day11_DefaultPage;
import com.techroed.pages.Day11_LoginPage;
import com.techroed.utilities.ConfigReader;
import com.techroed.utilities.Driver;
import com.techroed.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
public class Day14_LoginTestWithExcel {
    //    Creating ExcelUtil object
    ExcelUtil excelUtil;
    //    We will get test data (username,pasword) key value list as LIST OF MAP OF STRING
    List<Map<String , String>> testData;
    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;
    @BeforeMethod
    public void setUp(){
        loginPage= new Day11_LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
        //We are on the LoginPage
    }
    @Test
    public void adminLoginTest(){
//   Calling ExcelUtil to set the path and sheet name
        excelUtil=new ExcelUtil("./src/test/java/resources/smoketestdata.xlsx","admin_login_info");
//        Now that we have access to teh Excel Util class, We can use ANY REUSABLE METHOD IN THAT CLASS.
//        FOR EXAMPLE to get the number of column in admin_login_info worksheet:
//        System.out.println(excelUtil.columnCount());//2
//        FOR EXAMPLE to get the data in the 1st ROW 2nd CELL in admin_login_info:
//        System.out.println(excelUtil.getCellData(0,1));//username
//        FOR EXAMPLE to get the list of data in admin_login_info sheet:
//        System.out.println(excelUtil.getDataList());//[{password=Techproed123!, username=admin}]
        testData=excelUtil.getDataList();
        for(Map<String,String> each: testData) {
//            System.out.println(each);
//Map get method accepts a key and returns the value.
            loginPage.userName.sendKeys(each.get("username"));//admin
            loginPage.password.sendKeys(each.get("password"));//Techproed123!
            loginPage.logInButton.click();
            defaultPage = new Day11_DefaultPage();
            Assert.assertEquals(defaultPage.userID.getText(), "admin");
        }
    }
    @Test
    public void managerLoginTest(){
        excelUtil=new ExcelUtil("./src/test/java/resources/smoketestdata.xlsx","manager_login_info");
        testData=excelUtil.getDataList();
        for(Map<String,String> each: testData) {
            setUp();
            loginPage.userName.sendKeys(each.get("username"));//manager
            loginPage.password.sendKeys(each.get("password"));//manager!
            loginPage.logInButton.click();
            defaultPage = new Day11_DefaultPage();
            Assert.assertEquals(defaultPage.userID.getText(), each.get("username"));
        }
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}