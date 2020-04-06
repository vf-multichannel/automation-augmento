package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augment.base.BaseClass;
import com.augmento.pages.ContentRepository_EmailTemplatePage;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListLibrary_BlackListPage;
import com.augmento.pages.ListManager_ListLibraryPage;
import com.augmento.pages.ListManager_NewListPage;
import com.augmento.pages.LoginPage;
import com.augmento.utility.ExcelReader;

public class ContentRepository_EmailTemplatePageTest extends BaseClass {
	
	
	LoginPage loginpage;
	HomePage homepage;
	ListManager_NewListPage newlistpage;
	ListManager_ListLibraryPage listlibrarypage;
	ExcelReader reader;
	ListLibrary_BlackListPage blacklistpage;
	ContentRepository_EmailTemplatePage ContentRepositoryEmailPage;
	
	
	
	public  ContentRepository_EmailTemplatePageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
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
		 String sheetName =  prop.getProperty("ContentRepository_EmailTemplate");
		 
		
		  int row = reader.getrowCount("ContentRepository_EmailTemplate");
		  
		  int column = reader.getColumnCount("ContentRepository_EmailTemplate");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("ContentRepository_EmailTemplate", i + 1, j); } } return data; }
		
		  



@Test
(dataProvider = "getexceldata")
public void ContentRepositoryEmailPageTest(String Email_TemplateName, String Email_Description, String Email_ContentType, String Email_Text, 
		String Email_html, String Email_Weburl) throws InterruptedException {
	
	ContentRepositoryEmailPage.clickOnRepo();
	ContentRepositoryEmailPage.CreateEmailTmaplate(Email_TemplateName, Email_Description, Email_ContentType, Email_Text, Email_html, Email_Weburl);
	
}


}



