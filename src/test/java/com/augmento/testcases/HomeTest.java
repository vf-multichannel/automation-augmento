package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.augment.base.BaseClass;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListManager_NewListPage;
import com.augmento.pages.LoginPage;


public class HomeTest extends BaseClass{
	
	
	LoginPage loginpage;
	HomePage homepage;
	ListManager_NewListPage newlistpage;
	 
	public  HomeTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		init();
		newlistpage = new ListManager_NewListPage();
		loginpage =  new LoginPage();
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
				
		}
	
	@Test
	public void newList() throws InterruptedException {
		newlistpage=homepage.clickOnListManager();
	}
	
	
	
	

}
