package com.TestNG;

import org.testng.annotations.Test;

public class PracticeTest {
@Test
	public void createTest() {
		int []ar = {1,2,3};
		System.out.println(ar[4]);
		
		System.out.println("creating data");
	}
	
	@Test(dependsOnMethods = "createTest")
	public void editTest() {
		
		System.out.println("editing data");
	}
	
	@Test(priority = -1)
	public void deleteTest() {
		System.out.println("deleting data");
	}
	
}
