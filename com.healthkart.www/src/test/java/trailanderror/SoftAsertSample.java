package trailanderror;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsertSample {

	@Test
	public void sassert() {
		
		SoftAssert  sa =new SoftAssert();
		System.out.println(" ----> One <---- ");
		System.out.println(" ----> Two <---- ");
		sa.assertNotEquals("m","s");
		System.out.println(" ----> Three <---- ");
		sa.assertAll();
		
	}
	
	
	
	
	
	
	
}
