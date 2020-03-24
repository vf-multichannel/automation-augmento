package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateSMSTemplatePage extends BaseClass{

	
	@FindBy(xpath="//input[@id='tag_name']") WebElement TemplateName;
	@FindBy(xpath="//input[@name='remarks']") WebElement Decsription;
    @FindBy(xpath="//select[@id='type']") WebElement Type;
    @FindBy(xpath="//textarea[@id='sms-content-template']") WebElement MessageType;
    @FindBy(xpath="//input[@id='create_approve']") WebElement MessageText;
    @FindBy(name="//input[@id='create_approve']") WebElement SendForApproval;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
    
    
    
public void CreateTextTemplate(String TemplateNamex, String Descriptionx,String Typex,String MessageTypex,String MessageTextx){
    	
	    TemplateName.sendKeys(TemplateNamex);
	    Decsription.sendKeys(Descriptionx);
	    Select s=new Select(Type);
	    s.selectByValue(Typex);
	    Select s1=new Select(MessageType);
	    s.selectByValue(MessageTypex);
	    MessageText.sendKeys(MessageTextx);
    	SendForApproval.click();
    	
    }
	
	
}
