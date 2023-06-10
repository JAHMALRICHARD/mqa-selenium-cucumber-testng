package com.mqa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@test",
features = "./src/test/resources/features/login.feature",
glue = "com.mqa.stepdefs",
plugin = {
		"summary", "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
monochrome = true

)

public class LoginPageRunner extends AbstractTestNGCucumberTests  {
	

}
