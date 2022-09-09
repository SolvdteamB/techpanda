package com.guru99.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {

    @FindBy (xpath = "//select[@title='Sort By']")
    private WebElement dropDownSort;

    @FindBy (className = "product-info")
    private List<WebElement> productInfoList;

    @FindBy(css = "p:nth-child(1) > strong:nth-child(1)")
    private WebElement numberOfItems;

    @FindBy(xpath = "//div[@class='page-title category-title']")
    private WebElement mobileTitle;

    private WebDriver driver;
    
    public MobilePage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickDropDwBtn(String name){
        new Select(dropDownSort).selectByVisibleText(name);
    }
    
    public String getTitle(){
        return mobileTitle.getText();
    }

    public List<String> listPropertiesProductInfoList(){
        
        //getting number of phones
        String text = numberOfItems.getText();
        
        //Getting the number only
        Integer items=Integer.parseInt(numberOfItems.getText().split(" ")[0]);
        
        //Another easy way to obtein the number of phones
        int elements = (productInfoList.size());
        ArrayList<String> phones = new ArrayList<>();
        
        for(int i=0;i<elements;i++){
            phones.add(productInfoList.get(i).getText().split("\\n")[0]);
        }

        return phones;
 
    }

}
