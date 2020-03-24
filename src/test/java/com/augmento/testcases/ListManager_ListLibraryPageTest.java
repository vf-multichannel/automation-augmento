package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augmento.pages.BaseClass;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListManager_ListLibraryPage;
import com.augmento.pages.LoginPage;
import com.augmento.pages.ListManager_CreateListPage;
import com.augmento.utility.ExcelReader;

public class ListManager_ListLibraryPageTest extends BaseClass {
	
	
	private static final boolean False = false;
	LoginPage loginpage;
	HomePage homepage;
	ListManager_CreateListPage newlistpage;
	ListManager_ListLibraryPage listlibrarypage;
	ExcelReader reader;
	 
	public  ListManager_ListLibraryPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		init();
		listlibrarypage =new ListManager_ListLibraryPage();
		newlistpage = new ListManager_CreateListPage();
		loginpage =  new LoginPage();
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
				
		}
	
	
	
	@DataProvider 
	public Object[][] getexceldata() throws Exception {
		 
		 reader = new ExcelReader(System.getProperty("user.dir") +
		 "./TestData/Data.xlsx");
		 String sheetName =  prop.getProperty("ListManger_ListLibrary");
		 
		
		  int row = reader.getrowCount("ListManger_ListLibrary");
		  
		  int column = reader.getColumnCount("ListManger_ListLibrary");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("ListManger_ListLibrary", i + 1, j); } } return data; }
		
		  
	
		 
		  
		
		  
	

	/*
	 * @Test public void clickOnListLibrary() { listlibrarypage.goToListLibrary(); }
	 */
	

	/*
	 * @Test(enabled = False) //(dataProvider = "getexceldata") public void
	 * deleteList(String typeOfDelete, String value) throws InterruptedException {
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	  
	  
	  

			  
			  
			 
	/*
	 * 
	 * @Test(dataProvider = "getexceldata") public void exportList(String
	 * FileFormat, String delimeter, String valueListExport) throws
	 * InterruptedException {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 */
	  
	  
	
	 @Test(dataProvider = "getexceldata")
    public void createSegment(String Action, String typeOfDelete, String value,String
    		FileFormat, String delimeter, String valueListExport, String categorizeListx, String nameOfListx, String descriptionListx, String svalue,  
    		String selectRule, String ruleList, String operator, String Matchvalue) throws InterruptedException {
		 
		 if(Action.equalsIgnoreCase("Delete")) {
			 listlibrarypage.listelement(typeOfDelete, value);
		 
		  
	}
		 else if(Action.equalsIgnoreCase("Export")) {
			 listlibrarypage.exportList(FileFormat, delimeter,valueListExport );
		 

	 }
		 
		 else {
		 
		 listlibrarypage.createSegment(categorizeListx, nameOfListx, descriptionListx, svalue, selectRule, ruleList,operator, Matchvalue);
	 }
	 }

	  
	  
	

}
