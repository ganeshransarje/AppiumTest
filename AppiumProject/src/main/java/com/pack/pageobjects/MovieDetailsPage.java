package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.pack.utilities.Utility;

public class MovieDetailsPage extends Utility {
	private static final By bookBtnId = By.id("com.bt.bms:id/book_bt");
	private static final By releaseDateTextId = By
			.id("com.bt.bms:id/release_date");
	private static final By runTimeTextId = By.id("com.bt.bms:id/runtime");
	private static final By directorTextId = By.id("com.bt.bms:id/director");
	private static final By genreTextId = By.id("com.bt.bms:id/genre");
	private static final By languageTextId = By.id("com.bt.bms:id/language");
	private static final By castTextId = By.id("com.bt.bms:id/cast");
	
	public static void verifyMovieDetailsPage() {
		assertEquals(driver.findElement(bookBtnId).getText(), "BOOK");
		assertEquals(driver.findElement(releaseDateTextId).getText(),
				"RELEASE DATE");
		assertEquals(driver.findElement(runTimeTextId).getText(), "RUN TIME");
		assertEquals(driver.findElement(directorTextId).getText(), "DIRECTOR");
		assertEquals(driver.findElement(genreTextId).getText(), "GENRE");
		assertEquals(driver.findElement(languageTextId).getText(), "LANGUAGE");
		assertEquals(driver.findElement(castTextId).getText(), "CAST");
	}

	public static void clickBookBtn() {
		clickOnElement(bookBtnId);
		waitForElement(PickVenuePage.titleId);
	}
}