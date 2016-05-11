package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.pack.utilities.Utility;

public class UnableToIdentifyLocationPopup extends Utility {
	private static final By popupClass = By.className("android.widget.LinearLayout");
	public static final By loactionPopupTitleId = By.id("com.bt.bms:id/title");
	private static final By loactionPopupMessageId = By
			.id("com.bt.bms:id/message");
	private static final By loactionPopupDismissBtnId = By
			.id("com.bt.bms:id/dismiss");

	public static void verifyPopupElements() {
		assertEquals(driver.findElement(loactionPopupTitleId).getText(),
				"Oops!");
		assertEquals(
				driver.findElement(loactionPopupMessageId).getText(),
				"We are not able to identify your location.Please choose your city from the list.");
		assertEquals(driver.findElement(loactionPopupDismissBtnId).getText(),
				"DISMISS");
	}

	public static void clickDismissBtn() {
		clickOnElement(loactionPopupDismissBtnId);
		waitForElement(PickRegionPage.pickRegionTitleId);
	}
	
	public static Boolean getIsPopupVisible(){
		return driver.findElement(popupClass).isDisplayed();
	}
}