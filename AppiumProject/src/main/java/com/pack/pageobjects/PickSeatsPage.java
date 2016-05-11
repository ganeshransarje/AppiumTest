package com.pack.pageobjects;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.pack.utilities.Utility;

public class PickSeatsPage extends Utility {
	public static final By titleId = By.id("com.bt.bms:id/txvTitle");
	private static final By availableTextId = By
			.id("com.bt.bms:id/robotoCondensedBoldTextView3");
	private static final By yourSelectionTextId = By
			.id("com.bt.bms:id/robotoCondensedBoldTextView1");
	private static final By unavailableTextId = By
			.id("com.bt.bms:id/robotoCondensedBoldTextView2");
	private static final By payNowBtnId = By.id("com.bt.bms:id/txvDone");
	private static boolean isSeatsAvailable = false;
	private static WebElement element;
	private static Map m;
	private static final String SEATROW = prop.getProperty("seatrow");
	private static final int NOOFSEATS = Integer.parseInt(prop.getProperty("seatquantity"));
	private static final int STARTINGSEATNO = Integer.parseInt(prop.getProperty("seatnostartfrom"));
	
	public static void verifyPickSeatsPage() {
		assertEquals(driver.findElement(titleId).getText(), "PICK "+ HowManyTicketsPage.SEATQUANTITY +" SEATS");
		assertEquals(driver.findElement(availableTextId).getText(), "Available");
		assertEquals(driver.findElement(yourSelectionTextId).getText(),
				"Your Selection");
		assertEquals(driver.findElement(unavailableTextId).getText(),
				"Unavailable");
		assertEquals(driver.findElement(payNowBtnId).getText(), "Pay Now");
	}

	public static void selectSeats() {
		getCodeIndex();
		try {
			for (int i = STARTINGSEATNO; i < STARTINGSEATNO + NOOFSEATS; i++) {
				element = driver
						.findElement(By.xpath("//android.widget.TableRow["
								+ m.get(SEATROW)
								+ "]/android.widget.ImageView[@NAF='true' and @index='"
								+ i + "']"));
				isSeatsAvailable = true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Required seats are not Available.");
		}

		if (isSeatsAvailable) {
			clickOnElement(element);
			System.out.println("Seats Available and selected");
		}
	}

	private static void getCodeIndex() {
		m = new HashMap();
		m.put("A", 1);
		m.put("B", 2);
		m.put("C", 3);
		m.put("D", 4);
		m.put("E", 5);
		m.put("F", 6);
		m.put("G", 7);
		m.put("J", 10);
	}
}