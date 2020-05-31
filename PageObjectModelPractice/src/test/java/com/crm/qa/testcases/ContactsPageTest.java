package com.crm.qa.testcases;

import org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.ClickElement;;

public class ContactsPageTest  extends Testbase

{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	
	public ContactsPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		
		//contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsPageLink();
	}
	
	/*@Test(priority = 1)
	public void verifyContactsLabelDisplayedTest() {
		boolean isLabelDisplayed =contactsPage.verifyContactsLabelDisplayed();
		Assert.assertTrue(isLabelDisplayed , "label is not matching");
	}
	
	
	@Test(priority = 2)
	public void selectSingleContactByNameTest() {
		contactsPage.selectcontactsByName("Alley234 Yu");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsByNameTest() {
		contactsPage.selectcontactsByName("Alley1 Yu");
		contactsPage.selectcontactsByName("Alley2 Yu");
	}
	*/
	
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
			
	//
	//
	@Test(priority = 4,dataProvider="getCRMTestData")
	public void createNewContactTest(String title, String firstName, String lastName, String company) {
		
		
		System.out.println(title + firstName + lastName + company);
	
		//System.out.println(getCRMTestData());
	
		//	contactsPage.selectcontactsByName("Alley2 Yu");
		contactsPage.clickOnNewContactLink();		
		//contactsPage.createNewContact("Mr.", "Toma", "Peter", "Google");
		contactsPage.createNewContact(title,firstName, lastName,company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
