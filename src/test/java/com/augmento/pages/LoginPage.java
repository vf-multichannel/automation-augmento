package com.augmento.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class LoginPage extends BaseClass{


	

	
	
	@FindBy(name = "user_name") WebElement uname;
	@FindBy(name = "password") WebElement pwd;
	@FindBy(xpath = "//input[@value = 'Login']") WebElement loginbtn;
	
	
	

	 public LoginPage() { PageFactory.initElements(driver, this); }
	 
	
	
	public HomePage LogintoAugmento(String lusername, String lpassword) {
		test =extent.createTest("Login Augmento");
		test.log(Status.INFO, "UserName : "+lusername);
		test.log(Status.INFO, "Password : "+lpassword);
		uname.sendKeys(lusername);
		
		pwd.sendKeys(lpassword);
		
		loginbtn.click();
		
		
		
		
	
	
		String title = driver.getCurrentUrl();
		
		
		
		//**********************
		softassert.assertEquals("http://qa.goinfinito.com/dashboard/channelOverview", title);
		test.log(Status.INFO, "Login Succesfully");
		


		return new HomePage();
			}
	
	
	
	
}
