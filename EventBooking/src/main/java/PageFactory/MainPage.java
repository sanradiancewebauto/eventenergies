package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public static boolean status = true;
	public static boolean checkMenuBarItems(String browserName, WebDriver driver) 
	{
		try
		{
			// Check log, search, Registration, Login items
			System.out.println("\nVerify the presence of MainPage Elements");
			//WebDriver driver = DriverManager.BaseDriver.getDriverConn(browserName);
			System.out.println("Verify presence of logo.");
			WebElement icon_st = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.logoIcon));
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ElementRepository.MainPageElements.logoIcon))); 
			if (icon_st.isDisplayed())
			{
				System.out.println("Eventenergise LOGO displayed.");
			}else {
				System.out.println("Eventenergise LOGO not displayed.");
				status = false;
			}
			Thread.sleep(1000);
			System.out.println("Verify presence of Eventenergise LOGO title.");
			WebElement logo_Title = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.loginButton));
			if (logo_Title.isDisplayed())
			{
				System.out.println("Eventenergise logo title displayed");
			}else {
				System.out.println("Eventenergise Login button not displayed nor enabled.");
				status = false;
			}
			Thread.sleep(1000);
			System.out.println("Verify presence of search button.");
			WebElement search_Btn = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.searchButton));
			if (search_Btn.isDisplayed())
			{
				System.out.println("Eventenergise search button displayed.");
			}else {
				System.out.println("Eventenergise search button not displayed.");
				status = false;
			}
			Thread.sleep(1000);
			System.out.println("Verify presence of Registration button.");
			WebElement registration_Btn = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.registrationButton));
			if (registration_Btn.isDisplayed() && registration_Btn.isEnabled())
			{
				System.out.println("Eventenergise Registration button displayed.");
			}else {
				System.out.println("Eventenergise Registration button not displayed.");
				status = false;
			}
			Thread.sleep(1000);
			System.out.println("Verify presence of Login button.");
			WebElement login_Btn = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.loginButton));
			if (login_Btn.isDisplayed() && login_Btn.isEnabled())
			{
				System.out.println("Eventenergise Login button displayed and enabled");
			}else {
				System.out.println("Eventenergise Login button not displayed nor enabled.");
				status = false;
			}
			Thread.sleep(1000);
		}catch (Exception E) 
		{
			 E.printStackTrace();
		}
		return true;
	}


}
