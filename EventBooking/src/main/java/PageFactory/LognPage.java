package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LognPage {
	public static WebDriver driver;
	
	public static void login() throws Exception{
		driver = DriverManager.BaseDriver.getDriverConn("firefox");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id(ElementRepository.RegistrationPageElements.registerButton)).click();
	}

}
