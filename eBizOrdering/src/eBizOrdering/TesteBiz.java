package eBizOrdering;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import Util.UtilFunctions;



public class TesteBiz{
		
	 public static WebDriver driver;
	 public static Properties OR;
	 public static String parentWindow = null;
	 public static String windowHandle;
	 
	 public static void initilize()
	 {
		 OR = new Properties();
		try{	
		 FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\ObjectRepository\\OR.properties");
			OR.load(fs);
			System.setProperty("webdriver.chrome.driver", "C://Selenium Jar//chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
		}
		catch(Exception e)
		{
			System.out.println("Properties file not found");
		}
	 }
		public static void login() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
		
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		driver.get(OR.getProperty("TestURL"));
		UtilFunctions.getID("LoginID").sendKeys(XlReader.getExcelDataSheetNo(0, 0, 1));
		UtilFunctions.getID("Password").sendKeys(XlReader.getExcelDataSheetNo(0, 1, 1));
		UtilFunctions.getXpath("Submit").click();
		}
		
		public static void managePage() throws InterruptedException
		{
			UtilFunctions.getID("ClickManage").click();
			Thread.sleep(6000);
			Actions act = new Actions(driver);
			UtilFunctions.hover(UtilFunctions.getXpath("HoverNetwork"));
			UtilFunctions.getXpath("ViewAllInventory").click();
			System.out.println("You are in Network Inventory Page");
					
		}
		
		public static void addNewLocation()
		{
			UtilFunctions.explicitWaitclick("AddLocation");
			UtilFunctions.explicitWaitclick("AddService");
			
		}
		
		public static void  serviceLocationDetails1()
		{
			//UtilFunctions.getXpath("SelectOne").click();
			UtilFunctions.explicitWaitclick("SelectOne");
			UtilFunctions.getXpath("SelfManaged").click();
//			String st =UtilFunctions.getAttributeElement("Protocol");
//			if(!st.equalsIgnoreCase("Ethernet"))
//			{
//				UtilFunctions.getXpath("Ethernet").click();
//			}
			UtilFunctions.getXpath("Protocol").click();
			UtilFunctions.getXpath("PPP").click();
			UtilFunctions.getXpath("ContinueButton").click();
				
			
		}
		
