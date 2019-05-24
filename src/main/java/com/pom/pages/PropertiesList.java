package com.pom.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.test.HomePageTest;
import com.test.utilities.WaitTool;

public class PropertiesList {
 protected WebDriver driver;
	
	public static  Logger log = Logger.getLogger(PropertiesList.class.getName());
	public PropertiesList(WebDriver driver) {
	
	      this.driver = driver;
	      PageFactory.initElements(driver, this);
	
	}
	
	@FindBy (xpath =("//ul[@class='listing-results clearfix js-gtm-list']//li[@class='srp clearfix   '][5]//a[@class='listing-results-price text-price']"))
	WebElement property5;
	
	
	
	public boolean price(){
		
		//Using following List we store all price from page
		List<WebElement> price = driver.findElements(By.xpath("//a[@class='listing-results-price text-price']"));
		Set<Integer> listP=new TreeSet();
		//List<Integer> testp = new ArrayList<>();
		
		//Using foreach we itrate the price and store the price in string format
	    for (WebElement list : price)
	    {
	    	String price1=list.getText();
	    	price1=price1.replace("£", "");
	    	price1=price1.replace(",", "");
	      
	    	System.out.println(price1);
	    	
	    	try {
	    		//We convert string to interger 
				listP.add(Integer.parseInt(price1));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	    	

	    }
	
		List<Integer> descendingPrice=new ArrayList<>();
		descendingPrice.addAll(listP);
		Collections.sort(descendingPrice, Collections.reverseOrder()); 
        System.out.println("Price Print in  descending order: " + descendingPrice);
		return true; 

		
	}
	
	       
	public  PropertyDetailsPage selectpropery (){
		
		log.info("Try to click on 5th propery");
		Actions action  = new Actions(driver);
	    WaitTool.waitForElementPresent(property5, 10);
	    WaitTool.waitForElmentClick(property5, 10);
		action.moveToElement(property5).click().build().perform();
		log.info("Click and navigate to next page");
		System.out.println(driver.getCurrentUrl());
		return new PropertyDetailsPage(driver);
	}
	
}

	

