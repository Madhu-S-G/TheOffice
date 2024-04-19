package com.healthkart.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {

	
	// declaration
@FindBy(xpath="//a[@href='hms/user-login.php']") private WebElement patientLoginclick;
	
	@FindBy(name="username") private WebElement usernameEdtTxt;
	
	@FindBys(@FindBy(name ="password")) private WebElement passwordEdtTxt;;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement LoginBtnClk;
	
	@FindBy(xpath="//span[@class='username']") private WebElement userbtn;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-dark']/li)[last()]") private WebElement user_logout;

	
	// intialization	
	public PatientLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Business libraries
			/**
			 * login to application with username and password and click on save btn
			 * @param username
			 * @param password
			 */
			public void loginAsPatient(String username,String password)
			{
				patientLoginclick.click();
				usernameEdtTxt.sendKeys(username);
				passwordEdtTxt.sendKeys(password);
				LoginBtnClk.click();
			}
			
			public void logoutAsPatient() throws InterruptedException
			{
				userbtn.click();
				Thread.sleep(3000);
				user_logout.click();
			}
	
}
