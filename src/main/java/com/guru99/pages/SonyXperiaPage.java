package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SonyXperiaPage {
    
    private WebDriver driver;

    public SonyXperiaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//span[@class='price']" )
    private WebElement phonePrice;

    public Double getPhonePrice(){
        return Double.parseDouble(phonePrice.getText().replace("$", ""));
    }

}
