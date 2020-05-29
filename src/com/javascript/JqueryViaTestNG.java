package com.javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JqueryViaTestNG {
	
	WebDriver driver; 

	
	@BeforeTest
	public void beforeTest(){
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		
/*		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY, options);*/
		
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/");
	}
	
	@Test(priority=0)
	public void draggable(){
		
		Actions act = new Actions(driver);

		driver.findElement(By.linkText("Draggable")).click();

		driver.switchTo().frame(0);

		WebElement draggable = driver.findElement(By.id("draggable"));

		act.dragAndDropBy(draggable, 100, 100).build().perform();

		driver.switchTo().defaultContent();

	}
	
	@Test(priority=1)
	public void droppable(){
		
		Actions act = new Actions(driver);

		driver.findElement(By.linkText("Droppable")).click();

		driver.switchTo().frame(0);

		WebElement draggable1 = driver.findElement(By.id("draggable"));

		WebElement droppable = driver.findElement(By.id("droppable"));

		act.dragAndDrop(draggable1, droppable).build().perform();

		driver.switchTo().defaultContent();

	}
	
	
	@Test(priority=2)
	public void resizable(){
		
		Actions act = new Actions(driver);

		driver.findElement(By.linkText("Resizable")).click();

		driver.switchTo().frame(0);

		WebElement resizableIcon = driver.findElement(By
				.xpath("//div[@id='resizable']/div[3]"));

		act.dragAndDropBy(resizableIcon, 100, 100).build().perform();

		driver.switchTo().defaultContent();

	}
	
	@Test(priority=3)
	public void selectable() throws InterruptedException{
		
		Actions act = new Actions(driver);

		driver.findElement(By.linkText("Selectable")).click();

		driver.switchTo().frame(0);

		WebElement item1 = driver.findElement(By
				.xpath("//ol[@id='selectable']/li[1]"));
		
		WebElement item3 = driver.findElement(By
				.xpath("//ol[@id='selectable']/li[3]"));
		
		
		WebElement item5 = driver.findElement(By
				.xpath("//ol[@id='selectable']/li[5]"));

		act.keyDown(Keys.CONTROL).click(item1).build().perform();
		
		act.keyDown(Keys.CONTROL).click(item3).build().perform();

		act.keyDown(Keys.CONTROL).click(item5).build().perform();

		
		Thread.sleep(3000);

		driver.switchTo().defaultContent();

	}
	
	
	@Test(priority=4)
	public void sortable() throws InterruptedException{
		
		Actions act = new Actions(driver);

		driver.findElement(By.linkText("Sortable")).click();
		
		driver.switchTo().frame(0);
		
		Thread.sleep(3000);

		WebElement sortableItem1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		
		WebElement sortableItem3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]"));
		
		//act.dragAndDropBy(sortableItem1, 0, 100).build().perform();
		
		//act.dragAndDropBy(sortableItem3, 0, 600).build().perform();
		act.clickAndHold(sortableItem3).moveToElement(sortableItem1).release().build().perform();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();

	}
	
	
	@Test(priority=5)
	public void authenticationPopup(){
		
	
	}
	

	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
	

}
