package trailanderror;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class dprovider {

//@Test	
//	public void  getrandom() 
//	{
//		Random r= new Random();
//		int random=r.nextInt(500);
//		System.out.println(random);	
//	}
	
	@Test
	public void edge() throws InterruptedException {
		WebDriver driver= new EdgeDriver();
		Thread.sleep(15000);
		driver.get("https://youtube.com");
	}
	
	
	
	
}
