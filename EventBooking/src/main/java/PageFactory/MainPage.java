package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public static void checkMenuBarItems(String browserName) 
	{
		try
		{
			// Check log, search, Registration, Login items
			System.out.println("Verify the presence of MainPage Elements");
			WebDriver driver = DriverManager.BaseDriver.getDriverConn(browserName);
			WebElement icon_st = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.logoIcon));
			System.out.printf("Icon value is %s",icon_st);
		}
		catch (Exception E) 
		{
			 E.printStackTrace();
		}
	}


}
