package TestManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainpageTest {
	public static String browserName = "firefox";
	public static WebDriver driver = null ;
	
  
     
    @BeforeTest
    public void doBeforeTest() throws Exception {
    	long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
        System.out.printf("\n\nInitialize setup before test [%s] run.", this.getClass().getSimpleName());
        System.out.printf("\nSetting test browser as : [%s] ", browserName);

        //LOGIN TO SITE
        driver = DriverManager.BaseDriver.getDriverConn(browserName);
    }
    
    @Test
	public static void mainpage_menubar_element_display_test01() throws Exception{
		
    	System.out.println("Test to verify the mainpage menubar element display.");
    	long id = Thread.currentThread().getId();
    	System.out.println("Simple test-method One. Thread id is: " + id);
		boolean status = PageFactory.MainPage.checkMenuBarItems(browserName, driver);
		Assert.assertTrue(status, "Verification of MainPage Menubar status failed.");
		System.out.println("\nVerification of  MainPage Menubar status successful.");
		
	}
    
    @Test
  	public static void mainpage_event_slider_display_test02() throws Exception{
  		
      	System.out.println("Test to verify the mainpage event slider display.");
      	long id = Thread.currentThread().getId();
      	System.out.println("Simple test-method Two. Thread id is: " + id);
      	boolean status = PageFactory.MainPage.checkEventSlider(browserName, driver);
  		  Assert.assertTrue(status, "Verification of main page menubar event slider status failed.");
  		  System.out.println("\nVerification of  main page menubar event slider status successful.");
    }
     
    @AfterTest
    public void tearDown() throws Exception {
    	System.out.println("Test run completed.");
    	long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
		DriverManager.BaseDriver.closeDriver();
    }
}
