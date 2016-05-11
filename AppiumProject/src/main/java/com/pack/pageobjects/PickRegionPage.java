package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.pack.utilities.Utility;

public class PickRegionPage extends Utility {
	public static final By pickRegionTitleId = By.id("com.bt.bms:id/txvTitle");
	private static final By searchIconId = By.id("com.bt.bms:id/action_icon");
	private static final By searchTbId = By.id("com.bt.bms:id/edtSearchBox");
	public static final String REGION = prop.getProperty("region");
	
	public static void veerifyPickRegionPage() {
		assertEquals(driver.findElement(pickRegionTitleId).getText(),
				"PICK A REGION");
		driver.findElement(searchIconId).click();
		assertEquals(driver.findElement(searchTbId).getText(),
				"Search for your city");
	}

	public static void selectRegion() {
		sendKeys(searchTbId, REGION);
		if (driver.findElement(
				By.xpath("//android.widget.CheckedTextView[@text='"+REGION+"']"))
				.isDisplayed()) {
			driver.findElement(
					By.xpath("//android.widget.CheckedTextView[@text='"+REGION+"']"))
					.click();
		}
	}
}