package com.augmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class AutomationStudio_WorkflowConfigurationPage extends BaseClass{
	

	public AutomationStudio_WorkflowConfigurationPage() {
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath="//div[@id='droppableContainer']") WebElement destinationFlowchart;
    @FindBy(xpath="//input[@name='title']") WebElement workflow_Title;
    @FindBy(xpath="//button[@id='en_save']") WebElement workflow_save;
    @FindBy(xpath="//a[contains(text(),'Automation Studio')]") WebElement AutomationStudio;
    @FindBy(xpath="//a[contains(text(),'Workflow Library')]") WebElement  WorkflowLibrary;
    
    
    public void sourceSelection(String workflowID, String sourceType) throws InterruptedException {
    	
    mouseover(AutomationStudio);
    WorkflowLibrary.click();
    
    driver.findElement(By.xpath("//a[contains(text(),'"+workflowID+"')]")).click();
    
    Thread.sleep(2000);
  WebElement source = driver.findElement(By.xpath("//div[@class='item-list']/div/div[2]"));
  Thread.sleep(2000);
  WebElement destination = driver.findElement(By.xpath("//*[@id=\"flowChart\"]"));
  
  Actions actionBuilder = new Actions(driver);
  Thread.sleep(3000);
  actionBuilder.clickAndHold(source).moveToElement(destination).release().build().perform();
    		
    	}
    }


