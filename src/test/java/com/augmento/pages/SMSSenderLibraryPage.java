package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SMSSenderLibraryPage extends BaseClass{
	
	ContentRepository cr=new ContentRepository();

	
	@FindBy(name="//a[text()='Create New']") WebElement CreateNew;
    @FindBy(xpath="//select[@name='search']") WebElement SearchDropDown;
    @FindBy(xpath="//input[@name='searchKey']") WebElement SearchTextBox;
    @FindBy(xpath="//input[@value='Search List']") WebElement SearchButton;
	
	
    public void  navigateToCreateSMSSenderPage(){
    	
    	cr.navigateToSMSSenderPage();
    	CreateNew.click();
    	
    }
    
    
}
