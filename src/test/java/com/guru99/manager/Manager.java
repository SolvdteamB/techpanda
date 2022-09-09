package com.guru99.manager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Manager {
    
    public WebDriver driver;


    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
