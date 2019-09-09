package com.helpsystems.imdb.uitest.pageobject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingInPage extends BaseClassPage{

	public SingInPage(WebDriver driver) {
		this.webDriver = driver;
	}

	@FindBy(css = "span.signin-imdb-text")
	private WebElement singInButton;
	

	@FindBy(css = "div#signin-options")
	private WebElement singInOptions;
	
	@FindBy(xpath = "//span[@class='auth-provider-text' and text()='Sign in with IMDb']")
	private WebElement signInWithIMDb;
	
	@FindBy(id = "signInSubmit")
	private WebElement singInSubmit;
	
	@FindBy(id = "ap_email")
	private WebElement emailInput;
	
	@FindBy(id = "ap_password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//ul[@id='consumer_user_nav' and contains(text(), Gevorg)]")
	private WebElement userNameGevorg;
	
	public void singIn() {
		// click to sign in
		singInButton.click();
		waitForVisibilityOfElement(singInOptions);
		// click on "Sign in with IMDb" button
		signInWithIMDb.click();
		waitForVisibilityOfElement(singInSubmit);
		emailInput.sendKeys("goldentests1@gmail.com");
		passwordInput.sendKeys("As123456");
		singInSubmit.click();
		waitForVisibilityOfElement(userNameGevorg);
	}
		
}
