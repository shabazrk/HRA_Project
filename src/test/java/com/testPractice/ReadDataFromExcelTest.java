package com.testPractice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fi);
		Sheet sheet = workbook.getSheet("Org");
		int rowCount = sheet.getLastRowNum();
		System.out.println("row count is "+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			int lastColCount = sheet.getRow(i).getLastCellNum();
			System.out.println("Cell count is"+lastColCount);
			for (int j = 0; j < lastColCount; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+" ");
			}
			System.out.println();
		}	
	}
}
