package com.orangehrm.hooks;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.utilities.CommonObjects;
import com.orangehrm.utilities.ConfigReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

	public static DriverFactory df = new DriverFactory();
	public static Logger logger = LogManager.getLogger(hooks.class);

//	Logger logger = Logge.getLogger(Hooks.class);
//	public static Logger logger = LogManager.getLogger(Hooks.class);
	public static CommonObjects objCom = new CommonObjects(DriverFactory.getDriver());


	@Before()
	public void launchBrowser() {
		Instant startTime = objCom.startTime();
		String browserName = ConfigReader.initiate_properties().getProperty("Browser");
		df.initiate_browser(browserName);
		Instant endTime = objCom.endTime();
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("PageLoad Time is : " + duration.toMillis() + " Milli Seconds");
		logger.info("PageLoad Time is : " + duration.toMillis() + " Milli Seconds");
	}
	
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			// Take a screenshot...
			try {
				String screenShotName = scenario.getName().replaceAll(" ", "_");
				final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
						.getScreenshotAs(OutputType.BYTES);

				scenario.attach(screenshot, "image/png", screenShotName); // ... and embed it in the report.
				DriverFactory.close_app();
			} catch (Exception e) {

				logger.info(e.getMessage());
			}

		} else {
			DriverFactory.close_app();

		}

	}

}
