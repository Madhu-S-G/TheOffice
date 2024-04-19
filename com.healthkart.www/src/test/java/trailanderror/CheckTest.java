package trailanderror;

import org.testng.annotations.Test;

public class CheckTest {

	@Test(dependsOnMethods = "ty")
	public void qsp() 
	{
		
		System.out.println(" ----qsp---- ");
	}
	
	@Test
	public void ty()
	{
		
		System.out.println(" ----TY---- ");
	}
	
	@Test
	public void student()
	{
		System.out.println(" ----Studying---- ");
	}
	
	@Test
	public void parents()
	{
		System.out.println(" -----parents----- ");
	}
	
	
}
