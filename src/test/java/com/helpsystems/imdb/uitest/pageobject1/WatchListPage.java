
package com.helpsystems.imdb.uitest.pageobject1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WatchListPage extends BaseClassPage {

	public WatchListPage(WebDriver driver) {
		this.webDriver = driver;
	}

	@FindBy(xpath = "//p[@class= 'navCategory singleLine watchlist']//a")
	private WebElement watchlist;

	@FindBy(xpath = "//h3[@class = 'lister-item-header']/a")
	List<WebElement> watchlistShowsTitle;

	/**
	 * Method to navigate to the Whatchlist page
	 */
	public void goWatchList() {
		waitForVisibilityOfElement(watchlist);
		watchlist.click();
	}

	/**
	 * Method to validate show in Whatchlist by title
	 * 
	 * @param expectedShow
	 */
	public void validateShowInWhatchList(String expectedShow) {
		boolean isShowInWatchlist = isShowInWhatchlist(expectedShow);
		Assert.assertTrue("Show '" + expectedShow + "' doesn't exist in Whatchlist! :( ", isShowInWatchlist);
	}

	public void clickOnShowTitle(String showTitle) {
		webDriver.findElement(By.xpath("//h3//a[contains(text(), '" + showTitle + "')]")).click();
	}

	/**
	 * Method to check is Show in whatchlist or not
	 * 
	 * @param expectedShowTitle
	 * @return true - if show is in the whatchlist, false - if not
	 */
	private boolean isShowInWhatchlist(String expectedShowTitle) {
		boolean isShowInWhatchlist = false;
		List<String> showsTitleList = getWatchlistShowsTitle();
		for (String title : showsTitleList) {
			if (title.contains(expectedShowTitle)) {
				isShowInWhatchlist = true;
			} else {
				isShowInWhatchlist = false;
			}
		}

		return isShowInWhatchlist;

	}

	/**
	 * Method to get all shows' titles from page whatchlist
	 * 
	 * @return
	 */
	private List<String> getWatchlistShowsTitle() {
		List<String> showsTitleList = new ArrayList<String>();
		for (WebElement watchlistShowTitle : watchlistShowsTitle) {
			showsTitleList.add(watchlistShowTitle.getText());
		}
		return showsTitleList;
	}
}
