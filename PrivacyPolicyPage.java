package testing.com;

import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;


public class PrivacyPolicyPage {
	
WebDriver driver;		
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.kbhome.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
		
	@Test (priority = 1)
	public void privacyPolicy() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		Reporter.log("User is able to click on privacyPolicy with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 2)
	public void link1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link1 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[1]"));
		js.executeScript("arguments[0].click()", link1);
		
		Reporter.log("User is able to click on 'What Information Does This Privacy Policy Cover?' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 3)
	public void link2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link2 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[2]"));
		js.executeScript("arguments[0].click()", link2);
		
		Reporter.log("User is able to click on 'Individuals Under the Age of 16' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 4)
	public void link3() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link3 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[3]"));
		js.executeScript("arguments[0].click()", link3);
		
		Reporter.log("User is able to click on 'Types of Information We Collect' with PASS Status");
		Thread.sleep(2000);
	}	
	
	@Test (priority = 5)
	public void link4() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link4 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[4]"));
		js.executeScript("arguments[0].click()", link4);
		
		Reporter.log("User is able to click on 'How We Collect Your Information' with PASS Status");
		Thread.sleep(2000);
	}	
	
	@Test (priority = 6)
	public void link5() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link5 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[5]"));
		js.executeScript("arguments[0].click()", link5);
		
		Reporter.log("User is able to click on 'How We Use Personal Information' with PASS Status");
		Thread.sleep(2000);
	}	
	
	@Test (priority = 7)
	public void link6() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link6 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[6]"));
		js.executeScript("arguments[0].click()", link6);
		
		Reporter.log("User is able to click on 'How We Share Your Information' with PASS Status");
		Thread.sleep(2000);
	}	
	
	@Test (priority = 8)
	public void link7() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link7 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[7]"));
		js.executeScript("arguments[0].click()", link7);
		
		Reporter.log("User is able to click on 'Posting Content' with PASS Status");
		Thread.sleep(2000);
	}	
	
	@Test (priority = 9)
	public void link8() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link8 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[8]"));
		js.executeScript("arguments[0].click()", link8);
		
		Reporter.log("User is able to click on 'Social Media Plugins' with PASS Status");
		Thread.sleep(2000);
	}	
	
	@Test (priority = 10)
	public void link9() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link9 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[9]"));
		js.executeScript("arguments[0].click()", link9);
		
		Reporter.log("User is able to click on 'Cookie Policy: Information We Collect Through Automatic Data Collection Technologies' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 11)
	public void link10() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link10 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[10]"));
		js.executeScript("arguments[0].click()", link10);
		
		Reporter.log("User is able to click on 'Third-Party Use of Cookies and Other Tracking Technologies' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 12)
	public void link11() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link11 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[11]"));
		js.executeScript("arguments[0].click()", link11);
		
		Reporter.log("User is able to click on 'Your Privacy Rights' with PASS Status");
		Thread.sleep(2000);
	}
	
	
	@Test (priority = 13)
	public void link12() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link12 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[12]"));
		js.executeScript("arguments[0].click()", link12);
		
		Reporter.log("User is able to click on 'Security' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 14)
	public void link13() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link13 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[13]"));
		js.executeScript("arguments[0].click()", link13);
		
		Reporter.log("User is able to click on 'Storage of Information' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 15)
	public void link14() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link14 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[14]"));
		js.executeScript("arguments[0].click()", link14);
		
		Reporter.log("User is able to click on 'Data Retention' with PASS Status");
		Thread.sleep(2000);
	}
	
	
	@Test (priority = 16)
	public void link15() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link15 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[15]"));
		js.executeScript("arguments[0].click()", link15);
		
		Reporter.log("User is able to click on 'How to Contact Us' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 17)
	public void link16() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link16 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[2]/a[16]"));
		js.executeScript("arguments[0].click()", link16);
		
		Reporter.log("User is able to click on 'Choices Regarding Your Information' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 18)
	public void link17() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link17 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[3]/a"));
		js.executeScript("arguments[0].click()", link17);
		
		Reporter.log("User is able to click on 'Privacy Policy' with PASS Status");
		Thread.sleep(2000);
	}
	
	@Test (priority = 19)
	public void link18() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link18 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[4]/a"));
		js.executeScript("arguments[0].click()", link18);
		
		Reporter.log("User is able to click on 'Terms and Conditions' with PASS Status");
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 20)
	public void link19() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
	
		WebElement privacyPolicy = driver.findElement(By.xpath("//section[@class='boilerplate ']/div/div[1]/a[2]"));
		js.executeScript("arguments[0].click()", privacyPolicy);
		
		WebElement link19 = driver.findElement(By.xpath("//main[@id='info']/div/span/p[4]/a"));
		js.executeScript("arguments[0].click()", link19);
		
		Reporter.log("User is able to click on 'Content Posting and Community Guidelines' with PASS Status");
		Thread.sleep(2000);
		
	}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	}


