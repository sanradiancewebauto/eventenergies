package TestManager;


import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TicketBookingTest {
	public static String browserName = "firefox";
	public static WebDriver driver = null ;
	static Logger log = LogManager.getLogger(LoginTest.class.getName());

	public static final String baseURL = "https://www.storytwinkle.com";
	
	@BeforeTest
    public void doBeforeTest() throws Exception {
    	final long id = Thread.currentThread().getId();
		log.info("Executing test on thread id : {} ", id);
		log.info("Initialize setup before [{}] test run.", this.getClass().getSimpleName());
		log.info("Setting test browser as : {}", browserName);
		// LOGIN TO SITE
		driver = DriverManager.BaseDriver.getDriverConn(browserName);
	}
	
	@Test 
	public void event_booking_test01() throws InterruptedException, AWTException {
		log.info("Verification of event booking payment.");
		//System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
		//  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
		//  driver.get(ElementRepository.BaseURL.URL); 
		boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
		log.info("The test run status is {}", status);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		log.info("Test run completed.");
		final long id = Thread.currentThread().getId();
    	log.info("After test-method. Thread id is: " + id);
		DriverManager.BaseDriver.closeDriver();
    }
		

}
