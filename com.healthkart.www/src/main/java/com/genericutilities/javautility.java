package com.genericutilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class javautility {
	
	public int getrandom() 
	{
		Random r= new Random();
		int random=r.nextInt();
		return random;		
	}
	
	public String getsystemdate()
	{
		     Date dt = new Date();
		     String date= dt.toString();
		     return date;
	}
	
	public String getsystemdateInformat() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		    Date dt = new Date();
		    String sysdateInfromat= dateformat.format(dt);
		    return sysdateInfromat;
		}
	
}
