package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Home")
	private WebElement HomeTab;

	@FindBy(linkText = "Register")
	private WebElement RegisterBuilding;

	@FindBy(linkText = "Details/Update")
	private WebElement DetailsUpdateTab;

	@FindBy(linkText = "Send SMS")
	private WebElement SendSmsTab;

	@FindBy(linkText = "Complaint List")
	private WebElement ComplaintListTab;

	@FindBy(xpath = "//div[@class='alert alert-warning']/b[contains(.,'Registered Users: ')]")
	private WebElement RegisteredUsers;

	@FindBy(xpath = "//div[@class='alert alert-warning']/b[contains(.,'Rooms for Rent: ')]")
	private WebElement RoomsForRent;
	
	@FindBy(xpath = "//a[@class='navbar-brand js-scroll-trigger']")
	private WebElement PageHeading;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement Logout;
	
	//getters
	public WebElement getHomeTab() {
		return HomeTab;
	}

	public WebElement getRegisterBuilding() {
		return RegisterBuilding;
	}

	public WebElement getDetailsUpdateTab() {
		return DetailsUpdateTab;
	}

	public WebElement getSendSmsTab() {
		return SendSmsTab;
	}

	public WebElement getComplaintListTab() {
		return ComplaintListTab;
	}

	public WebElement getRegisteredUsers() {
		return RegisteredUsers;
	}

	public WebElement getRoomsForRent() {
		return RoomsForRent;
	}
	
	public WebElement getLogout() {
		return Logout;
	}
	
	public WebElement getPageHeading() {
		return PageHeading;
	}
	
	//Business Libraries
	
	public void clickOnHome() {
		HomeTab.click();
	}
	
	public void clickOnRegisterBuilding() {
		RegisterBuilding.click();
	}
	
	public void clickOnDetailsUpdate() {
		DetailsUpdateTab.click();
	}
	
	public void clickOnSendSMS() {
		SendSmsTab.click();
	}
	
	public void clickOnComplaint() {
		ComplaintListTab.click();
	}
	
	public void clickOnRegisteredUsers() {
		RegisteredUsers.click();
	}
	public String getPageHeadingText() {
	return	PageHeading.getText();
	}
	
	public void clickOnRoomsForRent() {
		RoomsForRent.click();
	}
	public void logout() {
		Logout.click();
	}
}
