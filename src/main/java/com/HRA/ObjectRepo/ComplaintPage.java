package com.HRA.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplaintPage {

	public ComplaintPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
