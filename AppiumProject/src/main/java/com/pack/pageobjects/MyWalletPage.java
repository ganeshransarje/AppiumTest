package com.pack.pageobjects;

import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import com.pack.utilities.Utility;

public class MyWalletPage extends Utility{
	private final static By titleTextId = By.id("com.bt.bms:id/txvTitle");
	private final static By introducingMyWalletTextId = By.id("com.bt.bms:id/textoffer");
	private final static By pleaseVerifyYourMobileNoTextId = By.id("com.bt.bms:id/textThanks");
	private final static By firstNameLblId = By.id("com.bt.bms:id/fnameLabel");
	private final static By firstNameTbId = By.id("com.bt.bms:id/editFName");
	private final static By lastNameLblId = By.id("com.bt.bms:id/lnameLabel");
	private final static By lastNameTbId = By.id("com.bt.bms:id/editLName");
	private final static By mobileNoLblId = By.id("com.bt.bms:id/mobileLabel");
	private final static By mobileNoTbId = By.id("com.bt.bms:id/etMobileNo");
	private final static By veriftBtnId = By.id("com.bt.bms:id/textVerify");
	
	public static void verifyMyWalletPage(){
		assertEquals(driver.findElement(titleTextId).getText(), "MyWallet");
		assertEquals(driver.findElement(introducingMyWalletTextId).getText(), "Introducing MyWallet");
		assertEquals(driver.findElement(pleaseVerifyYourMobileNoTextId).getText(), "Please verify your mobile number.");
		assertEquals(driver.findElement(firstNameLblId).getText(), "First Name");
		assertEquals(driver.findElement(firstNameTbId).getText(), "ganesh");
		assertEquals(driver.findElement(lastNameLblId).getText(), "Last Name");
		assertEquals(driver.findElement(lastNameTbId).getText(), "r");
		assertEquals(driver.findElement(mobileNoLblId).getText(), "Mobile number");
		assertEquals(driver.findElement(mobileNoTbId).getText(), "9960932313");
		assertEquals(driver.findElement(veriftBtnId).getText(), "VERIFY");
	}
}