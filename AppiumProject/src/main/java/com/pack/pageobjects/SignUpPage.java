package com.pack.pageobjects;

import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import com.pack.utilities.Utility;

public class SignUpPage extends Utility{
	public final static By titleTextId = By.id("com.bt.bms:id/txvTitle");
	private final static By firstNameTbId = By.id("com.bt.bms:id/edtFirstName");
	private final static By lastNameTbId = By.id("com.bt.bms:id/edtLastName");
	private final static By emailAddressTbId = By.id("com.bt.bms:id/edtEmailId");
	private final static By passwordTbId = By.id("com.bt.bms:id/edtPassword");
	private final static By mobileTbId = By.id("com.bt.bms:id/etmobile");
	private final static By activateWalletChkBxId = By.id("com.bt.bms:id/chkActivateWallet");
	private final static By doneBtnId = By.id("com.bt.bms:id/action_icon");
	
	public static void verifySignPage(){
		assertEquals(driver.findElement(titleTextId).getText(), "bookmyshow");
		assertEquals(driver.findElement(firstNameTbId).getText(), "First Name");
		assertEquals(driver.findElement(lastNameTbId).getText(), "Last Name");
		assertEquals(driver.findElement(emailAddressTbId).getText(), "email address");
		assertEquals(driver.findElement(passwordTbId).getText(), "Alphanumeric password");
		assertEquals(driver.findElement(mobileTbId).getText(), "phone number");
	}
	
	
}