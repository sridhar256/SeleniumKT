package com.javascript;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GroupingTests {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true,enabled=true)
	@Parameters({"browser","appURL"})
	public void openBrowser(String browser,String appURL) throws FileNotFoundException, IOException {

		switch (browser) {
		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			break;
			
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			break;
			
		case "ie":
			
			System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			default:
			
			System.out.println("Invalid browser name");
			System.exit(0);
			
		}
		
		driver.get(appURL);

		driver.manage().window().maximize();

	}

	@Test(groups = { "Sanity" },invocationCount =3)
	public void test1() {

		System.out.println("This is test1");
		

	}

	@Test(groups = { "Sanity" })
	public void test2() {

		System.out.println("This is test2");

	}

	@Test(groups = { "Regression" })
	public void test3() {

		System.out.println("This is test3");

	}

	@Test(groups = { "Regression" })
	public void test4() {

		System.out.println("This is test4");

	}

	@Test(groups = { "Sanity", "Regression" })
	public void test5() {

		System.out.println("This is test5");

	}

	@AfterMethod(alwaysRun=true,enabled = true)
	public void tearDown() {
		driver.quit();
	}
}
