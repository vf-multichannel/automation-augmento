package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass  {
	
	
	@FindBy(xpath = "//a[contains(text(),'List Manager')]") WebElement ListManager;
	@FindBy(xpath = "//a[contains(text(),'New List')]") WebElement NewList;
	@FindBy(xpath = "//a[contains(text(),'Online Users')]") WebElement onlineUser;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public NewListPage clickOnListManager()
	   {
		mouseover(ListManager);
		NewList.click();
		return new NewListPage();
		}

}
