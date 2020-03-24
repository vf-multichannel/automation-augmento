package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListLibrary_BlackListPage extends BaseClass{
	
	public ListLibrary_BlackListPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[contains(text(),'List Manager')]") WebElement ListManager;
	@FindBy(xpath = "//a[contains(text(),'Black List')]") WebElement BlackList;
	@FindBy(xpath = "//input[(@id = 'manualEmail')]") WebElement manualEmail;
	@FindBy(xpath = "//input[(@id = 'manualMobile')]") WebElement manualMobile;
	@FindBy(xpath = "//input[(@id = 'additionUpload')]") WebElement additionUpload;
	
	@FindBy(xpath = "//button[(@id = 'add-blacklist-records')]") WebElement blacklistButton;
	
	@FindBy(xpath = "//input[(@name = 'additiontype_value')]") WebElement addEmailOrMobile;
	
	@FindBy(xpath = "//input[(@id = 'uploadFile')]") WebElement blackListUpload;
	
	@FindBy(xpath = "//input[(@id = 'blacklistMobile')]") WebElement ViewblacklistMobile;
	@FindBy(xpath = "//input[(@id = 'blacklistEmail')]") WebElement ViewblacklistEmail;
	@FindBy(xpath = "//input[(@id = 'blacklist-import')]") WebElement importFile;
	
	@FindBy(xpath = "//select[(@id = 'emailIdentifier')]") WebElement emailIdentifier;
	@FindBy(xpath = "//select[(@id = 'mobileIdentifier')]") WebElement mobileIdentifier;
	@FindBy(xpath = "//input[(@id = 'import-save')]") WebElement filesave;
	
	
	
	
	
	
	
	
	
 

public void blackList(String ValueAdd, String mobileValue, String emailValue, String blackUploadPath, String emailIdentifierx, String mobileIdentifierx ) {
	
	mouseover(ListManager);
	
	BlackList.click();
	
	if(ValueAdd.equalsIgnoreCase("Email")) {
		
		manualEmail.click();
		addEmailOrMobile.sendKeys(emailValue);
		blacklistButton.click();
		ViewblacklistEmail.click();
		
	}
	else if(ValueAdd.equalsIgnoreCase("Mobile")) {
		
		manualMobile.click();
		addEmailOrMobile.sendKeys(mobileValue);
		blacklistButton.click();
		ViewblacklistMobile.click();
	}
	else {
		additionUpload.click();
		blackListUpload.sendKeys(blackUploadPath);
		importFile.click();
		
		emailIdentifier.sendKeys(emailIdentifierx);
		mobileIdentifier.sendKeys(mobileIdentifierx);
		filesave.click();
	}
	
	  
}

}