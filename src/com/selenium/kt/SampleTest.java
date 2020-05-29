package com.selenium.kt;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SampleTest {
	
	WebDriver driver;
	CommonMethods cm;
	
	@Test
	public void setUp() {
		
		driver = cm.OpenBrowser(driver, "chrome", "https://www.ebay.com/sch/ebayadvsearch");
		
		
	}
	

}
