package com.augmento.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;
import com.aventstack.extentreports.Status;

public class ListManager_ListLibraryPage extends BaseClass {

	public ListManager_ListLibraryPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'List Manager')]")
	WebElement ListManager;
	@FindBy(xpath = "//a[contains(text(),'List Library')]")
	WebElement ListLibrary;
	@FindBy(xpath = "//select[@id='deleteLists']")
	WebElement deletList;
	@FindBy(xpath = "//select[@id='exportType']")
	WebElement exportType;
	@FindBy(xpath = "//input[@name='ExportList']")
	WebElement exportClick;

	@FindBy(xpath = "//select[@id='delimiter']")
	WebElement delimiterexport;
	@FindBy(xpath = "//a[@id='segment']")
	WebElement createSegment;

	@FindBy(xpath = "//input[@id='listCategory']")
	WebElement categorizeList;
	@FindBy(xpath = "//input[@id='listName']")
	WebElement nameOfList;
	@FindBy(xpath = "//input[@id='listDesc']")
	WebElement descriptionList;
	@FindBy(xpath = "//button[@class='btn-qb button-blue-border']")
	WebElement addRule;
	@FindBy(xpath = "//select[@name='builder_rule_0_parent']")
	WebElement addRuleSelect;
	@FindBy(xpath = "//select[@name='builder_rule_0_filter']")
	WebElement ruleSelectList;
	@FindBy(xpath = "//select[@name='builder_rule_0_operator']")
	WebElement ruleOprator;
	@FindBy(xpath = "//input[@name='builder_rule_0_value']")
	WebElement ruleMatchValue;
	@FindBy(xpath = "//button[@class='btn btn-warning vfbtn-large preview']")
	WebElement clickPreview;

	@FindBy(xpath = "//button[@id='save-segment']")
	WebElement saveSegment;

	public void goToListLibrary() {

	}

	/*
	 * public void deleteList(String deleteType) { mouseover(ListManager);
	 * ListLibrary.click(); listelement(1);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public void listelement(String deleteTypex, String value) throws InterruptedException {
		
		//&&&&&&&&&&&&&&
		test = extent.createTest("Deleting List");
		
		
		
		mouseover(ListManager);
		ListLibrary.click();

		String[] values = value.split(",");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values.length);
			Thread.sleep(2000);
			String element = "//td[text()='"+values[i]+"']/../td[1]";
			driver.findElement(By.xpath(element)).click();

		}
		
		
		
		//###############################
		test.log(Status.INFO, "Delete List Name : " + value);
		
		
		
		selectElementByVisbleText(deletList, deleteTypex);
		alert();
	}

	
	
	
	
	
	
	public void exportList(String FileFormat, String delimeter, String value) throws InterruptedException {
		
		
		//&&&&&&&&&&&&&&
		test = extent.createTest("Exporting the List");

		mouseover(ListManager);
		ListLibrary.click();

		String[] values = value.split(",");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values.length);
			Thread.sleep(2000);
			//String element = "//input[@value=" + values[i] + "and @class='deleteList']";

			String element = "//td[text()='"+values[i]+"']/../td[1]";
			driver.findElement(By.xpath(element)).click();

		}
		
		

		//###############################
			test.log(Status.INFO, "List Selected : " + value);
			
			
			
		selectElementByVisbleText(exportType, FileFormat);
		//###############################
		test.log(Status.INFO, "File Format : " + FileFormat);
		
		selectElementByVisbleText(delimiterexport, delimeter);
		exportClick.click();
		
		//Thread.sleep(2000);
		/*
		 * Alert a=driver.switchTo().alert(); a.accept();
		 */

	}

	
	
	
	
	public void createSegment(String categorizeListx, String nameOfListx, String descriptionListx, String value,
			String selectRule, String ruleList, String operator, String MatchValue) throws InterruptedException {
		
		
		//&&&&&&&&&&&&&&
				test = extent.createTest("Creating the Segment");
		
		
		mouseover(ListManager);
		ListLibrary.click();

		String[] values = value.split(",");
		for (int i = 0; i < values.length; i++) {
			System.out.println(values.length);
			Thread.sleep(2000);
			String element = "//td[text()='"+values[i]+"']/../td[1]";

			driver.findElement(By.xpath(element)).click();

		}
		
		
		
			//###############################
				test.log(Status.INFO, "List Selected : " + value);
				
		
		Thread.sleep(1000);
	//	String listvaluexpath = "//input[@value = '" + values[0] + "']";
		//WebElement listValue = driver.findElement(By.xpath(listvaluexpath));
		//String ListValue = listValue.getAttribute("title");

		createSegment.click();
		categorizeList.sendKeys(categorizeListx);

		nameOfList.sendKeys(nameOfListx);

		descriptionList.sendKeys(descriptionListx);

		

		//###############################
			test.log(Status.INFO, "Segment Name : " + nameOfListx);
			
		
		
		
		Thread.sleep(1000);
		/*
		 * Alert alert = driver.switchTo().alert(); System.out.println(alert.getText() +
		 * " Alert is Displayed"); // Boolean flag;
		 * 
		 * if (alert.getText() != null) { for (int j = 0; j < 1; j++) { alert.accept();
		 * nameOfList.sendKeys(nameOfListx + j); } }
		 * 
		 * else {
		 * 
		 * System.out.println("No duplicate List");
		 * 
		 * }
		 */
		selectElementByVisbleText(addRuleSelect, selectRule);
		selectElementByVisbleText(ruleSelectList,ruleList);
		selectElementByVisbleText(ruleOprator, operator);
		ruleMatchValue.sendKeys(MatchValue);
		
		//###############################
		test.log(Status.INFO, "Rule selected from list :" +ruleList);
		

		clickPreview.click();

		try {

			saveSegment.isDisplayed();
			saveSegment.click();
			
			//###############################
			test.log(Status.INFO, "List has been segmented");
			
			
		} catch (Exception e) {

			System.out.println("No Recoreds Found in selected list");
			
			//###############################
			test.log(Status.INFO, "No Recoreds Found in selected list");
			
			
		}

	}

}
