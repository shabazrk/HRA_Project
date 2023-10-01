package com.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.HRA.ObjectRepo.AdminDashboardPage;
import com.HRA.ObjectRepo.ApartmentPage;
import com.HRA.ObjectRepo.HomePage;
import com.HRA.ObjectRepo.LoginPage;

public class BaseClass {
	

	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public static WebDriver sdriver;
	public WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		dLib.connectionToDB();
		System.out.println("Connecting to Database");
	}

	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)

	public void configBC() throws Throwable {
		String BROWSER = fLib.getPropertyAdminValue("browser");
		String URL = fLib.getPropertyAdminValue("url");
		System.out.println("launching the browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("msedge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		sdriver=driver;
		wLib.maximizeTheBrowser(driver);
		wLib.implicitlyWait(driver, 10);
		driver.get(URL);
	} 

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		String USERNAME = fLib.getPropertyAdminValue("username");
		String PASSWORD = fLib.getPropertyAdminValue("password");

		System.out.println("login to the application");
		HomePage hp = new HomePage(driver);
		hp.clickOnLogin();

		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		System.out.println("logout of the application");
		ApartmentPage ap = new ApartmentPage(driver);
		ap.logout();
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("close the browser");
		wLib.closeTheBrowser(driver);
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException {
		System.out.println("close DB connection");
		dLib.closeDB();
	}
}
