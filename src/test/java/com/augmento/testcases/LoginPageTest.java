package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.augment.base.BaseClass;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListManager_NewListPage;
import com.augmento.pages.LoginPage;
import com.augmento.utility.ExcelReader;

public class LoginPageTest extends BaseClass {
	ExcelReader reader;
	public static String excelsh;
	LoginPage loginpage;
	ListManager_NewListPage list_page;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		init();
		loginpage = new LoginPage();

	}
	
	
	
	@Test
	public void loginTest() {
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
	}
	
	
	
	

}