package CommonLibs;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ConditionChecks {
	public static WebDriver driver = null; 
	static Logger log = LogManager.getLogger(ConditionChecks.class.getName());
	
	public boolean isElementPresent(By by) 
	{
		try 
		{
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) 
		{
			log.info("Element not found.");
			return false;
		}
	}
	
	public boolean isAlertPresent() 
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}
	}

	public String closeAlertAndGetItsText() 
	{
		boolean acceptNextAlert = false;
		try 
		{
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) 
			{
				alert.accept();
			} 
			else 
			{
				alert.dismiss();
			}
		return alertText;
		} 
		finally 
		{
			acceptNextAlert = true;
		}
	}
	public static boolean mouseHover(String webElement) throws InterruptedException
	{
		boolean status = true;
		try {
			log.info("what is my class name {}",webElement);
			Thread.sleep(1000);
	        Actions action = new Actions(driver);
	        WebElement mouseOver = driver.findElement(By.xpath(webElement));
			action.moveToElement(mouseOver).perform();
			Thread.sleep(1000);
			log.info("Done Mouse hover on 'Event' details.");
			status = true;
		}finally {
			log.info("Failed Mouse hover on 'Event' details.");
			status = false;
		}
		return status;
		
		
	}
}
