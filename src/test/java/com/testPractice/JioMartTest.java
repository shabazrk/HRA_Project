package com.testPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement groceries = driver.findElement(By.xpath("//a[@class='header-nav-l1-item-link' and .='Groceries']"));
		Actions act = new Actions(driver);
		act.moveToElement(groceries).perform();
		act.moveToElement(driver.findElement(By.xpath("//a[.='Fruits & Vegetables']"))).perform();
		List<WebElement> listOfFruitsAndVeg = driver.findElements(By.xpath("//a[.='Fresh Vegetables']/ancestor::ul[@class='header-nav-l3 custom-scrollbar']/li/a"));
		for (WebElement item : listOfFruitsAndVeg) {
			System.out.println(item.getText());
		}
	}
}
