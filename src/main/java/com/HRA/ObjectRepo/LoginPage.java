package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@id='exampleInputEmail1']")
	private WebElement Username_Email;
	
	@FindBy (xpath = "//input[@id='exampleInputPassword1']")
	private WebElement Password;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	private WebElement Submit;

	public WebElement getUsername_Email() {
		return Username_Email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSubmit() {
		return Submit;
	}
	
	//Business Libraries
	public void login(String username,String pass) {
		Username_Email.sendKeys(username);
		Password.sendKeys(pass);
		Submit.click();
	}
}
