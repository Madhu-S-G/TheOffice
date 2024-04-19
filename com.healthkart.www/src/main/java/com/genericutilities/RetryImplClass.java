package com.genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplClass implements IRetryAnalyzer {
	int lowercount = 0;
	int uppercount = 3;

	
/* "retry(ITestResult result)" in this  ITestResult is built in  interface which holds results of 
 * testscripts  (ex=pass,fail,skipt) temporarily in ref variable called  result 	  */
	
	
	@Override
	public boolean retry(ITestResult result) {
	if(lowercount<uppercount) {
		lowercount++;
		return true;
	}
		return false;
	}

}
