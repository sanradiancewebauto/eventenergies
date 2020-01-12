package CommonLibs;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageFactory.EventsPage;

public class UploadDownloadFiles {
	static Logger log = LogManager.getLogger(EventsPage.class.getName());
	public static String absolute_file_dir = "/Users/arif/Desktop/EventTestData";
	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
	public static void uploadDownloadFiles(WebDriver driver, String fileType, String fileSize) throws Exception {
		try {
			WebElement file_input = driver.findElement(By.id("main_file"));
	    	if (fileType.equals("image")) {
	    		String absolute_file_path = absolute_file_dir + "/" + "crowd.jpeg";
	    		file_input.sendKeys(absolute_file_path);
	    		Thread.sleep(2000);
	    	}else if (fileType.equals("video")) {
	    		String absolute_file_path = absolute_file_dir + "/" + "SampleVideo_1280x720_1mb.mp4";
	    		file_input.sendKeys(absolute_file_path);
	    		Thread.sleep(3000);
	    	}else if (fileType.equals("pdf")) {
	    		String absolute_file_path = absolute_file_dir + "/" + "pdf-sample-3.pdf";
	    		file_input.sendKeys(absolute_file_path);
	    		Thread.sleep(5000);
	    		Actions action = new Actions(driver);
	    		action.sendKeys(Keys.ESCAPE).perform();
	    	}
	    	else {
	    		log.error("Invalid file input type {}", fileType);
	    	}
	    	Thread.sleep(5000);
		}catch (Exception E) 
		{
			E.printStackTrace();
		}
    		
		
	}

}
