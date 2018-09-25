package org.techsiddhi.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.techsiddhi.pages.*;

public class AppLib extends baseSetup{
	public WebDriver driver;
	public addUserPage objaddUserPage;
	public WebDriverWait wait;
	public AppLib(WebDriver driver) {
		
		this.driver=driver;
		objaddUserPage=new addUserPage(driver);
		wait = new WebDriverWait(this.driver, 50);
	}
	
	//method to enter user details
	public void addNewUser(String name, String pwd, String confirmpwd, String Email) {
		System.out.println("Start of add new user method");
		
		objaddUserPage.setName(name);
		objaddUserPage.setEmail(Email);
		objaddUserPage.setPassword(pwd);
		
		objaddUserPage.setConfirmationPassword(confirmpwd);
		
		objaddUserPage.clickSubmit();
		System.out.println("End of add new user method");
	
	}
	
	//validate if value is present in table
		public boolean validateUserPresentUI(String username)
		{
			boolean elementAvlbl;
			try {
			   driver.findElement(By.xpath("//td[text()='"+username+"']"));
			   elementAvlbl = true;
			} catch (NoSuchElementException e) {
				elementAvlbl = false;
			}
			return elementAvlbl;
		}
	
	
}
