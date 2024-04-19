package admin_module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericutilities.excelutility;
import com.genericutilities.fileutility;
import com.genericutilities.javautility;
import com.genericutilities.webdriverutility;
import com.healthkart.objectrepository.adminHomePage;
import com.healthkart.objectrepository.adminLoginPage;

public class updateDrProfile_util_pom {
@Test(groups = "regression")
public void script2main() throws Exception
	//public static void main(String[] args) throws Exception
{
	
		 WebDriver driver; 
	     fileutility futil = new fileutility();
		
	String url=futil.ReadDataFromPropertyFile("url");
	String un=futil.ReadDataFromPropertyFile("ad_un");
	String pwd=futil.ReadDataFromPropertyFile("ad_pwd");
	String mob=futil.ReadDataFromPropertyFile("mobile");
	
	driver= new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));	
		
	adminLoginPage adminLogint = new adminLoginPage(driver);
	adminLogint.loginAsAdmin(un, pwd);
		
	adminHomePage adminHomet = new adminHomePage(driver);
	adminHomet.admin_manageDr(mob);
	}
@Test
public void script2sub() throws Exception
//public static void main(String[] args) throws Exception
{
	// TODO Auto-generated method stub

	 WebDriver driver; 
      fileutility futil = new fileutility();
      excelutility executil = new excelutility();
      
	
String url=futil.ReadDataFromPropertyFile("url");
String un=futil.ReadDataFromPropertyFile("ad_un");
String pwd=futil.ReadDataFromPropertyFile("ad_pwd");
//String mob=futil.ReadDataFromPropertyFile("mobile");

driver= new ChromeDriver();
driver.get(url);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));	
	
adminLoginPage adminLogint = new adminLoginPage(driver);
adminLogint.loginAsAdmin(un, pwd);	
	
String frmdate = executil.ReadSingleDatafromExcel("Doctor", 10, 1);
String todate = executil.ReadSingleDatafromExcel("Doctor", 11, 1);
	
adminHomePage adminHomet = new adminHomePage(driver);
adminHomet.gotoreportsPage();
adminHomet.reportPage(frmdate, todate);
	
Thread.sleep(5000);
adminLogint.logoutAsAdmin();

}
}		
	
		
		
		
		
		
	
//	FileInputStream fios = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//	Properties obj = new Properties();
//	obj.load(fios);
//	String url=obj.getProperty("url");
//	String un=obj.getProperty("ad_un");
//	String pwd=obj.getProperty("ad_pwd");
//	String mob=obj.getProperty("mobile");
//	
//	WebDriver driver= new ChromeDriver();
//	driver.get(url);
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//	 driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
//     driver.findElement(By.name("username")).sendKeys(un);          
//     driver.findElement(By.name("password")).sendKeys(pwd);
//     driver.findElement(By.xpath("//button[@type='submit']")).click();
//     Thread.sleep(3000);
//     
//     
//     driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
//     driver.findElement(By.xpath("//span[.=' Manage Doctors ']")).click();
//     Thread.sleep(3000);
//     driver.findElement(By.xpath("(//tbody//tr)[last()]//a[@tooltip='Edit']")).click();
//     Thread.sleep(3000);
//     WebElement x = driver.findElement(By.name("doccontact"));
//     x.click();
//     x.sendKeys(Keys.CONTROL+"A");
//     x.sendKeys(mob);
//     driver.findElement(By.name("submit")).click();
//	}}
