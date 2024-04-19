package com.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class fileutility {

	
	/**
	 * This method is used to return value of key from propertyFile
	 * @param key
	 * @return value
	 * @throws Exception
	 */
     public String ReadDataFromPropertyFile(String key) throws Exception
     {
    	FileInputStream fi = new FileInputStream(Ipathconstant.FilePath);
    	            Properties pobj =  new Properties();
    	            pobj.load(fi);
    	          String value = pobj.getProperty(key);
    	            return value;
     }
     
     /**
      * This method is used to store  key and values into  propertyFile
      * @param key
      * @param value
      * @return
      * @throws Throwable
      */
     public void  InsertDataIntoPropertyFile(String key,String value , String commentvalue) throws Throwable
     {
    	 FileInputStream fi = new FileInputStream(Ipathconstant.FilePath);
         Properties pobj =  new Properties();
            
            pobj.setProperty(key, value);
                
          FileOutputStream fout = new FileOutputStream(Ipathconstant.FilePath);
                 pobj.store(fout, commentvalue);
                 pobj.load(fi);
			   	 
                 
            
         
     }
}
