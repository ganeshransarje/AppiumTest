package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.pack.utilities.Utility;

public class LogoutPopupPage extends Utility {
	public final static By titleTextId = By.id("com.bt.bms:id/title");
	private final static By messageTextId = By.id("com.bt.bms:id/message");
	private final static By noBtnId = By.id("com.bt.bms:id/no_bt");
	private final static By yesBtnId = By.id("com.bt.bms:id/yes_bt");

	public static void verifyLogoutPopup() {
		assertEquals(driver.findElement(titleTextId).getText(), "Logout");
		assertEquals(driver.findElement(messageTextId).getText(),
				"Are you sure you want to logout?");
		assertEquals(driver.findElement(noBtnId).getText(), "No");
		assertEquals(driver.findElement(yesBtnId).getText(), "Yes");
	}

	public static void clickYesBtn() {
		clickOnElement(yesBtnId);
	}
}