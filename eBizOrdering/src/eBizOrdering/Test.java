package eBizOrdering;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import Util.UtilFunctions;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C://Selenium Jar//chromedriver.exe");
	        ChromeDriver driver= new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://zltv7996.vci.att.com:8001/ebiz/registration/home.jsp#/login");
	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", "");
	}

}
