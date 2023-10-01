package com.RegisteredUser_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriverUtility;
import com.HRA.ObjectRepo.AdminDashboardPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.LoginPage;
import com.HRA.ObjectRepo.RegisteredUsersPage;

public class RegisteredUserAdminTest {
	static WebDriver driver = null;
		
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		
		String BROWSER = fLib.getPropertyAdminValue("browser");
		String URL = fLib.getPropertyAdminValue("url");
		String USERNAME = fLib.getPropertyAdminValue("username");
		String PASSWORD = fLib.getPropertyAdminValue("password");
		
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
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
		//validation
		AdminDashboardPage adminPage= new AdminDashboardPage(driver);
		
		String pageHeading = adminPage.getPageHeadingText();
		if (pageHeading.contains("Home")) {
			System.out.println("Home page is displayed");
		}
		else
			System.out.println("Home page is not displayed");
		
		adminPage.clickOnRegisteredUsers();
		
		//validation
		RegisteredUsersPage regUsersPage = new RegisteredUsersPage(driver);
		String userPage = regUsersPage.getListUsers().getText();
		if (userPage.contains("List Of Usres")) {
			System.out.println("List of users page is Displayed");
		}
		else
			System.out.println("Registered user link is not working");
		
	}
		
		
}
