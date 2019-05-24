package com.makemytrip.test;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.makemytrip.pages.Makemytrip;
import com.test.testbase.Testbase;

public class MakeMytriptest extends Testbase{

	
	public static Logger log = Logger.getLogger(Makemytrip.class.getName());
	
	Makemytrip makemytrip;
	
	
	@BeforeMethod
	public void pagesetup(){
		
		makemytrip = new Makemytrip(driver);
	}

	
	@Test (priority = 1)
	public void selectRountTript(){
		   extentTest = extent.createTest("selectRountTript");
	       extentTest.log(Status.INFO, "selectRountTript");
		   makemytrip.roundTrip();
	}
	
	@Test(priority = 2)
	public void enterciytName()
	{
		
		extentTest = extent.createTest("enterciytName");
		extentTest.log(Status.INFO, "enterciytName");
		makemytrip.enterCityName("Bangkok, Thailand");
	}
	
	@Test(priority =3)
	public void enterToCityName() throws InterruptedException
	{
		extentTest = extent.createTest("enterciytName");
		extentTest.log(Status.INFO, "enterciytName");
		
			
	
		makemytrip.enterTocityName("Bangalore, India");
		Thread.sleep(1000);
		
	}
}
