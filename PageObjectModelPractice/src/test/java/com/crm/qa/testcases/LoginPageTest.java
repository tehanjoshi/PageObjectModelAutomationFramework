package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Testbase{
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
		
	}
	
	
	@BeforeTest
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		
	}
	
	
	@Test(priority = 1)
	public void  loginPageTitleTest() {
		String titleString = loginPage.validateLoginPageTitle();
		Assert.assertEquals(titleString, "CRMPRO - CRM software for customer relationship management, sales, and support.");

	}
	
	
	@Test(priority = 2)
	public void loginPageLogoTest() {
		boolean logoDisplayed = loginPage.validateCRMImage();
		Assert.assertTrue(logoDisplayed);

	}
	
	
	@Test(priority = 3)
	public void loginPageLoginTest() {
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
