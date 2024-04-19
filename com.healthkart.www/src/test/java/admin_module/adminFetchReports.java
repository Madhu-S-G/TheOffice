package admin_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class adminFetchReports {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		FileInputStream fios = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties obj = new Properties();
		obj.load(fios);
		String url=obj.getProperty("url");
		String un=obj.getProperty("ad_un");
		String pwd=obj.getProperty("ad_pwd");
		
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
         driver.findElement(By.name("username")).sendKeys(un);          
         driver.findElement(By.name("password")).sendKeys(pwd);
         driver.findElement(By.xpath("//button[@type='submit']")).click();
         Thread.sleep(3000);
		
         driver.findElement(By.xpath("//span[.=' Reports ']")).click();
         Thread.sleep(2000);
 		driver.findElement(By.xpath("//span[.='B/w dates reports ']")).click();
 		WebElement ele = driver.findElement(By.name("fromdate"));
 	ele.click();
 	ele.sendKeys("20/03/2024");
 	WebElement ele1 = driver.findElement(By.name("todate"));
 	ele1.click();
 	ele1.sendKeys("03/04/2024");
 	driver.findElement(By.name("submit")).click();
 	 WebElement el = driver.findElement(By.xpath("//div[@class='col-md-12']/h5"));	
 	System.out.println(el.getText());
 	
 	Thread.sleep(1000);
 	driver.close();
		
	}

}
