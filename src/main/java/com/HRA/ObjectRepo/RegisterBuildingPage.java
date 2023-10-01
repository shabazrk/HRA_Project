package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterBuildingPage {

	public RegisterBuildingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[.='Individual Home Registration']")
	private WebElement IndHomeReg;

	@FindBy(xpath = "//a[.='Apartment Registration']")
	private WebElement ApartReg;

	@FindBy(xpath = "//a[@href='../auth/logout.php']")
	private WebElement Logout;
	//getters
	public WebElement getIndHomeReg() {
		return IndHomeReg;
	}

	public WebElement getApartReg() {
		return ApartReg;
	}
	
	
	
	public WebElement getLogout() {
		return Logout;
	}

	//business libraries
	public void clickOnApartmentTab() {
		ApartReg.click();
	}
	
	public void logoutAsUser() {
		Logout.click();
	}
	

}
