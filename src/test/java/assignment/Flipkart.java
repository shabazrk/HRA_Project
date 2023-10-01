package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("phones");
		driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
		driver.findElement(By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']")).click();
		System.out.println("Phone is "+driver.findElement(By.xpath("//div[.='APPLE iPhone 13 (Midnight, 128 GB)']")).getText());
		System.out.println("Rating is "+driver.findElement(By.xpath("//div[.='APPLE iPhone 13 (Midnight, 128 GB)']/parent::div//div[@class='_3LWZlK']")).getText());
		System.out.println("Price is "+driver.findElement(By.xpath("//div[.='APPLE iPhone 13 (Midnight, 128 GB)']/ancestor::div[@class='_3pLy-c row']//div[.='₹52,499']")).getText());
	}
}
