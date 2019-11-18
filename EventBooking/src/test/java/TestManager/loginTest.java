//package TestManager;
//
//public class LoginTest {
//	public static void main(String[] args) throws Exception{
//		//LOGIN TO SITE
//		DriverManager.BaseDriver.getDriverConn("chrome");
//	}
//		     
//		    
//}
package TestManager;

//import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ElementRepository.LoginPageElements;
import PageFactory.LognPage;

public class loginTest {

	@Test
	public void verifyValidLogin() {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.storytwinkle.com");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	LognPage LognPage= new LognPage(driver);
		
		LognPage.loginToEventEnergies("lokeshbabu@gmail.com", "lokeshbabu@gmail.com");

	}

}

