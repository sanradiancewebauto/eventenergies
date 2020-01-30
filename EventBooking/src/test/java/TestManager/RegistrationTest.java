package TestManager;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonLibs.NadaEMailService;
import PageFactory.LoginPage;

public class RegistrationTest {

    public static String browserName = "firefox";
	public static WebDriver driver = null ;
	private NadaEMailService nada;
    public static String autoRegisterUserFlag = "yes";
	static Logger log = LogManager.getLogger(LoginTest.class.getName());
	public static HashMap<String, String> autoRegisterUserData =  new HashMap<String, String>();


	@BeforeTest
	public void doBeforeTest1() throws Exception {
		System.out.println("Initialize setup before test run.");
		System.out.printf("Setting test browser as : %s ", browserName);
		driver = DriverManager.BaseDriver.getDriverConn(browserName);  //LOGIN TO SITE
		nada = new NadaEMailService();

	}

	@Test
	public void mainpage_menubar_element_display_test02() throws Exception{

		log.info("Test to verify the Registration page.");
		log.info("Validate the auto generated Email ID [{}] via [getnada.com] api's mail service.",nada.getEmailId());
    	autoRegisterUserData.put("EMAILID",nada.getEmailId());
    	autoRegisterUserData.put("PASSWORD",nada.getPassword());
    	String registeredMailId = nada.getInbox(nada.getEmailId());
    	log.info("Register a new user with generated email.");
		boolean status = PageFactory.RegistrationPage.navigateToRegisterPage(browserName, driver, 
				autoRegisterUserFlag, autoRegisterUserData);

    	Thread.sleep(5000);
    	int count = 0;
    	while (count < 2) {
    		Boolean msgStatus = nada.readMessages(registeredMailId);
    		if (msgStatus.equals(true)) {
    			break;
    		}
    		Thread.sleep(5000);
    		count = count + 1;
    	}
		Assert.assertTrue(status, "User registration failed");
		log.info("User registration successful.");
		LoginPage.userLoginElementDisplay(browserName, driver, autoRegisterUserData.get("EMAILID"), 
				autoRegisterUserData.get("PASSWORD"), "yes");

	}

	@AfterTest
	public void tearDown() throws Exception {
		System.out.println("Test run completed.");
		DriverManager.BaseDriver.closeDriver();
	}
	
}




