package com.HRA.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class IndividualPage extends WebDriverUtility{

	public IndividualPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='vacant']")
	private WebElement Dropdown;
	
	@FindBy(xpath = "//button[@name='register_individuals']")
	private WebElement SubmitBtn;
	
	
	//getters
	public WebElement getDropdown() {
		return Dropdown;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}



	//business libraries
	public void fillDetails(WebDriver driver,HashMap<String, String> map,String visibleText) {
		
		
		for (Entry<String, String> s : map.entrySet()) {
			 {
				driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
			}
			selectDropdown(visibleText, Dropdown);
	}
}
	public void clickOnSubmit() {
		SubmitBtn.click();
	}
}
