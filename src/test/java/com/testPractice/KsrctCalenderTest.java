package com.testPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KsrctCalenderTest {

	public static void main(String[] args) {
		int date = 20;
		String month = "September";
		int year = 2023;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath(
				"//span[.='"+month+"']/following-sibling::span[.='"+year+"']/ancestor::div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/following-sibling::table//a[.='"+date+"']"))
				.click();
	}

}
