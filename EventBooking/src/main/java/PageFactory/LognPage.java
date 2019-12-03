package PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LognPage {

	public static WebDriver driver = null ;
	public static boolean mainLoginClick(String browserName, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("here");
		WebElement LoginButton = driver.findElement(By.cssSelector(ElementRepository.MainPageElements.loginButton));
		LoginButton.click();
		System.out.println("done");
		return true;
	}

	
}
