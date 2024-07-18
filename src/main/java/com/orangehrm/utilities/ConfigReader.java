package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns Properties prop object
	 */

	public static Properties initiate_properties() {

		try {
			File filePath = new File(".\\src\\test\\resources\\config.properties");
			FileInputStream iputStream = new FileInputStream(filePath);
			prop = new Properties();
//			InputStream ip = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(iputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
