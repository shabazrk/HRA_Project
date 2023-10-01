package com.IntegrateRegisterUserTest;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.HRA.ObjectRepo.AdminDashboardPage;
import com.HRA.ObjectRepo.ApartmentPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.RegisterBuildingPage;

public class RegisterUserIntegrateTest extends BaseClass{

		@Test
		public void registerUserIntegrateTest() throws Throwable {
			Thread.sleep(2000);
			AdminDashboardPage adp = new AdminDashboardPage(driver);
			System.out.println("logout as admin");
			adp.logout();
			Thread.sleep(2000);
			HomePage hp = new HomePage(driver);
			hp.clickOnLogin();
			LoginPage lp = new LoginPage(driver);
			System.out.println("login as a user");
			lp.login("a", "anu");
		
		
		WebElement registeredRooms = driver.findElement(By.xpath("//b[text()='Registered Rooms: ']"));
		if (registeredRooms.isDisplayed()) {
			System.out.println("Home page is displayed");	
		}
		
		
		adp.clickOnRegisterBuilding();
		RegisterBuildingPage rPage = new RegisterBuildingPage(driver);
		rPage.clickOnApartmentTab();


		HashMap<String, String> map = eLib.getMultipleDataFromExcel("Apartment", 0, 1, driver, jLib);

		ApartmentPage ap = new ApartmentPage(driver);
		ap.readValuesExcel(driver, map);
		
		 

		 driver.findElement(By.xpath("//h2[.='Apartment Room']/parent::div//input[@id='image']")).sendKeys("C:\\Users\\Admin\\Downloads\\home.jpeg");
		driver.findElement(By.xpath("//h2[.='Apartment Room']/parent::div//button[@type='submit']")).click();
		
		String message=driver.findElement(By.xpath("//h2[.='Apartment Room']/../child::div")).getText();
		if (message.contains("Registration successfull. Thank you")) {
			System.out.println("Registration is succesful for Apartment");
		}
		
		RegisterBuildingPage regPage = new RegisterBuildingPage(driver);
		regPage.logoutAsUser();
		
		String USERNAME = fLib.getPropertyAdminValue("username");
		String PASSWORD = fLib.getPropertyAdminValue("password");
		lp.login(USERNAME, PASSWORD);
		
		adp.clickOnRoomsForRent();
		
	}
}
