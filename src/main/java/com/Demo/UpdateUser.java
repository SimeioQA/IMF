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

public class UpdateUser extends Base {

	WebDriver driver;
	@FindBy(xpath = "//*[@id='ADMIN']")
	private static WebElement clickAdmin;

	@FindBy(xpath = "//*[@id='irep']")
	private static WebElement clickIdentityRepositiory;

	@FindBy(xpath = "//*[@id='users']")
	private static WebElement clickUserlist;

	@FindBy(xpath = "//*[@id='dtsearch_usersList']")
	private static WebElement ClickSearch;

	@FindBy(xpath = "//*[@id='dtsearch_usersList']")
	private static WebElement SendUser;
	
	@FindBy(xpath = "//*[@id=\'usersList\']/tbody/tr[1]/td[1]/a")
	private static WebElement ClickUser;
	
	@FindBy(xpath = "//*[@id=\'phonenumber\']")
	private static WebElement PhoneNum;
	
	@FindBy(xpath = "//*[@id=\'street\']")
	private static WebElement Change_City;

	@FindBy(xpath = "//*[@id=\'firstname\']")
	private static WebElement F_name;

	@FindBy(xpath = "//*[@id=\'lastname\']")
	private static WebElement L_name;
	
	@FindBy(xpath = "//*[@id=\'middlename\']")
	private static WebElement M_name;
	
	@FindBy(xpath = "//*[@id=\'displayname\']")
	private static WebElement D_name;
	
	@FindBy(xpath = "//*[@id=\'street\']")
	private static WebElement u_street;
	
	@FindBy(xpath = "//*[@id=\'city\']")
	private static WebElement u_city;
	
	@FindBy(xpath = "//*[@id=\'email\']")
	private static WebElement u_email;
	
	@FindBy(xpath = "//*[@id=\'country\']")
	private static WebElement u_country;
	
	@FindBy(xpath = "//*[@id=\'state\']")
	private static WebElement u_state;
	
	@FindBy(xpath = "//*[@id=\'title\']")
	private static WebElement u_etitle;
	
	@FindBy(xpath = "//*[@id='departmentname']")
	private static WebElement u_depname;
	
	@FindBy(xpath = "//*[@id='departmentNumber']")
	private static WebElement u_depno;
	
	@FindBy(xpath = "//*[@id=\'employeeid\']")
	private static WebElement u_eid;
	
	@FindBy(xpath = "//*[@id=\'employeeType\']")
	private static WebElement u_type_e;
	
	
	/*
	 * @FindBy(xpath = "//*[@id='employeeType']") private static WebElement
	 * ActualEmpType;
	 * 
	 * @FindBy(xpath = "*[@id=\'s2id_statuskey\']/a") private static WebElement
	 * Status;
	 * 
	 * @FindBy(xpath = "//*[@id=\'updateuser\']/div[2]/a") private static WebElement
	 * Update;
	 * 
	 * @FindBy(xpath = "//*[@id=\'ui-id-6\']") private static WebElement sav_role;
	 * 
	 * @FindBy(xpath = "//*[@id=\'username\']") private static WebElement
	 * Update_User;
	 */
	
	@FindBy(xpath = "//*[@id=\"updateuser\"]/div[2]/a")
	private static WebElement Update_buttton;

	
	public UpdateUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void person_info(String fname,String mname,String lname,String dname,String sshot,String TestUser)throws Exception
	{
		  reportPass("Login Page",sshot);
			//  String ActualEmployeeType; 
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
			  SendUser.sendKeys(Keys.ENTER); 
			  
			  System.out.println("Finding the user" );//+ TestUser);
			  wait(2);
			  
			  List<WebElement> columVal =  driver.findElements(By.xpath("//*[@class=\'tooltip1\']"));                
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
			  
			  /*
			  wait(2);
			  System.out.println("Selecting te user ");
			  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			  reportPass("Searched User",sshot);*/
			  wait(2);
			  System.out.println("Working till here search user");
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  
			  reportPass("User Details",sshot);
			  System.out.println("Displaying the user details ");
			  
			  wait(2);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record mname ",sshot);
			  D_name.clear();
			  D_name.sendKeys(dname);
			  
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record Fname ",sshot);
			  F_name.clear();
			  F_name.sendKeys(fname);
			  
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record lname ",sshot);
			  L_name.clear();
			  L_name.sendKeys(lname);
			  
			  wait(2);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record mname ",sshot);
			  M_name.clear();
			  M_name.sendKeys(mname);
			 
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record Successfully ",sshot);
			  Update_buttton.click();
			  
	}
	
