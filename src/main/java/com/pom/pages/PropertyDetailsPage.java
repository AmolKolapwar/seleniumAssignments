package com.pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailsPage {

	
	private static final boolean WebElement = false;

	protected WebDriver driver;
	public PropertyDetailsPage(WebDriver driver)
	{
		 this.driver =  driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath=("//article[@class='dp-sidebar-wrapper__summary']//h2"))
      WebElement nameofhouse;
	
	@FindBy(xpath=("//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']"))
	WebElement agentName;
	
	static String abc = null;
	public String  name(){
		 
		abc = nameofhouse.getText();
		System.out.println("Print the house name :" + abc);
		return abc;
	}
	
	
	
	public boolean  address(){
		agentName.click();
		List<WebElement> addressName = driver.findElements(By.xpath("//div[@class='clearfix agents-latest-listings']/parent::div//a[@class='listing-results-address']"));
		
		   for(WebElement name1 : addressName){
			String name2 = name1.getText();
			//String name3 = name();
			System.out.println("Print the All Property Name :"  +name2 );
			
			if (name2.equals(abc)){
				System.out.println("print the =============");
				
			}
			return true;
		}
		return false;
	}
	
	
}
