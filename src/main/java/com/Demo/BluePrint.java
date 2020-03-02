package com.Demo;
//package com.test_Shellaccessmanager;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.Common.Base;
import com.Common.ExcelUtility;
import com.Common.ExtentLib;

/*import demo_CommonFunction.Base;
import demo_CommonFunction.ExcelUtility;
import demo_CommonFunction.ExtentLib;
import demo_SAMpages.SAM_Approval_WF;
import demo_SAMpages.SavHomePage;
import demo_SAMpages.SavLogin;
import demo_SAMpages.SAM_ReqAccessfrOthers;
import demo_SAMpages.SAM_SelectAccessPage;
*/

//new test final
public class BluePrint {
	public static WebDriver driver;
	public HashMap<String, String> map;
	ArrayList<HashMap<String, String>> list;
	private static Properties properties;
	private final static String propertyFilePath = "Properties\\config.properties";
	//this is pull push test
	@Test
	public void demoSAMtest() throws Exception {
		properties = new Properties();
		InputStream input = new FileInputStream(propertyFilePath);
		properties.load(input);
		//hello everyone this is push pull test
		ExcelUtility readXlsx = new ExcelUtility();
		ArrayList<HashMap<String, String>> list = readXlsx.readExcel(properties.getProperty("path.InputExcel"));
		ArrayList<HashMap<String, String>> outputList = new ArrayList<HashMap<String, String>>();

		for (HashMap<String, String> map : list) {
		//	try {
				if (map.get("Execution").equals("Yes")) {

					ExtentLib report = new ExtentLib();
					report.createExtentReport(map.get("TCNo"), map.get("Scenario"), map.get("SelectedJobposition"));

					Base B = new Base();
					driver = B.instantiateWebDriver(map.get("Driver"), properties.getProperty("path.driver.ie"),
							properties.getProperty("path.driver.chrome"),
							properties.getProperty("path.driver.firefox"));
					driver.get(properties.getProperty("baseUrl"));
					driver.manage().window().maximize();
                   // String ExtpectedType;
					SavLogin loginPage = new SavLogin(driver);
					SavHomePage homePage = new SavHomePage(driver);
					UpdateUser updateUser = new UpdateUser(driver);
					CreateIdentities CreateIdentity=new CreateIdentities(driver);
					Status s=new Status(driver);
					loginPage.loginSAM(map.get("Username"), map.get("Password"), map.get("Screenshot"));
					//Check the employee type
					CreateIdentity.checkEmpType(map.get("EmployeeType"),map.get("Screenshot"),map.get("TestUser"));
                    //Update details
					if (map.get("TCNo").equals("TC07"))
					updateUser.person_info(map.get("Change_Firstname"),map.get("Change_Lastname"),map.get("Change_Middlename") ,map.get("Change_Displayname"),map.get("Screenshot"),map.get("TestUser"));
					if(map.get("TCNo").equals("TC08"))
					updateUser.Update_Contactdetails(map.get("Change_Street"),map.get("Change_City"),map.get("Change_State"),map.get("Change_Country"),map.get("Change_Email"),map.get("Screenshot"),map.get("TestUser"));
					if(map.get("TCNo").equals("TC09"))
					updateUser.Update_department(map.get("Change_Departname"),map.get("Change_Departmentno"),map.get("Screenshot"),map.get("TestUser"));
				
					s.checkEmpStatus(map.get("TestUser"));
					//updateobj.person_info(map.get("Change_Firstname"),map.get("Change_Lastname"),map.get("Change_Middlename") ,map.get("Screenshot"),map.get("TestUser"));
					//updateobj.Update_Contactdetails(map.get("Change_City"),map.get("Change_email"),map.get("Screenshot"),map.get("TestUser"));
	               // updateobj.Update_otherdetails(map.get("Change_emp_type"),map.get("Change_emp_id"),map.get("Change_title"),map.get("Screenshot"),map.get("TestUser"));
					driver.close();
					
				}
			}
		}
				}
