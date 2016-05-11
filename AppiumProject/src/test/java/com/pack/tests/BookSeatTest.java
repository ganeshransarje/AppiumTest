package com.pack.tests;

import org.testng.annotations.Test;

import com.pack.pageobjects.HomePage;
import com.pack.pageobjects.HowManyTicketsPage;
import com.pack.pageobjects.MainTabPage;
import com.pack.pageobjects.MovieDetailsPage;
import com.pack.pageobjects.MoviesPage;
import com.pack.pageobjects.PickSeatsPage;
import com.pack.pageobjects.PickVenuePage;
import com.pack.pageobjects.ShowTimesPage;
import com.pack.pageobjects.TicketsPage;
import com.pack.utilities.Utility;

public class BookSeatTest extends Utility {
	@Test
	public void testBookSeat() throws InterruptedException {
		HomePage.verifyHomePage();
		HomePage.clickIwillSkipBtn();
		MainTabPage.verifyMainTabs();
		MainTabPage.clickYouTab();
		MainTabPage.clickTicketsTab();
		TicketsPage.verifyTicketsPage();
		TicketsPage.verifyLocation();
		TicketsPage.clickMoviesMenu();
		MoviesPage.verifyMoviesPage();
		if (MoviesPage.searchForMovie()) {
			MovieDetailsPage.verifyMovieDetailsPage();
			MovieDetailsPage.clickBookBtn();
			PickVenuePage.verifyPickVenuePage();
			if (PickVenuePage.searchForVenue()) {
				ShowTimesPage.verifyShowTimesPage();
				if (ShowTimesPage.selectShowTime()) {
					if (ShowTimesPage.selectSeatCategory()) {
						HowManyTicketsPage.verifyHowManyTicketsPage();
						if (HowManyTicketsPage.selectSeatsQuantity()) {
							PickSeatsPage.verifyPickSeatsPage();
							PickSeatsPage.selectSeats();
						}
					}
				}
			}
		}
	}
}