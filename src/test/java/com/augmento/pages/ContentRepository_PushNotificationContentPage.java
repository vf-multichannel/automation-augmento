package com.augmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ContentRepository_PushNotificationContentPage extends BaseClass{
	
	

	public ContentRepository_PushNotificationContentPage() {
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(xpath="//input[@name='name']") WebElement Name;
	@FindBy(xpath="//input[@name='push_title']") WebElement Title;
	@FindBy(xpath="//textarea[@id='count-message']") WebElement Description;
	@FindBy(xpath="//select[@class='form-control cta-link-type-primary']") WebElement PrimaryCTALink;
	@FindBy(xpath="//input[@id='count-cta']") WebElement CTALink;
	
	@FindBy(xpath="//input[@name='banner_file']") WebElement BrowserAndUpload;
	@FindBy(xpath="//input[@type='submit']") WebElement CreateNewTemplate;
    @FindBy(xpath="//a[text()='Back']") WebElement Back;
    
    @FindBy(xpath="//select[@name='platform']") WebElement platform;
	
    

    @FindBy(xpath="//a[contains(text(),'Content Repository')]") WebElement ContentRepository;
    @FindBy(xpath="//a[contains(text(),'Push Notification')]") WebElement  clickonPush;
    @FindBy(xpath="//li[@class='has-sub fivth_sub']/ul/li/a") WebElement pushContent;
    @FindBy(xpath="//a[@class='heading_common btn btn-info pull-right _oTop-15 create_btn']") WebElement createNewPush;


    public void gotoPush() throws InterruptedException {
    	
    	mouseover(ContentRepository);
    	mouseover(clickonPush);
    	pushContent.click();
    	
    }
    public void CreateNewTemplate(String Namex,String platForm, String pushNotificationTemplates,String Titlex,String Descriptionx,String BrowserAndUploadx, String primatyCTA, String CTALinks) throws InterruptedException {
    	
    	createNewPush.click();
    	Name.sendKeys(Namex);
    	platform.sendKeys(platForm);
    	if(pushNotificationTemplates.equalsIgnoreCase("Text")) {
    		String Texttemplates = "//*[@id=\"push-content-form\"]/section[2]/div[2]/div/ul/li[1]";
    		driver.findElement(By.xpath(Texttemplates+"/a/img")).click();
    		
    	}
    	
    	else if(pushNotificationTemplates.equalsIgnoreCase("Banner")) {
    		String Banertemplates = "//*[@id=\"push-content-form\"]/section[2]/div[2]/div/ul/li[2]";
    		driver.findElement(By.xpath(Banertemplates+"/a/img")).click();
    	}
    	else if(pushNotificationTemplates.equalsIgnoreCase("Carousel")) {
    		String Carsouseltemplates = "//*[@id=\"push-content-form\"]/section[2]/div[2]/div/ul/li[3]";
    		driver.findElement(By.xpath(Carsouseltemplates+"/a/img")).click();
    	}
    	else {
    		String Ratingtemplates = "//*[@id=\"push-content-form\"]/section[2]/div[2]/div/ul/li[4]";
    		driver.findElement(By.xpath(Ratingtemplates+"/a/img")).click();
    	}
    	
    	Title.sendKeys(Titlex);
    	Description.sendKeys(Descriptionx);
    	Thread.sleep(1000);
    	BrowserAndUpload.sendKeys(BrowserAndUploadx);
    	selectElementByVisbleText(PrimaryCTALink, primatyCTA);
    	CTALink.sendKeys(CTALinks);
    	CreateNewTemplate.click();
    }
	
	
	
	

}
