package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccMatches {

	public static void main(String[] args) {		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/odi");

		List<WebElement> matches = driver.findElements(By.xpath(
				"//span[@class='u-hide-phablet']/../following-sibling::td[@class='table-body__cell u-center-text' and text()<40 or @class='rankings-block__banner--matches' and text()<40]"));
		List<WebElement> pos=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		for (WebElement team : matches) {
			System.out.println(team.getText());
			driver.findElements(By.xpath("//tbody/child::tr"));
			
		}
		for (WebElement country : pos) {
			System.out.println(driver.findElement(By.xpath("//td[.='"+country.getText()+"' or @class='u-hide-phablet']/..//td[2]")).getText());
		}
		
	}
}
