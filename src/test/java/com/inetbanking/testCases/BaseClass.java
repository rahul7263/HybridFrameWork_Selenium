package com.inetbanking.testCases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.utilites.ReadConfig;


public class BaseClass {
   
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseURL = readconfig.getApllicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome")) {
		//System.getProperty("user.dir")+"//Drivers//chromedriver.exe"
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		 driver.get(BaseURL);
		 
		 
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
