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
import org.techsiddhi.framework.AppLib;
import org.techsiddhi.framework.baseSetup;
import org.techsiddhi.pages.addUserPage;

import junit.framework.Assert;
import junit.framework.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSelOne{
	static WebDriver driver=new ChromeDriver();
	static long now = Instant.now().toEpochMilli();
	AppLib addFnlib;
	public addUserPage objaddUserPage;
	
	public baseSetup fnLib=new baseSetup();
	
	public TestSelOne() {
		addFnlib= new AppLib(driver);
		objaddUserPage= new addUserPage(driver);
	}

	
	
	@Before
	public void callDriver()
	{
		driver.get(fnLib.baseUrl);
	}
	
	@Test
	public void test_001OnFieldValidations()
	{
		addFnlib.addNewUser("", "extra", "extra1", "yz@im.com");
		//Validate Name is required field
		Assert.assertEquals("Required",objaddUserPage.getOnFieldValidationError(objaddUserPage.lblUserErr));
		//Validate pwd size error
		Assert.assertEquals("Minimum size is 6", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblPwdErr));
		//Validate pwd and confirm pwd are same
		Assert.assertEquals("passwords are not the same", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblConfPwdErr));
	}
	
	@Test
	public void test_002AddUniqueUser()
	{
		addFnlib.addNewUser("user"+now, Long.toString(now), Long.toString(now), Long.toString(now)+"yz@im.com");
		//validate new user is added
		Assert.assertEquals(true,addFnlib.validateUserPresentUI("user"+now) );
		Assert.assertEquals(true, addFnlib.validateUserPresentAPI("user"+now));
	}
	
	@Test
	public void test_003DuplicateUser() throws InterruptedException
	{
		addFnlib.addNewUser("user"+now, Long.toString(now), Long.toString(now), Long.toString(now)+"yz@im.com");
		//validate name must be unique
		Assert.assertEquals("Must be unique", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblUserErr));
		//validate email must be unique
		Assert.assertEquals("Must be unique", objaddUserPage.getOnFieldValidationError(objaddUserPage.lblEmailErr));
//		addFnlib.deleteAllUsers();
	}
	
	@AfterClass
	public static void teardown()
	{
		driver.quit();
		
	}
	
		
}
