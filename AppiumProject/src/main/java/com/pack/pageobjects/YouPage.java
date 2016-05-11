package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.pack.utilities.Utility;

public class YouPage extends Utility {
	public final static By saveYourCreditCardsTextId = By
			.id("com.bt.bms:id/saveHeaderTv");
	private final static By saveMessageTextId = By
			.id("com.bt.bms:id/saveMessageTv");
	private final static By saveYourDetailsTextId = By
			.id("com.bt.bms:id/saveDetailTv");
	private final static By saveDetailMessageTextId = By
			.id("com.bt.bms:id/saveDeatailMessageTv");
	private final static By loginBtnId = By.id("com.bt.bms:id/login_bt");
	public final static By userNameTextId = By.id("com.bt.bms:id/user_name");
	public final static By myWalletTextId = By.id("com.bt.bms:id/wallet_tv");
	private final static By referMyFriendTextId = By
			.id("com.bt.bms:id/tvReferral");
	private final static By favVenueTextId = By
			.id("com.bt.bms:id/fav_venue_tv");
	private final static By settingsBtnId = By.id("com.bt.bms:id/action_icon");
	private static final String FIRSTNAME = prop.getProperty("firstname");
	private static final String LASTNAME = prop.getProperty("lastname");
	
	public static void verifyYouPage() {
		assertEquals(driver.findElement(saveYourCreditCardsTextId).getText(),
				"Save your credit cards");
		assertEquals(driver.findElement(saveMessageTextId).getText(),
				"Save your payment methods for faster checkouts.");
		assertEquals(driver.findElement(saveYourDetailsTextId).getText(),
				"Save your Details");
		assertEquals(driver.findElement(saveDetailMessageTextId).getText(),
				"Login and you won't have to enter your details everytime!");
		assertEquals(driver.findElement(loginBtnId).getText(), "Login");
	}

	public static void clickLoginBtn() {
		clickOnElement(loginBtnId);
		waitForElement(LoginPage.titleTextId);
	}

	public static void verifyYouPageAfetrLogin() {
		assertEquals(driver.findElement(userNameTextId).getText(),
				FIRSTNAME.toUpperCase()+" "+ LASTNAME.toUpperCase());
		assertEquals(driver.findElement(myWalletTextId).getText(),
				"MyWallet new");
		assertEquals(driver.findElement(referMyFriendTextId).getText(),
				"ReferMyFriend new");
		assertEquals(driver.findElement(favVenueTextId).getText(),
				"Favorite Venues");
	}

	public static void logout() {
		clickOnElement(settingsBtnId);
		waitForElement(SettingsPage.titleTextId);
		SettingsPage.clickLogoutText();
		waitForElement(LogoutPopupPage.titleTextId);
		LogoutPopupPage.verifyLogoutPopup();
		LogoutPopupPage.clickYesBtn();
		waitForElement(saveYourCreditCardsTextId);
	}
}