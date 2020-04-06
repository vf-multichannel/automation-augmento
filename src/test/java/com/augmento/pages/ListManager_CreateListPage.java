package com.augmento.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.augment.base.BaseClass;
import com.aventstack.extentreports.Status;

public class ListManager_CreateListPage extends BaseClass {

	public ListManager_CreateListPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='listName']")
	WebElement listName;
	@FindBy(xpath = "//input[@id='listCategory']")
	WebElement listCategory;
	@FindBy(xpath = "//textarea[@id='listDesc']")
	WebElement listDescription;
	@FindBy(xpath = "//input[@id='uploadFile']")
	WebElement listUploadList;
	@FindBy(xpath = "//button[@name='UploadList']")
	WebElement importfile;
	@FindBy(xpath = "//select[@id='listEmailIdentifier1']")
	WebElement emailIdentifier;
	@FindBy(xpath = "//select[@id='listMobileIdentifie']")
	WebElement mobilIdentifier;
	@FindBy(xpath = "//select[@id='listUniqueIdentifier']")
	WebElement uniqueIdentifire;
	@FindBy(xpath = "//input[@id='saveListManager']")
	WebElement listSave;
	@FindBy(xpath = "//textarea[@id='listTypeBox']")
	WebElement jsoncreateList;
	@FindBy(xpath = "//select[@id='delimeters']")
	WebElement delimeter;
	@FindBy(xpath = "//button[@name='CreateType']")
	WebElement preview;

	@FindBy(xpath = "listTypeBox")
	WebElement createJsonData;

	@FindBy(xpath = "//td[@class='action_width']")
	WebElement listvalidate;

	public void createList(String listnamex, String listCategoryx, String listDescriptionx)
			throws InterruptedException {
		test = extent.createTest("Create List : "+listnamex);
		listName.sendKeys(listnamex);

		// ##########
		test.log(Status.INFO, "List Name : " + listnamex);

		listCategory.sendKeys(listCategoryx);

		// ##########
		test.log(Status.INFO, "List Category : " + listCategoryx);

		Thread.sleep(5000);

		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText() + " Alert is Displayed");
			// Boolean flag;

			if (alert.getText() != null) {
				for (int j = 0; j < 1; j++) {
					alert.accept();
					listName.sendKeys(listnamex + j);

					// ##########
					test.log(Status.INFO, "Getting duplicate list so now the new list name is : " + listnamex + j);

					listDescription.sendKeys(listDescriptionx);

					// ##########
					test.log(Status.INFO, "List Description : " + listDescriptionx);
				}
			}

			else {

				System.out.println("No duplicate List");

			}

		} catch (Exception e) {
			listDescription.sendKeys(listDescriptionx);

			// ##########
			test.log(Status.INFO, "List Description : " + listDescriptionx);
		}

	}

	public ListManager_ListLibraryPage createFileInlist(String listnamex, String typeFile, String fileName,
			String emailIdentifierx, String mobilIdentifierx, String uniqueIdentifirex, String jsonDataHeader,
			String jsonData, String Delimiter) throws AWTException, InterruptedException {

		String[] jsonDataHs = jsonDataHeader.split("");
		String[] jsonDatas = jsonData.split(":");

		//##########
		test.log(Status.INFO, "Type of data we are importing in list is : " + typeFile);

		if (typeFile.equalsIgnoreCase("Import")) {
			listUploadList.sendKeys(fileName);

			//##########
			test.log(Status.INFO, "File Path : " + fileName);

			importfile.click();

			// Identifiers
			selectElementByVisbleText(emailIdentifier, emailIdentifierx);
			selectElementByVisbleText(mobilIdentifier, mobilIdentifierx);
			selectElementByVisbleText(uniqueIdentifire, uniqueIdentifirex);

			listSave.click();

		

		}

		else {

			for (int i = 0; i < jsonDataHs.length; i++) {
				jsoncreateList.sendKeys(jsonDataHs[i]);

			}
			//##########
			test.log(Status.INFO, "Data headers : " + jsonDataHeader);

			/*
			 * Robot robot = new Robot(); Thread.sleep(1000);
			 * robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			 */

			Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
			//enter a key
			keyboard.pressKey(Keys.ENTER);

			Thread.sleep(1000);

			for (int j = 0; j < jsonDatas.length; j++) {

				jsoncreateList.sendKeys(jsonDatas[j]);

				Thread.sleep(1000);
				keyboard.pressKey(Keys.ENTER);

			}

			//##########
			test.log(Status.INFO, "Data  : " + jsonData);

			System.out.println("Create List");
			
			
		

		selectElementByVisbleText(delimeter, Delimiter);
		preview.click();

		if (jsonDataHs.length == 1) {
			selectElementByValue(emailIdentifier, 0);
		} else if (jsonDataHs.length == 2) {
			selectElementByValue(emailIdentifier, 0);
			selectElementByValue(mobilIdentifier, 1);

		} else {
			selectElementByValue(emailIdentifier, 0);
			selectElementByValue(mobilIdentifier, 1);
			selectElementByValue(uniqueIdentifire, 2);
		}

		listSave.click();
		
		}
		
		//Wait for loading the list		
		invisibilityWait("//td[@class='queue-process']");
		
		//*************************
		String lisnamevalidate = listvalidate.getText();
		softassert.assertEquals(listnamex, lisnamevalidate);
		
		
		test.log(Status.INFO, "List has been saved");

		return new ListManager_ListLibraryPage();
	}

}
