package admin_module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.excelutility;
import com.genericutilities.fileutility;
import com.genericutilities.javautility;
import com.genericutilities.webdriverutility;
import com.healthkart.objectrepository.adminHomePage;
import com.healthkart.objectrepository.adminLoginPage;

public class adminDeleteSpeclztn_pomobjtest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	
		 WebDriver driver; 
	       excelutility exutil = new excelutility();
	      fileutility futil = new fileutility();
	      javautility jutil = new javautility();
     webdriverutility webutil = new webdriverutility();
		 
     String url = futil.ReadDataFromPropertyFile("url"); 
     String un = futil.ReadDataFromPropertyFile("ad_un"); 
     String pwd = futil.ReadDataFromPropertyFile("ad_pwd"); 
     
     driver= new ChromeDriver();
     driver.get(url);
     
     webutil.maximizewindow(driver);
     webutil.waitforpageload(driver, 10);
	
     adminLoginPage adminLogin = new adminLoginPage(driver);
     adminLogin.loginAsAdmin(un, pwd);
     
     adminHomePage adminHome = new adminHomePage(driver);
     adminHome.admingotosplztnAndDelete();
     
     webutil.acceptAlert(driver);
     Thread.sleep(3000);
     
     
     adminHome.dltconfrimtnmsg();
     Thread.sleep(3000);
     adminLogin.logoutAsAdmin();	
		
		
		
		
		
		
		
		
		
		
		
		
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
//         driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
//		driver.findElement(By.xpath("//span[.=' Doctor Specialization ']")).click();
//		driver.findElement(By.xpath("(//table//tbody//tr)[last()]//div//a[2]")).click();
//		Alert alt= driver.switchTo().alert();
//		alt.accept();
//		Thread.sleep(3000);
//		
//		WebElement txt = driver.findElement(By.xpath("//p[.='data deleted !!								']"));
//		String fin=txt.getText();
//		System.out.println(fin);
//		
//		
//		 driver.findElement(By.xpath("//span[@class='username']")).click();
//	       Thread.sleep(2000);
//	       driver.findElement(By.xpath("(//ul[@class='dropdown-menu dropdown-dark']/li)[last()]")).click();
//	       Thread.sleep(2000);
//	       driver.close();
//	
	
	
}
}
