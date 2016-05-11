package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pack.utilities.Utility;

public class TicketsPage extends Utility{
	public final static By allMenuXpath = By.xpath("//android.widget.TextView[@text='ALL']");
//	private final static By moviesMenuId = By.id("com.bt.bms:id/menu_image_dyn");
	private final static By eventsMenuXpath = By.xpath("//android.widget.TextView[@text='EVENTS']");
	private final static By playsMenuXpath = By.xpath("//android.widget.TextView[@text='PLAYS']");
	private final static By sportsMenuXpath = By.xpath("//android.widget.TextView[@text='SPORTS']");
	private final static By searchByVenueTextXpath = By.xpath("//android.widget.TextView[@text='Search by Venue']");
	private final static By locationTextId = By.id("com.bt.bms:id/txvLocation");
	private static List<WebElement> elements;
	
	public static void verifyTicketsPage() throws InterruptedException{
//		Thread.sleep(2000);
//		System.out.println(driver.getClass());
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getPageSource());
//		
//		try{
//			if(driver.findElement(By.id("com.bt.bms:id/btnCancel")).isDisplayed())
//				driver.findElement(By.id("com.bt.bms:id/btnCancel")).click();
//		}catch(Exception e){
//			
//		}
		elements = driver.findElements(By.className("android.widget.TextView"));
		assertEquals(driver.findElement(allMenuXpath).getText(), "ALL");
		assertEquals(elements.get(6).getText(), "MOVIES");
		assertEquals(driver.findElement(eventsMenuXpath).getText(), "EVENTS");
		assertEquals(driver.findElement(playsMenuXpath).getText(), "PLAYS");
		assertEquals(driver.findElement(sportsMenuXpath).getText(), "SPORTS");
		assertEquals(elements.get(11).getText(), "EXPERIENCES");
		assertEquals(driver.findElement(searchByVenueTextXpath).getText(), "Search by Venue");
		assertTrue(driver.findElement(locationTextId).isDisplayed());
	}
	
	public static void clickMoviesMenu(){
		clickOnElement(elements.get(6));
		waitForElement(MoviesPage.moviesTitleId);
	}
	
	public static void clickOnLocation(){
		clickOnElement(locationTextId);
		waitForElement(UnableToIdentifyLocationPopup.loactionPopupTitleId);
	}
	
	public static void verifyLocation(){
		assertEquals(driver.findElement(locationTextId).getText(), "You're in "+PickRegionPage.REGION);
	}
}