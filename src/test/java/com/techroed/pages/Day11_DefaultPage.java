package com.techroed.pages;

import com.techroed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day11_DefaultPage {
    public Day11_DefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addUserButton;

    @FindBy(xpath = "//span[contains(text(),'Hotel Management')]")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(partialLinkText = "Room reservations")
    public WebElement roomReservation;

    @FindBy(partialLinkText = "ADD ROOM RESERVATION")
    public WebElement addRoomReservation;

    @FindBy(xpath = "(//span)[1]")
    public WebElement userID;

}
