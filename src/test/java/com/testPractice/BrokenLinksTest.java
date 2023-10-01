package com.testPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opts= new ChromeOptions();
		opts.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total links are : "+links.size());
		
		ArrayList<String> allLinks = new ArrayList<String>();
		 int countWorking = 0;
		 int countNotWorking=0;
		for (int i = 0; i < links.size(); i++) {
			String eachLink = links.get(i).getAttribute("href");
			
			URL url = null;
			int statuscode = 0;
			
			try {
				url = new URL(eachLink);
				HttpsURLConnection httpconn = (HttpsURLConnection)url.openConnection();
				
				statuscode = httpconn.getResponseCode();
				
				if(statuscode>400)
					countNotWorking++;
					allLinks.add(eachLink);
					System.out.println("Not working links are"+eachLink);
				
			} catch (Exception e) {
				countWorking++;
				allLinks.add(eachLink);
				System.out.println("Working links are :"+eachLink);
			}
		}
		System.out.println("count of not working websites is "+countNotWorking);
		System.out.println("count of working websites is "+countWorking);
	}
}
