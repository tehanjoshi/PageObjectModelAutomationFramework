package com.crm.qa.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

import com.crm.qa.util.ClickElement;

public class LoginPage extends Testbase {

	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit'][@value='Login']")
	WebElement submitButton;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement crmLogo;

	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
		
	
	public boolean validateCRMImage() 
	{
		return crmLogo.isDisplayed();
		
	}
		
		
	public HomePage login(String un ,String pwd) {
		
		userName.sendKeys(un);
		password.sendKeys(pwd);
		ClickElement.clickByElement(driver, submitButton);
		
		return new HomePage();
		
	}
	
	
	
	
	
	
}
