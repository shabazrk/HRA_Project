package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class contains methods for Excel utilities
 * 
 * @author Admin
 *
 */
public class ExcelUtility {

	/**
	 * This method is used to fetch data from excel sheet
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws Throwable {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelFilePath));
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data = cell.getStringCellValue();
		return data;

	}

	/**
	 * This method is used to write data in to excel sheet
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String value)
			throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);

		FileOutputStream fout = new FileOutputStream(IPathConstants.excelFilePath);
		workbook.write(fout);
		workbook.close();

	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelFilePath));
		Sheet sheet = wb.getSheet(sheetName);
		int RowCount = sheet.getLastRowNum();
		wb.close();
		return RowCount;
	}

	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn,
			WebDriver driver, JavaUtility jLib) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();

		HashMap<String, String> map = new HashMap<>();

		for (int i = 1; i <= rowCount; i++) {
			String key = sheet.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sheet.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
}
