package org.techsiddhi.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techsiddhi.framework.addUsersFnlib;

import junit.framework.Assert;

public class TestSelOne extends addUsersFnlib{
	static WebDriver driver=new ChromeDriver();
	public TestSelOne() {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	@Before
	public void callDriver()
	{
		driver.get(baseUrl);
	}
	@Test
	public void testAllUsers()
	{
		super.addNewUser("", "extra", "extra", "yz@im.com");
//		Assert.assertEquals("Title is not matched", driver.getCurrentUrl(),baseUrl+"/users/all");
		Assert.assertEquals(objaddUserPage.getOnFieldValidationError(objaddUserPage.lblUserErr), "Required");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testLogin()
	{
		System.out.println("In test method21");
		Assert.assertEquals(true, true);
	}

}
