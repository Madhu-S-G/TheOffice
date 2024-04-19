
package com.healthkart.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addpatientPage {
	
// declaration	

	@FindBy(name="patname") private WebElement pname;	
	@FindBy(name="patcontact") private WebElement pmob;	
	@FindBy(name="patemail") private WebElement pmail;	
	@FindBy(name="pataddress") private WebElement paddr;	
	@FindBy(name="patage") private WebElement p_age;	
	@FindBy(name="medhis") private WebElement pmed;	
	@FindBy(xpath="//label[@for='rg-male']") private WebElement male_rbtn;	
	@FindBy(xpath="//input[@id='rg-female']") private WebElement female_rbtn;	
	@FindBy(name="submit") private WebElement subbtn;
	
	
	//intialization
	public addpatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//getters
	public WebElement getPname() {
		return pname;
	}
	public WebElement getPmob() {
		return pmob;
	}
	public WebElement getPmail() {
		return pmail;
	}
	public WebElement getPaddr() {
		return paddr;
	}
	public WebElement getP_age() {
		return p_age;
	}
	public WebElement getPmed() {
		return pmed;
	}
	public WebElement getMale_rbtn() {
		return male_rbtn;
	}
	public WebElement getFemale_rbtn() {
		return female_rbtn;
	}
	public WebElement getSubbtn() {
		return subbtn;
	}
	
	//	//Business libraries
	/**
	 * login to application with username and password and click on save btn
	 * @param username
	 * @param password
	 */
	public void patientdetails(String pn,String cn,String mid,String add,
			String age,String mh)
	{   pname.sendKeys(pn);
	      pmob.sendKeys(cn);
	      pmail.sendKeys(mid);
	      paddr.sendKeys(add);
	      p_age.sendKeys(age);
	      pmed.sendKeys(mh);
	      male_rbtn.click();
//	      female_rbtn.click();
	      subbtn.click();
	}	
	
	
	
	
	
}
