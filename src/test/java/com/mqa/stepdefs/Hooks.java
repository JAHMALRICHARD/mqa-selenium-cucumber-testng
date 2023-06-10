package com.mqa.stepdefs;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mqa.managers.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void setup() {
		// set DriverManager
		if (driver == null) {
			driver = DriverManager.getDriver();
		}

	}

	@AfterStep
	public static void takeScreenshot( Scenario scenario) {
		
		final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png","image");

	}

	@After
	public static void tearDown() {
		// close the driver/browser
		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;

	}
}
