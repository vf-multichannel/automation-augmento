package com.augmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;

public class CampaignStudio_NewCampaignPage extends BaseClass{
	
	
	
	
	
	
	
	
	
	public CampaignStudio_NewCampaignPage() {
		PageFactory.initElements(driver, this);
	}
	    @FindBy(xpath="//a[contains(.,'Campaign Studio')]") WebElement CampaignStudio;
	    @FindBy(xpath="//a[contains(.,'Campaign Studio')]/..//a[@id='new_engagement']") WebElement NewCampaign;
	    @FindBy(xpath="//input[@id='cs_campaign_name']") WebElement CampaignName;
	    @FindBy(xpath="//select[@id='cs_campaign_type']") WebElement CampaignType;
	    @FindBy(xpath="//select[@id='cs_campaign_type']") WebElement CampaignCategory;
	    @FindBy(xpath="//button[@id='cs_save']") WebElement Save;
	    @FindBy(xpath="//button[@id='cancelNewCampaign']") WebElement Cancel;
	    @FindBy(xpath="//a[@id='select_subscribers_lists']") WebElement SelectSubcribers;
	    @FindBy(xpath="//a[@class='parent_1_1'][contains(., 'List')]") WebElement ListLibrary;
	    @FindBy(xpath="//a[@class='parent_1_3'][contains(.,'Online')]") WebElement OnlineUsers;
	    @FindBy(xpath="//a[@class='parent_1_4'][contains(., 'Profiles')]") WebElement Profiles;
	    @FindBy(xpath="//table[@id='lists-listing']//tr[1]/td[1]/input[@type='checkbox']") WebElement SelectFirstList;
	    @FindBy(xpath="//button[@id='cs_save_lists'][contains(.,' Save')]") WebElement Savebutton;
	    @FindBy(xpath="//div[@id='getSubscribersListModal']//button[@class='close']") WebElement Crossbutton;
	    @FindBy(xpath="//input[@id=\"allowDuplicates\"]/../label/span") WebElement AllowDuplicates;
	    @FindBy(xpath="//*[@id=\"tab-1\"]/div[2]/div[1]/h4/a") WebElement  CampaignDetails;
	    @FindBy(xpath="//input[@id='rdPromo']/../label/span") WebElement PromotionalEmail;;
	    @FindBy(xpath="//input[@id='rdPromo']/../label/span") WebElement TransactionalEmail;;
	    @FindBy(xpath="//label[@for='rdPromo']/span") WebElement PromotionalSMS;
	    @FindBy(xpath="//label[@for='rdTrans']/span") WebElement TransactionalSMS;
	    @FindBy(xpath="//input[@id='subject_line']") WebElement SubjectLine;
	    @FindBy(xpath="//a[@id='upload_from_template_library']") WebElement EmailTempalteLibrary;
	    @FindBy(xpath="//table[@class='table table-striped']//tr[2]/td[1]/input[@name='selected_template_id']") WebElement SelectFirstEmailTemplate;
	    @FindBy(xpath="//select[@id='select_sms_content']") WebElement SelectSMSTemplate;
	    @FindBy(xpath="//input[@name='url_shortner']") WebElement URLShortner;
	    @FindBy(xpath="//input[@id='rdUrlFromText']/../label[@for='rdUrlFromText']/span") WebElement URLFromText;
	    @FindBy(xpath="//input[@id='rdUrlFromText']/../label[@for='rdUrlFromColumn']/span") WebElement URLFromColumns;
	    @FindBy(xpath="//select[@id='selectDomain']") WebElement SelectDomain;
	    @FindBy(xpath="//select[@id='selectDomain']") WebElement SetValidity;  
	    @FindBy(xpath="//a[@id='collapseThreeLink'][contains(.,'Scheduling')]") WebElement SchedulingDetails;
	    @FindBy(xpath="//input[@id='scheduled_date_chbk']") WebElement ScheduleCampaign;
	    @FindBy(xpath="//input[@id='scheduled_date']") WebElement SelectScheduleDate; 
	    @FindBy(xpath="//button[@id='save_campaign_confirm']") WebElement Send;
	    @FindBy(xpath="//a[@id='save-as-draft']") WebElement SaveAsDraft;
	    @FindBy(xpath="//input[@value='split_on_subject']") WebElement SplitEmailSubject;
	    @FindBy(xpath="//input[@value='split_on_content']") WebElement SplitEmailContent;
	    @FindBy(xpath="//select[@id='select_version']") WebElement SelectVersion;
	    @FindBy(xpath="//input[@id='subject_line_version_1']") WebElement Version1Subject;
	    @FindBy(xpath="//input[@id='subject_line_version_2']") WebElement Version2Subject;
	    @FindBy(xpath="//input[@id='subject_line_version_3']") WebElement Version3Subject;
	    @FindBy(xpath="//span[@class='irs']") WebElement TestSizeSliderbar;
	    @FindBy(xpath="//span[@class='irs-slider single']") WebElement SliderPoint;
	    @FindBy(xpath="//input[@value='on_open']") WebElement OpenRate;
	    @FindBy(xpath="//input[@value='on_link_click']") WebElement OnClick;
	    @FindBy(xpath="//input[@value='randomaly']") WebElement RandomlySelectACampaign;
	    @FindBy(xpath="//input[@value='manually']") WebElement ManuallySelectACampaign;
	    @FindBy(xpath="//select[@id='selectDay']") WebElement DurationDay;
	    @FindBy(xpath="//select[@id='selectHour']") WebElement DuartionHrs;
	    @FindBy(xpath="//select[@id='selectMinute']") WebElement DurationMinute;
	    @FindBy(xpath="//input[@id='filter_lists']") WebElement textsubscriber;
	    @FindBy(xpath="//input[@class='show_chbk_input parent_1_1']") WebElement checkBoxSubscriber;
	
