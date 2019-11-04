package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseDriver {

public static WebDriver driver = null;


//CALL WEB BROWSER AND OPEN WEBSITE
public static void openURL()
{

   try{

   System.setProperty("webdriver.chrome.driver", "D:\\EventTestAutomation\\Repos\\WebAutomation\\EventBooking\\src\\main\\java\\BrowserDrivers\\chromedriver77.exe");
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get(ElementRepository.BaseURL.URL);
   }catch(Exception E)

   {
       E.printStackTrace();


   }
}

}