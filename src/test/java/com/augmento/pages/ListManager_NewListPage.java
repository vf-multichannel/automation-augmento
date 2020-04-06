package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;


public class ListManager_NewListPage extends BaseClass {

	
	@FindBy(name = "//input[text() = 'List Manager']") WebElement ListManager;
	@FindBy(name = "//input[text() = 'New List']") WebElement NewList;
	@FindBy(name = "//input[text() = 'Online Users']") WebElement onlineUser;
	
	public ListManager_NewListPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void NewList() {
		ListManager.click();
		NewList.click();
		
	}
	

}
