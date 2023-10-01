package com.TestNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotation {

	@BeforeSuite
	public void connectToDB() {
		System.out.println("connect to db");
	}
	
	@BeforeClass
	public void launchTheBrowser() {
		System.out.println("launch the browser");
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("login to app");
	}
	
	@Test 
	public void executeTest() {
		System.out.println("execute test");
	}
	
	@AfterMethod
	public void logoutOfApp() {
		System.out.println("logout of app");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("close the browser");
	}
	
	@AfterSuite
	public void closeDB() {
		System.out.println("close the database conn");
	}
}
