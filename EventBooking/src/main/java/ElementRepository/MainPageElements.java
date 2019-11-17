package ElementRepository;

public class MainPageElements {
	
	// Capture the Main page Element identifier
	public static String logoIcon = ".navbar-header > img:nth-child(1)"; // CSS Selector
	public static String logoTitle = ".navbar-header > span:nth-child(2)"; // CSS Selector
	public static String searchButton = "li.default-right:nth-child(1) > div:nth-child(1)"; // CSS Selector
	public static String registrationButton = "li.default-right:nth-child(2) > a:nth-child(1) > input:nth-child(1)" ; // CSS Selector
	public static String loginButton = "li.default-right:nth-child(3) > a:nth-child(1) > input:nth-child(1)"; // CSS Selector
	public static String mainPageEvents = "/html/body/app-root/app-home-page/section[2]/div/carousel/div"; //XPath
}
