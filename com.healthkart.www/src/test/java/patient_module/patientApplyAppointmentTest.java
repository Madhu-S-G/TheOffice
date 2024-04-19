package patient_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class patientApplyAppointmentTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		   Properties pobj = new Properties();
		   pobj.load(fis);
		   
		   String url=pobj.getProperty("url");
		   String un=pobj.getProperty("p_un");
		   String pwd=pobj.getProperty("p_pwd");
		   driver= new ChromeDriver();
		   driver.get(url);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   
		   driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
	          driver.findElement(By.name("username")).sendKeys(un);          
	          driver.findElement(By.name("password")).sendKeys(pwd);
	          driver.findElement(By.xpath("//button[@type='submit']")).click();
	          Thread.sleep(3000);
		   driver.findElement(By.xpath("//div[@class='panel-body']//a[@href='book-appointment.php']")).click();
		   
		  FileInputStream exce = new  FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		   Workbook wb = WorkbookFactory.create(exce);
		        Sheet sh = wb.getSheet("Doctor");
		   
		    	String spdd= sh.getRow(7).getCell(1).getStringCellValue();
		      	String drdd= sh.getRow(8).getCell(1).getStringCellValue();
		      	String time= sh.getRow(9).getCell(1).getStringCellValue();
		     
		      	WebElement ab = driver.findElement(By.name("Doctorspecialization"));
		      	ab.click();
		      	Select s= new Select(ab);
		            s.selectByVisibleText(spdd);

	         WebElement abc = driver.findElement(By.name("doctor"));
	     	ab.click();
	    	Select se= new Select(abc);
          se.selectByVisibleText(drdd);
			            
			   driver.findElement(By.name("appdate")).click();         
       driver.findElement(By.xpath("//tbody//tr//td[.='30']")).click();
		   
       WebElement xy = driver.findElement(By.name("apptime"));
		   xy.clear();
		   xy.sendKeys(time);
		   
		   driver.findElement(By.name("submit")).click();
	         Thread.sleep(2000);
	         Alert alt = driver.switchTo().alert();
	         alt.accept();
	         
	         Thread.sleep(3000);
	      driver.findElement(By.xpath("//a[@href='appointment-history.php']")).click();   
	       WebElement sbc = driver.findElement(By.xpath("(//table//tbody//tr)[last()]")); 
		        String txt = sbc.getText();
//		        System.out.println(txt);
		        
		        if(txt.contains(drdd))
		        {
		        	System.out.println(" Appointment done and verified successfully!!!");
		        }
		        
		       driver.findElement(By.xpath("//span[@class='username']")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("(//ul[@class='dropdown-menu dropdown-dark']/li)[last()]")).click();
		       Thread.sleep(2000);
		       
		       wb.close();
		       driver.close();
		      
		        
		        
		        
		        
		        
	}

}
