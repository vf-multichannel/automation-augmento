package com.augmento.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


import com.augmento.utility.Helper;


public class BaseClass {
	
	public static WebDriver driver;
	//public ExcelDataProvider excel;
	//public ConfigDataProvider config;
	//public static ObjectRepo objrepo;
	public static Properties prop;
	

	
	
	public 	BaseClass() {

		File src = new File("./Configuration/Config.properties");
		try {	
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e) {
					System.out.println("Not able to load file >>" +e.getMessage());
			
		}
		
	}
	
	public String getDataFromConfig(String KeyTosearch) {
		return prop.getProperty(KeyTosearch);
		
	}
	
	public static void init() {
		
		String browserName =  prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver =  new ChromeDriver();
		}
		
		else {
			System.out.println("we do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}
	
	
	
	
	
	
	
	/*
	 * @BeforeSuite public void setUpSuit() throws FileNotFoundException { excel =
	 * new ExcelDataProvider(); config = new ConfigDataProvider(); objrepo = new
	 * ObjectRepo();
	 * 
	 * 
	 * }
	 */
	 
	
	
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
		
	}
	
	public static void mouseover(WebElement we) {
		Actions action = new Actions(driver);
	
		action.moveToElement(we).build().perform();
	}
	
	
	public static void selectElementByVisbleText(WebElement ele, String val) {
		Select select = new Select(ele);
		//select.deselectByValue(val);
		select.selectByVisibleText(val);
	}
	
	public static void selectElementByValue(WebElement ele, int val) {
		Select select = new Select(ele);
		select.selectByIndex(val);;
		
	}
	
	
	public static void alert() {
		driver.switchTo().alert().accept();

	}
	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */

}
