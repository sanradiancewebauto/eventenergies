package TestManager;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DriverManager.BaseDriver;
import ElementRepository.MainPageElements;
import PageFactory.EventsPage;
import TestDataProvider.EventsDataProvider;



public class EventsPageTest {
	
		public static String browserName = "firefox";
		public static String logoutValue="no";
		public static WebDriver driver = null ;
		static Logger log = LogManager.getLogger(EventsPageTest.class.getName());
				
		
		@BeforeTest
		public void doBeforeTest() throws Exception {
			final long id = Thread.currentThread().getId();
			
			log.info("Executing test on thread id : {} ", id);
			log.info("Initialize setup before [{}] test run.", this.getClass().getSimpleName());
			log.info("Setting test browser as : {}", browserName);
			// <LOGIN TO SITE
			driver = BaseDriver.getDriverConn(browserName);
			
		}
		@Parameters({"username", "password"})
		@BeforeClass()
	    public void doBeforeClass(String username, String password) throws Exception {
			log.info("Step1: Navigate to the Login window from the Main page.");
			Thread.sleep(1000);
			WebElement loginButton = driver.findElement(By.cssSelector(MainPageElements.loginButton));
			loginButton.click();
			Thread.sleep(1000);
			@SuppressWarnings("unchecked")
			final Map<String, String> returnValues = (Map<String, String>) PageFactory.LoginPage.userLoginElementDisplay(browserName, 
					driver, username, password, logoutValue);		
			log.info("return val in test  inside test {}", returnValues);
			Assert.assertEquals(returnValues.get("status"), "true", "Login failed.");
			log.info("Login successful.");
		}
		
		
		@Test(dataProvider="fetchData_JSON", dataProviderClass=EventsDataProvider.class)
		public static void verification_of_events_creation_test01(
				String eventtitle,
				String eventdescription,
				String eventdescriptiondetails,
				String eventtype,
				String selectcategory,
				String subcategory,
				String startdate,
				String enddate,
				String timezone,
				String venue,
				String addressline,
				String addressline2,
				String city,
				String state,
				String country,
				String pincode,
				String tags,
				String tagname,
				String description,
				String tickets,
				String tickettype,
				String ticketname,
				String paymentgateway,
				String quantity,
				String minqty,
				String maxqty,
				String price,
				String currency) throws Exception {
			
			log.info("Building a dataset map from the dataprovider extracted from json testdata file.");
			final HashMap<String, String> testdata =  new HashMap<String, String>();
			testdata.put("EventTitle", eventtitle);
			testdata.put("EventDescription",eventdescription);
			testdata.put("EventDescriptionDetails",eventdescriptiondetails);
			testdata.put("EventType",eventtype);
			testdata.put("SelectCategory", selectcategory);
			testdata.put("SubCategory", subcategory);
			testdata.put("StartDate", startdate);
			testdata.put("EndDate", enddate);
			testdata.put("TimeZone", timezone);
			testdata.put("Venue", venue);
			testdata.put("AddressLine", addressline);
			testdata.put("AddressLine2",addressline2);
			testdata.put("City",city);
			testdata.put("Ctate", state);
			testdata.put("Country", country);
			testdata.put("PinCode", pincode);
			testdata.put("Tags", tags);
			testdata.put("Tagname", tagname);
			testdata.put("Description", description);
			testdata.put("Tickets", tickets);
			testdata.put("TicketType", tickettype);
			testdata.put("TicketName", ticketname);
			testdata.put("PaymentGateway", paymentgateway);
			testdata.put("Quantity", quantity);
			testdata.put("Minqty", minqty);
			testdata.put("Maxqty", maxqty);
			testdata.put("Price", String.valueOf(price));
			testdata.put("Currency", currency);
	
			@SuppressWarnings("unchecked")
			final Map<String, String> checkEventValues = (Map<String, String>) EventsPage.CreateEvents(browserName, driver, testdata);
			log.info("Test Status :{}",checkEventValues.get("EventStatus"));
			//Assert.assertEquals(checkEventValues.get("hoverStatus"), "false", "Event detail element mouse hover check failed.");
			
			Assert.assertEquals(checkEventValues.get("EventStatus"), "true", "Navigation to the Event Details failed.");
			log.info("Navigation to the Event Details successful.");
			
			
			
		}
//		@Test(dataProvider = "SearchProvider", dataProviderClass=EventsDataProvider.class)
//		public static void verification_of_events_creation_test01(String Title, String DescTitle, String DescDetails) throws Exception {
//			final HashMap<String, String> testdata =  new HashMap<String, String>();
//			testdata.put("Title", Title);
//			testdata.put("DescriptionTitle", DescTitle);
//			testdata.put("DescriptionDetails", DescDetails);
//			@SuppressWarnings("unchecked")
//			final Map<String, String> checkEventValues = (Map<String, String>) EventsPage.CreateEvents(browserName, driver, testdata);
//			log.info("What is the value of my map events -- {}", checkEventValues);
//			//Assert.assertEquals(checkEventValues.get("hoverStatus"), "true", "Event detail element mouse hover check failed.");
//			
//			Assert.assertEquals(checkEventValues.get("eventStatus"), "true", "Navigation to the Event Details failed.");
//			log.info("Navigation to the Event Details successful.");
//			
//			
//		}
		

		@AfterTest
		public void tearDown() throws Exception {
			final long id = Thread.currentThread().getId();
			log.info("After test-method task on thread id : " + id);
			log.info("Test run completed.");
			log.info("Closing browser.");
			BaseDriver.closeDriver();
	    }


}
