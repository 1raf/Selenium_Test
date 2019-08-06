package com.helpsystems.imdb.uitest.authentication;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {

	static WebDriver webDriver;

	@Before
	public void setUp() {
		// Telling the system where to find the chrome driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverC.exe");

		// Open the Chrome browser
		webDriver = new ChromeDriver();

		// Maximize the browser window
		webDriver.manage().window().maximize();

		webDriver.get("https://imdb.com");
	}

	@Test
	public void testBody() throws InterruptedException {

		// click to sign in
		webDriver.findElement(By.cssSelector("span.signin-imdb-text")).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#signin-options")));

		// click on "Sign in with IMDb" button
		webDriver.findElement(By.xpath("//span[@class='auth-provider-text' and text()='Sign in with IMDb']")).click();

		WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signInSubmit")));

		WebElement emailInput = webDriver.findElement(By.id("ap_email"));
		WebElement passwordInput = webDriver.findElement(By.id("ap_password"));

		emailInput.sendKeys("goldentests1@gmail.com");
		passwordInput.sendKeys("As123456");
		signInButton.click();

		WebElement userMenu = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//ul[@id='consumer_user_nav' and contains(text(), Gevorg)]")));
		Actions action = new Actions(webDriver);
		action.moveToElement(userMenu).perform();
		TimeUnit.SECONDS.sleep(1);
		webDriver.findElement(By.id("nblogout")).click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='user-profile' and contains(text(), goldentests)]")));
	}

	@After
	public void tearDown() {
		webDriver.quit();

	}

}
