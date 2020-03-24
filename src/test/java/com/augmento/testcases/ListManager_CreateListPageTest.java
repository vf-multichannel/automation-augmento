package com.augmento.testcases;

import java.awt.AWTException;
import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augmento.pages.BaseClass;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListManager_ListLibraryPage;
import com.augmento.pages.LoginPage;
import com.augmento.pages.NewListPage;
import com.augmento.utility.ExcelReader;

public class ListManager_CreateListPageTest extends BaseClass {
	
	
	LoginPage loginpage;
	HomePage homepage;
	NewListPage newlistpage;
	ExcelReader reader;
	ListManager_ListLibraryPage listlibraryPage;
	

	public ListManager_CreateListPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {	
		init();
		listlibraryPage = new ListManager_ListLibraryPage();
		newlistpage = new NewListPage();
		loginpage =  new LoginPage();
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
		newlistpage = homepage.clickOnListManager();
	}
	
	@DataProvider 
	public Object[][] getexceldata() throws Exception {
		 
		 reader = new ExcelReader(System.getProperty("user.dir") +
		 "./TestData/Data.xlsx");
		  
		  int row = reader.getrowCount("ListManager_CreateList");
		  
		  int column = reader.getColumnCount("ListManager_CreateList");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("ListManager_CreateList", i + 1, j); } } return data; }
		  
		  
		 
		  
		
		  @Test(dataProvider = "getexceldata")
		  
		  
		  public void loginAugmento(String listName, String Listcategory, String description, String typeFile, String filePath , String emailModifier, 
				  String mobileIdentifier, String UniqueIdentifier, String jsonDataHeader, String jsonData, String delimeters) throws
		  FileNotFoundException, AWTException, InterruptedException {
		  
		  
			  newlistpage.createList(listName, Listcategory, description);
			  newlistpage.createFileInlist(typeFile, filePath, emailModifier, mobileIdentifier, UniqueIdentifier , jsonDataHeader ,jsonData, delimeters );
			
			  
			  
		  }
		  
		  
		

}
