package com.javascript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class JavascriptExecutorDemo {

	WebDriver driver;
	CommonMethodsJavascript cm = new CommonMethodsJavascript();
	HashMap<String, String> tcData;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	

	@BeforeTest(alwaysRun=true)
	public void setUpReports() {
		reporter = new ExtentHtmlReporter(
				"D:\\workspace1\\Selenium\\ExtentReports\\myReport.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("May Javascript Testing");
		reporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Hostname", "LocalHost");
		reports.setSystemInfo("OS", "Windows8");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("QA", "Sridhar");

	}

	@AfterTest(alwaysRun=true)
	public void endReport() {
		reports.flush();
	}

	@BeforeMethod(alwaysRun=true)
	public void openBrowser() throws FileNotFoundException, IOException {

		driver = cm.browsername(driver, "chrome", "https://www.twoplugs.com/");
		tcData = cm.readDataFromExcel("tcid1");
		
	

	}

	@Test(priority = 1)
	public void flashByJS() throws InterruptedException, IOException {

		test = reports.createTest("flashByJS");

		WebElement joinFree = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[2]/a"));
		JavascriptKT.flash(joinFree, driver);

		Assert.assertTrue(true);

	}

	@Test(groups={"Sanity"})
	public void borderbyJS() throws IOException {

		test = reports.createTest("borderbyJS");

		WebElement joinFree = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[2]/a"));
		JavascriptKT.drawBorder(joinFree, driver);

		/*File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"D:\\workspace1\\Selenium\\Screenshots\\border.png");
		FileUtils.copyFile(src, dest);*/

		Assert.assertTrue(true);

	}

	@Test(groups={"Sanity"})
	public void titleByJS() throws InterruptedException, IOException {

		test = reports.createTest("titleByJS");

		String title = JavascriptKT.titleByJS(driver);
		
		Assert.assertEquals(title,"Test" );

	}

	@Test(priority = 4)
	public void clickByJS() throws InterruptedException {

		test = reports.createTest("clickByJS");

		WebElement login = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[1]/a"));
		JavascriptKT.clickElementByJS(login, driver);

		Thread.sleep(2000);

		Assert.assertTrue(true);

	}

	@Test(priority = 5)
	public void disableEnableByJS() throws InterruptedException {

		test = reports.createTest("disableEnableByJS");

		WebElement login = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[1]/a"));
		JavascriptKT.clickElementByJS(login, driver);

		WebElement username = driver.findElement(By.id("signInEmail"));
		JavascriptKT.disableAnElementByJS(username, driver);

		Thread.sleep(3000);
		JavascriptKT.enableAnElementByJS(username, driver);

		Thread.sleep(2000);

		Assert.assertTrue(true);

	}

	@Test(priority =6,groups = {"Regression"})
	public void alertByJS() throws InterruptedException {

		test = reports.createTest("alertByJS");

		JavascriptKT.alertByJS(driver, "User clicked on Login button...");
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		Assert.assertTrue(true);
	}

	@Test(priority = 7)
	public void refreshBrowserByJS() throws InterruptedException {

		test = reports.createTest("refreshBrowserByJS");

		JavascriptKT.refreshBrowserByJS(driver);
		Thread.sleep(2000);

		Assert.assertTrue(false);
	}

	@Test(priority = 8)
	public void scrollByJS() throws InterruptedException {

		test = reports.createTest("scrollByJS");

		WebElement SignOn = driver.findElement(By
				.cssSelector("li#rslides3_s0>div:nth-of-type(1)"));

		JavascriptKT.scrollintoViewByJS(SignOn, driver);

		Thread.sleep(2000);

		JavascriptKT.scrollPagDown(driver);

		Thread.sleep(2000);

		JavascriptKT.scrollPagUp(driver);

		Thread.sleep(2000);

		Assert.assertTrue(true);
	}

	@Test(priority = 9)
	public void senKeysByJS() throws InterruptedException {

		test = reports.createTest("senKeysByJS");

		WebElement login = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[1]/a"));
		JavascriptKT.clickElementByJS(login, driver);

		Thread.sleep(2000);

		WebElement username = driver.findElement(By.id("signInEmail"));
		JavascriptKT.sendKeysByJS(username, driver);

		Thread.sleep(2000);

		System.out.println(tcData.get("Password"));
		driver.findElement(By.id("signInPassword")).sendKeys(
				tcData.get("Password"));
		
		Thread.sleep(2000);

		Assert.assertTrue(true);

	}
	
/*	@Test(priority=10) 
	public void elementExist(){
		
		By locator = By.xpath("html/body/div/header/div/ul/li[1]/a");
		
		driver.findElement(locator);
		
	}*/

	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case is FAILED " + result.getName());
			test.log(Status.FAIL,
					"Test Case is SKIPPED" + result.getThrowable());

			String screenShotPath = JavascriptExecutorDemo.getScreenShot(
					driver, result.getName());
			test.addScreenCaptureFromPath(screenShotPath);

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case is SKIPPED " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case is PASSED " + result.getName());
		}

		driver.quit();
	}

	public static String getScreenShot(WebDriver driver, String ScreenShotName)
			throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = "D:\\workspace1\\Selenium\\Screenshots\\FailedScreenshot.png";
		File dest = new File(destination);
		FileUtils.copyFile(src, dest);

		return destination;

	}

}
