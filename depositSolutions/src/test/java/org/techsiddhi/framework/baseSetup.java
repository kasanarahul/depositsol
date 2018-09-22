package org.techsiddhi.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.techsiddhi.pages.*;


public class baseSetup {

	WebDriver driver;
	public addUserPage objaddUserPage;
	public WebDriverWait wait;
	public String baseUrl="http://85.93.17.135:9000";
	
	public baseSetup (WebDriver driver)
	{
		this.driver=driver;
		objaddUserPage=new addUserPage(driver);
		wait=new WebDriverWait(this.driver, 50);
	}
}
