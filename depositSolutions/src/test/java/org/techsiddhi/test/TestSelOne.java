package org.techsiddhi.test;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techsiddhi.framework.addUsersFnlib;
import org.techsiddhi.framework.baseSetup;

import com.google.common.base.Converter;

import junit.framework.Assert;

public class TestSelOne extends baseSetup{
	static WebDriver driver=new ChromeDriver();
	addUsersFnlib addFnlib;
	public TestSelOne() {
		super(driver);
		addFnlib= new addUsersFnlib(driver);
		
	}

	
	
	@Before
	public void callDriver()
	{
		driver.get(baseUrl);
	}
//	@Test
//	public void testAllUsers()
//	{
//		super.addNewUser("", "extra", "extra", "yz@im.com");
////		Assert.assertEquals("Title is not matched", driver.getCurrentUrl(),baseUrl+"/users/all");
//		Assert.assertEquals("Required",objaddUserPage.getOnFieldValidationError(objaddUserPage.lblUserErr));
//		Assert.assertEquals("Minimum size is 6", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblPwdErr));
//	}
//	
	
	@Test
	public void testAddUniqueUser()
	{
		long now = Instant.now().toEpochMilli();
		addFnlib.addNewUser("user"+now, Long.toString(now), Long.toString(now), Long.toString(now)+"yz@im.com");
//		Assert.assertEquals("Title is not matched", driver.getCurrentUrl(),baseUrl+"/users/all");
//		Assert.assertEquals("Required",objaddUserPage.getOnFieldValidationError(objaddUserPage.lblUserErr));
//		Assert.assertEquals("Minimum size is 6", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblPwdErr));
		Assert.assertEquals(true,objallUserPage.validateUserPresent("user"+now) );
	}
	
}
