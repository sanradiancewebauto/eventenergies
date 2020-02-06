package DriverManager;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseDriver {

	public static String pwd = System.getProperty("user.dir");
	public static WebDriver driver = null;
	public static String driverLocation = pwd + "/src/main/java/" + "BrowserDrivers" + "/";
	public static final String baseURL = "https://www.eventenergies.com";
	
	// CALL WEB BROWSER AND OPEN WEBSITE
	public static WebDriver getDriverConn(String browserName) throws Exception {
		File folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		try {
			switch (browserName) {
			case "firefox":
				FirefoxProfile ffprofile = new FirefoxProfile();
				ffprofile.setAcceptUntrustedCertificates(true);
				// Instructing firefox to use custom download location
				ffprofile.setPreference("browser.download.folderList", 2);
				// Setting custom download directory
				ffprofile.setPreference("browser.download.dir", folder.getAbsolutePath());
				// Skipping Save As dialog box for types of files with their MIME
				ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		                "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");

				FirefoxOptions options = new FirefoxOptions();
	            options.setProfile(ffprofile);
				// code to system props and instantiate the driver
				System.setProperty("webdriver.gecko.driver", driverLocation + "geckodriver.exe");
				// Instantiating driver object and launching browser
				driver = new FirefoxDriver(options);
				
				break;
			case "chrome":
				// code to system props and instantiate the driver
				System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
				
				/*Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory", folder.getAbsolutePath());
				*/
				// Instantiating driver object
				driver = new ChromeDriver();
				break;
			case "ie":
				// code to system props and instantiate the driver
				System.setProperty("webdriver.chrome.driver", driverLocation + "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "safari":
				// code to system props and instantiate the driver
				driver = new SafariDriver();
				break;
			default:
				throw new Exception("Unsupported browser: " + browserName);
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		driver.manage().window().maximize();
		// Initailize the base URL="https://www.storytwinkle.com"
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeDriver() throws Exception {
		try {
			System.out.println("Closing browser.");
			driver.quit();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	public static void main() throws Exception {
		getDriverConn("firefox");
		System.out.println("I am at firefox");
	}

	@Override
	public String toString() {
		return "BaseDriver []";
	}
}
