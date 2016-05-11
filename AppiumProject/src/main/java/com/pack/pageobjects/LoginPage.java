package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.pack.utilities.Utility;

public class LoginPage extends Utility {
	public final static By titleTextId = By.id("com.bt.bms:id/txvTitle");
	private final static By whyTextId = By.id("com.bt.bms:id/action_text");
	private final static By loginWithFacebookTextId = By
			.id("com.bt.bms:id/loginfb");
	private final static By loginWithGoogleTextId = By
			.id("com.bt.bms:id/logingoogle");
	private final static By orTextId = By.id("com.bt.bms:id/or");
	private final static By emailAddressTbId = By.id("com.bt.bms:id/edtemail");
	private final static By passwordTbId = By.id("com.bt.bms:id/edtpass");
	private final static By signInBtnId = By.id("com.bt.bms:id/signin");
	private final static By forgotPasswordLinkId = By
			.id("com.bt.bms:id/forgotpwd");
	private final static By signUpLinkId = By.id("com.bt.bms:id/signup");
	private static final String USERNAME = prop.getProperty("username");
	private static final String PASSWORD = prop.getProperty("password");

	public static void verifyLoginPage() {
		assertEquals(driver.findElement(titleTextId).getText(), "LOGIN");
		assertEquals(driver.findElement(whyTextId).getText(), "why?");
		assertEquals(driver.findElement(loginWithFacebookTextId).getText(),
				"Login with Facebook");
		assertEquals(driver.findElement(loginWithGoogleTextId).getText(),
				"Sign in with Google");
		assertEquals(driver.findElement(orTextId).getText(), "OR");
		assertEquals(driver.findElement(emailAddressTbId).getText(),
				"Email Address");
		assertEquals(driver.findElement(forgotPasswordLinkId).getText(),
				"Forgot password?");
	}

	public static void clickSignUpLink() {
		clickOnElement(signUpLinkId);
		waitForElement(SignUpPage.titleTextId);
	}

	public static void loginWithValidCredential() {
		sendKeys(emailAddressTbId, USERNAME);
		sendKeys(passwordTbId, PASSWORD);
		clickOnElement(signInBtnId);
		try {
			if (UnableToIdentifyLocationPopup.getIsPopupVisible()) {
				handleRegionPage();
			}
		} catch (NoSuchElementException e) {
		}
		waitForElement(MainTabPage.showcaseTabXpath);
	}
	
	public static void handleRegionPage(){
		UnableToIdentifyLocationPopup.verifyPopupElements();
		UnableToIdentifyLocationPopup.clickDismissBtn();
		PickRegionPage.veerifyPickRegionPage();
		PickRegionPage.selectRegion();
	}
}