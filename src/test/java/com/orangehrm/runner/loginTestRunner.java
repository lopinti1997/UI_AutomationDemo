package com.orangehrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { 
		".\\src\\test\\resources\\FeatureFiles\\Login_Function.feature"  //
//		".\\src\\test\\resources\\FeatureFiles\\RegisterNewUsers.feature"
}, glue = {
		"com.orangehrm.hooks", "com.orangehrm.stepdef" }, dryRun = false, monochrome = true, plugin = { "pretty",
				"html:target\\cucumber-reports\\CucumberTestReport.html",
				"html:target/cucumber-reports/cucumber-pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
				tags = "@Valid or @InValid or @Forgot"
						)

public class loginTestRunner {

}
