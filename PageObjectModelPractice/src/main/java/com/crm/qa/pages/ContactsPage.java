package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;
import com.crm.qa.util.ClickElement;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends Testbase 
{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")           
            WebElement contactsLabel;
	
	@FindBy(id = "first_name")           
    WebElement firstNameInput;
	
	@FindBy(id = "surname")           
    WebElement lastNameInput;
	
	@FindBy(name = "client_lookup")           
    WebElement companyNameInput;
	
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsPageLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ContactsPage clickOnContactsPageLink() {
		ClickElement.clickByElement(driver,contactsPageLink );
		return new ContactsPage();
	}	
	
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);	
	
		//action.moveToElement(contactsPageLink).moveToElement(newContactLink).build().perform();
		TestUtil.mouseHoverJScript(contactsPageLink);
		
		newContactLink.click();
	}
	
	public boolean verifyContactsLabelDisplayed() {
		return contactsLabel.isDisplayed();
	}
	// //a[contains(text(),'Alley2 Yu')]/parent::td/preceding-sibling::td/input[@name='contact_id']
	
	public void selectcontactsByName(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'" + name+ "')]/parent::td/preceding-sibling::td/input[@name='contact_id']")).click();;
	}
	
	
	public void createNewContact( String titleName,String firstName , String lastName , String company)
	{
		//ClickElement.clickByElement(driver, firstNameInput);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select selectfromDropdown = new Select(driver.findElement(By.name("title")));
		selectfromDropdown.selectByValue(titleName);
		
		
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		companyNameInput.sendKeys(company);
		saveButton.click();
		
	}
	
	

}
