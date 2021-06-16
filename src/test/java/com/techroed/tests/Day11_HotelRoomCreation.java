package com.techroed.tests;

import com.techroed.pages.Day11_DefaultPage;
import com.techroed.pages.Day11_LoginPage;
import com.techroed.pages.Day12_HotelRoomPage;
import com.techroed.utilities.ConfigReader;
import com.techroed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_HotelRoomCreation {
    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;
    Day12_HotelRoomPage hotelRoomPage;
    @BeforeMethod
    public void setUp(){
        loginPage = new Day11_LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
        loginPage.userName.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.logInButton.click();
//      Checking if the login is successfully
        defaultPage = new Day11_DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }

    @Test
    public void hotelRoomCreation() throws InterruptedException {
//Click on Hotel Management
        defaultPage.hotelManagement.click();
//Click on Hotel Rooms
        defaultPage.hotelRooms.click();
//Click on Add Hotel Room
        hotelRoomPage = new Day12_HotelRoomPage();
        hotelRoomPage.addHotelRoom.click();
//Enter All required fields
//        1.WebElement-> is done in page class
//        2. Select object
        Select select=new Select(hotelRoomPage.hotelIdDropdown);
//        3. selectBy...
        select.selectByIndex(2);
        hotelRoomPage.code.sendKeys("discount code");
        hotelRoomPage.name.sendKeys("test name");
        hotelRoomPage.location.sendKeys("Dallas");
        hotelRoomPage.description.sendKeys("This is the best room for special guest");
        hotelRoomPage.price.sendKeys("1000");
        Select roomDropdown =new Select(hotelRoomPage.roomTypeDropdown);
        roomDropdown.selectByVisibleText("Studio");
        hotelRoomPage.maxAdultCount.sendKeys("2");
        hotelRoomPage.maxChildCount.sendKeys("5");
        hotelRoomPage.isAvailable.click();
        hotelRoomPage.saveButton.click();

//Verify the message: HotelRoom was inserted successfully
//      Thread.sleep(2000); //Not recommended
//      Assert.assertEquals(hotelRoomPage.alertBox.getText(),"HotelRoom was inserted successfully");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement popUpElement = wait.until(ExpectedConditions.visibilityOf(hotelRoomPage.alertBox));
        Assert.assertEquals(popUpElement.getText(),"HotelRoom was inserted successfully");
//Click OK
        hotelRoomPage.okButton.click();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
