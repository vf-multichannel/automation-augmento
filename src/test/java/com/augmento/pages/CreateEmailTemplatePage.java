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
    
    
    
    public void CreateTextTmaplate(String TemplateNamex,String TemplateSubjectx,String SimpleTextx ) {
    	
    	TemplateName.sendKeys(TemplateNamex);
    	TemplateSubject.sendKeys(TemplateSubjectx);
    	SimpleText.sendKeys(SimpleTextx);
    	CreateNewTemplate.click();
    }
    
    public void CreateHtmlTemplate(String TemplateNamex,String TemplateSubjectx,String HtmlFilepath) {
    	
    	TemplateName.sendKeys(TemplateNamex);
    	TemplateSubject.sendKeys(TemplateSubjectx);
    	Select s=new Select(TemplateContentType);
    	s.selectByValue("html");
    	ChooseHtmlFile.sendKeys(HtmlFilepath);
    	CreateNewTemplate.click();
    	
    	
    }

    public void WebURLTemplate(String TemplateNamex,String TemplateSubjectx,String WebUrlx ){
    	TemplateName.sendKeys(TemplateNamex);
    	TemplateSubject.sendKeys(TemplateSubjectx);
    	Select s=new Select(TemplateContentType);
    	s.selectByValue("webUrl");
    	WebUrl.sendKeys(WebUrlx);
    	CreateNewTemplate.click();
    } 


}
