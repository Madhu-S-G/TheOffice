package trailanderror;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssert {
	
	String a;
	@Test
	 public void abc()
	 {	 
	 assertNull(a);
	 System.out.println("Yes its not having value");
	 }	
	
	
	@Test
	public void hassert()
	{		
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		String actTitle= driver.getTitle();
		String expTitle = "Hospital Management System";
		assertEquals(actTitle, expTitle);
		System.out.println("yes both are equal");
		System.out.println(actTitle);		
	}

	
	
}
