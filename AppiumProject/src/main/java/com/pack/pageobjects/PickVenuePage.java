package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pack.utilities.Utility;

public class PickVenuePage extends Utility{
	public static final By titleId = By.id("com.bt.bms:id/txvTitle");
	private static final By subTitleId = By.id("com.bt.bms:id/txvSubTitle");
	private static final By searchIconId = By.id("com.bt.bms:id/action_icon");
	private static final By searchTbId = By.id("com.bt.bms:id/edtSearchBox");
	private static final By venueNameId = By.id("com.bt.bms:id/txvVenueName");
	private static final By cancelSearchBtnId = By.id("com.bt.bms:id/btnCancel");
	private static boolean isVenueFound = false;
	private static boolean isDateFound = false;
	public static final String VENUENAME = prop.getProperty("venuename");
	public static final String DATE = prop.getProperty("date");
	public static final String MONTH = prop.getProperty("month");
	
	public static void verifyPickVenuePage(){
		assertEquals(driver.findElement(titleId).getText(), "PICK A VENUE");
		assertEquals(driver.findElement(subTitleId).getText(), MoviesPage.MOVIENAME.toUpperCase());
		clickOnElement(searchIconId);
		assertEquals(driver.findElement(searchTbId).getText(), "Type to filter");
		clickOnElement(cancelSearchBtnId);
	}
	
	public static Boolean searchForVenue() throws InterruptedException{
		selectDateForMovie();
		clickOnElement(searchIconId);
		sendKeys(searchTbId, VENUENAME);
		Thread.sleep(3000);
		List<WebElement> elements = driver.findElements(venueNameId);
		for(WebElement element : elements){
			if(element.getText().equalsIgnoreCase(VENUENAME)){
				isVenueFound = true;
				clickOnElement(element);
				waitForElement(ShowTimesPage.titleId);
				break;
			}
		}
		
		if(!isVenueFound){
			System.out.println("Venue not found");
			return false;
		}else
			return true;
	}

	private static Boolean selectDateForMovie() {
		List<WebElement> elements = driver.findElements(By.xpath("//android.widget.TextView"));
		for(WebElement element : elements){
			if(element.getText().equalsIgnoreCase(DATE)){
				isDateFound = true;
				clickOnElement(element);
				break;
			}
		}
		
		if(!isDateFound){
			System.out.println("Date not found");
			return false;
		}else
			return true;
	}
}