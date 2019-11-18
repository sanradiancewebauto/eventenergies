//package PageFactory;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class LognPage {
//	public static WebDriver driver;
//	
//	public static void login() throws Exception{
//		driver = DriverManager.BaseDriver.getDriverConn("firefox");
//		
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.id(ElementRepository.RegistrationPageElements.registerButton)).click();
//	}
//
//}


package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LognPage {

	static WebDriver driver;

	static By Login = By.xpath(ElementRepository.LoginPageElements.Login);

	static By LoginUserName = By.id(ElementRepository.LoginPageElements.LoginUserName);

	static By LoginPassword = By.id(ElementRepository.LoginPageElements.LoginPassword);

	static By loginButton = By.xpath(ElementRepository.LoginPageElements.loginButton);

	public LognPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		LognPage.driver= driver;
	}


	public WebDriver loginToEventEnergies(String uid,String pass){

		driver.findElement(Login).click();

		driver.findElement(LoginUserName).sendKeys(uid);

		driver.findElement(LoginPassword).sendKeys(pass);

		driver.findElement(loginButton).click();

		return driver;
	}



}
