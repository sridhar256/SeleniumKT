package testing.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MIRPage {
	
	WebDriver driver;
	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;
	
@BeforeMethod 
	public void openApplication1() throws InterruptedException, FileNotFoundException, IOException {
		driver = CommonMethods.OpenBrowser(driver, "chrome","url");
		tcData = CommonMethods.readDataFromTC("tc1");
	}
	
	@Test
	public void MIRPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement findAHome = driver.findElement(By.xpath("//nav[@id='main-nav']/ul/li[2]/div/div[1]/a/span"));
		js.executeScript("arguments[0].click()", findAHome);
		Reporter.log("User is able to click on 'Find a Home' with PASS Status");
		Thread.sleep(3000);
		
		WebElement phoenix = driver.findElement(By.linkText("Phoenix"));
		js.executeScript("arguments[0].click()", phoenix);
		Reporter.log("User is able to click on 'Phoenix' with PASS Status");
		Thread.sleep(3000);
				
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='community-listing']/div[3]/div[3]/div[2]/a")));
		
		WebElement exploreCommunity = driver.findElement(By.xpath("//div[@id='community-listing']/div[3]/div[3]/div[2]/a"));
		js.executeScript("arguments[0].click()", exploreCommunity);
		Reporter.log("User is able to click on 'Explore Community' with PASS Status");
		Thread.sleep(3000);
				
		WebElement moveinReadyHomes = driver.findElement(By.xpath("//section[@id='community-listings']/div/ul/li[2]/a"));
		js.executeScript("arguments[0].click()", moveinReadyHomes);
		Reporter.log("User is able to click on 'Move-in Ready Homes' with PASS Status");
		Thread.sleep(3000);
		
		WebElement moveinReadyHomesView = driver.findElement(By.xpath("//section[@id='community-listings']/div[1]/ul/li[2]"));
		js.executeScript("arguments[0].scrollIntoView();", moveinReadyHomesView);
		Reporter.log("User is able to view the 'Move-in Ready Homes' with PASS Status");
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}

