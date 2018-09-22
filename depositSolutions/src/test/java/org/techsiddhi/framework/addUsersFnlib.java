package org.techsiddhi.framework;

import org.openqa.selenium.WebDriver;

public class addUsersFnlib extends baseSetup{
	public WebDriver driver;
	public addUsersFnlib(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	//method to enter user details
	public void addNewUser(String name, String pwd, String confirmpwd, String Email) {
		objaddUserPage.setName(name);
		objaddUserPage.setEmail(Email);
		objaddUserPage.setPassword(pwd);
		objaddUserPage.setConfirmationPassword(confirmpwd);
		
		objaddUserPage.clickSubmit();
//		objaddUserPage.clickAllUser();
		
	}

}
