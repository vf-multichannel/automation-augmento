package com.augmento.pages;



import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class ListManager_CreateListPage extends BaseClass {
	

	public ListManager_CreateListPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='listName']") WebElement listName;
	@FindBy(xpath = "//input[@id='listCategory']") WebElement listCategory;
	@FindBy(xpath = "//textarea[@id='listDesc']") WebElement listDescription;
	@FindBy(xpath = "//input[@id='uploadFile']") WebElement listUploadList;
	@FindBy(xpath = "//button[@name='UploadList']") WebElement importfile;
	@FindBy(xpath = "//select[@id='listEmailIdentifier1']") WebElement emailIdentifier;
	@FindBy(xpath = "//select[@id='listMobileIdentifier']") WebElement mobilIdentifier;
	@FindBy(xpath = "//select[@id='listUniqueIdentifier']") WebElement uniqueIdentifire;
	@FindBy(xpath = "//input[@id='saveListManager']") WebElement listSave;
	@FindBy(xpath = "//textarea[@id='listTypeBox']") WebElement jsoncreateList;
	@FindBy(xpath = "//select[@id='delimeters']") WebElement delimeter;
	@FindBy(xpath = "//button[@name='CreateType']") WebElement preview;
	
	@FindBy(xpath = "listTypeBox") WebElement createJsonData;
	
	public void createList(String listnamex, String listCategoryx, String listDescriptionx ) throws InterruptedException {
		
		listName.sendKeys(listnamex);
		listCategory.sendKeys(listCategoryx);
		Thread.sleep(2000);
		
		
		try {
		Alert alert = driver.switchTo().alert();
	    System.out.println(alert.getText()+" Alert is Displayed"); 
	    //Boolean flag;
		
			
			if(alert.getText() != null) {
				for(int j = 0;j<1;j++) {
				alert.accept();
				listName.sendKeys(listnamex+j);
				listDescription.sendKeys(listDescriptionx);
				}
			}
			
			else {
				
			System.out.println("No duplicate List");
				
			}
		}catch(Exception e) {
			listDescription.sendKeys(listDescriptionx);
		}
		
		
		
	}
	

	
	public ListManager_ListLibraryPage createFileInlist(String typeFile, String fileName, String emailIdentifierx, String mobilIdentifierx, String uniqueIdentifirex, String jsonDataHeader , 
			String jsonData, String Delimiter) throws AWTException, InterruptedException {
		
		String[] jsonDataHs = jsonDataHeader.split("");
		String[] jsonDatas = jsonData.split(":");
		
		if(typeFile.equalsIgnoreCase("ImportFile")) {
			listUploadList.sendKeys(fileName);
			importfile.click();
			
			//Identifiers
			selectElementByVisbleText(emailIdentifier, emailIdentifierx);
			selectElementByVisbleText(mobilIdentifier, mobilIdentifierx);
			selectElementByVisbleText(uniqueIdentifire, uniqueIdentifirex);
			
			listSave.click();
			
			
		}
			
			else {
				
				
				for (int i = 0; i < jsonDataHs.length; i++) {
					jsoncreateList.sendKeys(jsonDataHs[i]);
					
					
				}
				
				 Robot robot = new Robot();
				 Thread.sleep(1000);
				 robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
				   
				
				
				
					
					for (int j = 0; j < jsonDatas.length; j++) {
						jsoncreateList.sendKeys(jsonDatas[j]);
						Thread.sleep(1000);
						 robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);

					
				}	
					
					
				
				System.out.println("Create List");
			}
		
		selectElementByVisbleText(delimeter, Delimiter);
		preview.click();
		
		
		if(jsonDataHs.length==1) {
			selectElementByValue(emailIdentifier, 0);
		}
		else if(jsonDataHs.length==2) {
			selectElementByValue(emailIdentifier, 0);
			selectElementByValue(mobilIdentifier, 1);
		
		}
		else {
			selectElementByValue(emailIdentifier, 0);
			selectElementByValue(mobilIdentifier, 1);
			selectElementByValue(uniqueIdentifire,2);
		}
		
		listSave.click();
		return new ListManager_ListLibraryPage();
		}
	
	

}




