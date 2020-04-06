package com.augmento.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.augment.base.BaseClass;
import com.augmento.pages.AutomationStudio_NewWorkflowPage;
import com.augmento.pages.AutomationStudio_WorkflowConfigurationPage;
import com.augmento.pages.ContentRepository_EmailSenderPage;
import com.augmento.pages.ContentRepository_EmailTemplatePage;
import com.augmento.pages.HomePage;
import com.augmento.pages.ListLibrary_BlackListPage;
import com.augmento.pages.ListManager_ListLibraryPage;
import com.augmento.pages.ListManager_NewListPage;
import com.augmento.pages.LoginPage;
import com.augmento.utility.ExcelReader;

public class AutomationStudio_WorkflowConfigurationPageTest extends BaseClass{
	

	LoginPage loginpage;
	HomePage homepage;
	ListManager_NewListPage newlistpage;
	ListManager_ListLibraryPage listlibrarypage;
	ExcelReader reader;
	ListLibrary_BlackListPage blacklistpage;
	ContentRepository_EmailTemplatePage ContentRepositoryEmailPage;
	ContentRepository_EmailSenderPage ContentRepositoryEmailSenderPage;
	AutomationStudio_NewWorkflowPage AutomationStudioNewWorkflowPage;
	AutomationStudio_WorkflowConfigurationPage AutomationStudioWorkflowConfigurationPage;
	
	
	public  AutomationStudio_WorkflowConfigurationPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		AutomationStudioWorkflowConfigurationPage = new AutomationStudio_WorkflowConfigurationPage();
		AutomationStudioNewWorkflowPage= new AutomationStudio_NewWorkflowPage();
		ContentRepositoryEmailSenderPage = new ContentRepository_EmailSenderPage();
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
		 "./TestData/Workflow.xlsx");
		 String sheetName =  prop.getProperty("Workflow_Dashboard");
		 
		
		  int row = reader.getrowCount("Workflow_Dashboard");
		  
		  int column = reader.getColumnCount("Workflow_Dashboard");
		  
		  Object[][] data = new Object[row][column];
		  
		  for (int i = 0; i < row; i++) {
		  
		  for (int j = 0; j < column; j++) {
		  
		  data[i][j] = reader.getData("Workflow_Dashboard", i + 1, j); } } return data; }
		
		  



@Test
(dataProvider = "getexceldata")
public void workflowDashboard(String workflowName, String sourceType) throws InterruptedException{
	AutomationStudioWorkflowConfigurationPage.sourceSelection(workflowName, sourceType);
	
}

}
