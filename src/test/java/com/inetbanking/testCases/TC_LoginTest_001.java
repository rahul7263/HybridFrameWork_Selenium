package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
     
	@Test
	public void loginTest() {
		 
		ExtentSparkReporter htmlReport = new  ExtentSparkReporter("E-BankingReports.html");
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(htmlReport);
		 ExtentTest test = extent.createTest("E-banking Test info");
		 
         
          driver.manage().window().maximize();
          test.info("E-Banking App Opned");
        
         
          LoginPage lp = new LoginPage(driver);
          
          lp.setUserName(username);
          test.info("Password Entered");
        
          lp.setPassword(password);
          test.info("user-name entered");
          
          lp.clickSubmit();
          test.info("Submit Button Clicked");
          
          if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
        	  
        	  Assert.assertTrue(true);
        	
          }
          else {
        	  Assert.assertTrue(false);
        
          }
          
          extent.flush();
	}		
}
