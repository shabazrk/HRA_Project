package com.testPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboCalenderTest {

	public static void main(String[] args) {
		String month = "November";
		int date = 12;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-12foipm-18 inSbbt fswWidgetTitle']")).click();
//	driver.findElement(By.xpath("//div[.='"+month+" 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[.='" + month
						+ " 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='" + date + "']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}

		}
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.cssSelector("a[class='sc-12foipm-77 hhOMGd']")).click();
	}
}