		public static void  serviceLocationDetails2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			UtilFunctions.getID("StreetAddress").sendKeys(XlReader.getExcelDataSheetNo(0, 2, 1));
			UtilFunctions.getID("City").sendKeys(XlReader.getExcelDataSheetNo(0, 3, 1));
			UtilFunctions.getXpath("State").click();
			UtilFunctions.getXpath("StateSelection").click();
			UtilFunctions.getID("ZipCode").sendKeys(XlReader.getExcelDataSheetNo(0, 5, 1));
			UtilFunctions.getID("ZipCode").click();
			UtilFunctions.getID("StreetAddress").click();
			UtilFunctions.getXpath("ContinueButton").click();
			Thread.sleep(6000);
						
		}
		
		public static void  serviceLocationDetails3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			UtilFunctions.explicitWaitclick("MCN");
			//UtilFunctions.getXpath("MCN").click();
			UtilFunctions.getXpath("SelectMCN").click();
			UtilFunctions.getXpath("GRC").click();	
			UtilFunctions.getXpath("SelectGRC").click();
			UtilFunctions.getXpath("SOC").click();	
			UtilFunctions.getXpath("SelectSOC").click();
			UtilFunctions.getXpath("SelectCompany").click();
			//UtilFunctions.getXpath("SelectCompanyClick").click();
			UtilFunctions.explicitWaitclick("SelectCompanyClick");
			UtilFunctions.getXpath("BuildingInfo").click();
			UtilFunctions.getXpath("SelectBuilding").click();
			UtilFunctions.getName("BuldingDetail").sendKeys(XlReader.getExcelDataSheetNo(0, 6, 1));
			UtilFunctions.getName("FloorDetail").sendKeys(XlReader.getExcelDataSheetNo(0, 7, 1));
			UtilFunctions.getName("RoomDetail").sendKeys(XlReader.getExcelDataSheetNo(0, 8, 1));
			UtilFunctions.getName("BuldingDetail").click();
			UtilFunctions.getXpath("ClickSave").click();
			Thread.sleep(5000);
			
		}
		
		public static void localContact() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
		//	UtilFunctions.getXpath("RandomClick").click();
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
			System.out.println("Scroll down");
		//	UtilFunctions.explicitWaitclick("ClickLocalContact");
			Thread.sleep(5000);
			System.out.println("Thread sleep executed");
			System.out.println(driver.getWindowHandle());
			UtilFunctions.getXpath("FirstNameLocal").sendKeys(XlReader.getExcelDataSheetNo(0, 10, 1));
			System.out.println(XlReader.getExcelDataSheetNo(0, 11, 1));
			UtilFunctions.getXpath("LastNameLocal").sendKeys(XlReader.getExcelDataSheetNo(0, 11, 1));
			UtilFunctions.getXpath("PhoneNumberLocal").sendKeys(XlReader.getExcelDataSheetNo(0, 12, 1));
			UtilFunctions.getXpath("EmailLocal").sendKeys(XlReader.getExcelDataSheetNo(0, 13, 1));
			UtilFunctions.getXpath("ClickSaveLocal").click();
			UtilFunctions.getXpath("Success").click();
			Thread.sleep(5000);
			
		}
		
		public static void additionalContact() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
			//UtilFunctions.explicitWaitclick("additionalFlyout");
			UtilFunctions.getXpath("FirstNameAdditional").sendKeys(XlReader.getExcelDataSheetNo(0, 15, 1));
			UtilFunctions.getXpath("LastNameAdditional").sendKeys(XlReader.getExcelDataSheetNo(0, 16, 1));
			UtilFunctions.getXpath("CountryCodeAdditional").sendKeys(XlReader.getExcelDataSheetNo(0, 17, 1));
			UtilFunctions.getXpath("PhoneNumberAdditional").sendKeys(XlReader.getExcelDataSheetNo(0, 18, 1));
			UtilFunctions.getXpath("EmailAdditional").sendKeys(XlReader.getExcelDataSheetNo(0, 19, 1));
			UtilFunctions.getXpath("ClickSaveAdditional").click();
			UtilFunctions.getXpath("Success").click();
			
		}
		
		public static void billingContact() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
			//UtilFunctions.explicitWaitclick("additionalFlyout");
			Thread.sleep(5000);
			UtilFunctions.getXpath("ClickSelect").click();
			UtilFunctions.getXpath("ClickLocal").click();
			UtilFunctions.getXpath("ClickSaveBilling").click();
			UtilFunctions.getXpath("Success").click();
			
		}
		
		public static void technicalContact() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
			//UtilFunctions.explicitWaitclick("additionalFlyout");
			Thread.sleep(5000);
			UtilFunctions.getXpath("ClickSelectTech").click();
			UtilFunctions.getXpath("ClickAlternate").click();
			UtilFunctions.getXpath("ClickSaveTech").click();
			UtilFunctions.getXpath("Success").click();
			
		}
		
		public static void configureAccessPPP()
		{
			UtilFunctions.getXpath("ClickonSavePPP").click();
			UtilFunctions.getXpath("Success").click();
		}
		
		public static void configurePortPPP()
		{
			UtilFunctions.getXpath("ClickPortBillingOption").click();
			UtilFunctions.getXpath("SelectPortBillingOption").click();
			UtilFunctions.getXpath("ClickIPVersion").click();
			UtilFunctions.getXpath("SelectIPVersion").click();
			UtilFunctions.getXpath("ClickJackType").click();
			UtilFunctions.getXpath("SelectJackType").click();
			UtilFunctions.getXpath("ClickCOSPackage").click();
			UtilFunctions.getXpath("SelectCOSPackage").click();
			UtilFunctions.getXpath("ClickSave").click();
		}
		
	
}
