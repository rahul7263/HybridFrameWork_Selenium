package com.inetbanking.testCases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilites.ReadConfig;


public class BaseClass {
   
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseURL = readconfig.getApllicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		          
		//System.getProperty("user.dir")+"//Drivers//chromedriver.exe"
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver();
		
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
