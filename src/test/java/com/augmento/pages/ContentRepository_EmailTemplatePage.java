package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ContentRepository_EmailTemplatePage extends BaseClass {


	public ContentRepository_EmailTemplatePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'List Manager')]") WebElement ListManager;
	
	@FindBy(xpath="//input[@id='template_name']") WebElement TemplateName;
	@FindBy(xpath="//input[@id='subject']") WebElement TemplateSubject;
    @FindBy(xpath="//select[@id='content_type']") WebElement TemplateContentType;
    @FindBy(xpath="//textarea[@id='content']") WebElement SimpleText;
    @FindBy(xpath="//input[@id='html_template']") WebElement ChooseHtmlFile;
    @FindBy(xpath="//button[@id='template_upload']") WebElement Upload;
    @FindBy(xpath="//input[@id='web_url']") WebElement WebUrl;
    @FindBy(xpath="//input[@type='submit']") WebElement CreateNewTemplate;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
  
    @FindBy(xpath="//a[contains(text(),'Content Repository')]") WebElement ContentRepository;
    @FindBy(xpath="//a[contains(text(),'Email')]") WebElement  clickonEmail;
    
    
    @FindBy(xpath="//a[@class='button-new-header btn btn-info custom-bootstrap-btn btn_cust create_btn flt_right']") WebElement CreateNew;
    
    
    public void clickOnRepo() throws InterruptedException {
    	
    	//Thread.sleep(5000);
    mouseover(ContentRepository);
    	//ContentRepository.click();
    	clickonEmail.click();
    	
    }
    
    public void CreateEmailTmaplate(String TemplateNamex,String TemplateSubjectx,String TemplateContentTypex,String SimpleTextx,String HtmlFilepath,String WebUrlx  ) {
    	
    
    	CreateNew.click();
    	TemplateName.sendKeys(TemplateNamex);
    	TemplateSubject.sendKeys(TemplateSubjectx);
    	
    	if(TemplateContentTypex.equalsIgnoreCase("text")) {
    	SimpleText.sendKeys(SimpleTextx);
    	}
    
    	else if(TemplateContentTypex.equalsIgnoreCase("html")){
    		selectElementByVisbleText(TemplateContentType, TemplateContentTypex);
    	
    	ChooseHtmlFile.sendKeys(HtmlFilepath);
    	}
    	
    	
    	else{
    	
    		
    		selectElementByVisbleText(TemplateContentType, TemplateContentTypex);
    	
    	WebUrl.sendKeys(WebUrlx);
    	}
    	
    	CreateNewTemplate.click();
     


}


}