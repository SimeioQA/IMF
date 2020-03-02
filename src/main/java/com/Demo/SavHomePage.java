package com.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Common.Base;

public class SavHomePage extends Base {
WebDriver driver;
	
	@FindBy(xpath="*//div[div[contains(text(),'View Existing')]]/..//a")
	private static WebElement ViewExistingTile;
	
	@FindBy(xpath=".//li/a[@data-hover='dropdown']")
	private static WebElement userDropdown;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private static WebElement logOut;	
	
	@FindBy(xpath=".//*[@id='arsRequestAccess']/div/..//a")
	private static WebElement RequestAccessTile;
	
	@FindBy(xpath=".//*[@id='arsRequestAccessForOthers']/div/div[1]/div/a")
	private static WebElement RequestAccessForOthersTile;
	

	public SavHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickViewExistingTile() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//div[div[contains(text(),'View Existing')]]/..//a")));
		Actions action= new Actions(driver);
		action.moveToElement(ViewExistingTile).click().build().perform();
	}
	
	public void clickSelfAccessTile()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='arsRequestAccess']/div/..//a")));
		Actions action= new Actions(driver);
		action.moveToElement(RequestAccessTile).click().build().perform();
	}
	
	
	public void clickAccessforOthersTile()
	{
		//reportInfo("Clicking on Request access for others");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='arsRequestAccessForOthers']/div/..//a")));
		/*Actions action= new Actions(driver);
		action.moveToElement(RequestAccessForOthersTile).click().build().perform();*/
		RequestAccessForOthersTile.click();
	}
	
	public void clickLogout() {
		userDropdown.click();
		logOut.click();
	}

}
