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
import TestDataProvider.RegistrationDataProvider;

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
	
	@Test(dataProvider="GET_JSON_DATA", dataProviderClass=RegistrationDataProvider.class)
	public void resgister_new_user_verify_email_01(String usertype,
			String firstname,
			String lastname,
			String phonecountry) throws Exception{
		log.info("Building a dataset map from the dataprovider extracted from json testdata file.");
		final HashMap<String, String> testdata =  new HashMap<String, String>();
		testdata.put("USERTYPE", usertype);
		testdata.put("FIRSTNAME", firstname);
		testdata.put("LASTNAME", lastname);
		testdata.put("PHONECOUNTRY", phonecountry);
		testdata.put("EMAILID",nada.getEmailId());
		testdata.put("PASSWORD",nada.getPassword());
		
		log.info("Test to verify the Registration page.");
		log.info("Validate the auto generated Email ID [{}] via [getnada.com] api's mail "
				+ "service.",testdata.get("EMAILID"));
		String registeredMailId = nada.initMailID(testdata.get("EMAILID"));
		log.info("Mail ID registration status : {}",registeredMailId);
       	Thread.sleep(5000);
//    	int count = 0;
//    	while (count < 2) {
//    		Boolean msgStatus = nada.readMessages(registeredMailId);
//    		if (msgStatus.equals(true)) {
//    			break;
//    		}
//    		Thread.sleep(5000);
//    		count = count + 1;
//    	}
    	log.info("Register a new user with generated email. {}", testdata);
		boolean status = PageFactory.RegistrationPage.navigateToRegisterPage(browserName, driver, 
				autoRegisterUserFlag, testdata);

 
		Assert.assertTrue(status, "User registration failed");
		log.info("User registration successful.");
		LoginPage.userLoginElementDisplay(browserName, driver, testdata.get("EMAILID"), testdata.get("PASSWORD"), autoRegisterUserFlag);

	}

	@AfterTest
	public void tearDown() throws Exception {
		System.out.println("Test run completed.");
		DriverManager.BaseDriver.closeDriver();
	}
	
}




