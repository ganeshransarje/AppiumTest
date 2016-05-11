package com.pack.pageobjects;

import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import com.pack.utilities.Utility;

public class SettingsPage extends Utility{
	public final static By titleTextId = By.id("com.bt.bms:id/txvTitle");
	private final static By logoutTextId = By.id("com.bt.bms:id/action_text");
	
	public static void verifySettingsPage(){
		assertEquals(driver.findElement(titleTextId).getText(), "SETTINGS");
		assertEquals(driver.findElement(logoutTextId).getText(), "LOGOUT");
	}
	
	public static void clickLogoutText(){
		clickOnElement(logoutTextId);
	}
}