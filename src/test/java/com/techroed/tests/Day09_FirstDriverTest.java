package com.techroed.tests;

import com.techroed.utilities.ConfigReader;
import com.techroed.utilities.Driver;
import org.testng.annotations.Test;

public class Day09_FirstDriverTest {

    @Test
    public void firstDriverTest(){
        // driver=> Driver.getDriver()
     //   Driver.getDriver().get("https://amazon.com/");

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));



    }
}
