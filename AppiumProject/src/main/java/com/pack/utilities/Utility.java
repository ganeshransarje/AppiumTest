package com.pack.utilities;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Utility {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	// set up appium
	private static final File classpathRoot = new File(
			System.getProperty("user.dir"));
	private static final File appDir = new File(classpathRoot,
			"src/test/resources/apps");
	private static final File app = new File(appDir, "BookMyShow-4.3.2.apk");

	@BeforeClass
	public void setUp() throws MalformedURLException {
		readFileData();
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set android deviceName desired capability. Set your device name.
		// capabilities.setCapability("deviceName", "emulator-5554");
		// capabilities.setCapability("deviceName",
		// prop.getProperty("devicename"));
		capabilities.setCapability("deviceName", System.getenv("DEVICENAME"));

		// Set BROWSER_NAME desired capability. It's Android in our case here.
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		// Set android VERSION desired capability. Set your mobile device's OS
		// version.
		// capabilities.setCapability(CapabilityType.VERSION, "5.1");
		// capabilities.setCapability(CapabilityType.VERSION,
		// prop.getProperty("version"));
		capabilities.setCapability(CapabilityType.VERSION,
				System.getenv("VERSION"));
		// Set android platformName desired capability. It's Android in our case
		// here.
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());

		// Set android appPackage desired capability. It is
		// com.bt.bms for BookMyShow application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appPackage", "com.bt.bms");
		// Set android appActivity desired capability. It is
		// com.bt.bms.activities.IntroActivity for BookMyShow application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appActivity",
				"com.bt.bms.activities.IntroActivity");

		capabilities.setCapability("newCommandTimeout", "300");
		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch calculator app in android device.
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static void clickOnElement(By elementToClick) {
		driver.findElement(elementToClick).click();
	}

	public static void clickOnElement(WebElement elementToClick) {
		elementToClick.click();
	}

	public static void sendKeys(By textElement, String text) {
		driver.findElement(textElement).sendKeys(text);
	}

	public static void waitForElement(By elementForWait) {
		wait = new WebDriverWait(driver, 480);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(elementForWait));
	}

	public static void readFileData() {
		File file = new File("src/main/resources/datafile.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}