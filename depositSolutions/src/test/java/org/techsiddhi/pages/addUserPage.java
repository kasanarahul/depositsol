package org.techsiddhi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class addUserPage {
	private WebDriver driver;
	
	public By txtName= By.id("name");
	public By txtEmail= By.id("email");
	public By txtPassword= By.id("password");
	public By txtconfirmationPassword= By.id("confirmationPassword");
	public By btnAllUser= By.xpath("//*[@id=\"registrationForm\"]//a[text()='All User']");
	public By btnSubmit= By.xpath("//*[@id=\"registrationForm\"]//button");
	public By lblEmailErr= By.id("user.email.error");
	public By lblPwdErr= By.id("user.password.error");
	public By lblConfPwdErr= By.id("user.confirmationPassword.error");
	public By lblUserErr= By.id("user.name.error");
	
	
	public addUserPage(WebDriver driver){
		this.driver=driver;
	}
	
	//Enter Name for new user
	public void setName(String strName){

        driver.findElement(txtName).sendKeys(strName);

    }
	//Enter Email for new user
	public void setEmail(String strEmail){

        driver.findElement(txtEmail).sendKeys(strEmail);

    }
    //Set password in password textbox

    public void setPassword(String strPassword){

         driver.findElement(txtPassword).sendKeys(strPassword);
         driver.findElement(txtconfirmationPassword).sendKeys(strPassword);
    }

    //Set password in confirmpwd textbox

    public void setConfirmationPassword(String strPassword){

    	driver.findElement(txtconfirmationPassword).clear();
         driver.findElement(txtconfirmationPassword).sendKeys(strPassword);
    }
    
    //Click All User Button
    public void clickAllUser()
    {
    	driver.findElement(btnAllUser).click();
    }
    
  //Click Submit Button
    public void clickSubmit()
    {
    	driver.findElement(btnSubmit).click();
    }
    
    //Get OnFieldVAlidation Error
    public String getOnFieldValidationError(By errorField)
    {
    	String errorMsg=driver.findElement(errorField).getText();
    	return errorMsg;    	
    }
	
}
