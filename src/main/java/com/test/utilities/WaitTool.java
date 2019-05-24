package com.test.utilities;

import org.apache.xmlbeans.impl.regex.REUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Test;
import com.test.testbase.Testbase;

public class WaitTool {
	
	
	public static boolean waitForElementPresent(WebElement element,int timeout)
	{
		
		try{
			
			WebDriverWait wait = new WebDriverWait(Testbase.driver, timeout);
			
			element = wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
		
	}

	
	public static boolean waitForElmentClick(WebElement element,int timeout)
	{
		
		try
		{
			
			WebDriverWait wait = new WebDriverWait(Testbase.driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
