package PageFactory;

import java.awt.AWTException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TicketBookingPage {

	public static boolean status = true;
	static Logger log = LogManager.getLogger(LoginPage.class.getName());

	public static boolean BookTickets(String browserName, WebDriver driver) throws InterruptedException, AWTException {


		//JavascriptExecutor js = (JavascriptExecutor)driver;	

		log.info("\nVerify the presence of Event");
		WebElement event = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.Event));

		if (event.isDisplayed() && event.isEnabled())
		{
			log.info("Register button is displayed and enabled.");
			event.click();

		}else {
			log.info("Register button is not displayed nor enabled.");

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement bookemail = driver.findElement(By.id(ElementRepository.TicketBookingPageElement.BookedByEmail));
		bookemail.sendKeys("chaithra.s@sanradiance.com");
		Thread.sleep(1000);
		Select ticket = new Select(driver.findElement(By.name(ElementRepository.TicketBookingPageElement.TicketSelectField)));
		ticket.selectByIndex(5);
		WebElement bookTickets = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.BookNow));
		bookTickets.click();
		Thread.sleep(1000);
		WebElement passwordButton = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.password));
		passwordButton.sendKeys("chaithra@sanradiance.com");	
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.xpath(ElementRepository.LoginPageElements.loginButton));
		submit.click();
		Thread.sleep(1000);
		Select ticket1 = new Select(driver.findElement(By.name(ElementRepository.TicketBookingPageElement.TicketSelectField)));
		ticket1.selectByIndex(5);
		Thread.sleep(1000);
		WebElement bookTickets1 = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.BookNow));
		bookTickets1.click();
		Thread.sleep(1000);
		log.info("\n verify first name");

		
			WebElement fname = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeNameField));
			fname.sendKeys("chaithra");
			WebElement f1name = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeNameField1));
			f1name.sendKeys("chaithra");
			WebElement f2name = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeNameField2));
			f2name.sendKeys("event");
			WebElement f3name = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeNameField3));
			f3name.sendKeys("manjuraj");
			WebElement f4name = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeNameField4));
			f4name.sendKeys("basavaraj");
		
			
			WebElement email1 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeEmailField1));
			email1.sendKeys("chaithrashamanna113@gmail.com");
			WebElement email2 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeEmailField2));
			email2.sendKeys("eventenergies113@gmail.com");
			WebElement email3 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeEmailField3));
			email3.sendKeys("manasagccs@gmail.com");
			WebElement email4 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeEmailField4));
			email4.sendKeys("basavakumar.sg@sanradiance.com");
	

		WebElement mobileNumber = driver.findElement(By.name(ElementRepository.TicketBookingPageElement.AttendeeMobileField));
		mobileNumber.sendKeys("8550081528");
		WebElement mobileNumber1 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeMobileField1));
		mobileNumber1.sendKeys("9986368808");
		WebElement mobileNumber2 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeMobileField2));
		mobileNumber2.sendKeys("9986368808");
		WebElement mobileNumber3 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeMobileField3));
		mobileNumber3.sendKeys("9108147349");
		WebElement mobileNumber4 = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeMobileField4));
		mobileNumber4.sendKeys("9980830863");
		
		Thread.sleep(5000);
		WebElement book = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.BookTickets));
		book.click();	

		System.out.println("clcked on book tickets");

		Thread.sleep(1000);
		log.info("This is showing the model popup");
		// Switching to the modle popup that is on the frame(0) - (active frame)
		driver.switchTo().frame(0);

		Thread.sleep(5000);
		String popupHandle = driver.getWindowHandle();
		log.info("The popup handle id is {}",popupHandle);
		WebElement cardBtn = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.cardBtn));
		cardBtn.click();
		Thread.sleep(1000);
		WebElement choosepaytm = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.paytm));
		if (choosepaytm.isEnabled()){
			log.info("having paytm optin to select.");
			choosepaytm.click();
		}
		WebElement entrUpi = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.Upiid));
		entrUpi.sendKeys("8550081528");	
		Thread.sleep(1000);

		WebElement payBtn = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.pay));
		if (payBtn.isEnabled() && payBtn.isDisplayed()){
			log.info("pay Button is enabled and disabled");
			payBtn.click();
		}
		//        driver.close();
		log.info("completed");
		// Close Original window
		return status;

	}

}













