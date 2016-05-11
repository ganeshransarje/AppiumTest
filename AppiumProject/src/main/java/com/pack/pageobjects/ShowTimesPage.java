package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pack.utilities.Utility;

public class ShowTimesPage extends Utility{
	public static final By titleId = By.id("com.bt.bms:id/txvTitle");
	private static final By evbentNameId = By.id("com.bt.bms:id/eventName");
	private static final By venueNameId = By.id("com.bt.bms:id/venueName");
	private static final By weekNameId = By.id("com.bt.bms:id/weekName");
	private static final By dayId = By.id("com.bt.bms:id/day");
	private static final By monthId = By.id("com.bt.bms:id/month");
	private static final By timeId = By.id("com.bt.bms:id/time");
	private static final By timeModeId = By.id("com.bt.bms:id/time_mode");
	private static final By categoryId = By.id("com.bt.bms:id/txvCatName");
	private static final By categoryStatusId = By.id("com.bt.bms:id/txvCatStatus");
	private static boolean isShowTimeAvailable = false;
	private static boolean isSeatCatAvailable = false;
	public static final String TIME = prop.getProperty("time");
	public static final String TIMEMODE = prop.getProperty("timemode");
	public static final String SEATCATEGORY = prop.getProperty("seatcategory");
	
	public static void verifyShowTimesPage(){
		assertEquals(driver.findElement(titleId).getText(), "SHOW TIMES");
		assertEquals(driver.findElement(evbentNameId).getText(), MoviesPage.MOVIENAME);
		assertEquals(driver.findElement(venueNameId).getText(), PickVenuePage.VENUENAME);
		assertEquals(driver.findElement(dayId).getText(), PickVenuePage.DATE);
		assertEquals(driver.findElement(monthId).getText(), PickVenuePage.MONTH.toUpperCase());
	}
	
	public static Boolean selectShowTime(){
		List<WebElement> timeElements = driver.findElements(timeId);
		List<WebElement> timeModeElements = driver.findElements(timeModeId);
		for(int i=0; i<timeElements.size(); i++){
			if(timeElements.get(i).getText().equalsIgnoreCase(TIME) && timeModeElements.get(i).getText().equalsIgnoreCase(TIMEMODE)){
				isShowTimeAvailable = true;
				clickOnElement(timeElements.get(i));
				break;
			}
		}
		
		if(!isShowTimeAvailable){
			System.out.println("Show Time not available");
			return false;
		}else
			return true;
	}
	
	public static Boolean selectSeatCategory(){
		List<WebElement> categoryElements = driver.findElements(categoryId);
		List<WebElement> categoryStatusElements = driver.findElements(categoryStatusId);
		for(int i=0; i<categoryElements.size(); i++){
			if(categoryElements.get(i).getText().equalsIgnoreCase(SEATCATEGORY) && categoryStatusElements.get(i).getText().equalsIgnoreCase("available")){
				isSeatCatAvailable = true;
				clickOnElement(categoryElements.get(i));
				waitForElement(HowManyTicketsPage.titleId);
				break;
			}
		}
		
		if(!isSeatCatAvailable){
			System.out.println("Seat Category not available");
			return false;
		}else
			return true;
	}
}