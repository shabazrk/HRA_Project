package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This method is used maximize the browser
	 * 
	 * @param driver
	 * @param duration
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used minimize the browser
	 * 
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait until the elements in the page are loaded
	 * 
	 * @param driver
	 * @param duration
	 */
	public void implicitlyWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	/**
	 * This method will wait until the url of the page is loaded
	 * 
	 * @param driver
	 * @param duration
	 * @param expectedUrl
	 */
	public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}

	/**
	 * This method will wait until the title of the page is loaded
	 * 
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTitleLoads(WebDriver driver, int duration, String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}

	/**
	 * This method will wait until the element is clickable
	 * 
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementIsClickable(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will ignore NoSuchElementException and continues with execution
	 * 
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}

	/**
	 * This method will wait until the element is visible in the page
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element, int duration) throws InterruptedException {
		int count = 0;
		while (count < duration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method will select a dropdown element based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will select a dropdown element based on value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method will select a dropdown element based on visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void selectDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will move the cursor to the specifies element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to right click on a element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
		;
	}

	/**
	 * This method will double click on an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to press enter key
	 * 
	 * @throws AWTException
	 */
	public void enterKey() throws AWTException {

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used to release enter key
	 * 
	 * @throws AWTException
	 */
	public void enterKeyRelease() throws AWTException {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used to click on enter button
	 * 
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method used to switch from one frame to another using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method used to switch from one frame to another using frame id
	 * 
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * This method is used to switch to main frame
	 * 
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to accept qlert
	 * 
	 * @param driver
	 * @param expectedMsg
	 */
	public void acceptAlertPopup(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		if (alt.getText().equalsIgnoreCase(expectedMsg)) {
			System.out.println("alert msg is verified");
		} else {
			System.out.println("alert msg is not verified");
		}
		alt.accept();
	}

	public void dismissAlertPopup(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		if (alt.getText().equalsIgnoreCase(expectedMsg)) {
			System.out.println("alert msg is verified");
		} else {
			System.out.println("alert msg is not verified");
		}
		alt.dismiss();
	}

	/**
	 * This method is used switch from one window to another window based on title
	 * 
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver, String expectedTitle) {
		Set<String> wins = driver.getWindowHandles();
		for (String win : wins) {
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(expectedTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used switch from one window to another window based on url
	 * 
	 * @param driver
	 * @param expectedUrl
	 */
	public void switchWindowBasedOnUrl(WebDriver driver, String expectedUrl) {
		Set<String> titles = driver.getWindowHandles();
		Iterator<String> it = titles.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if (url.contains(expectedUrl)) {
				break;
			}
		}
	}

	/**
	 * This method takes screenshot of page and stores it a folder
	 * 
	 * @param driver
	 * @param screenshotname
	 * @return
	 */
	public static String takeScreenShot(WebDriver driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/" + screenshotname + ".png");
		try {
			Files.copy(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "./Screenshot/" + screenshotname + ".png";
	}

	public static String takeScreenShotOfElement(WebElement element, String screenshotname) {

		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/" + screenshotname + ".png");
		try {
			Files.copy(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "./Screenshot/" + screenshotname + ".png";
	}

	/**
	 * This method is used to scroll to a particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);

	}

	public void scrollBarAction(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}

	public void scrollAction(WebDriver driver, WebElement element) {

	}

	public void closeTheBrowser(WebDriver driver) {
		driver.quit();

	}
}
