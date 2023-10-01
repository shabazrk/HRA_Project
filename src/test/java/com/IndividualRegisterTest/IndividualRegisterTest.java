package com.IndividualRegisterTest;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;
import com.HRA.ObjectRepo.AdminDashboardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.IndividualPage;
import com.HRA.ObjectRepo.LoginPage;

public class IndividualRegisterTest extends BaseClass {

//	public static void main(String[] args) throws Throwable {
//		WebDriver driver = null;
//		WebDriverUtility wLib = new WebDriverUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		FileUtility fLib = new FileUtility();
//
//		String BROWSER = fLib.getPropertyKeyValue("browser");
//		String URL = fLib.getPropertyKeyValue("url");
//		String USERNAME = fLib.getPropertyKeyValue("username");
//		String PASSWORD = fLib.getPropertyKeyValue("password");
//
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			System.out.println("Invalid Browser");
//		}
//
//		wLib.maximizeTheBrowser(driver);
//		wLib.implicitlyWait(driver, 10);

		@Test(retryAnalyzer = com.GenericUtility.RetryImpClass.class)
		public void executeTest() throws Throwable {
		
		AdminDashboardPage adminDPage= new AdminDashboardPage(driver);
		adminDPage.clickOnRegisterBuilding();

		String registerPage = driver.findElement(By.xpath("//h2[.='Register Room']")).getText();
		if (registerPage.contains("Register Room"))
			System.out.println("Indiviual Room page is displayed");
		
		else if (registerPage.contains("Apartment Room"))
			System.out.println("Apartment Room page is displayed");
		else
			System.out.println("Register page is not working");
		
		// entering values into text fields from excel utility
		HashMap<String, String> map = eLib.getMultipleDataFromExcel("Individual", 0, 1, driver, jLib);

		IndividualPage ip = new IndividualPage(driver);
		ip.fillDetails(driver, map, "Occupied");
		ip.clickOnSubmit();
		int num = jLib.getRandomnumber();
		
		try {
			String message = driver
					.findElement(
							By.xpath("//div[@class='tab-pane active']//div[.='Registration successfull. Thank you']"))
					.getText();
			if (message.contains("Registration successfull. Thank you"))
				System.out.println("Registration is succesful	l");
		} catch (Exception e) {
			System.out.println("Registration unsuccessfull");
		}
		
	}

}
