package com.techroed.pages;

import com.techroed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day11_LoginPage {
    public Day11_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(id="UserName")
        public WebElement userName;

        @FindBy(id="Password")
        public WebElement password;

        @FindBy(id="btnSubmit")
        public WebElement logInButton;

        @FindBy(id="divMessageResult")
        public WebElement errorMessage;

    }


