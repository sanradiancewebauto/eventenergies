package TestManager;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ElementRepository.MainPageElements;

import TestDataProvider.*;



public class LoginTest {
	public static String browserName = "firefox";
	public static WebDriver driver = null ;
	static Logger log = LogManager.getLogger(LoginTest.class.getName());
			

	@BeforeTest
	public void doBeforeTest() throws Exception {
		final long id = Thread.currentThread().getId();
		log.info("Executing test on thread id : {} ", id);
		log.info("Initialize setup before [{}] test run.", this.getClass().getSimpleName());
		log.info("Setting test browser as : {}", browserName);
		// LOGIN TO SITE
		driver = DriverManager.BaseDriver.getDriverConn(browserName);
		
	}
	
	@BeforeClass
    public void doBeforeClass() throws Exception {
		log.info("Step1: Navigate to the Login window from the Main page.");
		Thread.sleep(1000);
		WebElement loginButton = driver.findElement(By.cssSelector(MainPageElements.loginButton));
		loginButton.click();
		Thread.sleep(1000);
		
	}
	@Test(dataProvider = "SearchProvider", dataProviderClass=LoginDataProvider.class)
	public static void verification_of_loginpage_element_view_test01(String username, String password) throws Exception {
		log.info("Verification of user [{}] login window",username);
		@SuppressWarnings("unchecked")
		final Map<String, String> checkValues = (Map<String, String>) PageFactory.LoginPage
				.userLoginElementDisplay(browserName, driver, username, password);
		log.info("the map object is {}", checkValues);
		Assert.assertEquals(checkValues.get("Title"), "Login to get going.", "No match for title found.");
		log.info("Title match found.");
		Assert.assertEquals(checkValues.get("status"), "true", "User login test successful");
	}

	@AfterTest
	public void tearDown() throws Exception {
		log.info("Test run completed.");
		final long id = Thread.currentThread().getId();
    	log.info("After test-method. Thread id is: " + id);
		DriverManager.BaseDriver.closeDriver();
    }
}