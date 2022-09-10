package com.guru99;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.Ordering;
import com.guru99.manager.Manager;
import com.guru99.pages.MainPage;
import com.guru99.pages.MobilePage;

/**
 * Unit test for simple App.
 */
public class AppTest extends Manager {

    @Test
    public void verifySortedListByName() throws InterruptedException {

        driver.get("http://live.techpanda.org/");

        SoftAssert softAssert = new SoftAssert();

        MainPage mainPanda = new MainPage(driver);
        softAssert.assertEquals(mainPanda.getTitle().trim(), "THIS IS DEMO SITE FOR", "The page can't be reach!");
        MobilePage mobilePage = mainPanda.clickMobileBtn();

        softAssert.assertEquals(mobilePage.getTitle(), "MOBILE", "Wrong page loaded!");

        mobilePage.clickDropDwBtn("Name");
    
        softAssert.assertTrue(mobilePage.listPropertiesProductInfoList(),"The list is not sorted!");

        Thread.sleep(1000);
        softAssert.assertAll();
    }

    @Test
    public void verifyCostOfProduct(){

        driver.get("http://live.techpanda.org/");
        SoftAssert softAssert = new SoftAssert();

        MainPage mainPage = new MainPage(driver);
        
        MobilePage mobilePage = mainPage.clickMobileBtn();

        //mobilePage.clickDropDwBtn("Name");











    }



}
