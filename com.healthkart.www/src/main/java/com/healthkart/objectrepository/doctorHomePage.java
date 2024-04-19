package com.healthkart.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class doctorHomePage {

	//declaration
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']/descendant::span[.=' Patients ']")
	private WebElement  patientddown;
	
	@FindBy(xpath="//span[.=' Add Patient']") private WebElement addpatientbtn;
	
	@FindBy(xpath="//span[.=' Manage Patient ']") private WebElement mngpatientbtn; 
	
	@FindBy(xpath="(//tbody/tr)[last()]//td[@class='hidden-xs']") private WebElement list_lastone;
	
	//intialization
	public doctorHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//access private members using getters
	public WebElement getPatientddown() {
		return patientddown;
	}
	
	public WebElement getAddpatient() {
		return addpatientbtn;
	}
		
	public WebElement getMngpatientbtn() {
		return mngpatientbtn;
	}
	
			public WebElement getList_lastone() {
		return list_lastone;
	}

			//Business libraries
			/**
			 * login to application with username and password and click on save btn
			 * @param username
			 * @param password
			 */
			public void patdropdown1()
			{   patientddown.click();
				addpatientbtn.click();		
			}	
			
			public void patdropdown2()
			{   patientddown.click();
			    mngpatientbtn.click();
		}	
			
			public void managepatient(String exp) {
				String act= list_lastone.getText();
				 if(act.equalsIgnoreCase(exp))
				 {
					 System.out.println(act+" Patient created successfully");
				 }
				 else
				 {
					 System.out.println(act+" Patient not created");
				 }
				
			}
			
		
}
