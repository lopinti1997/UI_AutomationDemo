package com.orangehrm.stepdef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.utilities.CommonObjects;
import com.orangehrm.utilities.getExcellData;

import io.cucumber.java.en.*;

public class Loginfuction {

	public static DriverFactory df = new DriverFactory();
	public static Logger logger = LogManager.getLogger(CommonObjects.class);

	public static CommonObjects objComm = new CommonObjects(DriverFactory.getDriver());

//	public void readExcellData() 
//	{
//		String userName = getExcellData.getCellData("LoginTestData", "TC02", "Username");
//		
//	}
	
	
	
	@Given("user launched blowser and entered url.")
	public void user_launched_blowser_and_entered_url() {

		System.out.println(" ********** user launched Browser sucessfully  ********** ");
	}

	
	@When("user entered id as {string} from Test Case {string}.")
	public void user_entered_id_as_from_test_case(String string, String TestCasesID){
		String userName = getExcellData.getCellData("LoginTestData", TestCasesID, "Username");
		try {
			df.EnteredUserName(userName);
			logger.info(" User Entered EmailID  ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			logger.info(e.getMessage());
		}

	}

	@When("user entered password as {string} from Test Case {string}.")
	public void user_entered_password_as_from_test_case(String string, String TestCasesID) {
		String password= getExcellData.getCellData("LoginTestData", TestCasesID, "Password");

		try {
			df.EntertedPasssword(password);
			logger.info(" User Entered Password  ");

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	@And("user clicked on {string}.")
	public void user_clicked_on(String string) {
		try {
			df.ClickOnLoginButton();
			logger.info(" User Clicked On login button  ");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}

	@And("user clicked on signOut {string}.")
	public void user_clicked_on_sign_out(String string) {
		System.out.println(" user entered in dash board ");

	}

}
