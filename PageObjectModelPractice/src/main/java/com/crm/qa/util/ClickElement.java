package com.crm.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickElement {
	
	public static void clickByXpath(WebDriver ldriver, String lxpath) {
		
		
		Actions actions = new Actions(ldriver);
		actions.moveToElement(ldriver.findElement(By.xpath(lxpath))).click().build().perform();
	}
		
		
		public static void clickByElement(WebDriver ldriver, WebElement lWebElement) {
			
			
			Actions actions = new Actions(ldriver);
			actions.moveToElement(lWebElement).click().build().perform();
	}

}
