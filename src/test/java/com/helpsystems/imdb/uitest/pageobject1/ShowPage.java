package com.helpsystems.imdb.uitest.pageobject1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowPage extends BaseClassPage {

	@FindBy(xpath = "//div[@class='wlb-title-main-details']//div[@title='Click to remove from watchlist']")
	private WebElement removeFromWatchlist;

	/**
	 * Method to click on "Add to whatchlist" button (when show already added in the
	 * list) to remove from list
	 */
	public void clickToRemoveFromWhatchlist() {
		waitForVisibilityOfElement(removeFromWatchlist);
		removeFromWatchlist.click();
	}

}
