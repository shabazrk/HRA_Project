package com.TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void softAssert() {
		SoftAssert sa = new SoftAssert();
		System.out.println("1");
		System.out.println("2");
		sa.assertEquals("A", "B");
		System.out.println("3");
		System.out.println("4");
		sa.assertAll();
		System.out.println("5");
	}
}
