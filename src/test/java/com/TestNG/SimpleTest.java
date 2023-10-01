package com.TestNG;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.JavaUtility;

public class SimpleTest extends BaseClass{

	@Test
	public void simpleTest() {
		System.out.println("simple test");
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDateInFormat());
		System.out.println(jUtil.getSystemDate());
	}
	
	
}
