package com.TestNG;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.IPathConstants;

public class DataProviderTest {

	@DataProvider
	public Object[][] mobiles(){
		Object [][] obj = new Object[3][3];
		obj[0][0]= "Samsung";
		obj[0][1]=20000;
		obj[0][2]="Black";
		
		obj[1][0]= "Apple";
		obj[1][1]=80000;
		obj[1][2]="Gold";
		
		obj[2][0]= "Nokia";
		obj[2][1]=50000;
		obj[2][2]="Blue";
		
		return obj;
		
	}
	@Test(dataProvider = "mobiles")
	public void getData(String mobName,int price,String color) {
		
		System.out.println(mobName+"-->"+price+"-->"+color);
	}
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("DP");
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
	@DataProvider
	public Object[][] getDataExUtility() throws Throwable{
		ExcelUtilityTestNG eLib = new ExcelUtilityTestNG();
		Object[][] obj = eLib.dataFromExcel("DP");
		return obj;
	}
}
