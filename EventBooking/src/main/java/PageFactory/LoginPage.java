package PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;



public class LoginPage {

	public static WebDriver driver = null ;
	public static HashMap<String, String> returnValues =  new HashMap<String, String>();
	final String classVal = this.getClass().getSimpleName();
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public static Object userLoginElementDisplay(String browserName, WebDriver driver) throws InterruptedException {
		returnValues.put("status","true");
		log.info("Step1: Navigate to the Login window from the Main page.");
		Thread.sleep(10000);
		WebElement loginButton = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.loginButton));
		loginButton.click();
		log.info("Step2: Verify login page visible after navigation.");
		WebElement loginPageTitle = driver.findElement(By.xpath(ElementRepository.LoginPageElements.LoginTitle));
		if (loginPageTitle.isDisplayed()) {
			log.info("Login page title displayed");
			if (loginPageTitle.getText() == "Sign in to get going."){
				log.info("Login page title text [%s] is valid.", loginPageTitle.getText());
			}else {
				log.error("Login page title text is Invalid");
				returnValues.put("status", "false");
				returnValues.put("Title", loginPageTitle.getText());
				return returnValues;
			}
		}else {
			log.error("Login page title not displayed.");
			returnValues.put("status", "false");
			return returnValues;
		}
		log.info("Step3: Verify the login page fields display");
		WebElement emailAddressLabel = driver.findElement(By.cssSelector(ElementRepository.LoginPageElements.LoginEmailAddresslabel));
		if (emailAddressLabel.isDisplayed()){
			log.info("Email label on Login page displayed.");
			WebElement LoginUserEmail = driver.findElement(By.id(ElementRepository.LoginPageElements.LoginUserName));
			if (LoginUserEmail.isEnabled()) {
				log.info("Email text field is enabled.");
			}else {
				log.error("Email text field is not enabled.");
				returnValues.put("status", "false");
			}
		}else {
			log.info("Email label on Login page not displayed.");
			returnValues.put("status", "false");
		}
		
		return returnValues;
	}

	
}
