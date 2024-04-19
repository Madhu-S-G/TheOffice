package com.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class databaseutility {

	Connection con= null;
		
	public void connectingDB() throws SQLException {
	
		//register database
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//get connection for database
	 con = DriverManager.getConnection(Ipathconstant.DBurl, Ipathconstant.DBun, Ipathconstant.DBpwd);
		}
	
	
	 public void executeandgetdata(String query, int colIndex, String expData) throws SQLException
	 {
	// create statement
  Statement state = con.createStatement();
  
	//execute query/update query
  ResultSet result =  state.executeQuery(query);
  boolean flag= false;
  while(result.next())
  {
	   String actual = result.getString(colIndex);
			   if(actual.contains(expData));
	   {
		   flag=true;
		   break;
		   
	   }
  }
	   
	   if(flag)
	   {
		  System.out.println(); 
	   }
	   else
	   {
		   System.out.println();
	   }
  
 
	 }
	 
	    public void closedb() throws SQLException {
	//close db connection
	    con.close();
       }
}
