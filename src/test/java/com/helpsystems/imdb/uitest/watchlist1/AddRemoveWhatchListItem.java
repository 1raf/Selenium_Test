package com.helpsystems.imdb.uitest.watchlist1;

import org.junit.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.helpsystems.imdb.uitest.base1.BaseTest;
import com.helpsystems.imdb.uitest.pageobject1.InTheatersPage;
import com.helpsystems.imdb.uitest.pageobject1.ShowPage;
import com.helpsystems.imdb.uitest.pageobject1.SingInPage;
import com.helpsystems.imdb.uitest.pageobject1.WatchListPage;

public class AddRemoveWhatchListItem extends BaseTest{
	
	@Test
	public void testBody() throws InterruptedException {
		Actions action = new Actions(webDriver);
		InTheatersPage inTheater = new InTheatersPage(action, webDriver);
		PageFactory.initElements(webDriver, inTheater);
		WatchListPage watchlist = PageFactory.initElements(webDriver, WatchListPage.class);
		ShowPage showPage = PageFactory.initElements(webDriver, ShowPage.class);
		SingInPage singInPage = PageFactory.initElements(webDriver, SingInPage.class);
		
		singInPage.singIn();
		
		
		//GO to “In Theaters”
		inTheater.goInTheater(action);
		//Get the name of 1st movie
		String firstShowTitle = inTheater.getFirstShowTitle();
		//Add the 1st movie to Watchlist
		inTheater.clickOnAddWatchListButtonFirstShow();
		//Go to Watchlist
		watchlist.goWatchList();
		//Validate the movie is in the Watchlist
		watchlist.validateShowInWhatchList(firstShowTitle);
		//Go to the movie (click on it)
		watchlist.clickOnShowTitle(firstShowTitle);
		//Remove from the Watchlist	
		showPage.clickToRemoveFromWhatchlist();
		
		
	}

}
