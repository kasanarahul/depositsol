package org.techsiddhi.framework;

import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class APIlib extends baseSetup{
	public WebDriver driver;
	public APIlib(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	public String getAllUsers()
	{
		Response resp=RestAssured.get(getAllUsers);
		int code = resp.getStatusCode();
		System.out.println(resp.jsonPath().getList("/name"));
		return resp.asString();
		
	}
	
	public String validateUserPresent(String userName)
	{
		Response resp=RestAssured.get(getAllUsers);
		int code = resp.getStatusCode();
		return resp.asString();
	}
	
	public static int deleteAllUsers()
	{
		Response resp=RestAssured.get(deleteAllUsers);
		int code = resp.getStatusCode();
		return code;
		
	}

}
