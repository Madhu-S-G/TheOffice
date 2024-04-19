package doctor_module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutilities.databaseutility;
import com.genericutilities.excelutility;
import com.genericutilities.fileutility;
import com.genericutilities.javautility;
import com.genericutilities.webdriverutility;

public class createPatient_usinggenericutilTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		 WebDriver driver; 
	       excelutility exutil = new excelutility();
	      fileutility futil = new fileutility();
	      javautility jutil = new javautility();
   webdriverutility webutil = new webdriverutility();
		 
       String url = futil.ReadDataFromPropertyFile("url"); 
       String un = futil.ReadDataFromPropertyFile("dr_username"); 
       String pwd = futil.ReadDataFromPropertyFile("dr_password"); 
       
       driver= new ChromeDriver();
       driver.get(url);
       
       webutil.maximizewindow(driver);
       webutil.waitforpageload(driver, 10);
   
       driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
       driver.findElement(By.name("username")).sendKeys(un);          
       driver.findElement(By.name("password")).sendKeys(pwd);
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       Thread.sleep(3000);
       
       driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[.=' Patients ']")).click();
       driver.findElement(By.xpath("//span[.=' Add Patient']")).click();
       Thread.sleep(3000);

       String pn= exutil.ReadSingleDatafromExcel("Doctor", 0, 1);
       String cn= exutil.ReadSingleDatafromExcel("Doctor", 1, 1);
       String mid= exutil.ReadSingleDatafromExcel("Doctor", 2, 1);
       String gen= exutil.ReadSingleDatafromExcel("Doctor", 3, 1);
       String add= exutil.ReadSingleDatafromExcel("Doctor", 4, 1);
       String age= exutil.ReadSingleDatafromExcel("Doctor", 5, 1);
       String mh= exutil.ReadSingleDatafromExcel("Doctor", 6, 1);
       
       driver.findElement(By.name("patname")).sendKeys(pn);
       driver.findElement(By.name("patcontact")).sendKeys(cn);
       driver.findElement(By.name("patemail")).sendKeys(mid);
       driver.findElement(By.name("pataddress")).sendKeys(add);
       driver.findElement(By.name("patage")).sendKeys(age);
       driver.findElement(By.name("medhis")).sendKeys(mh);
       Thread.sleep(3000);
       
       if(gen.contains("male")) 
       {
        driver.findElement(By.xpath("//label[@for='rg-male']")).click();
       }
       else if(gen.contains("female"))
       {
        driver.findElement(By.xpath("//input[@id='rg-female']")).click();
       }

       Thread.sleep(3000);
       driver.findElement(By.name("submit")).click();
       
       driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[.=' Patients ']")).click();
     driver.findElement(By.xpath("//span[.=' Manage Patient ']")).click();
     Thread.sleep(3000);
        
     WebElement txt = driver.findElement(By.xpath("(//tbody/tr)[last()]"));
       
     System.out.println("TestCase Executed Successfully");
     driver.findElement(By.xpath("//span[@class='username']")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("(//ul[@class='dropdown-menu dropdown-dark']/li)[last()]")).click();
     Thread.sleep(2000);
     driver.close();
       
	} 
}
       
//			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		       Properties pobj = new Properties();
//		          pobj.load(fis);
//   		      String url = pobj.getProperty("url");
//		          String un = pobj.getProperty("dr_username");
//		          String pwd = pobj.getProperty("dr_password");
//		          String brow = pobj.getProperty("browser");		          
//		          System.out.println(url+" "+un+" "+pwd+" "+brow);
//
//                  driver= new ChromeDriver();
//		          driver.get(url);
//		          
//		          driver.manage().window().maximize();
//		          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		          driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
//		          driver.findElement(By.name("username")).sendKeys(un);          
//		          driver.findElement(By.name("password")).sendKeys(pwd);
//		          driver.findElement(By.xpath("//button[@type='submit']")).click();
//		          Thread.sleep(3000);
//
//		          driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[.=' Patients ']")).click();
//		          driver.findElement(By.xpath("//span[.=' Add Patient']")).click();
//		          Thread.sleep(3000);
//		          
//		          FileInputStream exc = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		      	Workbook wb = WorkbookFactory.create(exc);  //which exception it going to  handle? - filenotfounfException
//		      	Sheet sh = wb.getSheet("Doctor");   // it gives you IOException
//		      	int rowcount= sh.getLastRowNum();
//		      	int cellcount = sh.getRow(0).getLastCellNum();
//		      	
//		        /*     	String pn,cn,mid,gen,add,age,mh;
//		      	String arr[]= {};     	
//		      	for(int i=0;i<=rowcount;i++){      		
//		      			String  value = sh.getRow(i).getCell(1).getStringCellValue();
//		      			for(int j=0;j<arr.length;j++)
//		      			{
//		      				arr[j]=value;
//		      			}      	}                     */
//		      	
//		      	String pn= sh.getRow(0).getCell(1).getStringCellValue();
//		      	String cn= sh.getRow(1).getCell(1).getStringCellValue();
//		      	String mid= sh.getRow(2).getCell(1).getStringCellValue();
//		      	String gen= sh.getRow(3).getCell(1).getStringCellValue();
//		      	String add= sh.getRow(4).getCell(1).getStringCellValue();
//		      	String age= sh.getRow(5).getCell(1).getStringCellValue();
//		      	String mh= sh.getRow(6).getCell(1).getStringCellValue();       
//		          
//		          driver.findElement(By.name("patname")).sendKeys(pn);
//		          driver.findElement(By.name("patcontact")).sendKeys(cn);
//		          driver.findElement(By.name("patemail")).sendKeys(mid);
//		          driver.findElement(By.name("pataddress")).sendKeys(add);
//		          driver.findElement(By.name("patage")).sendKeys(age);
//		          driver.findElement(By.name("medhis")).sendKeys(mh);
//		          Thread.sleep(3000);
//		          System.out.println(gen);
//		         if(gen.contains("male")) 
//		         {
//		          driver.findElement(By.xpath("//label[@for='rg-male']")).click();
//		         }
//		         else if(gen.contains("female"))
//		         {
//		          driver.findElement(By.xpath("//input[@id='rg-female']")).click();
//		         }
//		          
//		         Thread.sleep(3000);
//		         driver.findElement(By.name("submit")).click();
//		         
//		         driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[.=' Patients ']")).click();
//		       driver.findElement(By.xpath("//span[.=' Manage Patient ']")).click();
//		       Thread.sleep(3000);
//		          
//		       WebElement txt = driver.findElement(By.xpath("(//tbody/tr)[last()]"));
////		       System.out.println(txt.getText());
////		       if(pn.contains(txt.getText()))
////		    		   {
////		    	          System.out.println("TestCase Executed Successfully");
////		    		   }
////		       else
////		       {
////		    	   System.out.println("TestCase is not Executed");
////		       }
//		       
//		       System.out.println("TestCase Executed Successfully");
//		       driver.findElement(By.xpath("//span[@class='username']")).click();
//		       Thread.sleep(2000);
//		       driver.findElement(By.xpath("(//ul[@class='dropdown-menu dropdown-dark']/li)[last()]")).click();
//		       Thread.sleep(2000);
//		       wb.close();
//		       driver.close();
	

