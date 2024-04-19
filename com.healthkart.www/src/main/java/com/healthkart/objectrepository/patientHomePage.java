package com.healthkart.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.genericutilities.webdriverutility;

public class patientHomePage {
	webdriverutility webutil = new webdriverutility();
	
	@FindBy(xpath = "//div[@class='panel-body']//a[@href='book-appointment.php']") 
	private WebElement bookAppntm;
	
	@FindBy(name= "Doctorspecialization") private WebElement DrSplztn;
	
	@FindBy(name= "doctor") private WebElement Drname;
	
	@FindBy(name= "appdate") private WebElement calendar;
	
	
	@FindBy(xpath= "//tbody//tr[5]//td[.='29']") private WebElement date;
	
	
	@FindBy(name= "apptime") private WebElement time;
	
	@FindBy(name= "submit") private WebElement submit;
	
	
	
	@FindBy(xpath = "//a[@href='appointment-history.php']" ) private WebElement histrybtn;
	
	@FindBy(xpath = "//tbody//tr[last()]//td[@class='hidden-xs']") private WebElement apptndDr;
	
	//utilization
	public patientHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	//Business libraries
	/**
	 * login to application with username and password and click on save btn
	 * @param driver,  DrSplztn 
	 * @param username
	 * @param password
	 * @throws InterruptedException 
	 */
	public void bookApointment(String Splztn,String Dr, String tim, WebDriver driver) throws InterruptedException
	{
		bookAppntm.click();
		Thread.sleep(2000);
		DrSplztn.click();
		Thread.sleep(2000);
		webutil.handleDropdown(DrSplztn, Splztn);
		Thread.sleep(2000);
		Drname.click();
		Thread.sleep(2000);
		webutil.handleDropdown(Drname, Dr);
		Thread.sleep(2000);
		calendar.click();
		Thread.sleep(2000);
		date.click();
		time.clear();
		time.sendKeys(tim);
		submit.click();
		webutil.acceptAlert(driver);
		
	}
	
	public void appntmnt_history(String Dr) {
		
		histrybtn.click();
		String act = apptndDr.getText();	
		Assert.assertEquals(act, Dr);
		System.out.println("Appointment done and verified successfully!!!");
		
	}
	
}
