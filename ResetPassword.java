package testing.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResetPassword {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.kbhome.com/");
	}
	
	@Test
	public void KBHomeLoginPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement signin = driver.findElement(By.id("mykb"));
		js.executeScript("arguments[0].click()", signin);
		Reporter.log("User is able to click on 'SIGN IN' with PASS Status");
		Thread.sleep(2000);

		WebElement haveAccount = driver.findElement(By.id("have-account"));
		js.executeScript("arguments[0].click()", haveAccount);
		Reporter.log("User is able to click on 'Already have an account' with PASS Status");
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.xpath("//form[@id='login-form']/div/p[2]/input"));
		js.executeScript("arguments[0].value = 'sreedhar@stellaragency.com';", email);
		Reporter.log("User is able to input 'sreedhar@stellaragency.com' in email field with PASS Status");
		Thread.sleep(2000);

		WebElement resetPassword = driver.findElement(By.xpath("//form[@id='login-form']/div/p[6]/a"));
		js.executeScript("arguments[0].click()", resetPassword);
		Reporter.log("User is able to click on 'Forgot your password?' with PASS Status");
		Thread.sleep(2000);

		WebElement resetPasswordEmail = driver.findElement(By.xpath("//input[@title='not a valid email']"));
		js.executeScript("arguments[0].value = 'sreedhar@stellaragency.com';", resetPasswordEmail);
		Reporter.log("User is able to click on 'Forgot your password?' with PASS Status");
		Thread.sleep(2000);

		WebElement resetMyPassword = driver.findElement(By.xpath("//input[@value='Reset my password']"));
		js.executeScript("arguments[0].click()", resetMyPassword);
		Reporter.log("User is able to click on 'Reset my password' with PASS Status");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
