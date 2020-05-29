package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginOhrmPOM {
	
	public static WebDriver driver;
	
	public LoginOhrmPOM(WebDriver driver) {
		this.driver=driver;
	}
	


	public WebElement txtUsername(){
		return driver.findElement(By.id("txtUsername"));
	}
	
	public WebElement txtPassword(){
		return driver.findElement(By.id("txtPassword"));
	}
	
	public WebElement btnLogin(){
		return driver.findElement(By.id("btnLogin"));
	}
	
	public void enterTextOnUsername(String val) {
		txtUsername().sendKeys(val);
		System.out.println(val+" entered on username textbox");
	}

	public void enterTextOnPassword(String val) {
		txtPassword().sendKeys(val);
		System.out.println(val+" entered on password textbox");
	}
	
	public void clickOnLogin() {
		btnLogin().click();
		System.out.println("clicked on login button");
	}

}
