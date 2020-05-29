package com.javascript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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

public class JavascriptExecutorParametersGrid {

	WebDriver driver;
	CommonMethodsJavascript cm = new CommonMethodsJavascript();
	HashMap<String, String> tcData;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
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

	@AfterTest
	public void endReport() {
		reports.flush();
	}

	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser","appURL","nodeUrl"})
	
	public void setUp(String browser, String appURL,String nodeUrl) throws FileNotFoundException, IOException {
			
			switch (browser) {
			case "chrome":
				
				System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new RemoteWebDriver(new URL(nodeUrl), DesiredCapabilities.chrome());
				
				break;
				
			case "firefox":
				
				System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver-v0.26.0-win32\\geckodriver.exe");
				driver = new RemoteWebDriver(new URL(nodeUrl), DesiredCapabilities.firefox());
				
				break;
				
				/*case "ie":
				
				System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
				driver = new RemoteWebDriver(new URL("http://169.254.82.182:5555/wd/hub/"), DesiredCapabilities.internetExplorer());*/
				
				default:
				
				System.out.println("Invalid browser name");
				System.exit(0);
				
			}
			
			driver.get(appURL);
			
			System.out.println(browser);
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		tcData = cm.readDataFromExcel("tcid1");

	}

	@Test(priority = 1)
	public void flashByJS() throws InterruptedException, IOException {

		test = reports.createTest("flashByJS");

		WebElement joinFree = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[2]/a"));
		JavascriptKT.flash(joinFree, driver);

		Assert.assertTrue(true);	
		
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
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
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
	}

	@Test(groups={"Sanity"})
	public void titleByJS() throws InterruptedException, IOException {

		test = reports.createTest("titleByJS");

		String title = JavascriptKT.titleByJS(driver);
		
		Assert.assertEquals(title,"Test" );
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
	}

	@Test(priority = 4)
	public void clickByJS() throws InterruptedException {

		test = reports.createTest("clickByJS");

		WebElement login = driver.findElement(By
				.xpath("html/body/div/header/div/ul/li[1]/a"));
		JavascriptKT.clickElementByJS(login, driver);

		Thread.sleep(2000);

		Assert.assertTrue(true);
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
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
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
	}

	@Test(priority =6,groups = {"Regression"})
	public void alertByJS() throws InterruptedException {

		test = reports.createTest("alertByJS");

		JavascriptKT.alertByJS(driver, "User clicked on Login button...");
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		Assert.assertTrue(true);
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
	}

	@Test(priority = 7)
	public void refreshBrowserByJS() throws InterruptedException {

		test = reports.createTest("refreshBrowserByJS");

		JavascriptKT.refreshBrowserByJS(driver);
		Thread.sleep(2000);

		Assert.assertTrue(false);
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
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
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);
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
		String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(currentMethodName);

	}

	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case is FAILED " + result.getName());
			test.log(Status.FAIL,
					"Test Case is SKIPPED" + result.getThrowable());

			String screenShotPath = JavascriptExecutorParameters.getScreenShot(
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
