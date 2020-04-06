package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;


public class HomePage extends BaseClass  {
	
	
	@FindBy(xpath = "//a[contains(text(),'List Manager')]") WebElement ListManager;
	@FindBy(xpath = "//a[contains(text(),'New List')]") WebElement NewList;
	@FindBy(xpath = "//a[contains(text(),'Online Users')]") WebElement onlineUser;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public ListManager_NewListPage clickOnListManager() throws InterruptedException
	   {
		mouseover(ListManager);
		NewList.click();
		return new ListManager_NewListPage();
		}

}
