package com.javascript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonMethodsExcelParameters {

	public static  WebDriver browsername(WebDriver driver, String brName,
			String appURL) {

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
		
		return driver;

	}
	
	public static HashMap<String, String> readDataFromExcel(String flpath,String TCID) throws FileNotFoundException, IOException {
		
	//	String flapth = "D:\\Selenium\\Data\\NewTour\\Registration.xls";
		
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(flpath));
		
		HSSFSheet sht = wb.getSheet("Sheet1");
		
		int rc = sht.getLastRowNum();
		
		HashMap<String, String> tcData = new HashMap<String, String>();
		
		for (int r=1;r<=rc;r++) {
			int cc= sht.getRow(r).getLastCellNum();
			
			if(sht.getRow(r).getCell(0).toString().equalsIgnoreCase(TCID)) {
				for (int c=0;c<cc;c++) {
					String kname = sht.getRow(0).getCell(c).toString();
					String kvalue = sht.getRow(r).getCell(c).toString();
					
					tcData.put(kname, kvalue);
				}
				
				break;
			}
		}
		
		wb.close();
		return tcData;
		
	}


}
