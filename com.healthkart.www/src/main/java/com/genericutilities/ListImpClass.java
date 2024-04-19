package com.genericutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImpClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log("execution starts from here", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		test.log(Status.PASS, methodname);
		Reporter.log(methodname+"---> executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		try {
			
			 String screenshot =webdriverutility.getscreenshot(BASECLASS.sdriver, methodname);
			 test.log(Status.FAIL, methodname+"--> failed");
			 test.log(Status.FAIL, result.getThrowable());
			 test.addScreenCaptureFromPath(screenshot);
			 Reporter.log(methodname+"---> Failed");
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"--> skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodname+"--> Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
	ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("HealthKart");
		htmlreport.config().setReportName("SDET-55");
		htmlreport.config().setTheme(Theme.STANDARD);
		
		 report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-platform", "Windows");
		report.setSystemInfo("Base-browser", "chrome");
		report.setSystemInfo("Base-url", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Madhu");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
