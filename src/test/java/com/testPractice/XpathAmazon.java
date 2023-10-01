package com.testPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAmazon {

	public static void main(String[] args) {
		String phone = "Apple iPhone 14 Plus (128 GB) - Blue";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.amazon.in/");
//		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14");
//		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.get("https://www.icc-cricket.com/rankings/mens/rankings-predictor/test");
		driver.findElement(By.xpath("//div[.='Accept']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@data-match-id='102968']/div[@data-team-id='14']//a[@class='btn up']"))));
		driver.findElement(By.xpath("//div[@data-match-id='102968']/div[@data-team-id='14']//a[@class='btn up']"))
				.click();
		driver.findElement(By.xpath("//div[@data-match-id='102968']/div[@data-team-id='11']//a[@class='btn up']"))
		.click();
	}
}