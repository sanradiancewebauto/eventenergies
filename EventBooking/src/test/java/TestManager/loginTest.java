package TestManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class loginTest {
	public static String browserName = "chrome";
	public static WebDriver driver = null ;
	
     
    @BeforeTest
    public void doBeforeTest() throws Exception {
        System.out.println("Initialize setup before test run.Neelufar");
        System.out.printf("Setting test browser as : %s ", browserName);
        //LOGIN TO SITE
        driver = DriverManager.BaseDriver.getDriverConn(browserName);
    }
    
    @Test
    public static void mainpage_click_login_test01() throws Exception
    {
    	System.out.println("hi");
    }
    
}