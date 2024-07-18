package com.orangehrm.factory;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.orangehrm.utilities.ConfigReader;
import com.orangehrm.utilities.ConstantsValues;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

//	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger(DriverFactory.class);

	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

	// threadLocal = driver

	public WebDriver initiate_browser(String browser) {

		try {
			logger.info("Browser value is: " + browser);

			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				threadLocal.set(new ChromeDriver());
				logger.info(browser + "browser opened");

			} else if (browser.equalsIgnoreCase("ChromeHeadless")) {

				/*
				 * With Headless mode
				 * 
				 */
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				WebDriverManager.chromedriver().setup();
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--allow-insecure-localhost");
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				threadLocal.set(new ChromeDriver(options));

			} else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				threadLocal.set(new EdgeDriver());
				logger.info(browser + "Broser opned ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getDriver().manage().window().maximize();

//		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
//		getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICITY_WAIT, TimeUnit.SECONDS);

		String app_Url = ConfigReader.initiate_properties().getProperty("Url");
		getDriver().get(app_Url);
		getDriver().manage().timeouts().pageLoadTimeout(ConstantsValues.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(ConstantsValues.IMPLICITY_WAIT, TimeUnit.SECONDS);
		logger.info("Application URL is : " + app_Url);
		getDriver().get(app_Url);

		return getDriver();

	}

	public WebDriver EnteredUserName(String UN) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String xpath = "//*[@id='userEmail']";
		WebElement userName = getDriver().findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", userName);

		userName.sendKeys(Keys.HOME);
		userName.sendKeys(Keys.CONTROL + "A");
		userName.sendKeys(Keys.DELETE);
		userName.sendKeys(UN);
		logger.info("Entered username is :" + UN);
		Thread.sleep(3000);
		return getDriver();
	}

	public WebDriver EntertedPasssword(String pwd) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement password = getDriver().findElement(By.xpath("//*[@id='userPassword']"));
		js.executeScript("arguments[0].style.border='3px solid blue'", password);
		password.sendKeys(Keys.HOME);
		password.sendKeys(Keys.CONTROL + "A");
		password.sendKeys(Keys.DELETE);
		password.sendKeys(pwd);
		logger.info("Entered Password:-" + pwd);
		Thread.sleep(3000);
		return getDriver();
	}

	public WebDriver ClickOnLoginButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement Loginbtn = getDriver().findElement(By.xpath("//*[@id='login']"));
		js.executeScript("arguments[0].style.border='3px solid blue'", Loginbtn);
		Loginbtn.click();
		logger.info("Clicked on Login button");
		Thread.sleep(3000);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {

		// return threadLocal.get();
		return threadLocal.get();
	}
	
	

	public static void close_app() {
		getDriver().quit();
		logger.info(" Browser Closed ");
	}

}
