package com.testPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		try {
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		}
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Thread.sleep(1000);
		catch (Exception e) {
			System.out.println("Add not found");
		}
		WebElement close = driver
				.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("a[@id='webklipper-publisher-widget-container-notification-close-div']")));
		close.click();
//		String parent = driver.getWindowHandle();
//		driver.switchTo().window(parent);
//		act.doubleClick().perform();
		Thread.sleep(3000);
		act.moveByOffset(0, 80).click().perform();
		Thread.sleep(3000);

		// click on From city
		driver.findElement(By.cssSelector("input[id='fromCity']")).click();

		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		
		
		// click on to city
		driver.findElement(By.cssSelector("input[id='toCity']")).click();

		// clicking on Departure date
		driver.findElement(By.xpath("//p[@class='blackText font20 code lineHeight36']")).click();

		// Selecting departure date
		driver.findElement(
				By.xpath("//div[.='October 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='10']"))
				.click();

		// clicking on return date
		driver.findElement(By.xpath("//p[.='Tap to add a return date for bigger discounts']")).click();

		// selecting return date
		driver.findElement(By.xpath(
				"(//div[@class='DayPicker-Caption'])[2]/ancestor::div[@class='DayPicker-Month']/descendant::p[.='7']"))
				.click();
		// clicking on done
		driver.findElement(By.xpath("//span[@data-cy='travellerText']")).click();

		//selecting no of adults
		driver.findElement(
				By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/descendant::li[@data-cy='adults-2']"))
				.click();
		
		//clicking on apply
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
	}
}
