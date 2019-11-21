package TestManager;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class RegistrationTest {


	public static String browserName = "chrome";
	public static WebDriver driver = null ;


	@BeforeTest
	public void doBeforeTest1() throws Exception {
		System.out.println("Initialize setup before test run.");
		System.out.printf("Setting test browser as : %s ", browserName);
		//LOGIN TO SITE
		driver = DriverManager.BaseDriver.getDriverConn(browserName);
	}

	@Test
	public void mainpage_menubar_element_display_test02() throws Exception{

		System.out.println("Test to verify the Registration page.");
		boolean status = PageFactory.RegistrationPage.navigateToRegisterPage(browserName, driver);
		Assert.assertTrue(status, "Check MainPage Menubar status failed");
		System.out.println("Check MainPage Menubar status successful.");

	}

	@AfterTest
	public void tearDown() throws Exception {
		System.out.println("Test run completed.");
//		DriverManager.BaseDriver.closeDriver();
	}
	
}




