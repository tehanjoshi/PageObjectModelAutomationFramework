package com.crm.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends Testbase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void verifyUserNameDisplayedTest() {
		
		testUtil.switchToFrame();
		boolean userNameDisplayed = homePage.verifyUserNameDisplayed();
		Assert.assertTrue(userNameDisplayed,"user name not displayed");
	}
	
	@Test(priority = 1)
	public void  verifyHomePageTitleTest() {
		String homePageTitleString = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitleString, "CRMPRO", "Home Page title not matched");
	}
	

	@Test(priority = 1)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsPageLink();
		
		
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
