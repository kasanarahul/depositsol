package org.techsiddhi.framework;

import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class baseSetup {

	WebDriver driver;

	public static String baseUrl, getAllUsers;
	public static String deleteAllUsers;
	
	public baseSetup ()
	{
		//load env properties on setup
		
		Properties prop = new Properties();
		InputStream input = null;
		try {
		
		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		baseUrl=prop.getProperty("baseUrl");
		getAllUsers=prop.getProperty("getAllAPI");
		deleteAllUsers=prop.getProperty("deleteAPI");
		
		
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
	
	
	//get all users via API
	public String getAllUsers()
	{
		Response resp=RestAssured.get(baseUrl+getAllUsers);
		int code = resp.getStatusCode();
		System.out.println(resp.jsonPath().getList("/name"));
		return resp.asString();
		
	}
	
	//Validate if user is present via API
	public boolean validateUserPresentAPI(String userName)
	{
		Response resp=RestAssured.get(baseUrl+getAllUsers);
		if(resp.asString().contains("\"name\":\""+userName))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//Delete all users via API
	public int deleteAllUsers()
	{
		Response resp=RestAssured.delete(baseUrl+deleteAllUsers);
		int code = resp.getStatusCode();
		System.out.println("status code is: "+code);
		return code;
		
	}

}
