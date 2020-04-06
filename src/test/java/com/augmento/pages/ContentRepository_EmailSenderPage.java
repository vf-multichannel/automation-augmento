package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ContentRepository_EmailSenderPage extends BaseClass {
	


	public ContentRepository_EmailSenderPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='sender_name']") WebElement SenderName;
	@FindBy(xpath="//input[@id='sender_email']") WebElement SenderEmail;
    @FindBy(xpath="//input[@name='is_default']") WebElement DefaultSender;
    @FindBy(xpath="//input[@type='submit']") WebElement SendForApproval;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
    
   // @FindBy(xpath="//label[@class='dB p-R hand accordian__label']") WebElement clickonEmail;
    @FindBy(xpath="//a[contains(text(),'Sender Settings')]") WebElement EmailSenderSettings;
    @FindBy(xpath="//a[@class='button-new-header btn btn-info create_btn']") WebElement EmailSenderSettingsCreateNew;
    
    
    @FindBy(xpath="//a[contains(text(),'Content Repository')]") WebElement ContentRepository;
    @FindBy(xpath="//a[contains(text(),'Email')]") WebElement  clickonEmail;
    
    
    
    public void gotoEmailSender() throws InterruptedException {
    	//Thread.sleep(1000);
    	mouseover(ContentRepository);
    	mouseover(clickonEmail);
    	EmailSenderSettings.click();
    	
    }
    
    public void CreateEmailSender(String SenderNamex, String SenderEmailx ){
    	EmailSenderSettingsCreateNew.click();
    	SenderName.sendKeys(SenderNamex);
    	SenderEmail.sendKeys(SenderEmailx);
    	DefaultSender.click();
    	alert();
    	SendForApproval.click();
    	
    }
    




}
