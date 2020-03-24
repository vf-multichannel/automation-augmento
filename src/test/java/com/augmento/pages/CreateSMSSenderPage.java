package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSMSSenderPage extends BaseClass {
	
	
	@FindBy(name="//input[@id='sender_name']") WebElement SenderName;
	@FindBy(name="//textarea[@name='use_case']") WebElement UseCase;
	@FindBy(name="//textarea[@name='remarks']") WebElement SampleSMSText;
	@FindBy(name="//input[@name='is_default']") WebElement DefaultSender;
	@FindBy(name="//input[@id='create_approve']") WebElement SendForApproval;
	@FindBy(xpath="//a[text()='Back']") WebElement Back;
	
public void CreateSMSSender(String SenderNamex, String UseCasex,String  SampleSMSTextx){
    	
	    SenderName.sendKeys(SenderNamex);
	    UseCase.sendKeys(UseCasex);
	    SampleSMSText.sendKeys(SampleSMSTextx);
    	DefaultSender.click();
    	SendForApproval.click();
    	
    }
	
	
	
	
	
}
