package com.Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;



public class Base extends ExtentLib {
	public static WebDriver driver = null;
	private Properties properties;
	
	private final static String propertyFilePath = "Properties\\config.properties";

	public void readPropertyfile() {
		properties = new Properties();
		try {
			InputStream input = new FileInputStream(propertyFilePath);
			properties.load(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver instantiateWebDriver(String browser, String ieDriverpath, String chromeDriverpath,
			String firefoxDriverPath) throws Exception {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
				driver = new FirefoxDriver();
				// driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver", ieDriverpath);
				driver = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("Chrome")) {
				/*System.setProperty("webdriver.chrome.driver", chromeDriverpath);
				driver = new ChromeDriver();
				
				 * ChromeOptions options=new ChromeOptions();
				 * options.addArguments("--incognito");
				 
				// System.out.println(frameprops.getChromedriver());
				// System.setProperty("webdriver.chrome.driver",
				// System.setProperty("webdriver.chrome.driver",chromeDriverpath));
				// driver=new ChromeDriver(options);
*/			
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--incognito");
				//System.out.println(frameprops.getChromedriver());
				System.setProperty("webdriver.chrome.driver", chromeDriverpath);
				//System.out.println("Driver is inset");
				driver=new ChromeDriver(options);
				}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static String getScreenhot(String screenshot) throws Exception {
		// String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		Date d = new Date();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/FailScreenshot/"
				+ d.toString().replace(":", "_").replace(" ", "_") + ".png";

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}

	public void scrollup() {
		// WebDriver driver = new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-450)", "");
	}

	public void scrolldown() {
		// WebDriver driver = new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
	}

	public boolean isElementPresentbyDisplay(String elementXpath) {
		System.out.println("Element is" + elementXpath);
		boolean Xpath = driver.findElement(By.xpath(elementXpath)).isDisplayed();
		if (Xpath == true)
			return true;
		else
			return false;
	}

	
	public boolean isElementPresentbyDisplayValue(String elementXpath) {
		List<WebElement> elementList=null;	
		System.out.println("In the Display Block");
		elementList=driver.findElements(By.xpath(elementXpath));
		//System.out.println("Element is" + elementXpath);
		System.out.println("The size"+elementList.size());
		if(elementList.size()==0)
			return false;
		else
			return true;
	}
	
	
	public boolean isElementspresent(WebElement elementXpath) {
		int count = driver.findElements(By.xpath("elementXpath")).size();
		//System.out.println("The count is" + count);
		
		if (count == 0)
			return false;
		else
			System.out.println("Element is present");
			return true;

	}

	public void SAMLogout() {
		driver.findElement(By.xpath("")).click();
		driver.close();
	}

	public static void wait(int timeToWaitInSec) {
		try {
			Thread.sleep(timeToWaitInSec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForPageToLoad() {
		wait(1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript("return document.readyState");
		while (!state.equals("complete")) {
			wait(3);
			state = (String) js.executeScript("return document.readyState");
		}
		System.out.println("Page Load Succssfully");
	}
	
	public String getText(WebElement locatorKey,String sshot) throws Exception {
		//test.log(LogStatus.INFO, "Getting text from " +locatorKey);
		reportInfo("Getting text from locator", sshot);
		return locatorKey.getText();
					
	}
	public void click(WebElement locatorkey,String sshot) throws Exception {
		locatorkey.click();
		/*reportInfo("Clicked successfully on: " +locatorkey,sshot);*/
		reportPass("Click Successfully on the Mentioned Locator", sshot);
	}
	
	/*public void click(String locatorkey,String sshot) throws Exception {
		driver.findElement(By.xpath(locatorkey));
		//click(locatorkey, sshot);
		reportInfo("Clicked successfully on: " +locatorkey,sshot);
		
	}*/
	public void clickString(String locator,String sshot) throws Exception {
		locator =locator.replace("XPATH_", "");
		driver.findElement(By.xpath(locator)).click();
		//click(locatorkey, sshot);
		/*reportInfo("Clicked successfully on required string: " +locator,sshot);*/
		reportPass("Click successfuly on String Locator", sshot);
		
	}
	public void type(WebElement locatorkey,String data, String sshot) throws Exception {
		locatorkey.clear();
		locatorkey.sendKeys(data);
		/*reportInfo("Typed successfully on: " +locatorkey, null);*/
		reportPass("Typed successfully", sshot);
		
	}
	public void clickAndWait(WebElement locClicked, WebElement locToWaitFor) throws InterruptedException {
		int count=5;
		for(int i=0;i<count;i++) {
			locClicked.click();
			wait(2);
			if(isElementspresent(locToWaitFor))
				break;
			rep.flush();
			
		}
		
	}
	
	
	public static void Hover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		System.out.println("Hover is successful");
	}
	
	
	public void ByVisibleElement(String locator) {
		locator =locator.replace("XPATH_", "");
		WebElement element= driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", element);
        
        System.out.println("Element is Visible");
		
	}
	

	/*
	 * public static String takeScreenShot() { Date d=new Date(); String
	 * screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
	 * 
	 * 
	 * File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); try
	 * { FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +
	 * "//screenshots//" + screenshotFile)); } catch(IOException e) {
	 * e.printStackTrace(); } //return scrFile; return screenshotFile; }
	 */
	/*
	 * public static String scrollAndTakeScreenShot() { JavascriptExecutor js
	 * =(JavascriptExecutor) driver; long bodyHeight=(long)
	 * js.executeScript("return document.body.scrollHeight;"); Dimension
	 * initial_size=driver.manage().window().getSize(); long winHeight=(long)
	 * initial_size.getHeight();
	 * 
	 * if(bodyHeight <= winHeight) takeScreenShot(); else { int currentScroll =0;
	 * js.executeScript("window.scrollTo(0,0)");
	 * 
	 * do { takeScreenShot(); currentScroll += winHeight;
	 * js.executeScript("window.scrollTo(0," + currentScroll + ")"); wait(1); }
	 * while(currentScroll < bodyHeight); } return propertyFilePath;
	 * 
	 * }
	 */
	
	
}

