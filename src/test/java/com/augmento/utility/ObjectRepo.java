package com.augmento.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ObjectRepo {

	
	Properties prop;
	
	public ObjectRepo() {
		
		File src = new File("./Configuration/ObjectRepository.properties");
	try {	
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
	}catch(Exception e) {
				System.out.println("Not able to load file >>" +e.getMessage());
		
	}
}
	
	

	
	//Genric
	public String getDataFromConfig(String KeyTosearch) {
		return prop.getProperty(KeyTosearch);
		
	}

}

