package com.genericutilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.healthkart.objectrepository.adminLoginPage;
import com.healthkart.objectrepository.doctorLoginpage;

public class DrBASECLASS {

	public databaseutility dbutil = new databaseutility();
	public  excelutility exutil = new excelutility();
    public  fileutility futil = new fileutility();
    public javautility jutil = new javautility();
    public webdriverutility webutil = new webdriverutility();
    public static  WebDriver driver;
    public static WebDriver sdriver;

	@BeforeSuite
	public void connect_toDB() throws SQLException {
		dbutil.connectingDB();
		Reporter.log("connected to db");
	}

	
//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchbrowser() throws Exception {
		String browser=futil.ReadDataFromPropertyFile("browser");
//		String browser=System.getProperty("browser");       //for maven [mvn -Dbrowser]
//		String url=System.getProperty("url");                //for maven [mvn -Durl]
		String url=futil.ReadDataFromPropertyFile("url");
		Thread.sleep(3000);
		if(browser.contains("firefox")) {
			Thread.sleep(2000);
			driver=new FirefoxDriver();
			
			Reporter.log("this is firefox");
		}

		else if(browser.contains("chrome")) {
			Thread.sleep(2000);
			driver=new ChromeDriver();
			
			Reporter.log("this is chrome");
		}
		else if(browser.contains("edge")) {
			driver=new EdgeDriver();
			Thread.sleep(8000);
			Reporter.log("this is edge");
		}
		sdriver= driver;
		webutil.maximizewindow(driver);
		driver.get(url);
		webutil.waitforpageload(driver, 10);

	}

	
	@BeforeMethod(alwaysRun = true)
	public void loginAsDr() throws Exception {
		String un=futil.ReadDataFromPropertyFile("dr_username");
		String pw=futil.ReadDataFromPropertyFile("dr_password");
		doctorLoginpage doctorLogint = new doctorLoginpage(driver);
		 doctorLogint.loginAsDoctor(un, pw);
		Reporter.log("logged in", true);
	}

	@AfterMethod(alwaysRun = true)
	public void logoutAsDr() {
		doctorLoginpage doctorLogint = new doctorLoginpage(driver);
		doctorLogint.logoutAsDoctor();
		Reporter.log("logged out");
	}

	@AfterClass(alwaysRun = true)

	public void closebrowser() {
		driver.quit();
		Reporter.log("browser has been closed");
	}

	@AfterSuite
	public void closedb() throws SQLException {
		dbutil.closedb();
		Reporter.log("DB is shut down");
	
	
	}	
}
