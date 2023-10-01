package com.Register_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRM_AutomateTest {

	public static void main(String[] args) throws Throwable {
		Random random = new Random();
		int ranNum = random.nextInt(50);
		int ranEmail = random.nextInt(500);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
		// click on Register new User
		driver.findElement(By.xpath("//a[@class='nav-link' and .='Register']")).click();
		driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Andy");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Andy" + ranNum);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("99887766" + ranNum);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("andy" + ranEmail + "@gmail.com");
		String password = "pass" + ranNum;
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='c_password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		String statement = driver.findElement(
				By.xpath("//div[@class='alert alert-info']/div[.='Registration successfull. Now you can login']")).getText();
		if(statement.contains("Registration successfull. Now you can login")) 
			System.out.println("Registration succesfull");
		else 
			System.out.println("Registration not succesfull");
	}

}
