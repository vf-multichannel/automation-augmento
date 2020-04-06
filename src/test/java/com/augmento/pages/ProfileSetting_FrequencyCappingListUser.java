package com.augmento.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class ProfileSetting_FrequencyCappingListUser extends BaseClass{

	public ProfileSetting_FrequencyCappingListUser() {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//li[@class='has-sub log_icon']/a") WebElement Profile;
	@FindBy(xpath="//a[@class='cur_cap'][contains(., 'Settings')]") WebElement Settings;
	@FindBy(xpath="//a[contains(.,'Frequency')]") WebElement FrequencyCapping;
	@FindBy(xpath="//input[@name='list[days][1]']") WebElement ListObdSMSPerDay;
	@FindBy(xpath="//input[@name='list[weeks][1]']") WebElement ListObdSMSPerWeek;
	@FindBy(xpath="//input[@name='list[months][1]']") WebElement ListObdSMSPerMonth;
	@FindBy(xpath="//input[@name='list[intervals][1]']") WebElement ListObdSMSTimeGap;
	@FindBy(xpath="//select[@name='list[time_frame][1]']") WebElement ListObdSMSTimeUnit;
	@FindBy(xpath="//input[@name='list[status][1]']/../span") WebElement ListObdSMSOnOffBtn;
	@FindBy(xpath="//input[@name='list[days][2]']") WebElement ListEmailPerDay;
	@FindBy(xpath="//input[@name='list[weeks][2]']") WebElement ListEmailPerWeek;
	@FindBy(xpath="//input[@name='list[months][2]']") WebElement ListEmailPerMonth;
	@FindBy(xpath="//input[@name='list[intervals][2]']") WebElement ListEmailTimeGap;
	@FindBy(xpath="//select[@name='list[time_frame][2]']") WebElement ListEmailTimeUnit;
	@FindBy(xpath="//input[@name='list[status][2]']/../span") WebElement ListEmailOnOffBtn;
	@FindBy(xpath="//input[@name='list[days][4]']") WebElement ListObdCallPerDay;
	@FindBy(xpath="//input[@name='list[weeks][4]']") WebElement ListObdCallPerWeek;
	@FindBy(xpath="//input[@name='list[months][4]']") WebElement ListObdCallPerMonth;
	@FindBy(xpath="//input[@name='list[intervals][4]']") WebElement ListObdCallTimeGap;
	@FindBy(xpath="//select[@name='list[time_frame][4]']") WebElement ListObdCallTimeUnit;
	@FindBy(xpath="//input[@name='list[status][4]']/../span") WebElement ListObdCallOnOffBtn;
	@FindBy(xpath="//input[@name='list[days][13]']") WebElement ListPushNotificationPerDay;
	@FindBy(xpath="//input[@name='list[weeks][13]']") WebElement ListPushNotificationPerWeek;
	@FindBy(xpath="//input[@name='list[months][13]']") WebElement ListPushNotificationPerMonth;
	@FindBy(xpath="//input[@name='list[intervals][13]']") WebElement ListPushNotificationTimeGap;
	@FindBy(xpath="//select[@name='list[time_frame][13]']") WebElement ListPushNotificationTimeUnit;
	@FindBy(xpath="//input[@name='list[status][13]']/../span") WebElement ListPushNotificationOnOffBtn;
	@FindBy(xpath="//input[@class='select2-search__field']") WebElement ExcludeWorkflows;
	@FindBy(xpath="//input[@type='submit']") WebElement Save;
	@FindBy(xpath="//a[contains(.,'Cancel')]") WebElement Cancel;
	
	
	public void setfrequencyCappingOfObdSMSForListUser(String ListObdSMSPerDayx,String ListObdSMSPerWeekx,String ListObdSMSPerMonthx,String ListObdSMSTimeGapx,String  ListObdSMSTimeUnitx,String ExcludeWorkflowsx1,String ExcludeWorkflowsx2) throws InterruptedException {
	
		mouseover(Profile);
		mouseover(Settings);
		FrequencyCapping.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ListObdSMSPerDay.clear();
		ListObdSMSPerDay.sendKeys(ListObdSMSPerDayx);
		ListObdSMSPerWeek.clear();
		ListObdSMSPerWeek.sendKeys(ListObdSMSPerWeekx);
		ListObdSMSPerMonth.clear();
		ListObdSMSPerMonth.sendKeys(ListObdSMSPerMonthx);
		ListObdSMSTimeGap.clear();
		ListObdSMSTimeGap.sendKeys(ListObdSMSTimeGapx);
		selectElementByVisbleText(ListObdSMSTimeUnit, ListObdSMSTimeUnitx);
		boolean l = ListObdSMSOnOffBtn.isSelected();
		if(l==false){
			
			ListObdSMSOnOffBtn.click();
		}
	
		else {
			
			System.out.println("The Frequncy Capping of Outbound SMS was also setup earlier for List Users");
		}
		
		ExcludeWorkflows.clear();
		ExcludeWorkflows.click();
		
		WebElement ExcludeWorkflows1 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx1+"')]"));
		WebElement ExcludeWorkflows2 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx2+"')]"));
		ExcludeWorkflows1.click();
		ExcludeWorkflows2.click();
		Save.click();
		
	}
	
	public void setfrequencyCappingOfEmailForListUser(String ListEmailPerDayx,String ListEmailPerWeekx,String ListEmailPerMonthx,String ListEmailTimeGapx,String  ListEmailTimeUnitx,String ExcludeWorkflowsx3,String ExcludeWorkflowsx4) throws InterruptedException {
		
		mouseover(Profile);
		mouseover(Settings);
		FrequencyCapping.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ListEmailPerDay.clear();
		ListEmailPerDay.sendKeys(ListEmailPerDayx);
		ListEmailPerWeek.clear();
		ListEmailPerWeek.sendKeys(ListEmailPerWeekx);
		ListEmailPerMonth.clear();
		ListEmailPerMonth.sendKeys(ListEmailPerMonthx);
		ListEmailTimeGap.clear();
		ListEmailTimeGap.sendKeys(ListEmailTimeGapx);
		selectElementByVisbleText(ListEmailTimeUnit, ListEmailTimeUnitx);
		boolean l = ListEmailOnOffBtn.isSelected();
		if(l==false){
			
			ListEmailOnOffBtn.click();
		}
	
		else {
			
			System.out.println("The Frequncy Capping of Email was also setup earlier for List Users");
		}
		
		ExcludeWorkflows.clear();
		ExcludeWorkflows.click();
		
		WebElement ExcludeWorkflows3 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx3+"')]"));
		WebElement ExcludeWorkflows4 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx4+"')]"));
		ExcludeWorkflows3.click();
		ExcludeWorkflows4.click();
		Save.click();
		
	}
