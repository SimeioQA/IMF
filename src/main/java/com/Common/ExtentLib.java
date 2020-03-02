package com.Common;
import java.io.File;
import java.util.Date;

import org.testng.Reporter;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.Common.Base;
import com.Common.ExtentLib;

public class ExtentLib {
	private static ExtentReports extent;
	public static String resfileName;
	public static ExtentTest test;
	public static ExtentReports rep;
	public static Base Base=new Base();
	
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			Date d=new Date();
			//System.out.println("Current timestamp: "+d.toString());
			resfileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent= new ExtentReports(System.getProperty("user.dir")+"\\Report\\"+resfileName, true, DisplayOrder.NEWEST_FIRST);
			//extent= new ExtentReports("myreport.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\ReportsConfig.xml"));
			extent.addSystemInfo("Selenium Version", "3.4.0").addSystemInfo("Environment", "QA");
			//System.out.println("The file name is : " + resfileName);
			
		}
		return extent;
	}
	
	public void createExtentReport(String TestId,String TestScenario, String jobPostition) throws InterruptedException {
		rep=ExtentLib.getInstance();	
		//System.out.println("Starting with testing");
		test=rep.startTest(TestId+"-"+TestScenario+"-"+jobPostition);
		Thread.sleep(3000);
		//System.out.println("Flush the report" + test);
		rep.flush();
		Thread.sleep(3000);
		//System.out.println("Seems issue here");
		//
	}
	
	public static void SaveExtentReport() {
		rep.endTest(test);
		rep.flush();
		
	}
	
	
	public void reportPass(String msg,String sshot) throws Exception {
		if(sshot.equals("Yes"))
		{
		test.log(LogStatus.PASS,test.addScreenCapture(Base.getScreenhot(sshot)),msg);
		}
		else
		{
		test.log(LogStatus.PASS,msg);
		}
		rep.flush();
		Reporter.log(msg, true);
	}
	
	public void reportFailure(String msg,String sshot) throws Exception {
		if(sshot.equals("Yes"))
		{
		test.log(LogStatus.FAIL,test.addScreenCapture(Base.getScreenhot(sshot)), msg);
		}
		else
		{
		test.log(LogStatus.FAIL,msg);
		}
		rep.flush();
		Reporter.log(msg, true);
	}
	
	//Rudra updated code as suggested by Aru
	public void reportIncomplete(String msg,String sshot) throws Exception {
		if(sshot.equals("Yes"))
		{
		test.log(LogStatus.SKIP,test.addScreenCapture(Base.getScreenhot(sshot)), msg);
		}
		else
		{
		test.log(LogStatus.SKIP,msg);
		}
		rep.flush();
		Reporter.log(msg, true);
	}
	
	public void reportInfo(String msg,String sshot) throws Exception {
		test.log(LogStatus.INFO,test.addScreenCapture(Base.getScreenhot(sshot)), msg);
		rep.flush();
		Reporter.log(msg, true);
	}
	
	public void printActionLog(String logLevel,String msg,String sshot) throws Exception {
		switch(logLevel) {
		case "PASS":
			reportPass(msg,sshot);
			break;
		case "FAIL":
			reportFailure(msg,sshot);
			break;
		default:
			reportInfo(msg,sshot);
			break;
		
		}
		
		System.out.println("  [INFO] "  +logLevel+ ":" + msg);
		
	}

}

