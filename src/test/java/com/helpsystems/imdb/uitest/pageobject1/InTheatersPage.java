package com.helpsystems.imdb.uitest.pageobject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InTheatersPage extends BaseClassPage {

	// WebElements
	@FindBy(id = "navTitleMenu")
	private WebElement navMenu;

	@FindBy(xpath = "//div[@class='subNavListContainer']//a[contains(text(), \"In Thea\")]")
	private WebElement inTheatres;

	@FindBy(xpath = "//div[@class='list detail sub-list'][1]//div[@class='list_item odd'][1]//h4//a[1]")
	private WebElement firstShow;

	@FindBy(xpath = "//div[@class='list detail sub-list'][1]//div[@class='list_item odd'][1]//span[contains(text(), 'Add to Watchlist')]")
	private WebElement addWatchlistFirstShow;

	// Constructors
	public InTheatersPage() {

	}

	public InTheatersPage(Actions action, WebDriver driver) {
		this.webDriver = driver;
	}

	// ######## -- Methods for In Theater page -- #############
	/**
	 * Method to navigate to the In Theater page from main page
	 * 
	 * @param action
	 */
	public void goInTheater(Actions action) {
		waitForVisibilityOfElement(navMenu);
		action.moveToElement(navMenu).build().perform();
		waitForVisibilityOfElement(inTheatres);
		inTheatres.click();
	}

	/**
	 * Method to get first show's name from the page
	 * 
	 * @return the title of the first show on the page
	 */
	public String getFirstShowTitle() {
		waitForVisibilityOfElement(firstShow);
		String firstShowTitle = firstShow.getText();
		System.out.println("First show's title is: " + firstShowTitle);
		return firstShowTitle.substring(0, firstShowTitle.length() - 7);
	}

	/**
	 * Method to click on Add Whatchlist button for the first show in the list
	 */
	public void clickOnAddWatchListButtonFirstShow() {
		waitForVisibilityOfElement(addWatchlistFirstShow);
		addWatchlistFirstShow.click();
	}

}
