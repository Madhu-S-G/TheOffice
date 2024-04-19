package doctor_module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericutilities.BASECLASS;
import com.genericutilities.DrBASECLASS;
import com.genericutilities.excelutility;
import com.genericutilities.fileutility;
import com.genericutilities.javautility;
import com.genericutilities.webdriverutility;
import com.healthkart.objectrepository.addpatientPage;
import com.healthkart.objectrepository.doctorHomePage;
import com.healthkart.objectrepository.doctorLoginpage;

public class pomDrcreatePatient extends DrBASECLASS {
	
	
@Test
	public void DrcreatePat() throws Exception
	{
//		WebDriver driver; 
     excelutility exutil = new excelutility();
//    fileutility futil = new fileutility();
//    javautility jutil = new javautility();
      webdriverutility webutil = new webdriverutility();
	 
// String url = futil.ReadDataFromPropertyFile("url"); 
// String un = futil.ReadDataFromPropertyFile("dr_username"); 
// String pw = futil.ReadDataFromPropertyFile("dr_password"); 
// 
// driver= new ChromeDriver();
// driver.get(url);
// 
// webutil.maximizewindow(driver);
// webutil.waitforpageload(driver, 10);
  
// doctorLoginpage doctorLogint = new doctorLoginpage(driver);
// doctorLogint.loginAsDoctor(un, pw);
 
 doctorHomePage doctorHomet = new doctorHomePage(driver);
 doctorHomet.patdropdown1();
 
 webutil.waitforpageload(driver, 3);
 String pn= exutil.ReadSingleDatafromExcel("Doctor", 0, 1);
 String cn= exutil.ReadSingleDatafromExcel("Doctor", 1, 1);
 String mid= exutil.ReadSingleDatafromExcel("Doctor", 2, 1);
//String gen= exutil.ReadSingleDatafromExcel("Doctor", 3, 1);
String add= exutil.ReadSingleDatafromExcel("Doctor", 4, 1);
String age= exutil.ReadSingleDatafromExcel("Doctor", 5, 1);
String mh= exutil.ReadSingleDatafromExcel("Doctor", 6, 1);
 
webutil.waitforpageload(driver, 3);
addpatientPage addpatientt = new addpatientPage(driver); 
addpatientt.patientdetails(pn, cn, mid, add, age, mh);

doctorHomet.patdropdown2();
Thread.sleep(3000);
doctorHomet.managepatient(pn);
//doctorLogint.logoutAsDoctor();

driver.close();
	}
	


//Im just Doing Changes go throouh it
         public void abcd() {
        	 System.out.println(" Void ");
         }

}

/////////////////////////////////////////////////////////////////////////////
// driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
// driver.findElement(By.name("username")).sendKeys(un);          
// driver.findElement(By.name("password")).sendKeys(pwd);
// driver.findElement(By.xpath("//button[@type='submit']")).click();
// Thread.sleep(3000);
 
// driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[.=' Patients ']")).click();
// driver.findElement(By.xpath("//span[.=' Add Patient']")).click();
// Thread.sleep(3000);
//
// String pn= exutil.ReadSingleDatafromExcel("Doctor", 0, 1);
// String cn= exutil.ReadSingleDatafromExcel("Doctor", 1, 1);
// String mid= exutil.ReadSingleDatafromExcel("Doctor", 2, 1);
// String gen= exutil.ReadSingleDatafromExcel("Doctor", 3, 1);
// String add= exutil.ReadSingleDatafromExcel("Doctor", 4, 1);
// String age= exutil.ReadSingleDatafromExcel("Doctor", 5, 1);
// String mh= exutil.ReadSingleDatafromExcel("Doctor", 6, 1);
// 
// driver.findElement(By.name("patname")).sendKeys(pn);
// driver.findElement(By.name("patcontact")).sendKeys(cn);
// driver.findElement(By.name("patemail")).sendKeys(mid);
// driver.findElement(By.name("pataddress")).sendKeys(add);
// driver.findElement(By.name("patage")).sendKeys(age);
// driver.findElement(By.name("medhis")).sendKeys(mh);
// Thread.sleep(3000);
// 
// if(gen.contains("male")) 
// {
//  driver.findElement(By.xpath("//label[@for='rg-male']")).click();
// }
// else if(gen.contains("female"))
// {
//  driver.findElement(By.xpath("//input[@id='rg-female']")).click();
// }
//
// Thread.sleep(3000);
// driver.findElement(By.name("submit")).click();
// 
// driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[.=' Patients ']")).click();
//driver.findElement(By.xpath("//span[.=' Manage Patient ']")).click();
//Thread.sleep(3000);
//  
//WebElement txt = driver.findElement(By.xpath("(//tbody/tr)[last()]"));
// 
//System.out.println("TestCase Executed Successfully");
//driver.findElement(By.xpath("//span[@class='username']")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("(//ul[@class='dropdown-menu dropdown-dark']/li)[last()]")).click();
//Thread.sleep(2000);
//driver.close();
//}
//	}
	

