
package com.crm.qa.pages;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.ClickElement;


public class HomePage extends Testbase {
	
	
	@FindBy(xpath = "//td[@class='headertext'][contains(text(),'Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsPageLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsPageLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksPageLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
		
	
	
	public boolean verifyUserNameDisplayed() {
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle() {		
		return driver.getTitle();			
	}
	
	
	public ContactsPage clickOnContactsPageLink() {
		ClickElement.clickByElement(driver,contactsPageLink );
		return new ContactsPage();
	}	
	
	
/*	public ContactsPage clickOnNewContactLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsPageLink).build().perform();
		newContactLink.click();
		return new ContactsPage();
	}*/
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		
		action.moveToElement(contactsPageLink).build().perform();
		
		newContactLink.click();
	}
	
	public DealsPage clickOnDealsPageLink() {
		ClickElement.clickByElement(driver,dealsPageLink );
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPageLink() {
		ClickElement.clickByElement(driver,tasksPageLink );
		return new TasksPage();
	}
	
}
