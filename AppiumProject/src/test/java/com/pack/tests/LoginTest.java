package com.pack.tests;

import org.testng.annotations.Test;

import com.pack.pageobjects.HomePage;
import com.pack.pageobjects.LoginPage;
import com.pack.pageobjects.MainTabPage;
import com.pack.pageobjects.YouPage;
import com.pack.utilities.Utility;

public class LoginTest extends Utility {
	@Test
	public void testLoginLogout() {
		HomePage.verifyHomePage();
		HomePage.clickLoginBtn();
		LoginPage.verifyLoginPage();
		LoginPage.loginWithValidCredential();
		MainTabPage.clickYouTabAfterLogin();
		YouPage.verifyYouPageAfetrLogin();
		YouPage.logout();
	}
}