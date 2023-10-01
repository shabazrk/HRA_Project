package com.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer{

	int count = 0;
	int upperLimit = 3;
	@Override
	public boolean retry(ITestResult result) {
		System.out.println(result);
		while(count<upperLimit) {
			count++;
			return true;
		}
		return false;
	}

}
