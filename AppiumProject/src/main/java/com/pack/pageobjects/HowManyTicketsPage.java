package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pack.utilities.Utility;

public class HowManyTicketsPage extends Utility{
	public static final By titleId = By.id("com.bt.bms:id/txvTitle");
	private static final By eventNameId = By.id("com.bt.bms:id/eventName");
	private static final By venueNameId = By.id("com.bt.bms:id/venueName");
	private static final By categoryId = By.id("com.bt.bms:id/txvCatName");
	private static final By timeId = By.id("com.bt.bms:id/time");
	private static final By timeModeId = By.id("com.bt.bms:id/time_mode");
	private static final By weekNameId = By.id("com.bt.bms:id/weekName");
	private static final By dayId = By.id("com.bt.bms:id/day");
	private static final By monthId = By.id("com.bt.bms:id/month");
	private static final By headerId = By.id("com.bt.bms:id/header_value");
	private static final By quantityId = By.id("com.bt.bms:id/txvQuantity");
	private static final By proceedBtnId = By.id("com.bt.bms:id/txvDone");
	private static boolean isQuantityAvailable = false;
	public static final String SEATQUANTITY = prop.getProperty("seatquantity");
	
	public static void verifyHowManyTicketsPage(){
		assertEquals(driver.findElement(titleId).getText(), "HOW MANY TICKETS?");
		assertEquals(driver.findElement(eventNameId).getText(), MoviesPage.MOVIENAME);
		assertEquals(driver.findElement(venueNameId).getText(), PickVenuePage.VENUENAME);
		assertEquals(driver.findElement(categoryId).getText(), ShowTimesPage.SEATCATEGORY);
		assertEquals(driver.findElement(timeId).getText(), ShowTimesPage.TIME);
		assertEquals(driver.findElement(timeModeId).getText(), ShowTimesPage.TIMEMODE);
		assertEquals(driver.findElement(dayId).getText(), PickVenuePage.DATE);
		assertEquals(driver.findElement(headerId).getText(), "HOW MANY TICKETS?");
	}
	
	public static Boolean selectSeatsQuantity(){
		List<WebElement> elements = driver.findElements(quantityId);
		for(WebElement element : elements){
			if(element.getText().equalsIgnoreCase(SEATQUANTITY)){
				isQuantityAvailable = true;
				clickOnElement(element);
				clickOnElement(proceedBtnId);
				waitForElement(PickSeatsPage.titleId);
				break;
			}
		}
		
		if(!isQuantityAvailable){
			System.out.println("Quantity of seats are not available.");
			return false;
		}else
			return true;
	}
}