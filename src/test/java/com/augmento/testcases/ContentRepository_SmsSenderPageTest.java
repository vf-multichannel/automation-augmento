package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augment.base.BaseClass;
import com.augmento.pages.ContentRepository_EmailTemplatePage;
import com.augmento.pages.ContentRepository_SmsSenderPage;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListLibrary_BlackListPage;
import com.augmento.pages.ListManager_ListLibraryPage;
import com.augmento.pages.ListManager_NewListPage;
import com.augmento.pages.LoginPage;
import com.augmento.utility.ExcelReader;

public class ContentRepository_SmsSenderPageTest extends BaseClass {
	
	

	LoginPage loginpage;
	HomePage homepage;
	ListManager_NewListPage newlistpage;
	ListManager_ListLibraryPage listlibrarypage;
	ExcelReader reader;
	ListLibrary_BlackListPage blacklistpage;
	ContentRepository_EmailTemplatePage ContentRepositoryEmailPage;
	ContentRepository_SmsSenderPage ContentRepositorySmsSenderPage;
	
	
	public  ContentRepository_SmsSenderPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		ContentRepositorySmsSenderPage = new ContentRepository_SmsSenderPage();
		ContentRepositoryEmailPage = new ContentRepository_EmailTemplatePage();
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
		 String sheetName =  prop.getProperty("ContentRepository_SmsSender");
		 
		
		  int row = reader.getrowCount("ContentRepository_SmsSender");
		  
		  int column = reader.getColumnCount("ContentRepository_SmsSender");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("ContentRepository_SmsSender", i + 1, j); } } return data; }
		
		  



@Test
(dataProvider = "getexceldata")
public void smsSender(String senderId, String senderUseCase, String SampleSmsText, String approveType, String ApproveContent, String ActionDescripton, String Action) throws InterruptedException   {
	
	ContentRepositorySmsSenderPage.gotosmsSender();
	ContentRepositorySmsSenderPage.CreateSMSSender(senderId, senderUseCase, SampleSmsText);
	approvalLogin(approveType, ApproveContent, ActionDescripton, Action);
}
}
