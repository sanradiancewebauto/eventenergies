package TestManager;


import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class TicketBookingTest {
	public static String browserName = "chrome";
	public static WebDriver driver = null ;

	public static String driverLocation = "D:\\chromedriver_win32\\";
	public static final String baseURL = "https://www.storytwinkle.com";
	@Test 
	public void test1() throws InterruptedException, AWTException {
		System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
		System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
		  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
		  driver.get(ElementRepository.BaseURL.URL); 
		  @SuppressWarnings("unused")
		WebElement status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);


}
}
