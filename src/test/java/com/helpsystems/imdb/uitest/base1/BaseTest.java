package com.helpsystems.imdb.uitest.base1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	protected static WebDriver webDriver;
	
	@Before
	public void setUp() {
		// Telling the system where to find the Firefox driver
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

		// Open the Firefor browser
		webDriver = new FirefoxDriver();

		// Maximize the browser window
		webDriver.manage().window().maximize();

		webDriver.get("https://imdb.com");
		
	}
	
	@After
	public void tearDown() {
		webDriver.quit();

	}
	
}
