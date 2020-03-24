package com.augmento.testcases;

import java.io.FileNotFoundException;

import org.apache.bcel.classfile.Utility;
import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augmento.pages.BaseClass;
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