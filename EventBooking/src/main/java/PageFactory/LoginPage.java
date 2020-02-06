package PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import CommonLibs.TitleVerification;
import ElementRepository.LoginPageElements;

import java.util.HashMap;
import java.util.List;



public class LoginPage {

	public static WebDriver driver = null ;
	public static HashMap<String, String> returnValues =  new HashMap<String, String>();
	final String classVal = this.getClass().getSimpleName();
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public static Object userLoginElementDisplay(String browserName, WebDriver driver, String username, String password, 
			String logoutValue) throws Exception {
		returnValues.put("status","true");
		log.info("Step2: Verify login page visible after navigation.");
		WebElement loginPageTitle = driver.findElement(By.xpath(ElementRepository.LoginPageElements.LoginTitle));
		if (loginPageTitle.isDisplayed()) {
			log.info("Login page title is displayed.");
			returnValues.put("Title", loginPageTitle.getText());
			boolean status = TitleVerification.verify_title(loginPageTitle.getText());
			if (status != true){
				returnValues.put("status","false");
				return returnValues;
			}
		}else {
			log.error("Login page title not displayed.");
			returnValues.put("status", "false");
			return returnValues;
		}
		log.info("Step3: Verify the login page fields display.");
		WebElement emailAddressLabel = driver.findElement(By.cssSelector(ElementRepository.LoginPageElements.LoginEmailAddresslabel));
		WebElement passwordLabel = driver.findElement(By.cssSelector(ElementRepository.LoginPageElements.LoginPasswordlabel));
		if (emailAddressLabel.isDisplayed() && passwordLabel.isDisplayed()){
			log.info("Email and password label on Login page displayed.");
			WebElement loginUserEmail = driver.findElement(By.id(ElementRepository.LoginPageElements.LoginUserName));
			WebElement loginPassword = driver.findElement(By.id(ElementRepository.LoginPageElements.LoginPassword));
			if (loginUserEmail.isEnabled() && loginPassword.isEnabled()) {
				log.info("Step4: Verify the user login and logout feature.");
				log.info("Email and Password text field are enabled.");
				log.info("Enter the user name=[{}] and password=[{}] ", username, password);
				loginUserEmail.clear();
				loginPassword.clear();
				loginUserEmail.sendKeys(username);
				loginPassword.sendKeys(password);
				WebElement loginBtn = driver.findElement(By.xpath(ElementRepository.LoginPageElements.loginButton));
				loginBtn.click();
				Thread.sleep(1000);
				log.info("Step4: Check if credentials are valid or invalid.");
				Thread.sleep(2000);
				if (driver.findElement(By.xpath(ElementRepository.LoginPageElements.loginErrorPopup)).isDisplayed()) {
					WebElement errorPopup = driver.findElement(By.xpath(ElementRepository.LoginPageElements.loginErrorPopup));
					boolean verify_status = TitleVerification.verify_title(errorPopup.getText());
					log.error("Login credentials are invalid, failed with error [{}]", errorPopup.getText());
					returnValues.put("verify_status", Boolean.toString(verify_status));
					returnValues.put("status", "invalid");
				}else if (logoutValue.equals("yes")) {
					WebElement userSetting = driver.findElement(By.cssSelector(LoginPageElements.userSetting));
					if (userSetting.isDisplayed()) {
						userSetting.click();
						Thread.sleep(2000);
						log.info("Login credentials are valid, user login successful.");
						WebElement settingMenu = driver.findElement(By.cssSelector(LoginPageElements.userSettingMenu));
						List<WebElement> userSettingMenu = settingMenu.findElements(By.tagName("li"));
						for (int i=0; i<userSettingMenu.size();i++){	 
							log.info("Traversal to search [Logout] button.");
							log.debug("Get all the menu list text :{}: ", userSettingMenu.get(i).getText());
							if ((userSettingMenu.get(i).getText()).equals("Logout")) {
								log.info("Found logout button.");
								Thread.sleep(2000);
								userSettingMenu.get(i).click();
							}
						}
						Thread.sleep(1000);	
						returnValues.put("status", "true");
					}
				}else {
					log.info("Continue on the further test");
					Thread.sleep(2000);
					returnValues.put("status", "true");
				}

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
