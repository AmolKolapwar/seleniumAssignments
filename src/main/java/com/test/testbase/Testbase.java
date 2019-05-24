package com.test.testbase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.listener.WebEventListener;
import com.test.utilities.FileManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase extends FileManager {

	public static Logger log = Logger.getLogger(Testbase.class.getName());
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	 private static Platform platform;
	String nodeURL;
	

  @BeforeClass
  
  /*private static Platform getCurrentPlatform () {
      if (platform == null) {
          String operSys = System.getProperty("os.name").toLowerCase();
          System.out.println("Os Name: ===="  + operSys);
          if (operSys.contains("win")) {
              platform = Platform.WINDOWS;
          } else if (operSys.contains("nix") || operSys.contains("nux")
                  || operSys.contains("aix")) {
              platform = Platform.LINUX;
          } else if (operSys.contains("mac")) {
              platform = Platform.MAC;
          }
      }
      return platform;
  }  
*/
  @Parameters({"browser","appUrl"})
  public WebDriver setup(String browser,String appUrl) throws MalformedURLException 
  {
	  
	  
	 /* nodeURL = "http://192.168.1.150:4444/wd/hub";
      DesiredCapabilities capability = DesiredCapabilities.firefox();
      capability.setBrowserName("firefox");
      capability.setPlatform(Platform.ANY);
      driver = new RemoteWebDriver(new URL(nodeURL), capability);*/
	  if ( browser.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		 // System.getProperty("webdriver.chrome.driver","D:\\Amol_BkUp\\SeleniumAssignments\\SeleniumAssignments\\src\\main\\resources\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }else if(browser.equalsIgnoreCase("FF"))
	  { 
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
	  }
	  
	  
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener(); 
		e_driver.register(eventListener);
		driver = e_driver;
		
	  driver.get(appUrl);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  
	  

	return driver;
	
	  
	  
	  
  }
  
  @BeforeSuite
  public void extentSetUp() {
try{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + prjprop.getProperty("REPORT_LOCATION"));
		System.out.println(htmlReporter);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Host Name", "Amol");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "AMOL KOLAPWAR");
      
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Selenium Automation Repots");
		htmlReporter.config().setReportName("Test Execution Report ");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
}catch (Exception e){
	System.out.println(e.getMessage());
}
	}
			
			
  
  


  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
	  
	  
	  
	  
  }
  
  
       public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		Date date = new Date();

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + "\\"+ screenshotName +"_" +dateName
				+ ".png";
		
		System.out.println("Screenshot captured at location: " + destination);

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		log.debug(" ########### Screenshot captured at location: ########### " + destination);

		return destination;
		
	}

}
