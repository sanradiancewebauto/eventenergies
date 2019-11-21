package TestManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainpageTest {
	public static String browserName = "chrome";
	public static WebDriver driver = null ;
	
  
     
    @BeforeTest
    public void doBeforeTest() throws Exception {
        System.out.println("Initialize setup before test run.");
        System.out.printf("Setting test browser as : %s ", browserName);
        //LOGIN TO SITE
        driver = DriverManager.BaseDriver.getDriverConn(browserName);
    }
     
    @Test
	public static void mainpage_menubar_element_display_test01() throws Exception{
		
    	System.out.println("Test to verify the mainpage menubar element display.");
		boolean status = PageFactory.MainPage.checkMenuBarItems(browserName, driver);
		Assert.assertTrue(status, "Check MainPage Menubar status failed");
		System.out.println("Check MainPage Menubar status successful.");
		
	}
     
    @AfterTest
    public void tearDown() throws Exception {
    	System.out.println("Test run completed.");
		DriverManager.BaseDriver.closeDriver();
    }
}
