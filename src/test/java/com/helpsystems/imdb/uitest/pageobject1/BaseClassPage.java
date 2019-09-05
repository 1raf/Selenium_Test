package com.helpsystems.imdb.uitest.pageobject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassPage {
	static WebDriver webDriver;
	
	/**
	 * Method to wait for visibility of element
	 * 
	 * @param element
	 */
	protected void waitForVisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
