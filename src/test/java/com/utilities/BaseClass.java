package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	@Parameters("browser")
	
	@BeforeClass
	public  void SetUp(String br) {
		 
		
		if (br.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",PropertiesUtilies.getProperty("ChromePath"));
			
			 driver=new ChromeDriver();
			
			
		}else if (br.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "fireFox");
			driver=new FirefoxDriver();
			
			
			
		}
driver.get(PropertiesUtilies.getProperty("BaseUrl"));
		
	}
@AfterClass
public void tearDown() {
	driver.quit();
}
	}


