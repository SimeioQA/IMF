package com.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Common.Base;

public class Status  extends Base {

		
	    WebDriver driver;
		@FindBy(xpath="//*[@id='ADMIN']")
		private static WebElement clickAdmin;
		
		public Status(WebDriver driver) {
			 this.driver = driver;
		        PageFactory.initElements(driver, this);
			
		}
	
	

public boolean checkEmpStatus(String TestUser) throws Exception
{
	
	
	return false;
	
}


}
