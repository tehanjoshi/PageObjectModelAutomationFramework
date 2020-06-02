package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties properties;
	public static EventFiringWebDriver 	eventFiringWebDriver;
	public  static WebEventListener webEventListener;
	
	public Testbase() {
		properties = new Properties();
		try {
			//FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ADMIN\\NewEclipseWorkspace\\PageObjectModelPractice\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			properties.load(fileInputStream);
		} 

		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
	}
	
	public static void initialization() {
		
		String browserString = properties.getProperty("browser");
		if(browserString.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "F:\\FromDesktop\\Selenium\\Selenium\\Rahul shetty\\chromedriver_win32_v83\\chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
			
		}
		else if(browserString.equals("firefox"))
		{	
			//C:\Users\ADMIN\Desktop\Selenium\Rahul shetty\geckodriver-v0.26.0-win64
			//System.setProperty("webdriver.gecko.driver", "F:\\FromDesktop\\Selenium\\Selenium\\Rahul shetty\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		webEventListener = new WebEventListener();
		eventFiringWebDriver.register(webEventListener);
		driver = eventFiringWebDriver;
			
					
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
		
		
		
	}
	
	

}
