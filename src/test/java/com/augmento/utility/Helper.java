package com.augmento.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		
		String path=	System.getProperty("user.dir")+"/Screenshots/"+ getCurrentDateTime() +".png";
		File des = new File(path);	
		try {
		FileUtils.copyFile(src, des);
			System.out.println("Screenshot Captured");
		}catch(Exception e){
			System.out.println("Unable to capture screenshot " +e.getMessage());
		}
		
	return path;
		
}
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
		
	}
}
