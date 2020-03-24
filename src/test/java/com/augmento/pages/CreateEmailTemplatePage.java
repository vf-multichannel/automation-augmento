package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateEmailTemplatePage extends BaseClass {

	EmailTemplateLibraryPage template=new EmailTemplateLibraryPage();
	
	@FindBy(name="//input[@id='template_name']") WebElement TemplateName;
	@FindBy(name="//input[@id='subject']") WebElement TemplateSubject;
    @FindBy(name="//select[@id='content_type']") WebElement TemplateContentType;
    @FindBy(name="//textarea[@id='content']") WebElement SimpleText;
    @FindBy(name="//input[@id='html_template']") WebElement ChooseHtmlFile;
    @FindBy(name="//button[@id='template_upload']") WebElement Upload;
    @FindBy(name="//input[@id='web_url']") WebElement WebUrl;
    @FindBy(name="//input[@type='submit']") WebElement CreateNewTemplate;
    @FindBy(name="//a[text()='Back']") WebElement Back;
    
    
    
    public void CreateSMSTmaplate(String TemplateNamex,String TemplateSubjectx,String TemplateContentTypex,String SimpleTextx,String HtmlFilepath,String WebUrlx  ) {
    	
    	TemplateName.sendKeys(TemplateNamex);
    	TemplateSubject.sendKeys(TemplateSubjectx);
    	
    	if(TemplateContentTypex.equalsIgnoreCase("text")) {
    	SimpleText.sendKeys(SimpleTextx);
    	}
    
    	if(TemplateContentTypex.equalsIgnoreCase("html")){
    	Select s=new Select(TemplateContentType);
    	s.selectByValue("html");
    	ChooseHtmlFile.sendKeys(HtmlFilepath);
    	}
    	
    	
    	if(TemplateContentTypex.equalsIgnoreCase("weburl")){
    	TemplateName.sendKeys(TemplateNamex);
    	TemplateSubject.sendKeys(TemplateSubjectx);
    	Select s=new Select(TemplateContentType);
    	s.selectByValue("webUrl");
    	WebUrl.sendKeys(WebUrlx);
    	}
    	
    	CreateNewTemplate.click();
     


}


}