package org.techsiddhi.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testSel {
	
	WebDriver driver=new ChromeDriver();
	
	@Before
	public void callDriver()
	{
		driver.get("http://www.techsiddhi.com");
	}
	
	@Test
	public void testLogin()
	{
		System.out.println("In test method");
	}

}
