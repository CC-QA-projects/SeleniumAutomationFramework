package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import java.util.logging.Logger;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{ 
	
	@Test
	public void testValidLogin() {
		Log.info("Starting Login Page");
		test = ExtentReportManager.createTest("Login Test");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials");
		test.info("Entered credentials");
		loginPage.enterUsername("admin@yourstore.com"); 
		loginPage.enterPassword("admin"); 
		loginPage.clickLogin();
		test.info("Clicked Login");

		
		test.info("Verify Page Title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		Log.info("Login test completed");
		test.pass("Login Successful");
	} 
	@Test
	public void testInvalidLogin() {
		Log.info("Starting Login Page");
		test = ExtentReportManager.createTest("Login Test with invalid credentials");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials");
		test.info("Entered credentials");
		loginPage.enterUsername("admin1234@yourstore.com"); 
		loginPage.enterPassword("admin"); 
		loginPage.clickLogin();
		test.info("Clicked Login");

		
		test.info("Verify Page Title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
		
		Log.info("Login test completed");
		test.pass("Login Successful");
	}

}
