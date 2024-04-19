package admin_module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericutilities.BASECLASS;
import com.genericutilities.excelutility;
import com.genericutilities.fileutility;
import com.healthkart.objectrepository.adminHomePage;
import com.healthkart.objectrepository.adminLoginPage;

@Listeners(com.genericutilities.ListImpClass.class)
public class adminFetchReports_pom_util_Test extends BASECLASS{
	
	@Test  (retryAnalyzer = com.genericutilities.RetryImplClass.class  /*,groups = "regression"*/) 
	public void script1main() throws Exception  
//	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub

//		 WebDriver driver; 
//	      fileutility futil = new fileutility();
	      excelutility executil = new excelutility();
//	      
//		
//	String url=futil.ReadDataFromPropertyFile("url");
//	String un=futil.ReadDataFromPropertyFile("ad_un");
//	String pwd=futil.ReadDataFromPropertyFile("ad_pwd");
//	String mob=futil.ReadDataFromPropertyFile("mobile");
	
//	driver= new ChromeDriver();
//	driver.get(url);
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));	
		
//	adminLoginPage adminLogint = new adminLoginPage(driver);
//	adminLogint.loginAsAdmin(un, pwd);	
		
	String frmdate = executil.ReadSingleDatafromExcel("Doctor", 10, 1);
	String todate = executil.ReadSingleDatafromExcel("Doctor", 11, 1);
		
	adminHomePage adminHomet1 = new adminHomePage(driver);
	adminHomet1.gotoreportsPage();
//	Assert.fail();
	adminHomet1.reportPage(frmdate, todate);
	
	
	Thread.sleep(5000);
//	adminLogint.logoutAsAdmin();

	}
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		FileInputStream fios = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties obj = new Properties();
//		obj.load(fios);
//		String url=obj.getProperty("url");
//		String un=obj.getProperty("ad_un");
//		String pwd=obj.getProperty("ad_pwd");
//		
//		WebDriver driver= new ChromeDriver();
//		driver.get(url);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		 driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
//         driver.findElement(By.name("username")).sendKeys(un);          
//         driver.findElement(By.name("password")).sendKeys(pwd);
//         driver.findElement(By.xpath("//button[@type='submit']")).click();
//         Thread.sleep(3000);
//		
//         driver.findElement(By.xpath("//span[.=' Reports ']")).click();
//         Thread.sleep(2000);
// 		driver.findElement(By.xpath("//span[.='B/w dates reports ']")).click();
// 		WebElement ele = driver.findElement(By.name("fromdate"));
// 	ele.click();
// 	ele.sendKeys("20/03/2024");
// 	WebElement ele1 = driver.findElement(By.name("todate"));
// 	ele1.click();
// 	ele1.sendKeys("03/04/2024");
// 	driver.findElement(By.name("submit")).click();
// 	 WebElement el = driver.findElement(By.xpath("//div[@class='col-md-12']/h5"));	
// 	System.out.println(el.getText());
// 	
// 	Thread.sleep(1000);
// 	driver.close();
//	}
//}
