package com.pom;

public class OhrmMain {

	public static void main(String[] args) {
		
		POM_Integration pom = new POM_Integration();
		
		pom.openApplication("chrome", "https://opensource-demo.orangehrmlive.com/");
		pom.loginpage.enterTextOnUsername("Admin");
		pom.loginpage.enterTextOnPassword("admin123");
		pom.loginpage.clickOnLogin();

	}

}
