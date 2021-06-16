package com.techroed.pages;

import com.techroed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day12_HotelRoomPage {
    public Day12_HotelRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy(partialLinkText = "ADD HOTELROOM")
        public WebElement addHotelRoom;
        @FindBy(id="IDHotel")
        public WebElement hotelIdDropdown;
        @FindBy(id="Code")
        public WebElement code;
        @FindBy(id="Name")
        public WebElement name;
        @FindBy(id="Location")
        public  WebElement location;
        @FindBy(xpath = "//textarea[@dir='ltr']")
        public WebElement description;
        @FindBy(id="Price")
        public WebElement price;
        @FindBy(id = "IDGroupRoomType")
        public WebElement roomTypeDropdown;
        @FindBy(id="MaxAdultCount")
        public WebElement maxAdultCount;
        @FindBy(id="MaxChildCount")
        public WebElement maxChildCount;
        @FindBy(id="IsAvailable")
        public WebElement isAvailable;
        @FindBy(id="btnSubmit")
        public WebElement saveButton;
        @FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement alertBox;
        @FindBy(xpath = "(//button[@type='button'])[6]")
        public WebElement okButton;




}
