package com.Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.runtime.Timeout;
import gherkin.formatter.model.Row;


//URL-http://192.168.14.152:9080/ECM
//login-admin,password-Simeio@123

public class CreateIdentity {
	
	//System.setProperty("webdriver.chrome.driver","C://Users//nchaudhari//Desktop//chromedriver.exe");
	static String usr= null;
	  static String  psw = null;


	    public static void main(String abc[]) throws IOException
	    {
	    	String val = null;
	    	
	    	//C:\Users\sadki\Desktop\Project_Automation1\geckodriver-v0.26.0-win64
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\nchaudhari\\Desktop\\geckodriver.exe");
	    	
	    	 //Create an object of File class to open xlsx file

	        File file =    new File("C:\\Users\\nchaudhari\\eclipse-workspace\\IMF\\src\\main\\InputExcel\\Input_GOM.xlsx");

	        //Create an object of FileInputStream class to read excel file

	        FileInputStream inputStream = new FileInputStream(file);

	        Workbook wb = new XSSFWorkbook(inputStream);
	        Sheet sh = wb.getSheet("User Data WF");

	        //Find number of rows in excel file
	        
	        
	        String d1;
	        
            System.out.println("Data at first cell");
           d1=sh.getRow(0).getCell(0).getStringCellValue();
           System.out.println(d1);
           
           System.out.println("Read Complete Excel");
	       //rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
           
           for (int i = 0; i <5; i++)
           {
        	   System.out.println();
        	   for (int j = 0; j <5; j++) {
	    		   
 	    		   val= sh.getRow(i).getCell(j).getStringCellValue();
 	    		   System.out.print(val+"|| ");
 	    		   
        	   }
        	   
           }
           
	       
	       for (int k = 0;k<5;k++)
	       {  	    	   for (int m= 0;m<5;m++) {
	    		   
	    		  val=sh.getRow(k).getCell(m).getStringCellValue();
	    		  
				if(sh.getRow(k).getCell(m).getStringCellValue().contains("admin")) {
	    		  usr=sh.getRow(k).getCell(m).getStringCellValue();
	    		  }
				 if(sh.getRow(k).getCell(m).getStringCellValue().contains("@123")) {
	    	      psw=sh.getRow(k).getCell(m).getStringCellValue();
	    	      
				 }
	    	       if(val.contains("Yes")) {
	    	    	
	    	    	WebDriver driver = new FirefoxDriver();
	    	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    	        driver.get("http://192.168.14.152:9080/ECM/");  
	    	        driver.manage().window().maximize();
	    	           
	    	        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(usr);
	    	    		     
	    	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(psw);
	    	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    	    	//driver.findElement(By.xpath("//*[@type='submit']")).click();
	    	    
	    	        //driver.findElement(By.xpath(".//*[@button='submit']")).click();
	    	        ////button[@type='submit']
	    	        driver.findElement(By.xpath("//*[@type='submit']")).click();
	    	        
	    	        driver.findElement(By.xpath("")).click();
	    	        
	    	        //button[@type='submit']
	    	        //*[@button='submit']
	    	    }	   
	    	   }
	       }
	       
	    }
}
	    