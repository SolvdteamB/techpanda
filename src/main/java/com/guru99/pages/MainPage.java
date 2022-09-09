package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy (xpath =  "//h2[1]")
    private WebElement title;

    @FindBy (xpath =  "//a[normalize-space()='Mobile']")
    private WebElement mobileBtn;

    private WebDriver driver;

    
    public MainPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return title.getText();
    }

    public MobilePage clickMobileBtn(){
        mobileBtn.click();
        return new MobilePage(driver);
    }

}
