package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ContentRepository_SmsTemplatePage extends BaseClass {
	

	public ContentRepository_SmsTemplatePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(xpath="//input[@id='tag_name']") WebElement TemplateName;
	@FindBy(xpath="//input[@name='remarks']") WebElement Decsription;
    @FindBy(xpath="//select[@id='message_type']") WebElement Type;
    @FindBy(xpath="//select[@class='smsType form-control']") WebElement MessageType;
    @FindBy(xpath="//textarea[@id='sms-content-template']") WebElement MessageText;
    @FindBy(xpath="//input[@id='create_approve']") WebElement SendForApproval;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
    @FindBy(xpath="//a[@class='button-new-header btn btn-info create_btn']") WebElement  CreateNew;
    @FindBy(xpath="//label[@class='dB p-R hand accordian__label']") WebElement  clicksmsTemplate;
    @FindBy(xpath="//li[@class=\"has-sub fif_sub\"]/ul/li[1]/a") WebElement smsTemplates;
    
    @FindBy(xpath="//a[contains(text(),'Content Repository')]") WebElement ContentRepository;
    @FindBy(xpath="//a[contains(text(),'SMS')]") WebElement  clickonSMS;
 
    @FindBy(xpath="//label[@for='_12']") WebElement  clickonSMSinternal;
    
   public void smsTemplategoto() throws InterruptedException {
		mouseover(ContentRepository);
    	mouseover(clickonSMS);
    //	Thread.sleep(1000);
    	//mouseover(smsTemplates);
    	smsTemplates.click();
    	
    	//clickonSMSinternal.click();
	   
	   
   }
   
    
public void CreateSMSTemplate(String TemplateNamex, String Descriptionx,String MessageTypex,String Typex,String MessageTextx){
	      
	CreateNew.click();
	
	    TemplateName.sendKeys(TemplateNamex);
	    Decsription.sendKeys(Descriptionx);
	   
	    selectElementByVisbleText(MessageType, MessageTypex);
	    selectElementByVisbleText(Type, Typex);
	    MessageText.sendKeys(MessageTextx);
    	SendForApproval.click();
    	
    }

}
