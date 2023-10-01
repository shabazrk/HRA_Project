package com.testPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Org");
		sheet.createRow(8).createCell(0).setCellValue("Zeta");
		sheet.getRow(8).createCell(1).setCellValue("Meta");
//		sheet.createRow(9);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cell value");
//		Random ran = new Random();
		int rowCount=sheet.getLastRowNum();
		int colColumn=sheet.getRow(1).getLastCellNum();
		System.out.println("rowcount"+ rowCount);
		System.out.println("col count "+colColumn);
//		for (int i = 0; i <= 15; i++) {
//			for (int j = 0; j < 2; j++) {
//				String cellValue = sc.nextLine();
//				sheet.createRow(i);
//				sheet.getRow(i).createCell(j).setCellValue(cellValue);
//				
//			}
//			
//		}
////		int rowCount = sheet.getLastRowNum();
////		System.out.println(rowCount);
////		int cellCount = sheet.getRow(0).getLastCellNum();
////		System.out.println(cellCount);
//		FileOutputStream fOut= new FileOutputStream("./src/test/resources/TestData.xlsx");
//		wb.write(fOut);
//		wb.close();
	}
}
