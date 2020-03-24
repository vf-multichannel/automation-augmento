package com.augmento.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	
		
		
		Properties prop;
		
		public ConfigDataProvider() {
			
			File src = new File("./Configuration/Config.properties");
		try {	
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e) {
					System.out.println("Not able to load file >>" +e.getMessage());
			
		}
	}
		
		
		public String getBrowser() {
			return prop.getProperty("Browser");
			
		}
		
		public String getStagingUrl() {
			return prop.getProperty("StagingUrl");
			
		}
		
		//Genric
		public String getDataFromConfig(String KeyTosearch) {
			return prop.getProperty(KeyTosearch);
			
		}

}
