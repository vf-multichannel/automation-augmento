package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augmento.pages.BaseClass;
import com.augmento.pages.CreateSMSSenderPage;
import com.augmento.pages.HomePage;
import com.augmento.pages.LoginPage;
import com.augmento.pages.SMSSenderLibraryPage;
import com.augmento.utility.ExcelReader;

public class CreateSMSSenderTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader reader;
	CreateSMSSenderPage smssender;
	SMSSenderLibraryPage smssenderlibrary;
	
	@BeforeMethod
	public void setup() {	
		init();
		smssender = new CreateSMSSenderPage();
		smssenderlibrary=new SMSSenderLibraryPage();
		loginpage =  new LoginPage();
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
		smssenderlibrary.navigateToCreateSMSSenderPage();
		
	}
	
	
	@DataProvider 
	public Object[][] getexceldata() throws Exception {
		 
		 reader = new ExcelReader(System.getProperty("user.dir") +
		 "./TestData/Data.xlsx");
		  
		  int row = reader.getrowCount("SMSSender");
		  
		  int column = reader.getColumnCount("SMSSender");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("SMSSender", i + 1, j); } } return data; }
		  
	 
	@Test(dataProvider = "getexceldata")
	public void creatingEmailSender(String SenderName,String UseCase,String SampleSMSText){
		
		smssender.CreateSMSSender(SenderName, UseCase, SampleSMSText);
	} 
	
}


