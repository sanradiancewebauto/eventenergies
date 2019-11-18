package CommonLibs;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class ConditionChecks {
	public static WebDriver driver = null; 
	
	public boolean isElementPresent(By by) 
	{
		try 
		{
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) 
		{
			System.out.println("Element not found.");
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
}
