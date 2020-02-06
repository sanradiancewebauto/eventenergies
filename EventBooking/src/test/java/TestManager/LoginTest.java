package TestManager;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import ElementRepository.MainPageElements;

import TestDataProvider.*;



public class LoginTest {
	public static String browserName = "firefox";
	public static String logoutValue="yes";
	public static WebDriver driver = null ;
	static Logger log = LogManager.getLogger(LoginTest.class.getName());
			

	@BeforeTest
	public void doBeforeTest() throws Exception {
		final long id = Thread.currentThread().getId();
		log.info("Executing test on thread id : {} ", id);
		log.info("Initialize setup before [{}] test run.", this.getClass().getSimpleName());
		log.info("Setting test browser as : {}", browserName);
		// LOGIN TO SITE
		//driver = DriverManager.BaseDriver.getDriverConn(browserName);
		
	}
	
	@BeforeMethod
    public void doBeforeClass() throws Exception {
		driver = DriverManager.BaseDriver.getDriverConn(browserName);
		log.info("Step1: Navigate to the Login window from the Main page.");
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(By.cssSelector(MainPageElements.loginButton));
		loginButton.click();
		Thread.sleep(1000);
		
	}
	
	@Test(dataProvider = "SearchProvider", threadPoolSize=1, invocationCount=1, dataProviderClass=LoginDataProvider.class)
	public static void verification_of_valid_login_credentials_test01(String username, String password) throws Exception {
		final long id = Thread.currentThread().getId();
		log.info("------------------------Start Thread={}-------------------------", id);
		log.info("Executing test method [{}]",Thread.currentThread().getStackTrace()[1].getMethodName());

		
		driver = DriverManager.BaseDriver.getDriverConn(browserName);
		log.info("Step1: Navigate to the Login window from the Main page.");
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(By.cssSelector(MainPageElements.loginButton));
		loginButton.click();
		Thread.sleep(1000);
		log.info("Verification of user [{}] login window",username);
		@SuppressWarnings("unchecked")
		final Map<String, String> checkValues = (Map<String, String>) PageFactory.LoginPage
				.userLoginElementDisplay(browserName, driver, username, password, logoutValue);
		//log.info("The map object is {}", checkValues);
		Assert.assertEquals(checkValues.get("Title"), "Login to get going.", "No match for title found.");
		log.info("Login page elements are visible.");
		Assert.assertEquals(checkValues.get("status"), "true", "Valid user login credentails test failed.");
		log.error("Valid user login credentails test passed.");
		
		
		
	}
	
	@Test(dataProvider = "SearchProvider", dataProviderClass=LoginDataProvider.class)
	public static void verification_of_Invalid_login_credentials_test02(String username, String password) throws Exception {
		final long id = Thread.currentThread().getId();
		log.info("------------------------Start Thread={}-------------------------", id);
		log.info("Verification of user [{}] login window",username);
		@SuppressWarnings("unchecked")
		final Map<String, String> checkValues = (Map<String, String>) PageFactory.LoginPage
				.userLoginElementDisplay(browserName, driver, username, password, logoutValue);
		//log.info("The map object is {}", checkValues);
		Assert.assertEquals(checkValues.get("Title"), "Login to get going.", "No match for title found.");
		log.info("Login page elements are visible.");
		Assert.assertEquals(checkValues.get("status"), "true", "Valid user login credentails test failed.");
		log.error("Valid user login credentails test passed.");
	}
		

	@AfterMethod
	public void tearDown() throws Exception {
		log.info("Test run completed.");
		final long id = Thread.currentThread().getId();
		DriverManager.BaseDriver.closeDriver();
		log.info("------------------------END Thread={}-------------------------", id);
    }
	
//	@AfterTest
//	public void tearDownAfterTest() throws Exception {
//		log.info("Test run-set completed.");
//		final long id = Thread.currentThread().getId();
//		DriverManager.BaseDriver.closeDriver();
//		log.info("------------------------FINAL END Thread={}-------------------------", id);
//    }
}