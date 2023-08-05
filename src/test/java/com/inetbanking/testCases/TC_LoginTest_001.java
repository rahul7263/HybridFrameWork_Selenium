package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
     
	@Test
	public void loginTest() {
	 
          driver.get(BaseURL);
          logger.info("URL is opened");
         
          LoginPage lp = new LoginPage(driver);
          
          lp.setUserName(username);
          logger.info("UserName Entred");
          
          lp.setPassword(password);
          logger.info("Passowrd Entred");
          
          lp.clickSubmit();
          
          if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
        	  
        	  Assert.assertTrue(true);
        	  logger.info("Login Test Passed");
          }
          else {
        	  Assert.assertTrue(false);
        	  logger.info("Login Test Failed");
          }
	}		
}
