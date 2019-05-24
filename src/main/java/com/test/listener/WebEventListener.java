package com.test.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.test.testbase.Testbase;

public class WebEventListener extends Testbase implements WebDriverEventListener {
	

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
		//welog.info("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
		//welog.info("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
		//welog.info("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
		//welog.info("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
		//welog.info("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
		//welog.info("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		//welog.info("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		//welog.info("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
		//welog.info("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
		//welog.info("Navigated forward to next page");
	}

	/*public void onException1(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		welog.info("Exception occured: " + error);
		try {
		Testbase.getScreenshot(driver, "screenShotName");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", element);*/
/*		
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File((System.getProperty("user.dir") + prjprop.getProperty("SCREEN_SHOT_PATH"))
					+ System.currentTimeMillis() + ".png"));
			System.out.println("Screenshot captured at location: " + System.getProperty("user.dir")
					+  prjprop.getProperty("SCREEN_SHOT_PATH"));
			welog.info("Screenshot captured at location: " + System.getProperty("user.dir")
			+  prjprop.getProperty("SCREEN_SHOT_PATH"));
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
		welog.info("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		welog.info("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	} {

	}
}

