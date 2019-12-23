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
		ticket.selectByIndex(1);
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
		ticket1.selectByIndex(1);
		Thread.sleep(1000);
		WebElement bookTickets1 = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.BookNow));
		bookTickets1.click();
		Thread.sleep(1000);
		log.info("\n verify first name");
		WebElement fname = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeNameField));
		fname.sendKeys("chaithra");
		Thread.sleep(1000);
		WebElement mobileNumber = driver.findElement(By.name(ElementRepository.TicketBookingPageElement.AttendeeMobileField));
		mobileNumber.sendKeys("9986368808");
		Thread.sleep(1000);
		WebElement book = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.BookTickets));
		book.click();	
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
		WebElement skipCardText = driver.findElement(By.id(ElementRepository.TicketBookingPageElement.skipCard));
		if (skipCardText.isEnabled()){
			log.info("I do not have card OTP, skipping saved card.");
			skipCardText.click();
		}
		
        driver.close();
         
        log.info("completed");
         
         
        // Close Original window
 
         
		return status;
	     
	}

}













