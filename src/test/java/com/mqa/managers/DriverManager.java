package com.mqa.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		// setting up chrome driver for the system
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();	
		return driver;
	}
	
}