	    @FindBy(xpath="  //*[@id=\"lists-listing\"]/tbody/tr[2]/td[1]/text()/../input") WebElement checkBoxSubscribersms;
	    @FindBy(xpath="//*[@id=\"tab-1\"]/div[1]/div[1]/h4/a") WebElement closesubscriber;
	  
	    @FindBy(xpath="//button[@id='save_campaign']") WebElement saveagain;
	    
	    public void CreateNewCampaign(String CampaignNamex,String CampaignTypex, String CampaignCategoryx,String selectSubscriber,String selecttemplate, String TemplateTypex,String SubjectLinex,String SelectSMSTemplatex,String SelectVersionx,String Version1Subjectx,String Version2Subjectx,String DurationDayx,String DurationHrsx,String DurationMinutex ) throws InterruptedException {
	    	
	    	mouseover(CampaignStudio);
	    	NewCampaign.click();
	    //	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	CampaignName.sendKeys(CampaignNamex);
	    	
	    	selectElementByVisbleText(CampaignCategory,CampaignCategoryx);
	    	//CampaignCategory.sendKeys(CampaignCategoryx);
	    	Save.click();
	    	
	    	if(CampaignTypex.equalsIgnoreCase("Email")){
	    	//	SelectSubcribers.click();
	    		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    		//SelectFirstList.click();
	    		textsubscriber.sendKeys(selectSubscriber);
		    	checkBoxSubscriber.click();
	    		Savebutton.click();
	    	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    		Thread.sleep(3000);
	    		closesubscriber.click();
	    		Thread.sleep(1000);
	    		CampaignDetails.click();
	    		if(TemplateTypex.equalsIgnoreCase("Promotional")) {
	    			PromotionalEmail.click();
	    		}
	    		else if(TemplateTypex.equalsIgnoreCase("Transactional")) {
	    			TransactionalEmail.click();
	    		}
	    		
	    		SubjectLine.sendKeys(SubjectLinex);
	    		
	    		EmailTempalteLibrary.click();
	    WebElement selectTemplate = driver.findElement(By.xpath("//td[text()='"+selecttemplate+"']/../td/input"));
	    Thread.sleep(3000);
	    selectTemplate.click();
	    Thread.sleep(2000);
	    		Send.click();  			
	    		saveagain.click();
	    		
	    		
	    	}
	    		
	    	else if(CampaignTypex.equalsIgnoreCase("SMS")){
	    		SelectSubcribers.click();
	    		
	    		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    		//SelectFirstList.click();
	    		textsubscriber.sendKeys(selectSubscriber);
	    		Thread.sleep(1000);
	    		checkBoxSubscribersms.click();
	    		
	    		Savebutton.click();
	    		Thread.sleep(3000);
	    		closesubscriber.click();
	    		Thread.sleep(1000);
	    		CampaignDetails.click();
	    		if(TemplateTypex.equalsIgnoreCase("Promotional")) {
	    			PromotionalSMS.click();
	    		}
	    		else if(TemplateTypex.equalsIgnoreCase("Transactional")) {
	    			TransactionalSMS.click();
	    		}
	    		SubjectLine.sendKeys(SubjectLinex);
	    	
	    		EmailTempalteLibrary.click();
	    	//selectElementByVisbleText(SelectSMSTemplate,SelectSMSTemplatex);
	    		   WebElement selectTemplate = driver.findElement(By.xpath("//td[text()='"+selecttemplate+"']/../td/input"));
	    		    Thread.sleep(3000);
	    		    selectTemplate.click();
	    		    Thread.sleep(2000);
	    		Thread.sleep(2000);
	    		Send.click();  			
	    		saveagain.click();
	   
	    		
	    	}	
	    	   	
	   
	    	else {
	    		SelectSubcribers.click();
	    	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    		textsubscriber.sendKeys(selectSubscriber);
	    		Thread.sleep(1000);
	    		checkBoxSubscribersms.click();
	    		
	    	//	SelectFirstList.click();
	    		Savebutton.click();
	    		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    		Thread.sleep(3000);
	    		closesubscriber.click();
	    		Thread.sleep(2000);
	    		CampaignDetails.click();
	    		
	    		if(TemplateTypex.equalsIgnoreCase("Promotional")) {
	    			PromotionalSMS.click();
	    		}
	    		else if(TemplateTypex.equalsIgnoreCase("Trans	actional")) {
	    			TransactionalSMS.click();
	    		}
	    		
	    		SplitEmailSubject.click();
	    		EmailTempalteLibrary.click();
	    		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    		 WebElement selectTemplate = driver.findElement(By.xpath("//td[text()='"+selecttemplate+"']/../td/input"));
	    		    Thread.sleep(3000);
	    		    selectTemplate.click();
	    		    Thread.sleep(2000);
	    		selectElementByVisbleText(SelectVersion,SelectVersionx);
	    		Version1Subject.sendKeys(Version1Subjectx);
	    		Version2Subject.sendKeys(Version2Subjectx);
			/*
			 * Dimension d= TestSizeSliderbar.getSize(); int width = d.getWidth(); int
			 * xcord=TestSizeSliderbar.getLocation().getX(); dragToDropBy(TestSizeSliderbar,
			 * xcord+width);
			 */
	    		OpenRate.click();
	    		RandomlySelectACampaign.click();
	    		selectElementByVisbleText(DurationDay,DurationDayx);
	    		selectElementByVisbleText(DuartionHrs,DurationHrsx);
	    		selectElementByVisbleText(DurationMinute,DurationMinutex);
	    		Send.click();  	
	    		saveagain.click();
	    		
	    	}	
	    	
	    	
	    	
	    	
	    }
	    
	    
	    
	


}
