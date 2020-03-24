package com.augmento.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseClass{


	

	
	
	@FindBy(name = "user_name") WebElement uname;
	@FindBy(name = "password") WebElement pwd;
	@FindBy(xpath = "//input[@value = 'Login']") WebElement loginbtn;
	
	
	

	 public LoginPage() { PageFactory.initElements(driver, this); }
	 
	
	
	public HomePage LogintoAugmento(String lusername, String lpassword) {
		uname.sendKeys(lusername);
		pwd.sendKeys(lpassword);
		loginbtn.click();
		return new HomePage();
		
	}
	
	
	
	
}
