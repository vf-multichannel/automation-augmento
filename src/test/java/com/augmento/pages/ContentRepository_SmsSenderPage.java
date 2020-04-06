package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ContentRepository_SmsSenderPage extends BaseClass {

	public ContentRepository_SmsSenderPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(xpath="//input[@id='sender_name']") WebElement SenderName;
	@FindBy(xpath="//textarea[@name='use_case']") WebElement UseCase;
	@FindBy(xpath="//textarea[@name='remarks']") WebElement SampleSMSText;
	@FindBy(xpath="//input[@name='is_default']") WebElement DefaultSender;
	@FindBy(xpath="//input[@id='create_approve']") WebElement SendForApproval;
	@FindBy(xpath="//a[text()='Back']") WebElement Back;
	
	
	  @FindBy(xpath="//a[contains(text(),'Content Repository')]") WebElement ContentRepository;
	    @FindBy(xpath="//a[contains(text(),'SMS')]") WebElement  clickonSMS;
	    @FindBy(xpath="//li[@class=\"has-sub fif_sub\"]/ul/li[2]/a") WebElement smsSender;
	   
	    @FindBy(xpath="//a[@class='button-new-header btn btn-info create_btn']") WebElement createNew;

	public void gotosmsSender() throws InterruptedException {
		mouseover(ContentRepository);
    	mouseover(clickonSMS);
    	smsSender.click();
		
	}
	
	
	public void CreateSMSSender(String SenderNamex, String UseCasex,String  SampleSMSTextx){
		
		createNew.click();
	    SenderName.sendKeys(SenderNamex);
	    UseCase.sendKeys(UseCasex);
	    SampleSMSText.sendKeys(SampleSMSTextx);
    	DefaultSender.click();
    	alert();
    	SendForApproval.click();
    	
    }

}
