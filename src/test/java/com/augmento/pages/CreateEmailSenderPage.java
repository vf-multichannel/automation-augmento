package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.augmento.utility.ExcelReader;

public class CreateEmailSenderPage  extends BaseClass {
	
		
	
	@FindBy(xpath="//input[@id='sender_name']") WebElement SenderName;
	@FindBy(xpath="//input[@id='sender_email']") WebElement SenderEmail;
    @FindBy(xpath="//input[@name='is_default']") WebElement DefaultSender;
    @FindBy(xpath="//input[@type='submit']") WebElement SendForApproval;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
    
    
    
    public void CreateEmailSender(String SenderNamex, String SenderEmailx ){
    	
    	SenderName.sendKeys(SenderNamex);
    	SenderEmail.sendKeys(SenderEmailx);
    	DefaultSender.click();
    	SendForApproval.click();
    	
    }
    


}