package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJet {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa' and .='round trip']"))
				.click();

		driver.findElement(
				By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2' and .='From']"))
				.click();
		// selecting bengaluru as from city
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and .='Bengaluru']"))
				.click();

		// selecting chennai as destination
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and .='Chennai']")).click();

		// selecting 9 sep 2023 as departure date
		driver.findElement(By.xpath(
				"//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(.,'September 2023')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41' and .='11']"))
				.click();
		// selecting 2nd october as return date
		driver.findElement(By.xpath(
				"//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(.,'October 2023')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[.='2']"))
				.click();

		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		WebElement noOfAdults = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
		for (int i = 1; i < 5; i++) {
			noOfAdults.click();
		}

		driver.findElement(By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e' and .='Currency']"))
				.click();

		driver.findElement(By.xpath("//div[.='USD']")).click();
	}
}
