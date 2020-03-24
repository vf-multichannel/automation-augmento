package com.augmento.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.augmento.pages.BaseClass;

public class ExcelDataProvider  {
	
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() throws FileNotFoundException {
	
	File src = new File("./TestData/Data.xlsx");
	
	try {
	FileInputStream fis = new FileInputStream(src);
	
	wb = new XSSFWorkbook(fis);
	
	}catch(Exception e) {
		System.out.println("Unable to read excel" +e.getMessage());
	}
	
	
}
	
	
	
	
	
	public String getStringData(int sheetIndex, int row, int column) {
		
		 return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		 
	}
	
	
	
	
	public String getStringData(String sheet, int row, int column) {
		 return wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getnumeridata(String sheet, int row, int column) {
		 return wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
	}
	
}
