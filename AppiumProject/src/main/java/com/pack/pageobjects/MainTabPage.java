package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.pack.utilities.Utility;

public class MainTabPage extends Utility {
	public final static By showcaseTabXpath = By
			.xpath("//android.widget.TextView[@text='SHOWCASE']");
	private final static By ticketsTabXpath = By
			.xpath("//android.widget.TextView[@text='TICKETS']");
	private final static By youTabXpath = By
			.xpath("//android.widget.TextView[@text='YOU']");
	private final static By discoverTabXpath = By
			.xpath("//android.widget.TextView[@text='DISCOVER']");

	public static void verifyMainTabs() {
		assertEquals(driver.findElement(showcaseTabXpath).getText(), "SHOWCASE");
		assertEquals(driver.findElement(ticketsTabXpath).getText(), "TICKETS");
		assertEquals(driver.findElement(youTabXpath).getText(), "YOU");
		assertEquals(driver.findElement(discoverTabXpath).getText(), "DISCOVER");
	}

	public static void clickTicketsTab() {
		clickOnElement(ticketsTabXpath);
		waitForElement(TicketsPage.allMenuXpath);
	}

	public static void clickYouTab() {
		clickOnElement(youTabXpath);
		waitForElement(YouPage.saveYourCreditCardsTextId);
	}

	public static void clickYouTabAfterLogin() {
		clickOnElement(youTabXpath);
		waitForElement(YouPage.myWalletTextId);
	}
}