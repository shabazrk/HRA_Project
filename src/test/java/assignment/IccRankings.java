package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccRankings {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	System.out.println(driver.findElement(By.xpath("//td[@class='rankings-block__banner--rating u-text-right']")).getText());
}
}
