package com.augment.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass {
	public static WebDriver driver;
	//public ExcelDataProvider excel;
	//public ConfigDataProvider config;
	//public static ObjectRepo objrepo;
	public static Properties prop;
	public static ExtentHtmlReporter reporter;
	public static  ExtentTest test;
	public static ExtentReports extent;
	public static SoftAssert softassert;
	@BeforeSuite
	public void report() {
	 reporter=new ExtentHtmlReporter("./Reports/AugmentoReport.html");
	 
	  extent = new ExtentReports();
	  extent.attachReporter(reporter);
	  softassert= new SoftAssert();
	 
	}
	
	
	@AfterSuite
	public void flushreport() {
	extent.flush();
	}
	
	
	public 	BaseClass() {

		File src = new File("./Configuration/Config.properties");
		File obj = new File("./Configuration/Config.properties");
		try {	
			FileInputStream fis = new FileInputStream(src);
			FileInputStream fisobj = new FileInputStream(obj);
			prop = new Properties();
			prop.load(fis);
			prop.load(fisobj);
			
		}catch(Exception e) {
					System.out.println("Not able to load file >>" +e.getMessage());
			
		}
		
	}
	
	public static String getDataFromConfig(String KeyTosearch) {
		return prop.getProperty(KeyTosearch);
		
	}
	
	public static String getDataFromObj(String KeyTosearch) {
		return prop.getProperty(KeyTosearch);
		
	}
	public static void init() {
		
		String browserName =  prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver =  new ChromeDriver(capabilities);
		}
		
		else {
			System.out.println("we do not support this browser");
		}
		
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		
	}
	
	
	
	
	
	
	
	/*
	 * @BeforeSuite public void setUpSuit() throws FileNotFoundException { excel =
	 * new ExcelDataProvider(); config = new ConfigDataProvider(); objrepo = new
	 * ObjectRepo();
	 * 
	 * 
	 * }
	 */
	
	 
	  
	/*
	 * 
	 * @AfterMethod public void tearDownMethod(ITestResult result) {
	 * 
	 * if(result.getStatus()==ITestResult.FAILURE) {
	 * Helper.captureScreenshot(driver); }
	 * 
	 * }
	 * 
	 */	
	public static void mouseover(WebElement we) throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(1000);
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
		 Alert a=driver.switchTo().alert();
	        a.accept();

	}
	
	
	public static void invisibilityWait(String locator) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));

		
	}
	
	
	
	
public static void approvalLogin(String approveType, String ApproveContent,String ActionDescripton ,String Action) throws InterruptedException {
	
	
	driver =  new ChromeDriver();
	driver.get(getDataFromConfig("ApprovalURL"));
	driver.findElement(By.name("user_name")).sendKeys(getDataFromConfig("AUserName"));
	driver.findElement(By.name("password")).sendKeys(getDataFromConfig("AUserPassword"));
	driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/input")).click();
	
	
	if(approveType.equalsIgnoreCase("EmailSender")) {
		
		mouseover(driver.findElement(By.xpath("//a[text()='Approval Admin']")));
		driver.findElement(By.xpath("//a[contains(text(),'E-Mail Sender List')]")).click();
		
		
		//Sender_Name(ApproveContent)
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[8]/textarea[@name='approval_remarks']")).sendKeys(ActionDescripton);
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[9]/input[@value='"+Action+"']")).click();
		
		
	}else if(approveType.equalsIgnoreCase("SmsSender")) {
		mouseover(driver.findElement(By.xpath("//a[text()='Approval Admin']")));
		driver.findElement(By.xpath("//a[text()='SMS Sender List']")).click();;
		
		//senderid
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[9]/textarea[@name='approval_remarks']")).sendKeys(ActionDescripton);
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[10]/input[@value='"+Action+"']")).click();
	}
	
	//smscontent
	else if(approveType.equalsIgnoreCase("SmsTemplate")) {
		mouseover(driver.findElement(By.xpath("//a[text()='Approval Admin']")));
		driver.findElement(By.xpath("//a[text()='SMS Content List']")).click();;
		
		//smsContent
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[9]/textarea[@name='approval_remarks']")).sendKeys(ActionDescripton);
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[10]/input[@value='"+Action+"']")).click();
		
	}else {
		mouseover(driver.findElement(By.xpath("//a[text()='Approval Admin']")));
		driver.findElement(By.xpath("//a[text()='OBD Content List']")).click();;
		
		//templateName
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[9]/textarea[@name='approval_remarks']")).sendKeys(ActionDescripton);
		driver.findElement(By.xpath("//td[@title='"+ApproveContent+"']/../td[10]/input[@value='"+Action+"']")).click();
		
	}
	
	
}
	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */

}
