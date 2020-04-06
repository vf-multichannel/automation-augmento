package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augment.base.BaseClass;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListLibrary_BlackListPage;
import com.augmento.pages.ListManager_ListLibraryPage;
import com.augmento.pages.ListManager_NewListPage;
import com.augmento.pages.LoginPage;
import com.augmento.utility.ExcelReader;

public class ListLibrary_BlackListPageTest extends BaseClass {
	
	private static final boolean False = false;
	LoginPage loginpage;
	HomePage homepage;
	ListManager_NewListPage newlistpage;
	ListManager_ListLibraryPage listlibrarypage;
	ExcelReader reader;
	ListLibrary_BlackListPage blacklistpage;
	
	 
	public  ListLibrary_BlackListPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		init();
		listlibrarypage =new ListManager_ListLibraryPage();
		newlistpage = new ListManager_NewListPage();
		loginpage =  new LoginPage();
		blacklistpage =  new ListLibrary_BlackListPage();
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
				
		}
	
	
	
	@DataProvider 
	public Object[][] getexceldata() throws Exception {
		 
		 reader = new ExcelReader(System.getProperty("user.dir") +
		 "./TestData/Data.xlsx");
		 String sheetName =  prop.getProperty("ListManager_BlackList");
		 
		
		  int row = reader.getrowCount("ListManager_BlackList");
		  
		  int column = reader.getColumnCount("ListManager_BlackList");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("ListManager_BlackList", i + 1, j); } } return data; }
		
		  



@Test
(dataProvider = "getexceldata")
public void blackList(String ValueAdd, String mobileValue, String emailValue, String blackUploadPath, String emailIdentifier, String mobileIdentifier) throws InterruptedException {
	
	blacklistpage.blackList(ValueAdd, mobileValue, emailValue ,blackUploadPath, emailIdentifier, mobileIdentifier);
	
}


}
