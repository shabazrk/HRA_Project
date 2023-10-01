package com.TestNG;

import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;

public class SampleTest extends BaseClass{

	@Test
	public void sample() {
		System.out.println("sample test in smoke group");
		
	}
	@Test
	public void sampleReg() {
		System.out.println("Regression group from sample");
	}
}
