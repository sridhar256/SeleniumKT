package com.javascript;

import java.awt.Toolkit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeliniumQuestions {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Drivers\\chromedriver_win32\\chromedriver.exe");

		//WebDriver driver = new ChromeDriver();
		
		String str= "2,567.65";
	    double d = Double.parseDouble(str.replace(",", ""));
	    System.out.println(d);
	    
	    String str1= "2,567";
	    int d1 = Integer.parseInt(str1.replaceFirst(",", ""));
	    System.out.println(d1);

	}

}
