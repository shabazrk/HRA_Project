package com.testPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EmiCalculator {

	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions act = new Actions(driver);
		WebElement p = driver.findElement(By.xpath("//*[@class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker']//*[@class='highcharts-point'][2]"));
		Actions a = new Actions(driver);
		a.moveToElement(p).perform();
		List<WebElement> allPoints = driver.findElements(By.xpath("//*[@class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker highcharts-series-hover']//*[contains(@class,'highcharts-point')]"));
		for (WebElement point : allPoints) {

			act.moveToElement(point).perform();
			
			String text=driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']")).getText();
		System.out.println(text);
		}
	}
}
