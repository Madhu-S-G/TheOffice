package com.healthkart.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminHomePage {

	@FindBy(xpath="//span[.=' Doctors ']") private WebElement  doctors;
	
	@FindBy(xpath="//span[.=' Doctor Specialization ']") private WebElement spclztnbtn;
	
	@FindBy(xpath="(//table//tbody//tr)[last()]//div//a[2]") private WebElement dltlstdctr; 
	
	@FindBy(xpath="//p[contains(.,'data deleted')]") 
	       private WebElement confrmtn_msg;
	
	@FindBy(xpath="//span[@class='username']") private WebElement  un_btn;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu dropdown-dark']/li)[last()]") private WebElement  logoutbtn;
	
	@FindBy(xpath="//span[.=' Manage Doctors ']") private WebElement mngDr;
	
	@FindBy(xpath = "(//tbody//tr)[last()]//a[@tooltip='Edit']") private WebElement last_DrEdit;
	
	@FindBy(name="doccontact") private WebElement mobile;
	
	@FindBy(name="submit") private WebElement submit;
	
	@FindBy(xpath ="//span[.=' Reports ']") private WebElement rprtbtn;
	
	@FindBy(xpath="//span[.='B/w dates reports ']") private WebElement betwRprtBtn;
	
	@FindBy(name="fromdate") private WebElement frmdate;
	
	@FindBy(name="todate") private WebElement todate;
	
	@FindBy(name="submit") private WebElement rprtsubmitbtn;
	
	@FindBy(xpath="//div[@class='col-md-12']/h5") private WebElement textofRprtPage;
	
	
	//Initialization
	public adminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	

			//Business libraries
			/**
			 * login to application with username and password and click on save btn
			 * @param username
			 * @param password
			 */
			public void admingotosplztnAndDelete()
			{  
				doctors.click();			
				spclztnbtn.click();	
				dltlstdctr.click();
			}	
			
			public void admin_manageDr(String mob) throws InterruptedException
			{  Thread.sleep(3000);
				doctors.click();			
				mngDr.click();
				last_DrEdit.click();
				Thread.sleep(2000);
				mobile.click();
				mobile.sendKeys(Keys.CONTROL+"A");
				mobile.sendKeys(mob);
				submit.click();
			}	

			public void dltconfrimtnmsg() throws InterruptedException
			{ 
			Thread.sleep(3000);
				String act = confrmtn_msg.getText();
				Thread.sleep(3000);
//				System.out.println(act);
						if(act.contains("data deleted !!"))
						{
							System.out.println("Specializtn deleted and verified");
						}

						else
				{
					System.out.println("Specializtn not deleted");
				}
			}	
			
		public void gotoreportsPage()
		{
			rprtbtn.click();
			betwRprtBtn.click();
			
		}
			
			
		public void reportPage(String fr, String to) throws InterruptedException {
			frmdate.click();
			frmdate.sendKeys(fr);
			todate.click();
			todate.sendKeys(to);
			Thread.sleep(4000);
			rprtsubmitbtn.click();
			System.out.println(textofRprtPage.getText()+ " fetched successfully");
		}	
			
			
			
			
}
	
	
	

