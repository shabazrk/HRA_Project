package com.HRA.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterRoomPage {

	@FindBy (xpath = "//input[@name='fullname']")
	private WebElement Fullname;
	
	@FindBy (xpath = "//input[@name='mobile']")
	private WebElement Mobile;
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement Email;
	
	@FindBy (xpath = "//input[@id='country']")
	private WebElement Country;
	
	@FindBy (xpath = "//input[@id='state']")
	private WebElement State;
	
	@FindBy (xpath = "//input[@id='plot_number']")
	private WebElement PlotNumber;
	
	@FindBy (xpath = "//input[@name='image']")
	private WebElement Image;
	
	@FindBy (xpath = "//input[@id='rooms']")
	private WebElement AvailableRooms;
	
	@FindBy (xpath = "//input[@id='deposit']")
	private WebElement Deposit;
	
	@FindBy (xpath = "//input[@id='rent']")
	private WebElement Rent;
	
	@FindBy (xpath = "input[@id='city']")
	private WebElement City;
	
	@FindBy (xpath = "//input[@id='address']")
	private WebElement Address;
	
	@FindBy(xpath = "//button[@name='register_individuals']")
	private WebElement Submit;

	//getters
	public WebElement getFullname() {
		return Fullname;
	}

	public WebElement getMobile() {
		return Mobile;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getState() {
		return State;
	}

	public WebElement getPlotNumber() {
		return PlotNumber;
	}

	public WebElement getImage() {
		return Image;
	}

	public WebElement getAvailableRooms() {
		return AvailableRooms;
	}

	public WebElement getDeposit() {
		return Deposit;
	}

	public WebElement getRent() {
		return Rent;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getAddress() {
		return Address;
	}

	public WebElement getSubmit() {
		return Submit;
	}
	
	//Business Libraries
	
	
}
