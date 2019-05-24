package com.pom.pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.testbase.Testbase;
import com.test.utilities.WaitTool;

public class HomePage extends Testbase {
	public static Logger log = Logger.getLogger(HomePage.class.getName());
    protected WebDriver driver;
	
	
    
    @FindBy (xpath=("//span[@class='search-input-location-placeholder-1 ']"))
    WebElement Inputbox;
    
    @FindBy (xpath=("//div[@class='search-bottom-right right']//button[@type='submit']"))
    WebElement SerachButton;
    
    
    
 public HomePage(WebDriver driver){
	 
      this.driver = driver;
	  PageFactory.initElements(driver,this);
 }
 
 
 
 public PropertiesList searchlocation(String country)
 
 {	
	 Actions action = new Actions(driver);
	 WaitTool.waitForElementPresent(Inputbox, 20);
	 action.moveToElement(Inputbox).sendKeys(country).build().perform();
		//if (Inputbox.getText().equals("London")){
			
			 SerachButton.submit();
		
			
		
		
	
	 return new PropertiesList(driver);

	 }
	 
	 
	 
 
 public String  getURL()
 {
	 System.out.println(driver.getTitle()); 
	 
	 return driver.getCurrentUrl();
 }
}
