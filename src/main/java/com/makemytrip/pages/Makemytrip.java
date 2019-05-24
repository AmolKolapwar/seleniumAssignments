package com.makemytrip.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.utilities.WaitTool;

public class Makemytrip {
	public static Logger log = Logger.getLogger(Makemytrip.class.getName());
	 protected WebDriver driver;
	
	
	public Makemytrip(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy (xpath=("//li[contains(text(),'Round Trip')]"))
	WebElement roundTrip;
	
	@FindBy (xpath=("//input[@id='fromCity']"))
	WebElement fromcity;
	
	@FindBy (xpath=("//div[@role='combobox']//input[@type='text']"))
	WebElement inputtext;
	
	@FindBy (xpath=("//input[@id='toCity']"))
	WebElement toCity;
	
	
	public boolean roundTrip(){
		
		if (roundTrip.isEnabled() &&  !roundTrip.isSelected())
		{
			 log.info("==============RoundTrip option is enabled and not selected======================== ");
			 roundTrip.click();
			 return true;
		}else{
			log.info("RoundTrip option not enables or already selected");
			assertTrue(false);
			System.out.println("=====RoundTrip Option is selected ");
			
		}
		return false;
		      
		
	}
	
	public void enterCityName(String fromcity1)
	{
		
		log.info("Mousehover on From city and enter the city name");
		Actions action = new Actions(driver);
		action.moveToElement(fromcity).click().build().perform();
		inputtext.sendKeys(fromcity1);
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		System.out.println("============ :" +list.size());
               for(int i=0;i<list.size();i++)
            	   
                              {
			                                 
            	                    System.out.println("Print the All From city Name :" + list.get(i).getText());
       			                    if (list.get(i).getText().contains(fromcity1))
       			                    {
       			                    	
       			                                WaitTool.waitForElmentClick(list.get(i), 10);
       			                   	            action.moveToElement(list.get(0)).click().build().perform();
       			                   
       				                break;
			                               
			                          
       			                    }
                              }		                    
		
		
		
		
	}
	
	public void enterTocityName(String tocity)
	
	{
		Actions action = new Actions(driver);
		action.moveToElement(toCity).click().build().perform();
		inputtext.sendKeys(tocity);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

		 for(int i=0;i<list.size();i++)
      	   
         {
                        
               System.out.println("Print the All ToCity Name :" + list.get(i).getText());
                  if (list.get(i).getText().contains(tocity)) {
		                    WaitTool.waitForElmentClick(list.get(i), 10);

		                   	action.moveToElement(list.get(0)).click().build().perform();
	                break;
                      
                  }
         }		           
		
	}
	

}
