package TestManager;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class loginTest {
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
    public static void mainpage_click_login_test01() throws Exception
    {
    	System.out.println("Click the main page Login Button");
    	boolean status = PageFactory.LognPage.mainLoginClick(browserName, driver);
    	System.out.print(status);
    	
    	
    }
    
 
    
}