	public void Update(String ChangeStreet,String sshot,String TestUser) throws Exception
	  { 
	  reportPass("Login Page",sshot);
	//  String ActualEmployeeType; 
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
	  SendUser.sendKeys(Keys.ENTER); 
	  
	  System.out.println("Finding the user" );//+ TestUser);
	  wait(2);
	  
	  List<WebElement> columVal =  driver.findElements(By.xpath("//*[@class=\'tooltip1\']"));                
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
	  
	  /*
	  wait(2);
	  System.out.println("Selecting te user ");
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  reportPass("Searched User",sshot);*/
	  
	  ClickUser.click();
	  wait(2);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  reportPass("User Details",sshot);
	  System.out.println("Displaying the user details ");
	  
	 //Performing the update  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,600)");
	 
      js.executeScript("window.scrollBy(600,1200)");

      System.out.println("Been Cleared before");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  reportPass("Updateing record of street ",sshot);
	  Change_City.clear();
	  Change_City.sendKeys(ChangeStreet);
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  reportPass("Updateing record Successfully ",sshot);
	  Update_buttton.click();	
	  
	
	  }
	//Update_Contactdetails
	public void Update_Contactdetails(String street,String city,String state,String country,String email,String sshot,String TestUser)throws Exception
	{
		reportPass("Login Page",sshot);
		//  String ActualEmployeeType; 
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
		  SendUser.sendKeys(Keys.ENTER); 
		  
		  System.out.println("Finding the user" );//+ TestUser);
		  wait(2);
		  
		  List<WebElement> columVal =  driver.findElements(By.xpath("//*[@class=\'tooltip1\']"));                
	      System.out.println("Size of the contents in the column state is : " + columVal.size());
	      for(int i=0;i<columVal.size();i++){
	          String twoVal = columVal.get(i).getText();
	          System.out.println(twoVal);
	       if(twoVal.equalsIgnoreCase(TestUser))
	       {
	        		   System.out.println("Find the element" + twoVal );
	                        }
	      }
	      
		  reportPass("Searched User",sshot);
		  ClickUser.click();
		  
			  
			 //Performing the update  
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		      JavascriptExecutor js = (JavascriptExecutor) driver;
		      js.executeScript("window.scrollBy(0,600)");


			  wait(2);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record Country ",sshot);
			  u_street.clear();
			  u_street.sendKeys(street);
			  
	      wait(2);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Updateing record city ",sshot);
		  u_city.clear();
		  u_city.sendKeys(city);

		  wait(2);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Updateing record Country ",sshot);
		  u_state.clear();
		  u_state.sendKeys(state);
		  
		  wait(2);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Updateing record Country ",sshot);
		  u_country.clear();
		  u_country.sendKeys(country);
		  
		  wait(2);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Updateing record email ",sshot);
		  u_email.clear();
		  u_email.sendKeys(email);
		
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Updateing record Successfully ",sshot);
		  Update_buttton.click();		
	}
	
	public void Update_otherdetails(String type,String id,String title,String sshot,String TestUser)throws Exception 
	{  reportPass("Login Page",sshot);
	//  String ActualEmployeeType; 
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
	  SendUser.sendKeys(Keys.ENTER); 
	  wait(2);
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  reportPass("Searched User",sshot);
	  ClickUser.click();
	  wait(2);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  reportPass("User Details",sshot);
	  System.out.println("Displaying the user details ");
	  
	 //Performing the update  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,600)");
	 
    js.executeScript("window.scrollBy(600,1200)");


		      wait(2);
		      u_type_e.clear();
		      u_type_e.sendKeys(title);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Update Type  ",sshot);
			  
			  wait(2);
			  u_eid.clear();
			  u_eid.sendKeys(id);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Update id ",sshot);
			 
			  wait(2);
			  u_etitle.clear();
		      u_etitle.sendKeys(title);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Update title ",sshot);
			 
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record Successfully ",sshot);
			  Update_buttton.click();	
	}
	
	public void Update_department(String d_name,String d_no, String sshot, String TestUser)throws Exception
	{
		reportPass("Login Page",sshot);
		//  String ActualEmployeeType; 
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
		  SendUser.sendKeys(Keys.ENTER); 
		  wait(2);
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  reportPass("Searched User",sshot);
		  ClickUser.click();
		  wait(2);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("User Details",sshot);
		  System.out.println("Displaying the user details ");
		  
		 //Performing the update  
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)");
		 
	    js.executeScript("window.scrollBy(600,1200)");

	    wait(2);
	    u_depname.clear();
	    u_depname.sendKeys(d_name);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Update Type  ",sshot);
		  
		  wait(2);
		  u_depno.clear();
		  u_depno.sendKeys(d_no);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Update id ",sshot);
		 

		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  reportPass("Updateing record Successfully ",sshot);
		  Update_buttton.click();	
	    
	}
	public void Update_Contactdetails_phonenum(String Username, String sshot,String TestUser)throws Exception 
	{  
		reportPass("Login Page",sshot);
	//  String ActualEmployeeType; 
	  clickAdmin.click();
	  
	  reportPass("Clicked on Admin tab",sshot);
	  clickIdentityRepositiory.click();
	  
	  reportPass("Clicked on Identity Repository tab",sshot);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  clickUserlist.click();
	  
	  reportPass("Clicked on User List",sshot);
	  ClickSearch.click();
	  
	  SendUser.sendKeys(TestUser);
	 // reportPass("Enter username to test",sshot);
	  SendUser.sendKeys(Keys.ENTER);
	  
	  System.out.println("Finding the user" );//+ TestUser);
	  wait(2);
	  List<WebElement> columVal =  driver.findElements(By.xpath("//*[@class=\'tooltip1\']"));                
      System.out.println("Size of the contents in the column state is : " +columVal.size());
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
	  
	  wait(2);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  reportPass("User Details",sshot);
	  System.out.println("Displaying the user details ");
	  
	 //Performing the update  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,600)");
	 
    js.executeScript("window.scrollBy(600,1200)");

   // PhoneNum
    		  //String p_number_int = Integer.toString(phone_num); 
			  //string p_number = (string)phone_num;
    		  //phone_num
			  wait(2);
			/*  PhoneNum.clear();
			  PhoneNum.sendKeys(phone_num);
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Update Phone number ",sshot);*/
			
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  reportPass("Updateing record Successfully ",sshot);
			  Update_buttton.click();	
	}

}