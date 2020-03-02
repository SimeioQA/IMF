package com.Demo;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Common.Base;

public class CreateIdentities extends Base {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='ADMIN']")
	private static WebElement clickAdmin;
	
	@FindBy(xpath="//*[@id='irep']")
	private static WebElement clickIdentityRepositiory;
	
	@FindBy(xpath="//*[@id='users']")
	private static WebElement clickUserlist;
	
	@FindBy(xpath="//*[@id='dtsearch_usersList']")
	private static WebElement ClickSearch;
	
	@FindBy(xpath="//*[@id='dtsearch_usersList']")
	private static WebElement SendUser;
	
	@FindBy(xpath="//*[@id=\'usersList\']/tbody/tr[1]/td[1]/a")
	private static WebElement ClickUser;
	
	@FindBy(xpath="//*[@id='employeeType']")
	private static WebElement ActualEmpType;
	
	
	/*@FindBy(xpath="//*[@type='submit']")
	private static  WebElement loginBtn;
	*/
	public CreateIdentities(WebDriver driver) {
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
		
	}
	
	public boolean checkEmpType(String ExtepectedEmpType,String sshot,String TestUser) throws Exception
	{
		reportPass("Home Page",sshot);
		String ActualEmployeeType;
		clickAdmin.click();
		reportPass("Clicked on Admin tab",sshot);
		clickIdentityRepositiory.click();
		reportPass("Clicked on Identity Repository tab",sshot);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		clickUserlist.click();
		reportPass("Clicked on User List",sshot);
		ClickSearch.click();
		
		SendUser.sendKeys(TestUser);
		reportPass("Enter username to test",sshot);
		wait(2);
		SendUser.sendKeys(Keys.ENTER);
	
		System.out.println("Finding the user" );//+ TestUser);
        wait(2);
       
        List<WebElement> columVal =  driver.findElements(By.xpath("//*[@class='tooltip1']"));               
        System.out.println("Size of the contents in the column state is : " + columVal.size());
        for(int i=0;i<columVal.size();i++){
            String twoVal = columVal.get(i).getText();
            System.out.println(twoVal);
         if(twoVal.equalsIgnoreCase(TestUser))
         {
                     System.out.println("Find the element" + twoVal );
                          }
        }
       
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        reportPass("Searched User",sshot);
        ClickUser.click();
       
        
        
		reportPass("Searched User",sshot);
		/*
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		reportPass("Searched User",sshot);
		ClickUser.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		reportPass("User Details",sshot);*/
		//Vaildation of employee type
	//	wait(2);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Before Scroll");
		reportPass("User Details",sshot);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		System.out.println("After Scroll");
		
	   reportPass("Scroll Down",sshot);
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   
		ActualEmployeeType=ActualEmpType.getAttribute("value");
		System.out.println("Actual Employee Type is  "+ActualEmployeeType);
		System.out.println("Expected Employee Type is  "+ExtepectedEmpType);
		
		if(ActualEmployeeType.equals(ExtepectedEmpType))
		{
			reportPass("Actual and Expected Employee Type are Same",sshot);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");
			reportPass("User Details",sshot);
			return true;
		}
		else
		{
			reportFailure("Actual and Expected Employee Type are not Same",sshot);
			
			return false;
		}
		
		
		
		//ActualEmpType.getText()
		
		//assertEquals("Verify Employee Type",ExtepectedEmpType, ActualEmployeeType);

	//	reportPass("Employee type is valid",sshot);
		//System.out.println("Employee type is valid");
	//if()
		
		
  	//if(driver.getCurrentUrl().equalsIgnoreCase("http://192.168.14.152:9080/ECM/users/list"))
		/*{
			try {
				reportPass("List of users display successfully",sshot);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return true;
			
		}*/
		/*else
		{
			reportFailure("List of users are not getting display",sshot);
			//return false;	
		}*/		
	}	

}