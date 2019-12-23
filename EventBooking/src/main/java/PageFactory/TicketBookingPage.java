package PageFactory;

import java.awt.AWTException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TicketBookingPage {
	

	public static WebElement BookTickets(String browserName, WebDriver driver) throws InterruptedException, AWTException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
		 String handle= driver.getWindowHandle();
		 
         System.out.println(handle);

		System.out.println("\nVerify the presence of Event");
		WebElement event = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.Event));

		if (event.isDisplayed() && event.isEnabled())
		{
			System.out.println("Register button is displayed and enabled.");
			event.click();

		}else {
			System.out.println("Register button is not displayed nor enabled.");

		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement bookemail = driver.findElement(By.id(ElementRepository.TicketBookingPageElement.BookedByEmail));
		bookemail.sendKeys("chaithra.s@sanradiance.com");
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
		System.out.println("\n verify first name");
		WebElement fname = driver.findElement(By.xpath(ElementRepository.TicketBookingPageElement.AttendeeNameField));
		fname.sendKeys("chaithra");
		Thread.sleep(1000);
		WebElement mobileNumber = driver.findElement(By.name(ElementRepository.TicketBookingPageElement.AttendeeMobileField));
		mobileNumber.sendKeys("9986368808");
		Thread.sleep(1000);
		WebElement book = driver.findElement(By.cssSelector(ElementRepository.TicketBookingPageElement.BookTickets));
		book.click();	
		System.out.println();
		
		Thread.sleep(5000);
		Set handles = driver.getWindowHandles();
		System.out.println(handles);
         for (String handle1 : driver.getWindowHandles()) {
        	 System.out.println(handle1);
        	 driver.switchTo().window(handle1);
        	 Thread.sleep(5000);
             WebElement pop = driver.findElement(By.xpath("//*[@id=\"form-common\"]"));
             System.out.print("element found");
     }
         driver.close();
         
//		driver.switchTo().frame(0);
//	    driver.findElement(By.cssSelector(".p13n-instrument:nth-child(1) .svelte-sycrgz:nth-child(2) > div")).click();
//	    driver.findElement(By.cssSelector("#footer > span")).click();
         
         
         
         System.out.println("completed");
         
         
         // Close Original window
 
         
		return book;
	     
	}

}













