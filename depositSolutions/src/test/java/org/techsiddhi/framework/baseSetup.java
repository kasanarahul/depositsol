package org.techsiddhi.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.techsiddhi.pages.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class baseSetup {

	WebDriver driver;
	public addUserPage objaddUserPage;
	public allUserPage objallUserPage;
	public WebDriverWait wait;
	public String baseUrl, getAllUsers;
	public static String deleteAllUsers;
	
	public baseSetup (WebDriver driver)
	{
		this.driver=driver;
		objaddUserPage=new addUserPage(driver);
		objallUserPage=new allUserPage(driver);
		wait=new WebDriverWait(this.driver, 50);
		Properties prop = new Properties();
		InputStream input = null;
		try {
		
		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		this.baseUrl=prop.getProperty("baseUrl");
		this.getAllUsers=prop.getProperty("getAllAPI");
		this.deleteAllUsers=prop.getProperty("deleteAPI");
		
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
