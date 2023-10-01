package com.TestNG;

import org.testng.annotations.Test;

public class DataExecutionTest {

	
//	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "mobiles")
//	public void readData(String mobName,int price,String color) {
//		System.out.println(mobName+"-->"+price+"-->"+color);
//	}
	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "dataFromExcel",invocationCount = 0)
	public void readExcelData(String mobName,String price,String color) {
		System.out.println(mobName+"-->"+price+"-->"+color);
	}
	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataExUtility")
	public void readData(String mobName,String price,String color) {
		System.out.println(mobName+"-->"+price+"-->"+color);
	}
	
}
