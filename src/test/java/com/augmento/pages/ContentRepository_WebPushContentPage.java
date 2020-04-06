package com.augmento.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ContentRepository_WebPushContentPage extends BaseClass {
	

	
	


	public ContentRepository_WebPushContentPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

	@FindBy(xpath="//input[@id='name']") WebElement Name;
	@FindBy(xpath="//input[@name='title']") WebElement Title;
	@FindBy(xpath="//textarea[@id='inputDescription']") WebElement Description;
	@FindBy(xpath="//input[@id='inputCTA']") WebElement CTALink;
	@FindBy(xpath="//input[@name='iconFile']") WebElement BrowserAndUpload;
	@FindBy(xpath="//*[@id=\"web-push-content-form\"]/div[3]/div[2]/input") WebElement CreateNewTemplate;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
    
    @FindBy(xpath="//input[@id='inputCTA']") WebElement CTAinput;
	
	
	
    @FindBy(xpath="//a[contains(text(),'Content Repository')]") WebElement ContentRepository;
    @FindBy(xpath="//a[contains(text(),'Web Push')]") WebElement  clickonWebPush;
    //@FindBy(xpath="//li[@class=\"has-sub six_sub\"]/ul/li/a") WebElement ;	
    @FindBy(xpath="//a[@class='button-new-header btn btn-info custom-bootstrap-btn btn_cust create_btn flt_right']") WebElement createNewWebPush;
   
    
    public void gotoWebPush() throws InterruptedException {
    	
    	mouseover(ContentRepository);
    	
    	clickonWebPush.click();
    	
    }
    

    public void CreateNewTemplate(String Namex,String Titlex,String Descriptionx,String CTAinputx,String BrowserAndUploadx ) throws InterruptedException {
    	createNewWebPush.click();
    	Name.sendKeys(Namex);
    	Title.sendKeys(Titlex);
    	Description.sendKeys(Descriptionx);
    	CTAinput.sendKeys(CTAinputx);
    	Thread.sleep(2000);
    	BrowserAndUpload.sendKeys(BrowserAndUploadx);
    	
    	CreateNewTemplate.click();
    }
    
}
