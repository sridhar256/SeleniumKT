package com.javascript;

import java.util.HashMap;

import org.testng.annotations.Test;

public class DataProvider {
	
	
	@org.testng.annotations.DataProvider(name ="login")
	
	public static Object[][] loginData(){
		
		Object[][] loginData = new Object[1][1];
		
		loginData[0][1] = "Admin";
		loginData[1][1] ="admin123";
		
		return loginData;
		 
		
	}
	
	@org.testng.annotations.DataProvider(name ="SignUp")
	public static Object[][] signUp() {
		
		Object[][] signUp = new Object[1][3];
		
		signUp[0][0] = "Test1";
		signUp[0][1] = "Test2";
		signUp[0][2] = "Test3";
		
		return signUp;
	}
	
	@org.testng.annotations.DataProvider
	
	public static Object[][] allData(){
		
		Object[][] data= new Object[1][1];
		
		HashMap<String, String> tcDataDD = new HashMap<String,String>();
		tcDataDD.put("username", "username");
		tcDataDD.put("password", "password");
		tcDataDD.put("email", "email");
		
		data[0][0] = tcDataDD;
		
		return data;
		
	}

}
