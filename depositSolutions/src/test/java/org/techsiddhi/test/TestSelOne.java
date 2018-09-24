package org.techsiddhi.test;

import java.time.Instant;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techsiddhi.framework.APIlib;
import org.techsiddhi.framework.addUsersFnlib;
import org.techsiddhi.framework.baseSetup;

import junit.framework.Assert;
import junit.framework.*;

@FixMethodOrder(MethodSorters.JVM)
public class TestSelOne extends baseSetup{
	static WebDriver driver=new ChromeDriver();
	static long now = Instant.now().toEpochMilli();
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
	
	@Test
	public void testOnFieldValidations()
	{
		addFnlib.addNewUser("", "extra", "extra1", "yz@im.com");
		Assert.assertEquals("Required",objaddUserPage.getOnFieldValidationError(objaddUserPage.lblUserErr));
		Assert.assertEquals("Minimum size is 6", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblPwdErr));
		Assert.assertEquals("passwords are not the same", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblConfPwdErr));
	}
	
	
	@Test
	public void testAddUniqueUser()
	{
		addFnlib.addNewUser("user"+now, Long.toString(now), Long.toString(now), Long.toString(now)+"yz@im.com");
		Assert.assertEquals(true,objallUserPage.validateUserPresent("user"+now) );
		
		
	}
	
	@Test
	public void testDuplicateUser() throws InterruptedException
	{
		addFnlib.addNewUser("user"+now, Long.toString(now), Long.toString(now), Long.toString(now)+"yz@im.com");
		Assert.assertEquals("Must be unique", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblUserErr));
	}
	
//	@AfterClass
//	public void deleteAllUsers()
//	{
//		APIlib.deleteAllUsers();
//	}
	
}
