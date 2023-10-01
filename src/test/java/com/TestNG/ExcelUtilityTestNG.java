package com.TestNG;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtility.IPathConstants;

public class ExcelUtilityTestNG {

	
		
	public Object[][] dataFromExcel(String sheetName) throws Throwable{

		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(lastRow).getLastCellNum();
		
		Object[][] ar= new Object[lastRow+1][lastCell];
		for(int i=0;i<=lastRow;i++) {
			for (int j = 0; j < lastCell; j++) {
				ar[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			} 
		}
		return ar;
	}
	
}

