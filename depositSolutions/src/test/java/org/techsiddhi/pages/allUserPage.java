package org.techsiddhi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class allUserPage {
	private WebDriver driver;
	
		
	
	public allUserPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	//validate if value is present in table
	public boolean validateUserPresent(String username)
	{
		boolean present;
		try {
		   driver.findElement(By.xpath("//td[text()='"+username+"']"));
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		return present;
	}
}
