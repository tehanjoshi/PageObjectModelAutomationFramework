package com.crm.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.base.Testbase;

public class ExtentManager  extends Testbase{

private static ExtentReports extent;

public static ExtentReports createInstance(String fileName) {
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);


htmlReporter.config().setTheme(Theme.STANDARD);
htmlReporter.config().setDocumentTitle(fileName);
htmlReporter.config().setEncoding("utf-8");
htmlReporter.config().setReportName(fileName);

extent = new ExtentReports();
extent.attachReporter(htmlReporter);
extent.setSystemInfo("Automation Tester", "Tehan Joshi");
extent.setSystemInfo("Organization", "TJ's");
extent.setSystemInfo("Build no", "27");


return extent;
}


public static String screenshotPath;
public static String screenshotName;

public static void captureScreenshot() {

File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

Date d = new Date(0);
screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

try {
FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}





}

}