public void setfrequencyCappingOfObdCallForListUser(String ListObdCallPerDayx,String ListObdCallPerWeekx,String ListObdCallPerMonthx,String ListObdCallTimeGapx,String  ListObdCallTimeUnitx,String ExcludeWorkflowsx5,String ExcludeWorkflowsx6) throws InterruptedException {
		
		mouseover(Profile);
		mouseover(Settings);
		FrequencyCapping.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ListObdCallPerDay.clear();
		ListObdCallPerDay.sendKeys(ListObdCallPerDayx);
		ListObdCallPerWeek.clear();
		ListObdCallPerWeek.sendKeys(ListObdCallPerWeekx);
		ListObdCallPerMonth.clear();
		ListObdCallPerMonth.sendKeys(ListObdCallPerMonthx);
		ListObdCallTimeGap.clear();
		ListObdCallTimeGap.sendKeys(ListObdCallTimeGapx);
		selectElementByVisbleText(ListObdCallTimeUnit, ListObdCallTimeUnitx);
		boolean l = ListObdCallOnOffBtn.isSelected();
		if(l==false){
			
			ListObdCallOnOffBtn.click();
		}
	
		else {
			
			System.out.println("The Frequncy Capping of Outbound Call was also setup earlier for List Users");
		}
		
		ExcludeWorkflows.clear();
		ExcludeWorkflows.click();
		
		WebElement ExcludeWorkflows5 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx5+"')]"));
		WebElement ExcludeWorkflows6 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx6+"')]"));
		ExcludeWorkflows5.click();
		ExcludeWorkflows6.click();
		Save.click();
		
	}

public void setfrequencyCappingOfPushNotificationForListUser(String ListPushNotificationPerDayx,String ListPushNotificationPerWeekx,String ListPushNotificationPerMonthx,String ListPushNotificationTimeGapx,String  ListPushNotificationTimeUnitx,String ExcludeWorkflowsx7,String ExcludeWorkflowsx8) throws InterruptedException {
	
	mouseover(Profile);
	mouseover(Settings);
	FrequencyCapping.click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	ListPushNotificationPerDay.clear();
	ListPushNotificationPerDay.sendKeys(ListPushNotificationPerDayx);
	ListPushNotificationPerWeek.clear();
	ListPushNotificationPerWeek.sendKeys(ListPushNotificationPerWeekx);
	ListPushNotificationPerMonth.clear();
	ListPushNotificationPerMonth.sendKeys(ListPushNotificationPerMonthx);
	ListPushNotificationTimeGap.clear();
	ListPushNotificationTimeGap.sendKeys(ListPushNotificationTimeGapx);
	selectElementByVisbleText(ListPushNotificationTimeUnit, ListPushNotificationTimeUnitx);
	boolean l = ListPushNotificationOnOffBtn.isSelected();
	if(l==false){
		
		ListPushNotificationOnOffBtn.click();
	}

	else {
		
		System.out.println("The Frequncy Capping of Push Notification was also setup earlier for List Users");
	}
	
	ExcludeWorkflows.clear();
	ExcludeWorkflows.click();
	
	WebElement ExcludeWorkflows7 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx7+"')]"));
	WebElement ExcludeWorkflows8 = driver.findElement(By.xpath("//li[contains(.,'"+ExcludeWorkflowsx8+"')]"));
	ExcludeWorkflows7.click();
	ExcludeWorkflows8.click();
	Save.click();
	
}



}
