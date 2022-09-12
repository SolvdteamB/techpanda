package com.guru99.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Ordering;

public class MobilePage {

    @FindBy(xpath = "//select[@title='Sort By']")
    private WebElement dropDownSort;

    @FindBy(className = "product-info")
    private List<WebElement> productInfoList;

    @FindBy(css = "p:nth-child(1) > strong:nth-child(1)")
    private WebElement numberOfItems;

    @FindBy(xpath = "//div[@class='page-title category-title']")
    private WebElement mobileTitle;

    @FindBy(xpath = "//img[@id='product-collection-image-1']")
    private WebElement sonyXperiaImg;



    private WebDriver driver;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDropDwBtn(String name) {
        new Select(dropDownSort).selectByVisibleText(name);
    }

    public String getTitle() {
        return mobileTitle.getText();
    }

    public SonyXperiaPage clickSonyXperia(){
        sonyXperiaImg.click();
        return new SonyXperiaPage(driver);
    }


    public boolean listPropertiesProductInfoList() {

        // getting number of phones
        String text = numberOfItems.getText();

        // Getting the number only
        Integer items = Integer.parseInt(numberOfItems.getText().split(" ")[0]);

        // Another easy way to obtein the number of phones
        // int elements = (productInfoList.size());
        // ArrayList<String> phones = new ArrayList<>();

        // for(int i=0;i<elements;i++){
        // phones.add(productInfoList.get(i).getText().split("\\n")[0]);
        // }

        ArrayList<String> phones = listOfProducts(productInfoList);
        System.out.println(phones);
        return Ordering.natural().isOrdered(phones);

    }

    public ArrayList<String> listOfProducts(List<WebElement> productsInfoList) {
        int elements = (productInfoList.size());

        ArrayList<String> phones = new ArrayList<>();

        for (int i = 0; i < elements; i++) {
            phones.add(productInfoList.get(i).getText().split("\\n")[0]);
        }

        return phones;
    }

    public HashMap<String, Double> getPhonesInfo() {

        int elements = (productInfoList.size());
        Double firstValue = 0.0;
        Double secondValue = 0.0;

        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
        var map = new HashMap<String, Double>();

        for (int i = 0; i < elements; i++) {
            phones.add(productInfoList.get(i).getText().split("\\n")[0]);
            price.add(productInfoList.get(i).getText().split("\\n")[1].replace("$", ""));

            firstValue = 0.0;
            secondValue = 0.0;
            try {
                firstValue = Double.parseDouble(price.get(i).split(" ")[0]);
                secondValue = Double.parseDouble(price.get(i).split(" ")[1]);

            } catch (Exception e) {
                System.out.println("Can't do it!");
            }

            if (secondValue == 0.0) {
                map.put(phones.get(i), firstValue);
            } else if (firstValue > secondValue) {
                map.put(phones.get(i), secondValue);
            } else
                map.put(phones.get(i), firstValue);
        }

        System.out.println(map);
        return map;
    }

    public Double getPhonePrice(String name){

        var map = new HashMap<String,Double>();

        map = getPhonesInfo();

        return map.get(name.toUpperCase());

    }


}
