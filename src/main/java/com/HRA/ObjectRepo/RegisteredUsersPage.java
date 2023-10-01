package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUsersPage {

	public RegisteredUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//h2[.='List Of Usres']")
	private WebElement ListUsers;

	public WebElement getListUsers() {
		return ListUsers;
	}
	
	
}
