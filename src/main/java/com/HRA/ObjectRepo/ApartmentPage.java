package com.HRA.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentPage {

	public ApartmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='apartment_name']")
	private WebElement ApartmentName;
	
	@FindBy(xpath = "(//input[@id='mobile'])[2]")
	private WebElement MobNum;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='alternat_mobile']")
	private WebElement AltMobNum;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='email']")
	private WebElement Email;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='plot_number']")
	private WebElement PlotNum;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='country']")
	private WebElement Country;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='state']")
	private WebElement State;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='city']")
	private WebElement City;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='landmark']")
	private WebElement Landmark;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='address']")
	private WebElement Address;

	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//input[@id='image']")
	private WebElement Image;
	
	@FindBy(xpath = "//h2[.='Apartment Room']/parent::div//button[.='Submit']")
	private WebElement Submit;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement Logout;
	
	//getters
	public WebElement getApartmentName() {
		return ApartmentName;
	}

	public WebElement getMobNum() {
		return MobNum;
	}

	public WebElement getAltMobNum() {
		return AltMobNum;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPlotNum() {
		return PlotNum;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getState() {
		return State;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getLandmark() {
		return Landmark;
	}

	public WebElement getAddress() {
		return Address;
	}
	
	
	
	public WebElement getImage() {
		return Image;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	//business libraries
	public void readValuesExcel(WebDriver driver,HashMap<String, String> map) {
		for (Entry<String, String> s : map.entrySet()) {
			 {
				driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
			}
	}
	}
	
	public void clickOnSubmit() {
		Submit.click();
	}
	
	public void logout() {
		Logout.click();
	}
}
