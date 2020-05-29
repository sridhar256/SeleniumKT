package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class POM_Integration {

	public static WebDriver driver;
	public LoginOhrmPOM loginpage;


	public void openApplication(String brName, String appURL) {

		switch (brName) {
		case "chrome":
			// configure web driver
			System.setProperty("webdriver.chrome.driver",
					"D:\\Drivers\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
			break;

		case "ff":
			System.setProperty("webdriver.gecko.driver",
					"D:\\Drivers\\geckodriver-v0.26.0-win32\\geckodriver.exe");

			// opens a new FF window
			driver = new FirefoxDriver();

			break;

		case "ie":
			System.setProperty("webdriver.ie.driver",
					"D:\\Drivers\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Invalid browser name");
			System.exit(0);

		}

		driver.get(appURL);
		driver.manage().window().maximize();

		initPageClasses();
	}

	public void initPageClasses() {

			loginpage = new LoginOhrmPOM(driver);


	}

}
