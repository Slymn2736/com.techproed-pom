package com.techroed.pages;

import com.techroed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HW_HotelReservationPage {
    public HW_HotelReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "IDUser")
    public WebElement idUser;

    @FindBy(id = "IDHotelRoom")
    public WebElement idHotelRoom;

    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(id = "DateStart")
    public WebElement dateStart;

    @FindBy(id = "DateEnd")
    public WebElement dateEnd;

    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;

    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmount;

    @FindBy(id = "ContactNameSurname")
    public WebElement contactNameSurname;

    @FindBy(id = "ContactPhone")
    public WebElement contactPhone;

    @FindBy(id = "ContactEmail")
    public WebElement contactEmail;

    @FindBy(id = "Notes")
    public WebElement notes;

    @FindBy(id = "uniform-Approved")
    public WebElement uniformApproved;

    @FindBy(id = "uniform-IsPaid")
    public WebElement uniformIsPaid;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement messageBox;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement okButton;

}
