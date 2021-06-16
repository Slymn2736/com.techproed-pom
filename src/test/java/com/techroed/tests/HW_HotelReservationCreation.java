package com.techroed.tests;

import com.techroed.pages.Day11_DefaultPage;
import com.techroed.pages.Day11_LoginPage;
import com.techroed.pages.HW_HotelReservationPage;
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

public class HW_HotelReservationCreation {
    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;
    HW_HotelReservationPage hotelReservationPage;
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
    public void hotelReservationCreation(){
//      Click on Hotel Management
        defaultPage.hotelManagement.click();
//      Click on Room Reservation
        defaultPage.roomReservation.click();
//      Click on Add Room Reservation
        defaultPage.addRoomReservation.click();
//      Enter all required fields

        hotelReservationPage = new HW_HotelReservationPage();
        Select select = new Select(hotelReservationPage.idUser);
        select.selectByIndex(1);
        Select select1 = new Select(hotelReservationPage.idHotelRoom);
        select1.selectByIndex(1);
        hotelReservationPage.price.sendKeys("1000");
        hotelReservationPage.dateStart.sendKeys("07/15/2021");
        hotelReservationPage.dateEnd.sendKeys("07/18/2021");
        hotelReservationPage.adultAmount.sendKeys("2");
        hotelReservationPage.childrenAmount.sendKeys("2");
        hotelReservationPage.contactNameSurname.sendKeys("Tom Hanks");
        hotelReservationPage.contactPhone.sendKeys("+447955151251");
        hotelReservationPage.contactEmail.sendKeys("abc@gmail.com");
        hotelReservationPage.notes.sendKeys("Do not smoke in the room");
        hotelReservationPage.uniformApproved.click();
        hotelReservationPage.uniformIsPaid.click();
        hotelReservationPage.saveButton.click();

//      Verify the message: RoomReservation was inserted successfully
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement popUpMessage = wait.until(ExpectedConditions.visibilityOf(hotelReservationPage.messageBox));
        Assert.assertEquals(popUpMessage.getText(),"RoomReservation was inserted successfully");

        hotelReservationPage.okButton.click();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
