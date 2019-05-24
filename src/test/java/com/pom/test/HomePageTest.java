package com.pom.test;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pom.pages.HomePage;
import com.pom.pages.PropertiesList;
import com.pom.pages.PropertyDetailsPage;
import com.test.testbase.Testbase;
import com.test.utilities.FileManager;

import dataprovider.Testdata;

public class HomePageTest extends Testbase {
	
	public static  Logger log = Logger.getLogger(HomePageTest.class.getName());
	 HomePage homepage;
	 PropertiesList propertieslist;
	  PropertyDetailsPage propertydetils;
	  Testdata test;
	 @BeforeMethod
	 public void pagesetup()
	 {
		  
		 
		  homepage = new HomePage(driver);
		  propertieslist = new PropertiesList(driver);
		  propertydetils = new PropertyDetailsPage(driver);
          test = new Testdata();
	 }
	 
	 @DataProvider 
	  public Object [][] testing () throws InvalidFormatException{
		  
		  Object data [][] = FileManager.getTestData("Country");
		  return data;
	  }
  @Test(dataProvider = "testing")
  public void searchLocation(String country) {
	  extentTest = extent.createTest("searchLocation");
      extentTest.log(Status.INFO, "searchLocation");
	  homepage.getURL();
	  homepage.searchlocation(country);
	  
  }
	  
	  @Test
	  public void priceAsscendingOrder(){
		  extentTest = extent.createTest("priceAsscendingOrder");
	      extentTest.log(Status.INFO, "priceAsscendingOrder");
	      log.info("Verify Price is asscending order");
	      assertTrue(	  propertieslist.price());
	      
	      
		
		  propertydetils.name();
		  assertTrue(propertydetils.address());
		  
		  
	  }
	  
	  
	  @Test
	  
	  public void selectPropertyNo5(){
		  extentTest = extent.createTest("selectPropertyNo5");
	      extentTest.log(Status.INFO, "selectPropertyNo5"); 
	      propertieslist.selectpropery();
	      assertTrue(true);
	  }
	 
	 
  
  

}