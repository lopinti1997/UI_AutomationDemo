package com.orangehrm.utilities;


import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.factory.DriverFactory;

public class CommonObjects {

	public WebDriver driver = null;
	WebElement element;
	WebElement text_box;
	WebElement button;
	WebElement successMsg;
	WebElement chekbox;
	WebElement errormsg;
	WebElement radiobtn;
	WebElement dropDown;

	WebElement dropDown_options;

	/*
	 * Constructor
	 */

//	public static DriverFactory df = new DriverFactory();
	public static Logger logger = LogManager.getLogger(CommonObjects.class);

	public CommonObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is created to get Element by ID
	 * 
	 *
	 */

	public WebElement getElementByID(String textBox) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		String xpath = "//input[@id='" + textBox + "']";
		WebElement textBoxWebElement = DriverFactory.getDriver().findElement(By.xpath(xpath));
		appyWaitForElement().until(ExpectedConditions.visibilityOf(textBoxWebElement));
		js.executeScript("arguments[0].style.border='3px solid blue'", textBoxWebElement);

		this.text_box = textBoxWebElement;
		return textBoxWebElement;

	}
	
	

	/**
	 * This method is created to get element by Class
	 * 
	 *
	 */

	public WebElement getElementByClass(String text) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		String xpath = "//*[@class='"+text+"']";
		WebElement textBoxWebElement = DriverFactory.getDriver().findElement(By.xpath(xpath));
		appyWaitForElement().until(ExpectedConditions.visibilityOf(textBoxWebElement));
		js.executeScript("arguments[0].style.border='3px solid blue'", textBoxWebElement);

		this.text_box = textBoxWebElement;
		return textBoxWebElement;

	}
	
	/**
	 * This method is created to get by contains text
	 * 
	 * @return
	 */
	public WebElement getContainsText(String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String xpath = "//*[contains(text(),'" + text + "')]";
		appyWaitForElement();
		WebElement buttonWebElement = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", buttonWebElement);
//		buttonWebElement.click();
		return buttonWebElement;
	}
	
	


	/**
	 * This method is created to get button by ID
	 * 
	 */
	public WebElement getButtonByID(String buttonName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String xpath = "//*[@id='" + buttonName + "']";
		appyWaitForElement();
		WebElement buttonWebElement = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", buttonWebElement);
//		this.button = buttonWebElement;
		buttonWebElement.click();
		return buttonWebElement;

	}


	/**
	 * This method is created to get button by ID
	 * 
	 */
	public WebElement getButtonByType(String buttonName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String xpath = "//*[@type='" + buttonName + "']";
		appyWaitForElement();
		WebElement buttonWebElement = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", buttonWebElement);
//		this.button = buttonWebElement;
//		buttonWebElement.click();
		return buttonWebElement;

	}



	
	
	/**
	 * This method is created to get by Type
	 * 
	 * @return
	 */
	public WebElement getElementByType(String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String xpath = "//*[@type='"+text+"']";
		appyWaitForElement();
		WebElement buttonWebElement = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].style.border='3px solid blue'", buttonWebElement);
//		buttonWebElement.click();
		return buttonWebElement;
	}
	
	
	
	public WebDriverWait appyWaitForElement() {
		WebDriverWait wait = new WebDriverWait(driver, ConstantsValues.EXPLICIT_WAIT);
		return wait;

	}
	
	public Instant startTime() {

		Instant startTime = Instant.now();
		return startTime;

	}

	public Instant endTime() {
		Instant endTime = Instant.now();
		return endTime;
	}


}
