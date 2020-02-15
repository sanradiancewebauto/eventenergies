
package TestManager;

import java.awt.AWTException;
import java.awt.Robot;
import org.openqa.selenium.WebDriver;
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
		  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
		
		  }

//
//	@Test 
//	public void test2() throws InterruptedException, AWTException {
//		System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//		System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//		  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//		  driver.get(ElementRepository.BaseURL.URL); 
//		  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//}
//	@Test 
//	public void test3() throws InterruptedException, AWTException {
//		System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//		System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//		  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//		  driver.get(ElementRepository.BaseURL.URL); 
//		  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//}
//	@Test 
//	public void test4() throws InterruptedException, AWTException {
//		System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//		System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//		  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//		  driver.get(ElementRepository.BaseURL.URL); 
//		  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//}
//	@Test 
//	public void test5() throws InterruptedException, AWTException {
//		System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//		System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//		  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//		  driver.get(ElementRepository.BaseURL.URL); 
//		  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//}
//	@Test 
//	public void test6() throws InterruptedException, AWTException {
//		System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//		System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//		  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//		  driver.get(ElementRepository.BaseURL.URL); 
//		  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//}
//		@Test 
//		public void test7() throws InterruptedException, AWTException {
//			System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//			System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//			  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//			  driver.get(ElementRepository.BaseURL.URL); 
//			  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//	}
//		@Test 
//		public void test8() throws InterruptedException, AWTException {
//			System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//			System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//			  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//			  driver.get(ElementRepository.BaseURL.URL); 
//			  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//	}
//		@Test 
//		public void test9() throws InterruptedException, AWTException {
//			System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//			System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//			  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//			  driver.get(ElementRepository.BaseURL.URL); 
//			  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//		}
//		@Test 
//		public void test10() throws InterruptedException, AWTException {
//			System.out.println(" i am inside test resut 2" +Thread.currentThread().getId());
//			System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
//			  WebDriver driver=new ChromeDriver(); driver.manage().window().maximize(); 
//			  driver.get(ElementRepository.BaseURL.URL); 
//			  boolean status = PageFactory.TicketBookingPage.BookTickets(browserName, driver);
//		}
	

}

