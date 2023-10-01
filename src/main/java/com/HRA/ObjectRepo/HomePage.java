package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Search")
	private WebElement Search;
	
	@FindBy(xpath =  "//a[.='Login']")
	private WebElement Login;
	
	@FindBy (linkText = "Register")
	private WebElement RegisterUser;

	public WebElement getSearch() {
		return Search;
	}

	public WebElement login() {
		return Login;
	}

	public WebElement getRegister() {
		return RegisterUser;
	}
	//business libraries
	
	public void clickOnLogin() {
		Login.click();
	}
	
}
