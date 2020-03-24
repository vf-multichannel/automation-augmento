package com.augmento.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class ContentRepository{
	
	BaseClass bc=new BaseClass();
	
	@FindBy(xpath="//div[@class='top_nav']//a[contains(., 'Content Repository')]") WebElement ContentRepository;
	@FindBy(xpath="//a[text()='Email']") WebElement Email;
	@FindBy(xpath="//a[text()='Email']/../ul[@class='settgin-sub']//a[text()='Templates']") WebElement EmailTemplates;
	@FindBy(xpath="//a[text()='Email']/../ul[@class='settgin-sub']//a[text()='Sender Settings']") WebElement EmailSenderSettings;
	@FindBy(xpath="//a[text()='SMS']") WebElement SMS;
	@FindBy(xpath="//a[text()='SMS']/../ul[@class='settgin-sub']//a[text()='Templates']]") WebElement SMSTemplates;
	@FindBy(xpath="//a[text()='SMS']/../ul[@class='settgin-sub']//a[text()='Sender IDs']") WebElement SMSSenderIDs;
	@FindBy(xpath="//a[text()='Voice']") WebElement Voice;
	@FindBy(xpath="//a[text()='Voice']/../ul[@class='settgin-sub']//a[text()='Sound Clips']") WebElement SoundClips;
	@FindBy(xpath="/a[text()='Push Notification']") WebElement PushNotification;
	@FindBy(xpath="//a[text()='Push Notification']/../ul[@class='settgin-sub']//a[text()='Content']") WebElement PushNotificationContent;
	@FindBy(xpath="//a[text()='Web Push']") WebElement WebPushNotification;

	
	public void navigateToEmailTemplatePage(){
		
		bc.mouseover(ContentRepository);
		bc.mouseover(Email);
		EmailTemplates.click();
		
		
	}
	
	
public void navigateToEmailSenderPage(){
	
		bc.mouseover(ContentRepository);
		bc.mouseover(Email);
		EmailSenderSettings.click();
		
		
		
	}
	
public void navigateToSMSTemplatePage(){
	
	bc.mouseover(ContentRepository);
	bc.mouseover(SMS);
	SMSTemplates.click();
	
	
	
}
	
public void navigateToSMSSenderPage(){
	
	bc.mouseover(ContentRepository);
	bc.mouseover(SMS);
	SMSSenderIDs.click();
		
}


public void navigateToVoicePage(){
	
	bc.mouseover(ContentRepository);
	bc.mouseover(Voice);
	SoundClips.click();
		
}	

public void navigateToPushNotificationPage(){
	
	bc.mouseover(ContentRepository);
	bc.mouseover(PushNotification);
	PushNotificationContent.click();
		
}
public void navigateToWebPushNotificationPage(){
	
	bc.mouseover(ContentRepository);
	WebPushNotification.click();
		
}

}
