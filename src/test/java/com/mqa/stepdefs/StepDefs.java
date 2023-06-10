package com.mqa.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	public static WebDriver driver;
	
	@Given("The user is on the login screen")
	public void the_user_is_on_the_login_screen() {
		driver = Hooks.driver;
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement usernameTextBox = driver.findElement(By.id("user-name"));
		assertEquals("User is on the Home Page", usernameTextBox.isDisplayed(), true);
	    
	}

	@When("the user enters {string} in username field")
	public void the_user_enters_in_username_field(String strUserNsme) {
		
		WebElement usernameTextBox = driver.findElement(By.id("user-name"));
		usernameTextBox.click();
		usernameTextBox.clear();
		usernameTextBox.sendKeys(strUserNsme);
	}

	@When("the user enters {string} in the password field")
	public void the_user_enters_in_the_password_field(String strPwd) {
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.click();
		passwordTextBox.clear();
		passwordTextBox.sendKeys(strPwd);
	}
	
	@When("the user clicks the Log in button")
	public void the_user_clicks_the_log_in_button() {
		WebElement signInButton = driver.findElement(By.id("login-button"));
		signInButton.click();
		Wait(3000);
	}

	@Then("the product page is displayed")
	public void the_product_page_is_displayed() {
	   
	    WebElement pageTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		assertEquals("User is on the Product Page", pageTitle.getText().matches("Products"), true);
	}
	
	@Then("the system displays an error")
	public void the_system_displays_an_error() {
		//WebElement errorEle = driver.findElement(By.className("error-button"));
		WebElement errorEle = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
		System.out.println(errorEle.getText());
		assertEquals("Error message displayed", errorEle.getText().contains("Epic sadface: Username and password do not match any user in this service"), true);
	    
	}
	
	public void Wait(int ms) {
		
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
