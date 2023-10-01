package com.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernersImpClass  implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//actual test scripts execution starts from here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"---->Execution starts");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---->Passed");
		Reporter.log(methodName+"-----TestScript executed succesfully");
	}
		
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String methodName = result.getMethod().getMethodName();
	
	String failedScript = WebDriverUtility.takeScreenShot(BaseClass.sdriver,methodName);
	test.addScreenCaptureFromPath(failedScript);
		
//	test.log(Status.FAIL,result.getThrowable());
	test.log(Status.FAIL, methodName+"-----Failed");
	Reporter.log(methodName+"----->Failed");
	
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodName+"---->skipped");
		Reporter.log(methodName+"----->Skipped");
	}
	
	@Override
	public void onStart(ITestContext context) {
	ExtentSparkReporter htmlReport = new ExtentSparkReporter("./Extentreport/report.html");
	
	htmlReport.config().setDocumentTitle("HRA");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("HRA TestNG");
	
	report = new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("Base-Browser", "chrome");
	report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/House_Rental_Application/");
	report.setSystemInfo("Reporter Name", "Shabaz");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
}
