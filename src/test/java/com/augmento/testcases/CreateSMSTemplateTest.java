package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augmento.pages.BaseClass;
import com.augmento.pages.CreateSMSTemplatePage;
import com.augmento.pages.HomePage;
import com.augmento.pages.LoginPage;
import com.augmento.pages.SMSTemplateLibraryPage;
import com.augmento.utility.ExcelReader;

public class CreateSMSTemplateTest extends BaseClass  {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader reader;
	CreateSMSTemplatePage smstemplate;
	SMSTemplateLibraryPage smstemplatelibrary;
	
	@BeforeMethod
	public void setup() {	
		init();
		smstemplate = new CreateSMSTemplatePage();
		smstemplatelibrary=new SMSTemplateLibraryPage();
		loginpage =  new LoginPage();
		homepage = loginpage.LogintoAugmento(prop.getProperty("UserName"), prop.getProperty("Password"));
		smstemplatelibrary.navigateToCreateSMSTemplatePage();
		
	}
	
	
	@DataProvider 
	public Object[][] getexceldata() throws Exception {
		 
		 reader = new ExcelReader(System.getProperty("user.dir") +
		 "./TestData/Data.xlsx");
		  
		  int row = reader.getrowCount("SMSTemplate");
		  
		  int column = reader.getColumnCount("SMSTemplate");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("SMSTemplate", i + 1, j); } } return data; }
		  
	 
	@Test(dataProvider = "getexceldata")
	public void creatingEmailSender(String TemplateName,String Description,String Type,String MessageType,String MessageText){
		
		smstemplate.CreateTextTemplate(TemplateName, Description, Type, MessageType, MessageText);
	} 
	
}
