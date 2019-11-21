package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegistrationPage {

	public static boolean status = true;
	public static boolean navigateToRegisterPage(String browserName, WebDriver driver) 
	{
		try
		{
			// verify the register button
			System.out.println("\nVerify the presence of Register Button");
			//WebDriver driver = DriverManager.BaseDriver.getDriverConn(browserName);
			WebElement registerNow = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.registrationButton));
			System.out.printf("browser=",browserName,"driver=",driver);
			if (registerNow.isDisplayed() && registerNow.isEnabled())
			{
				System.out.println("Register button is displayed and enabled.");
			}else {
				System.out.println("Register button is not displayed nor enabled.");
				status = false;
			}
			registerNow.click();
			Thread.sleep(1000);
			System.out.println("\nVerify the presence of EventAttendee registration");
			WebElement attendee = driver.findElement(By.xpath(ElementRepository.RegistrationPageElements.EventAttendee));
			if(attendee.isEnabled())
			{
				System.out.println("Event Attendee is Displayed");
			}else {
				System.out.println("Event Attendee is not Displayed");
			}
			attendee.click();
			Thread.sleep(1000);
			System.out.println("\nVerify the presence of EventEnergies Title");
			WebElement title = driver.findElement(By.linkText(ElementRepository.RegistrationPageElements.RegisterTitle));
			if(title.isDisplayed())
			{
				System.out.println("EventEnergies title is Displayed");
			}else {
				System.out.println("EventEnergies title not Displayed");
			}
			Thread.sleep(1000);
			System.out.println("verify the pressence of EventEnergies Subtitle");
			WebElement subTitle = driver.findElement(By.cssSelector(ElementRepository.RegistrationPageElements.RegisterSubTitle));
			if(subTitle.isDisplayed())
			{
				System.out.println("EventEnergies subtitle is Displayed");
			}else {
				System.out.println("EventEnergies subtitle is not Displayed");
			}

			Thread.sleep(1000);
			//verify registration for attendee
			ReadExcel(browserName, driver);

		}catch (Exception E) 
		{
			E.printStackTrace();
		}
		return status;
	}

	private static void ReadExcel(String browserName, WebDriver driver) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("D:\\eventenergies\\EventBooking\\src\\test\\java\\TestManager\\Login .xlsx");
		@SuppressWarnings("resource")
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
			System.out.println(sheet.getRow(i).getCell(0));

			//import data for last name
			System.out.print("lastname:");
			cell = sheet.getRow(i).getCell(1); 
			WebElement lastname = driver.findElement(By.name(ElementRepository.RegistrationPageElements.RegisterLastNamefield));
			lastname.sendKeys(cell.getStringCellValue());
			Thread.sleep(1000);
			System.out.println(sheet.getRow(i).getCell(1));
			
			//import data for mobile number
			System.out.print("contact number:");
			cell = sheet.getRow(i).getCell(2); 
			WebElement contactNumber = driver.findElement(By.id(ElementRepository.RegistrationPageElements.RegisterPhonefield));
			contactNumber.sendKeys(cell.getStringCellValue());
			Thread.sleep(1000);
			System.out.println(sheet.getRow(i).getCell(1));
			
			firstname.clear(); lastname.clear();contactNumber.clear();

		} 


	} 

}





