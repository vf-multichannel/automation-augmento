package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class AutomationStudio_NewWorkflowPage extends BaseClass{
	
	

	public AutomationStudio_NewWorkflowPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

    
    @FindBy(xpath="//a[contains(text(),'Automation Studio')]") WebElement AutomationStudio;
    @FindBy(xpath="//a[contains(text(),'New Workflow')]") WebElement  NewWorkflow;
    
    
    
	@FindBy(xpath="//textarea[@name='description']") WebElement workflow_Description;
    @FindBy(xpath="//input[@name='title']") WebElement workflow_Title;
    @FindBy(xpath="//button[@id='en_save']") WebElement workflow_save;
    
    
    public void createNewWorkflow(String workflowTitle, String workflowDescription) throws InterruptedException {
    	mouseover(AutomationStudio);
    	NewWorkflow.click();
    	workflow_Title.sendKeys(workflowTitle);
    	workflow_Description.sendKeys(workflowDescription);
    	
    	workflow_save.click();
    	
    	
    }

}
