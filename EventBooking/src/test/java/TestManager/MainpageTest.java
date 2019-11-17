package TestManager;

public class MainpageTest {
	public static String browserName = "firefox";
	public static void main(String[] args) throws Exception{
		//LOGIN TO SITE
		System.out.printf("Setting test browser as :", browserName);
		PageFactory.MainPage.checkMenuBarItems(browserName);
		//Thread.sleep(30);
		DriverManager.BaseDriver.closeDriver();
	}
		    

}
