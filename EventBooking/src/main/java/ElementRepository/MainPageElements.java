package ElementRepository;

public class MainPageElements {
	
	// Capture the Main page Element identifier
	public static String logoIcon = ".navbar-header > img:nth-child(2)"; //CSS Selector
	public static String logoTitle = ".navbar-header > span:nth-child(3)"; // CSS Selector
	public static String registrationButton = ".nav > li:nth-child(1) > a:nth-child(1) > input:nth-child(1)" ; // CSS Selector
	public static String loginButton = ".nav > li:nth-child(2) > a:nth-child(1) > input:nth-child(1)";// CSS Selector
	public static String iterateItem(int i) {
		//String sliderBtn = "#slick-slide-control" + iterValue; //CSS Selector
		String eventImg = String.format("/html/body/app-root/app-home-page/section[1]/div/ngx-slick-carousel/div/div/div[%s]/a/img", i);
		return eventImg;
	}
	public static String sliderDotsMenu = ".slick-dots";
	public static String iterateItemSliderDots(int i) {
		String dotBtn = String.format("//button[@id='slick-slide-control0%s']",i); 
		return dotBtn;
	}
	
	
	
		
}