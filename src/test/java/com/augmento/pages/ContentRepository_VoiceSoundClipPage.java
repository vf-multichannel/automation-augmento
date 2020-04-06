package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ContentRepository_VoiceSoundClipPage extends BaseClass {
	
	
	
	
	public ContentRepository_VoiceSoundClipPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

	
	@FindBy(xpath="//input[@id='template_name']") WebElement TemplateName;
	@FindBy(xpath="//input[@id='subject']") WebElement Decsription;
    @FindBy(xpath="//select[@id='type']") WebElement Type;
    @FindBy(xpath="//input[@id='obdfile']") WebElement ChooseFile;
    @FindBy(xpath="//button[@id='uploadOBDClipFile']") WebElement Upload;
    @FindBy(xpath="//input[@id='create_approve']") WebElement SendForApproval;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
	
    
   
    
    @FindBy(xpath="//a[contains(text(),'Content Repository')]") WebElement ContentRepository;
    @FindBy(xpath="//a[contains(text(),'Voice')]") WebElement  clickonVoice;
    @FindBy(xpath="//li[@class=\"has-sub six_sub\"]/ul/li/a") WebElement VoiceSoundClip;
    @FindBy(xpath="//a[@class='button-new-header  btn btn-info custom-bootstrap-btn btn_cust create_btn flt_right']") WebElement createNewVoice;
   
    
    public void gotoVoice() throws InterruptedException {
    	
    	mouseover(ContentRepository);
    	mouseover(clickonVoice);
    	VoiceSoundClip.click();
    	
    }
    
    public void CreateVoiceTemplate(String TemplateNamex,String Decsriptionx,String Typex,String ChooseFilex){
    	createNewVoice.click();
    	TemplateName.sendKeys(TemplateNamex);
    	Decsription.sendKeys(Decsriptionx);
    	selectElementByVisbleText(Type, Typex);
    	ChooseFile.sendKeys(ChooseFilex);
    	Upload.click();
    	SendForApproval.click();
    
    } 
    

}
