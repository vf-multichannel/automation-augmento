package com.augmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ProfileSetting_FrequencyCappingListUserPage extends BaseClass {
	
	
	
	public ProfileSetting_FrequencyCappingListUserPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@class='has-sub log_icon']/a") WebElement Profile;
	@FindBy(xpath="//a[@class='cur_cap'][contains(., 'Settings')]") WebElement Settings;
	@FindBy(xpath="//a[contains(.,'Frequency')]") WebElement FrequencyCapping;
	
	public void gotoCapping() throws InterruptedException {
		
		mouseover(Profile);
		mouseover(Settings);
		FrequencyCapping.click();
		
	}
	
	public void smsCapping(String outboundSMS) {
		String[] outboundSMSvalue = outboundSMS.split(",");
		
		
		for(int i=3;i<=7;i++) {
			
			
			
			if(i==6) {
				WebElement cappingValueTimeGap = driver.findElement(By.xpath("//td[text()='Outbound SMS']/../td["+i+"]/input/../select"));
				selectElementByVisbleText(cappingValueTimeGap, outboundSMSvalue[i-2]);
			}
			
			if(i==7) {
			WebElement cappingValueoneoff = driver.findElement(By.xpath("//td[text()='Outbound SMS']/../td[["+(i+1)+"]]/label/span"));
			if(outboundSMSvalue[i-2].equalsIgnoreCase("select")) {
				boolean l = cappingValueoneoff.isSelected();
				System.out.println("In 7");
				System.out.println(l);
				if(l==false){
					
					cappingValueoneoff.click();
				}
			
				else {
					
					System.out.println("The Frequncy Capping of Outbound Call was also setup earlier for List Users");
				}
							}
			
			
			else {
				boolean l = cappingValueoneoff.isSelected();
                  if(l==true){
					
					cappingValueoneoff.click();
				}
			
				else {
					
					System.out.println("The Frequncy Capping of Outbound Call was not setup earlier for List Users");
				
			}
				
			}
			}
			
			String cappingValue = "//td[text()='Outbound SMS']/../td["+i+"]/input";
			driver.findElement(By.xpath(cappingValue)).clear();
			driver.findElement(By.xpath(cappingValue)).sendKeys(outboundSMSvalue[i-3]);
			
			
		}
	}
	
	
	
	public void emailCapping(String email) {
		
		String[] emailvalue = email.split(",");
		
		
		for(int i=3;i<=6;i++) {
			
			String cappingValue = "//td[text()='Email']/../td["+i+"]/input";
			driver.findElement(By.xpath(cappingValue)).clear();
			driver.findElement(By.xpath(cappingValue)).sendKeys(emailvalue[i-3]);
			
			if(i==6) {
				WebElement cappingValueTimeGap = driver.findElement(By.xpath("//td[text()='Email']/../td["+i+"]/input/../select"));
				selectElementByVisbleText(cappingValueTimeGap, emailvalue[i-2]);
			}
			
		}
	}
	
	
	
	
	public void outboundCall(String outboundCall) {
		String[] outboundCalls = outboundCall.split(",");
		
		
		for(int i=3;i<=6;i++) {
			
			String cappingValue = "//td[text()='Outbound Call']/../td["+i+"]/input";
			driver.findElement(By.xpath(cappingValue)).clear();
			driver.findElement(By.xpath(cappingValue)).sendKeys(outboundCalls[i-3]);
			
			if(i==6) {
				WebElement cappingValueTimeGap = driver.findElement(By.xpath("//td[text()='Outbound Call']/../td["+i+"]/input/../select"));
				selectElementByVisbleText(cappingValueTimeGap, outboundCalls[i-2]);
			}
			
		}
	}
	
	
	
	
	public void PushNotification(String pushNotification) {
		String[] pushNotifications = pushNotification.split(",");
		
		
		for(int i=3;i<=6;i++) {
			
			String cappingValue = "//td[text()='Push Notification']/../td["+i+"]/input";
			driver.findElement(By.xpath(cappingValue)).clear();
			driver.findElement(By.xpath(cappingValue)).sendKeys(pushNotifications[i-3]);
			
			if(i==6) {
				WebElement cappingValueTimeGap = driver.findElement(By.xpath("//td[text()='Push Notification']/../td["+i+"]/input/../select"));
				selectElementByVisbleText(cappingValueTimeGap, pushNotifications[i-2]);
			}
			
		}
	}
	
	
}
