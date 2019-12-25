package PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CommonLibs.TitleVerification;
import java.util.HashMap;



public class LoginPage {

	public static WebDriver driver = null ;
	public static HashMap<String, String> returnValues =  new HashMap<String, String>();
	final String classVal = this.getClass().getSimpleName();
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public static Object userLoginElementDisplay(String browserName, WebDriver driver, String username, String password) throws Exception {
		returnValues.put("status","true");
		log.info("Step2: Verify login page visible after navigation.");
		WebElement loginPageTitle = driver.findElement(By.xpath(ElementRepository.LoginPageElements.LoginTitle));
		if (loginPageTitle.isDisplayed()) {
			log.info("Login page title displayed");
			returnValues.put("Title", loginPageTitle.getText());
			boolean status = TitleVerification.verify_login_title(loginPageTitle.getText());
			log.info("The status is {}",status);
			if (status != true){
				returnValues.put("status","false");
				return returnValues;
			}
		}else {
			log.error("Login page title not displayed.");
			returnValues.put("status", "false");
			return returnValues;
		}
		log.info("Step3: Verify the login page fields display");
		WebElement emailAddressLabel = driver.findElement(By.cssSelector(ElementRepository.LoginPageElements.LoginEmailAddresslabel));
		WebElement passwordLabel = driver.findElement(By.cssSelector(ElementRepository.LoginPageElements.LoginPasswordlabel));
		if (emailAddressLabel.isDisplayed() && passwordLabel.isDisplayed()){
			log.info("Email and password label on Login page displayed.");
			WebElement loginUserEmail = driver.findElement(By.id(ElementRepository.LoginPageElements.LoginUserName));
			WebElement loginPassword = driver.findElement(By.id(ElementRepository.LoginPageElements.LoginPassword));
			if (loginUserEmail.isEnabled() && loginPassword.isEnabled()) {
				log.info("Email and Password text field are enabled.");
				log.info("Enter the user name=[{}] and password=[{}] ]", username, password);
				log.info("Step4: Verify the user login and logout feature.");
				loginUserEmail.sendKeys(username);
				loginPassword.sendKeys(password);
				WebElement loginBtn = driver.findElement(By.xpath(ElementRepository.LoginPageElements.loginButton));
				loginBtn.click();
				Thread.sleep(1000);
				WebElement userSetting = driver.findElement(By.xpath(ElementRepository.LoginPageElements.userSetting));
				userSetting.click();
				Thread.sleep(1000);
				WebElement logoutBtn = driver.findElement(By.xpath(ElementRepository.LoginPageElements.userLogoutButton));
				logoutBtn.click();
				Thread.sleep(1000);
				returnValues.put("status", "true");
				
			}else {
				log.error("Email and Password text field is not enabled.");
				returnValues.put("status", "false");
			}
		}else {
			log.info("Email label on Login page not displayed.");
			returnValues.put("status", "false");
		}
		return returnValues;
		
	}

	
}
