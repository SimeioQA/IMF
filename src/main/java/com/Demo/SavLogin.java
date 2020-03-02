package com.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Common.Base;

public class SavLogin extends Base {
	
WebDriver driver;
	
	//driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
	// driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Simeio@123");
	//  driver.findElement(By.xpath("//*[@type='submit']")).click();
	
	@FindBy(xpath="//*[@id='username']")
	private static WebElement userName;
	
	@FindBy(xpath="//*[@type='password']")
	 private static WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	private static  WebElement loginBtn;
	
	/*@FindBy(xpath="//*[@id='ADMIN']")
	private static WebElement clickAdmin;
	
	@FindBy(xpath="//*[@id='irep']/a/span[2]")
	private static WebElement clickIdentityRepositiory;
	
	@FindBy(xpath="//*[@id='users']")
	private static WebElement clickUserlist;
	*/
	@FindBy(xpath="//div[@class='alert alert-danger']/span")
	private static WebElement errorMsg;
	 
	public SavLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public boolean loginSAM(String uName,String pWord,String sshot) throws Exception
	{
		//reportInfo("Trying to Login with: " +uName);
		userName.sendKeys(uName);
		password.sendKeys(pWord);
		reportPass("Login Page",sshot);
		loginBtn.click();
		
	
		if(driver.getCurrentUrl().equalsIgnoreCase("http://192.168.14.152:9080/ECM/workflowmanagement/requesthome?menu=1"))
		{
			reportPass("Login to application is sucessfull",sshot);
			return true;
			
		}
		else
		{
			reportFailure("Login to application is not sucessfull",sshot);
			return false;	
		}
		
		
		
	}
	
	
	
	
		
	
		
	}
