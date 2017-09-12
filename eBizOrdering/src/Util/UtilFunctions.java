package Util;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import eBizOrdering.TesteBiz;


public class UtilFunctions extends TesteBiz  {
	
	 public static String parentWindow;
	 public static String windowHandle;
	
	public static WebElement getXpath(String key)
	{
		return driver.findElement(By.xpath(OR.getProperty(key)));
	}
	
	public static WebElement getID(String key)
	{
		return driver.findElement(By.id(OR.getProperty(key)));
	}
	
	public static WebElement getName(String key)
	{
		return driver.findElement(By.name(OR.getProperty(key)));
	}
	
		
	public static WebElement getLinkText(String key)
	{
		return driver.findElement(By.linkText(key));
	}
	
	public static void hover(WebElement key)
	{
		Actions act = new Actions(driver);
		act.moveToElement(key).build().perform();
	}
	
	public static void explicitWaitclick(String key)
	{
	WebDriverWait wait = new WebDriverWait(driver, 240);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(key))));
	element.click();

	}
	
	
	
	public static String getAttributeElement(String key)
	{
	return driver.findElement(By.xpath(key)).getAttribute("value");
	}
	
	public static void ScroolDown()
	{
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
	}
	
	public static void ScroolUp()
	{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,-250)", "");
	}
	
	public static void windowChild()
	{			
	parentWindow = driver.getWindowHandle();
	Set<String> handles =  driver.getWindowHandles();
		 for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		  }
		       }
		 
		 	}
	
	public static void windowParent()
	{
	driver.switchTo().window(parentWindow);
	}
}
