package com.testPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeamRankings {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr/td[2]//span[@class='u-hide-phablet']"));
		for (WebElement we : teams) {
			String teamNames = we.getText();
			if (teamNames.equalsIgnoreCase("Scotland"))
				System.out.println("scotland is present");

		}
	}
}
