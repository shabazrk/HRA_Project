package com.ComplaintAdminTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.HRA.ObjectRepo.AdminDashboardPage;
import com.HRA.ObjectRepo.DetailsUpdatePage;

public class ComplaintAdminTest extends BaseClass{

	@Test
	public void executeComplaintAdmin() {
			
		
		
		AdminDashboardPage adminPage = new AdminDashboardPage(driver);
		adminPage.clickOnDetailsUpdate();
		
		DetailsUpdatePage details = new DetailsUpdatePage(driver);
		details.clickOnComplaint();
		
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Green Building");
		driver.findElement(By.xpath("//input[@id='cmp']")).sendKeys("Lift not working");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		String message = driver.findElement(By.xpath("//h2[.='Complaints']/../div")).getText();
		if (message.contains("Sent Successfully")) {
			System.out.println("Complaint registered successfully");
		}
	}
}
