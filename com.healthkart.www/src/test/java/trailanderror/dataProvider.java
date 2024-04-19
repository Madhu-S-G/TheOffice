package trailanderror;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	/** 
	 * in the DataProvider() we can give any name. and that name we can call in @test
	 * @return
	 */
	@DataProvider(name = "spider")
	public Object[][] data() {
		
		Object[][] obj= new Object[3][3];
		
		obj[0][0]="Qspider";
		obj[0][1]="Bengaluru";
		obj[0][2]="manual";
							
				
		obj[1][0]="Jspider";
		obj[1][1]="Hyderabad";
		obj[1][2]="JSSscript";
		

		obj[2][0]="PySpider";
		obj[2][1]="Mysore";
		obj[2][2]="python";
		
		return obj;
		
	}
	
	
	@Test(dataProvider = "spider")
	public void getData(String org, String loc, String course)
	{
		System.out.println(org + "  "+ loc+"  "+course);
	}
	
}
