
package com.ApartmentRoomTest;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.HRA.ObjectRepo.AdminDashboardPage;
import com.HRA.ObjectRepo.ApartmentPage;
import com.HRA.ObjectRepo.RegisterBuildingPage;
@Listeners(com.GenericUtility.ListernersImpClass.class)
public class ApartmentRoomRegisterTest extends BaseClass {
	@Test
	public void executeScript() throws Throwable {
 
		AdminDashboardPage adminPage = new AdminDashboardPage(driver);
		adminPage.clickOnRegisterBuilding();

		RegisterBuildingPage reg = new RegisterBuildingPage(driver);
		reg.clickOnApartmentTab();

		HashMap<String, String> map = eLib.getMultipleDataFromExcel("Apartment", 0, 1, driver, jLib);

		ApartmentPage ap = new ApartmentPage(driver);
		ap.readValuesExcel(driver, map);
		
		
		ap.clickOnSubmit();
		
		Thread.sleep(5000);
		String message = driver
				.findElement(By.xpath("//div[@class='tab-pane active']//div[@class='alert alert-info']/div")).getText();
		Assert.assertEquals(message, "Registration successfull. Thank you");

		System.out.println("Registration is succesful for Apartment");

	}
}
