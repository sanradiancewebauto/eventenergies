package PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			if (icon_st.isDisplayed())
			{
				System.out.println("Eventenergise LOGO displayed.");
			}else {
				System.out.println("Eventenergise LOGO not displayed.");
				status = false;
			}
			Thread.sleep(1000);
			System.out.println("Verify presence of Eventenergise LOGO title.");
			WebElement logo_Title = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.logoTitle));
			if (logo_Title.isDisplayed())
			{
				System.out.println("Eventenergise logo title displayed");
			}else {
				System.out.println("Eventenergise Login button not displayed nor enabled.");
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
		return status;
	}
	
	public static boolean checkEventSlider(String browserName, WebDriver driver) 
	{
		try
		{
			
			System.out.println("Verify presence of main page event slider.");
			List<WebElement> eventCounts = (List<WebElement>) driver.findElements(By.className("title-slider"));
			System.out.printf("\nDisplaying event count on the MainPage slider %s.",eventCounts.size());
			for(int i=1; i < eventCounts.size(); i++) {
				System.out.printf("\nGetting details of event number [%S]",i);
				System.out.printf("\nEvent Title : " + eventCounts.get(i).getText());
				System.out.printf("\nCheck if the event image is displayed and responsive. ");
				WebElement eventImage = eventCounts.get(i).findElement(By.xpath(ElementRepository.MainPageElements.iterateItem(i)));
				if (eventImage.getAttribute("class").equals("img-responsive")){
						System.out.printf("Event image is clickable.");
				}else {
					System.out.printf("Event image is not clickable.");
					status = false;
				}
			}
			System.out.println("\nVerify slider dots functionality.");
			WebElement sliderDotsMenu = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.sliderDotsMenu));
			if (sliderDotsMenu.isDisplayed()) {
				System.out.println("Slider dots menu bar is visiable.");
				System.out.println("Check the button functionality.");
				for (int i=0; i<=5; i++) {
					WebElement eventDots = driver.findElement(By.xpath(ElementRepository.MainPageElements.iterateItemSliderDots(i)));
					if (eventDots.isDisplayed()) {
						System.out.printf("\nSlider dot button is clickable. %s", eventDots.getTagName());
						Thread.sleep(500);
						eventDots.click();
						WebElement activeEvent = driver.findElement(By.className("slick-active"));
						System.out.printf("\nDisplaying active event on the MainPage Slider.",activeEvent);
						
					}else {
						System.out.println("Slider dotbutton not clickable.");
						status = false;
					}
				}
				
			}else {
				System.out.println("Slider dots menu not visiable");
				status = false;
			}
			
			Thread.sleep(1000);		
		}catch (Exception E) {
			E.printStackTrace();
			System.out.println("Test failure due to exception.");
			status=false;
		}
		return status;
		
	}
}


/*
WebElement  mainPageEventSlide = driver.findElement(By.xpath(ElementRepository.MainPageElements.mainPageEvents));
//WebDriverWait wait = new WebDriverWait(driver, 10);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ElementRepository.MainPageElements.logoIcon))); 
if (mainPageEventSlide.isDisplayed())
{
	System.out.println("Eventenergise main page event slider displayed.");
}else {
	System.out.println("Eventenergise main page event slider not displayed.");
	status = false;
}
Thread.sleep(1000);

//WebElement  mainPageEventsRollBtnRight = driver.findElement(By.xpath(ElementRepository.MainPageElements.mainPageEventsRollBtnRight));
//WebElement  mainPageEventsRollBtnLeft = driver.findElement(By.xpath(ElementRepository.MainPageElements.mainPageEventsRollBtnLeft));
if (mainPageEventsRollBtnRight.isDisplayed() && mainPageEventsRollBtnLeft.isDisplayed())
{
	System.out.println("Eventenergise main page event slider roll button displayed.");
	System.out.println("Verify slider roll-up feature");
	List<WebElement> eventCounts = (List<WebElement>) driver.findElements(By.className("slide slick-slide"));
	System.out.printf("\nDisplaying %i events on the MainPage Slider.",eventCounts.size());
	for(int numofevent=1; numofevent <= eventCounts.size(); numofevent++) {
		System.out.println("Getting each event details.");
		//WebElement  mainPageEventsRollBtnLeft = driver.findElement(By.xpath(ElementRepository.MainPageElements.
			//	"body > app-root > app-home-page > section:nth-child(3) > div > carousel > div > div > slide:nth-child(3) > div > a > div > div.title-slider"
		
		mainPageEventsRollBtnRight.click();
		Thread.sleep(5000);
		mainPageEventsRollBtnLeft.click();
	
	}
}

else {
	System.out.println("Eventenergise main page event slider roll button not displayed..");
	status = false;
}
*/
