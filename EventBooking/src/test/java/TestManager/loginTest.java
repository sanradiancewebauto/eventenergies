package TestManager;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LoginTest {
	public static String browserName = "chrome";
	public static WebDriver driver = null ;
	static Logger log = LogManager.getLogger(LoginTest.class.getName());
			
	@BeforeTest
    public void doBeforeTest() throws Exception {
    	long id = Thread.currentThread().getId();
    	log.info("Executing test on thread id : {} ", id);
    	log.info("Initialize setup before [{}] test run.", this.getClass().getSimpleName());
        log.info("Setting test browser as : {}", browserName);

        //LOGIN TO SITE
        driver = DriverManager.BaseDriver.getDriverConn(browserName);
    }
    
    @Test
    public static void verification_of_loginpage_element_view_test01() throws Exception
    {
    	log.info("Verification of LoginPage element view.");
    	@SuppressWarnings("unchecked")
		Map<String, String> checkValues = (Map<String, String>) PageFactory.LoginPage.userLoginElementDisplay(browserName, driver);
    	log.info("the map object is {}", checkValues);
    	Assert.assertEquals(checkValues.get("Title"),"Sign in to get going.", "No match for title found.");
    	log.info("Title match found.");
    	
    	
    }
    
    @AfterTest
    public void tearDown() throws Exception {
    	log.info("Test run completed.");
    	long id = Thread.currentThread().getId();
    	log.info("After test-method. Thread id is: " + id);
		DriverManager.BaseDriver.closeDriver();
    }
}