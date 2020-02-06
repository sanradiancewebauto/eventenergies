package PageFactory;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonLibs.Utils;

public class RegistrationPage {
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	public static boolean status = true;
	public static String pwd = System.getProperty("user.dir");
	
	public static boolean navigateToRegisterPage(String browserName, WebDriver driver, String autoRegisterUserFlag, HashMap<String, String> autoRegisterUserData) 
	{
		try
		{
			// verify the register button
			log.info("Verify the presence of Register Button");
			//WebDriver driver = DriverManager.BaseDriver.getDriverConn(browserName);
			WebElement registerNow = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.registrationButton));
			System.out.printf("browser=",browserName,"driver=",driver);
			if (registerNow.isDisplayed() && registerNow.isEnabled())
			{
				log.info("Register button is displayed and enabled.");
			}else {
				log.info("Register button is not displayed nor enabled.");
				status = false;
			}
			registerNow.click();
			Thread.sleep(1000);
			log.info("Verify the presence of EventAttendee registration");
			WebElement attendee = driver.findElement(By.xpath(ElementRepository.RegistrationPageElements.EventAttendee));
			if(attendee.isEnabled())
			{
				log.info("Event Attendee is Displayed");
			}else {
				log.info("Event Attendee is not Displayed");
				status = false;
			}
			attendee.click();
			Thread.sleep(1000);
			log.info("Verify the presence of EventEnergies Title");
			WebElement title = driver.findElement(By.linkText(ElementRepository.RegistrationPageElements.RegisterTitle));
			if(title.isDisplayed())
			{
				log.info("EventEnergies title is Displayed");
			}else {
				log.info("EventEnergies title not Displayed");
				status = false;
			}
			Thread.sleep(1000);
			log.info("verify the pressence of EventEnergies Subtitle");
			WebElement subTitle = driver.findElement(By.cssSelector(ElementRepository.RegistrationPageElements.RegisterSubTitle));
			if(subTitle.isDisplayed())
			{
				log.info("EventEnergies subtitle is Displayed");
			}else {
				log.info("EventEnergies subtitle is not Displayed");
				status = false;
			}

			Thread.sleep(1000);
			//verify registration for attendee
			if (autoRegisterUserFlag=="yes") {
				status = autoRegisterUserData(driver, autoRegisterUserData);
				
			}else {
				ReadExcel(browserName, driver);
			}
			log.info("Verify new user registration.");

		}catch (Exception E) 
		{
			E.printStackTrace();
		}
		return status;
	}

	private static boolean autoRegisterUserData(WebDriver driver, HashMap<String, String> autoRegisterUserData) throws InterruptedException {
		// TODO Auto-generated method stub
		log.info("First user = {}", autoRegisterUserData.get("EMAILID"));
		log.info("First password = {}", autoRegisterUserData.get("PASSWORD"));
		log.info("Implementation of auto generated Email ID registration.");
		String countryCode = "+91";
		WebElement firstname = driver.findElement(By.name(ElementRepository.RegistrationPageElements.RegisterFirstNamefield));
		firstname.sendKeys(autoRegisterUserData.get("FIRSTNAME"));
		Thread.sleep(2000);
		WebElement lastname = driver.findElement(By.name(ElementRepository.RegistrationPageElements.RegisterLastNamefield));
		lastname.sendKeys(autoRegisterUserData.get("LASTNAME"));
		Thread.sleep(1000);
		WebElement contactNumber = driver.findElement(By.id(ElementRepository.RegistrationPageElements.RegisterPhonefield));
		final int phoneNumber = RandomUtils.nextInt(900) + 100;
		if (autoRegisterUserData.get("LASTNAME").equals("US")) {
			countryCode = "+1";
		}else if (autoRegisterUserData.get("LASTNAME").equals("AU")) {
			countryCode = "+16";
		}
		contactNumber.sendKeys(countryCode + "7733404" + phoneNumber);
		Thread.sleep(1000);
		WebElement emailID = driver.findElement(By.name(ElementRepository.RegistrationPageElements.EmailField));
		emailID.sendKeys(autoRegisterUserData.get("EMAILID"));
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.name(ElementRepository.RegistrationPageElements.PasswordField));
		password.sendKeys(autoRegisterUserData.get("PASSWORD"));
		Thread.sleep(1000);
		WebElement checkbox = driver.findElement(By.cssSelector(ElementRepository.RegistrationPageElements.CheckboxLabel));
		checkbox.click();
		Thread.sleep(1000);
		WebElement submitBtn = driver.findElement(By.cssSelector(ElementRepository.RegistrationPageElements.SubmitButton));
		if (submitBtn.isEnabled()){
			submitBtn.click();
			Thread.sleep(1000);
			status = true;
		}else {
			log.info("Submit button is not enabled. Please check the form input.");
			status = false;
		}
		
		return status;
	}

	private static void ReadExcel(String browserName, WebDriver driver) throws Exception {
		
		String userExcelLocation = pwd + "\\src\\test\\java\\TestManager\\" + "Login.xlsx"; 
		String dynamicPath = Utils.separatorsToSystem(userExcelLocation);
		FileInputStream fis = new FileInputStream(dynamicPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		for(int i=1; i<=sheet.getLastRowNum(); i++) { 
			//import data for first name
			cell = sheet.getRow(i).getCell(0); 
			System.out.print("firstname");
			WebElement firstname = driver.findElement(By.name(ElementRepository.RegistrationPageElements.RegisterFirstNamefield));
			firstname.sendKeys(cell.getStringCellValue());
			Thread.sleep(2000);
			log.info(sheet.getRow(i).getCell(0));

			//import data for last name
			log.info("lastname:");
			cell = sheet.getRow(i).getCell(1); 
			WebElement lastname = driver.findElement(By.name(ElementRepository.RegistrationPageElements.RegisterLastNamefield));
			lastname.sendKeys(cell.getStringCellValue());
			Thread.sleep(1000);
			log.info(sheet.getRow(i).getCell(1));
			
			//import data for mobile number
			System.out.print("contact number:");
			cell = sheet.getRow(i).getCell(2); 
			WebElement contactNumber = driver.findElement(By.id(ElementRepository.RegistrationPageElements.RegisterPhonefield));
			contactNumber.sendKeys(cell.getStringCellValue());
			Thread.sleep(1000);
			log.info(sheet.getRow(i).getCell(1));
			
			firstname.clear(); lastname.clear();contactNumber.clear();

		} 


	} 

}





