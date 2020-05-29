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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class JavascriptExecutorDemoDataProviderExcel {

	WebDriver driver;
	CommonMethodsExcelParameters cm = new CommonMethodsExcelParameters();
	HashMap<String, String> tcData;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest(alwaysRun = true)
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

	@AfterTest(alwaysRun = true)
	public void endReport() {
		reports.flush();
	}

	@Parameters({ "browser", "appURL", "flpath" })
	@BeforeMethod(alwaysRun = true)
	public void openBrowser(String browser, String appURL, String flpath)
			throws FileNotFoundException, IOException {

		driver = cm.browsername(driver, "chrome", "https://www.twoplugs.com/");
		tcData = cm.readDataFromExcel(flpath, "tcid1");

	}

	@Test(priority = 1)
	public void senKeysByJS() throws InterruptedException {

		test = reports.createTest("senKeysByJS");

		WebElement login = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[1]/a"));
		JavascriptKT.clickElementByJS(login, driver);

		Thread.sleep(2000);

		driver.findElement(By.id("signInEmail")).sendKeys(
				tcData.get("username"));

		Thread.sleep(2000);

		driver.findElement(By.id("signInPassword")).sendKeys(
				tcData.get("password"));

		Thread.sleep(2000);

		Assert.assertTrue(true);

	}

	@Test(priority = 2)
	public void signUp() throws InterruptedException {

		test = reports.createTest("signUp");

		WebElement signUp = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[2]/a"));

		JavascriptKT.clickElementByJS(signUp, driver);

		Thread.sleep(2000);

		driver.findElement(By.id("signUpUser")).sendKeys(
				tcData.get("username"));

		Thread.sleep(2000);

		driver.findElement(By.id("signUpEmail"))
				.sendKeys(tcData.get("email"));

		Thread.sleep(2000);

		driver.findElement(By.id("signUpPassword")).sendKeys(
				tcData.get("password"));

		Thread.sleep(2000);

		Assert.assertTrue(true);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case is FAILED " + result.getName());
			test.log(Status.FAIL,
					"Test Case is SKIPPED" + result.getThrowable());

			String screenShotPath = JavascriptExecutorDemoDataProviderExcel
					.getScreenShot(driver, result.getName());
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
