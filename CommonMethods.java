package testing.com;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {

	public static WebDriver OpenBrowser(WebDriver driver, String brName,
			String appUrl) {

		switch (brName) {
		case "chrome":
			// configure web driver
			System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");

			// opens a new chrome window
			driver = new ChromeDriver();
			break;
		case "ff":
			// configure web driver
			System.setProperty("webdriver.gecko.driver",
					"C:\\BrowserDriver\\geckodriver.exe");

			// opens a new FF window
			driver = new FirefoxDriver();

			break;
		case "edge":
			// configure web driver
			System.setProperty("webdriver.edge.driver", 
					"C:\\BrowserDriver\\msedgedriver.exe");


			// opens a new edge window
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			System.exit(0);
		}
		
		driver.manage().deleteAllCookies();

		// maximize window
		driver.manage().window().maximize();

		// open url
		driver.get("https://www.kbhome.com/");
		
		// specify page load time
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// specify element load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;

	}

	public static HashMap<String, String> readDataFromTC(String tcID)
			throws FileNotFoundException, IOException {
		String flPath = "C:\\Data\\Data.xls";

		// open work book
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(flPath));
		// get sheet
		HSSFSheet sht = wb.getSheet("Sheet1");

		// get row count
		int rc = sht.getLastRowNum();

		HashMap<String, String> tcData = new HashMap<String, String>();
		for (int r = 1; r <= rc; r++) {
			int cc = sht.getRow(r).getLastCellNum();
			if (sht.getRow(r).getCell(0).toString().equalsIgnoreCase(tcID)) {

				for (int c = 0; c < cc; c++) {
					String kName = sht.getRow(0).getCell(c).toString();
					String kVal = sht.getRow(r).getCell(c).toString();
					tcData.put(kName, kVal);
				}
				break;
			}
		}
		wb.close();
		return tcData;

	}
}

