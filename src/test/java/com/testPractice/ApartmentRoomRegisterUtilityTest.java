package com.testPractice;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriverUtility;

public class ApartmentRoomRegisterUtilityTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();

		String BROWSER = fLib.getPropertyAdminValue("browser");
		String URL = fLib.getPropertyAdminValue("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		
		wLib.maximizeTheBrowser(driver);
		wLib.implicitlyWait(driver, 10);
		
		driver.get(URL);
		Assert.fail();
		driver.findElement(By.xpath("//a[@class='nav-link'and .='Login']")).click();
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link' and .='Register']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link' and .='Apartment Registration']")).click();
		
		eLib.getMultipleDataFromExcel("Apartment", 0, 1, driver, jLib);

		driver.findElement(By.xpath("//h2[.='Apartment Room']/parent::div//input[@id='image']")).sendKeys("C:\\Users\\Admin\\Downloads\\home.jpeg");
		driver.findElement(By.xpath("//h2[.='Apartment Room']/parent::div//button[@type='submit']")).click();
		
		String message=driver.findElement(By.xpath("//h2[.='Apartment Room']/../child::div")).getText();
		if (message.contains("Registration successfull. Thank you")) {
			System.out.println("Registration is succesful for Apartment");
		}
	}
}
