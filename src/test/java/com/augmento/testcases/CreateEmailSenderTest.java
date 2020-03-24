package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augmento.pages.BaseClass;
import com.augmento.pages.CreateEmailSenderPage;
import com.augmento.pages.EmailSenderLibraryPage;
import com.augmento.pages.HomePage;
import com.augmento.pages.LoginPage;
import com.augmento.utility.ExcelReader;

public class CreateEmailSenderTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader reader;
	CreateEmailSenderPage emailsender;
	EmailSenderLibraryPage emailsenderlibrary;
	
	@BeforeMethod
	public void setup() {	
		init();
		emailsender = new CreateEmailSenderPage();
		emailsenderlibrary=new EmailSenderLibraryPage();
		loginpage =  new LoginPage();
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
		emailsenderlibrary.navigateToCreateSenderPage();
	    
		
	}
	
	
	@DataProvider 
	public Object[][] getexceldata() throws Exception {
		 
		 reader = new ExcelReader(System.getProperty("user.dir") +
		 "./TestData/Data.xlsx");
		  
		  int row = reader.getrowCount("EmailSender");
		  
		  int column = reader.getColumnCount("EmailSender");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("EmailSender", i + 1, j); } } return data; }
		  
	 
	@Test(dataProvider = "getexceldata")
	public void creatingEmailSender(String SenderName,String SenderEmail){
		
		emailsender.CreateEmailSender(SenderName, SenderEmail);
	} 
	
}
