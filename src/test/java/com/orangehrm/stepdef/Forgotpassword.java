package com.orangehrm.stepdef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.utilities.CommonObjects;
import com.orangehrm.utilities.getExcellData;

import io.cucumber.java.en.*;

public class Forgotpassword {

	public static Logger logger = LogManager.getLogger(CommonObjects.class);
	public static CommonObjects objComm = new CommonObjects(DriverFactory.getDriver());

	@When("user clicked on forgot as {string}.")
	public void user_clicked_on_forgot_as(String forgotlink) {

		try {
//			//*[@class='forgot-password-link']

			WebElement element = objComm.getElementByClass(forgotlink);
			Thread.sleep(3000);
			element.click();
			logger.info(" >>>>>>>>>> User clicked on forgot link <<<<<<<<<<");
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
	}

	@When("user enterd {string}.")
	public void user_enterd(String userEmail) {

		String emailID = getExcellData.getCellData("ForgotTestData", "TC03", "Username");
		System.out.println("Email ID : " +  emailID);

		try { //
				// *[@type='email']

			WebElement element = objComm.getElementByType(userEmail);
			Thread.sleep(3000);

			element.sendKeys(emailID);
			logger.info(" >>>>>>>>>> User Entered Email id <<<<<<<<<<");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	@When("user entered pwd as {string}.")
	public void user_entered_pwd_as(String password) {

		String Password = getExcellData.getCellData("ForgotTestData", "TC03", "Password");

		try {
// //input[@id='userPassword']
			WebElement element = objComm.getElementByID(password);
			Thread.sleep(3000);

			element.sendKeys(Password);
			logger.info(" >>>>>>>>>> User Entered Password  <<<<<<<<<<");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	@When("user entered confpwd as {string}.")
	public void user_entered_confpwd_as(String ConformPwd) {
		String Conformpassword = getExcellData.getCellData("ForgotTestData", "TC03", "Conformpassword");

		try {
			// //input[@id='confirmPassword']

			WebElement element = objComm.getElementByID(ConformPwd);
			Thread.sleep(3000);

			element.sendKeys(Conformpassword);
			logger.info(" >>>>>>>>>> User Entered Password  <<<<<<<<<<");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	@When("user clicked on buuton {string}.")
	public void user_clicked_on_buuton(String submit) {
		try {
			WebElement element = objComm.getButtonByType(submit);
			Thread.sleep(3000);

			element.click();
			logger.info(" >>>>>>>>>> User Clicked on submit button <<<<<<<<<<");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

}
