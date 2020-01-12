package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ElementRepository.*;
import CommonLibs.*;

public class EventsPage {

	public static HashMap<String, String> returnValues =  new HashMap<String, String>();
	static Logger log = LogManager.getLogger(EventsPage.class.getName());
	static String logoutValue = "no";
	

	public static Object CreateEvents(String browserName, WebDriver driver, HashMap<String, String> testdata) throws Exception  {
		try {
			returnValues.put("EventStatus", "false");
			log.info("Step 1: Navigate to the Add Event Details for event creation.");
			WebElement createEventsBtn = driver.findElement(By.xpath(EventCreationPageElements.eventCreateButton));
			if (createEventsBtn.isDisplayed()) {
				createEventsBtn.click();
				Thread.sleep(2000);
			}
			WebElement eventPageTitle = driver.findElement(By.xpath(EventCreationPageElements.eventPageTitle));
			if (TitleVerification.verify_title(eventPageTitle.getText()) == true) {
				log.info("Navigation to Event Details page successful");
			}else {
				log.error("Navigation to Event Details page failed.");
				returnValues.put("EventStatus", "false");
			}
			WebElement eventLabel = driver.findElement(By.linkText(EventCreationPageElements.eventLabel));
			if (TitleVerification.verify_title(eventLabel.getText()) == true) {
				log.info("Event lable appears to be correct.");
			}else {
				log.error("Event lable appears to be in-correct.");
				returnValues.put("EventStatus", "false");
			}
			log.info("Step 2: Create a Event with following details :");
//			WebElement eventTitle = driver.findElement(By.cssSelector(EventCreationPageElements.eventTitle));
//			log.info("Event Left Section");
//			log.info("Enter the event Title as [{}]", testdata.get("EventTitle"));
////			eventTitle.click();
//        	Thread.sleep(1000);
//        	eventTitle.sendKeys(testdata.get("EventTitle"));
//        	Thread.sleep(1000);
//			List<WebElement> eventElements = driver.findElements(By.xpath(EventCreationPageElements.eventInputFields));
//			for (int i=0; i<eventElements.size();i++){	  
//				WebElement eventAddIcon = driver.findElement(By.id(EventCreationPageElements.eventAddIcon));
//				eventAddIcon.click();
//				Thread.sleep(1000);
//				log.info("Add event [{}] as [{}] ",eventElements.get(i).getText(), eventElements.get(i).getAttribute("title"));	        
//		        Thread.sleep(1000); 
//		        eventElements.get(i).click();
//		        Thread.sleep(1000);
//		        String isTitle = eventElements.get(i).getAttribute("title");
//		        log.info("testing the text + {}", isTitle);
//		        if (isTitle.matches("Add text")) {
//			        log.info("Enter the event description title as [{}].",testdata.get("EventDescription"));
//			        WebElement eventDescriptionTitle = driver.findElement(By.cssSelector(EventCreationPageElements.eventDescriptionTitle));
//			        if (eventDescriptionTitle.isDisplayed()){
//			        	eventDescriptionTitle.click();
//			        	Thread.sleep(1000);
//			        	eventDescriptionTitle.sendKeys(testdata.get("EventDescription"));
//			        	Thread.sleep(1000);
//			        	log.info("Enter the event description details as [{}].",testdata.get("EventDescriptionDetails"));
//			        	WebElement eventDescriptionContents = driver.findElement(By.cssSelector(EventCreationPageElements.eventDescriptionContents));
//			        	eventDescriptionContents.click();
//			        	Thread.sleep(1000);
//			        	eventDescriptionContents.sendKeys(testdata.get("EventDescriptionDetails"));
//			        	Thread.sleep(1000);
//			        	returnValues.put("EventStatus", "true");
//			        }else {
//			        	returnValues.put("EventStatus", "false");
//			        }
//		        }else if (isTitle.matches("Add images")) {
//		        	log.info("Upload image to the event from system location.");
//		        	CommonLibs.UploadDownloadFiles.uploadDownloadFiles(driver, "image", "1M");
//		        }else if (isTitle.matches("Add video")) {
//		        	log.info("Upload video to the event from system location.");
//		        	CommonLibs.UploadDownloadFiles.uploadDownloadFiles(driver, "video", "1M");
//		        	returnValues.put("EventStatus", "true");
//		        }else if (isTitle.matches("Add pdf")) {
//		        	log.info("Upload PDF file to the event from system location.");
//		        	CommonLibs.UploadDownloadFiles.uploadDownloadFiles(driver, "pdf", "1M");
//		        	returnValues.put("EventStatus", "true");
//		        }else if (isTitle.matches("Open Camera")) { 
//		        	driver.findElement(By.cssSelector(EventCreationPageElements.closeCamera)).click();
//		        	log.info("Capture camera image and upload to the event.");
//		        	//continue;
//		        }else {
//		        	log.error("Invalid event details input : {} ", isTitle);
//		        	returnValues.put("EventStatus", "false");
//		        }
//			}
			log.info("Event Right Section");
			log.info("Select the event type.");
			if (testdata.get("EventType").equals("Public")) {
				driver.findElement(By.cssSelector(EventCreationPageElements.eventTypePublic)).click();
			}else {
				driver.findElement(By.cssSelector(EventCreationPageElements.eventTypePrivate)).click();
			}
			WebElement categoryLabel = driver.findElement(By.cssSelector(EventCreationPageElements.categoryLabel));
			if (categoryLabel.getText().equals("Select category")) {
				log.info("I am inside select categoryyyyy");
				WebElement categoryField = driver.findElement(By.id(EventCreationPageElements.categoryField));
				categoryField.click();
				WebElement categoryMenuBox = driver.findElement(By.cssSelector(EventCreationPageElements.categoryDropDownMenu));
				List<WebElement> categoryMenuItems = categoryMenuBox.findElements(By.xpath(EventCreationPageElements.categoryMenuItems));
				for (WebElement catogery : categoryMenuItems)
				{
				    if (catogery.getText().equals(testdata.get("SelectCategory")))
				    {
				    	log.info("Selecting the event category as [{}]",testdata.get("SelectCategory"));
				    	catogery.click(); // click the desired option
				        break;
				    }
				}
				Thread.sleep(2000);
				WebElement subCategoryMenu = driver.findElement(By.cssSelector(EventCreationPageElements.subCategoryDropDownMenu));
				List<WebElement> subCategoryMenuItems = subCategoryMenu.findElements(By.xpath(EventCreationPageElements.subCategoryMenuItems)); 
				log.info("Selecting event sub-category from the list = {}.", subCategoryMenuItems.get(0).getText());
				for ( WebElement subcategory : subCategoryMenuItems ) {
					if(testdata.get("SubCategory").equals(subcategory.getText())) {
						log.info("Selecting the event subcategory as [{}]",testdata.get("SubCategory"));
						subcategory.click();
						break;
					}else if (testdata.get("SubCategory").equals("random")) {
						log.info("Selecting event sub-category from the list as [{}]", subCategoryMenuItems.get(0).getText());
						subcategory.click();
						break;
					}
				}
			}
			log.info("Date processing.");
			final Map<String, String> checkdateValues = EventsPage.dateProcessing(driver, testdata);
			if (checkdateValues.get("DateStatus").equals("false")){
				returnValues.put("EventStatus", "false");
			}else {
				returnValues.put("EventStatus", "true");
			}

			
			
		}catch (Exception E) 
		{
			 E.printStackTrace();
		}
		
		return returnValues;
		
	}


	public static HashMap<String, String> dateProcessing(WebDriver driver,  HashMap<String, String> testdata) throws Exception {
		
		HashMap<String, String> dateStatus = new HashMap<String, String>();
		try {
			returnValues.put("DateStatus", "false");
			if (driver.findElement(By.cssSelector(EventCreationPageElements.whenLabel)).getText().contentEquals("When")) {
				log.info("Selection of event dates, under 'When' table");
				
				HashMap<String, String> datetimevalues = getDateTime(testdata.get("StartDate"));
				
				WebElement startDateLabel = driver.findElement(By.cssSelector(EventCreationPageElements.startDateLabel));
				startDateLabel.click();
				while (true) {
					WebElement sMonth = driver.findElement(By.cssSelector(EventCreationPageElements.sMonth));
					WebElement sYear = driver.findElement(By.cssSelector(EventCreationPageElements.sYear));
					if (sMonth.getText().equals(datetimevalues.get("month")) && sYear.getText().equals(datetimevalues.get("year"))) {
						log.info("Calender selection  event Month={}  & Year = {}", sMonth.getText(), sYear.getText());
						break;
					}else {
						driver.findElement(By.cssSelector(".next > span:nth-child(1)")).click();
						Thread.sleep(2000);
					}
				}
				log.info("Day selection");
				List<WebElement> sDayTable = driver.findElements(By.xpath(EventCreationPageElements.sDay));
				for (WebElement sDay : sDayTable) {
					if (sDay.getText().equals(datetimevalues.get("day"))) {
						log.info("Calender selection  event Day={}.", sDay.getText());
						sDay.click();
						Thread.sleep(2000);
						break;
					}
				}
				log.info("StartTime selection");
				WebElement startTimeLabel = driver.findElement(By.cssSelector(EventCreationPageElements.startTimeLabel));
				startTimeLabel.click();
				WebElement sTimeHour = driver.findElement(By.xpath(EventCreationPageElements.sTimeHour));
				sTimeHour.clear();
				sTimeHour.sendKeys(datetimevalues.get("hour"));
				Thread.sleep(1000);
				WebElement sTimeMin = driver.findElement(By.xpath(EventCreationPageElements.sTimeMin));
				sTimeMin.clear();
				sTimeMin.sendKeys(datetimevalues.get("min"));
				Thread.sleep(1000);
				WebElement sTimeMerideim = driver.findElement(By.xpath(EventCreationPageElements.sTimeMerideim));
				if (!sTimeMerideim.getText().equals(datetimevalues.get("meridiem"))){
					sTimeMerideim.click();
				}
				Thread.sleep(2000);
				
				log.info("End Date Setter");
				HashMap<String, String> enddatetimevalues = getDateTime(testdata.get("EndDate"));
				WebElement endDateLabel = driver.findElement(By.cssSelector(EventCreationPageElements.endDateLabel));
				endDateLabel.click();
				while (true) {
					WebElement eMonth = driver.findElement(By.cssSelector(EventCreationPageElements.eMonth));
					WebElement eYear = driver.findElement(By.cssSelector(EventCreationPageElements.eYear));
					if (enddatetimevalues.get("month").equals(datetimevalues.get("month"))
							&& Integer.parseInt(enddatetimevalues.get("year")) <= Integer.parseInt(datetimevalues.get("year")))  {
						log.error("End Date value cannot be smaller than Start Date value");
						dateStatus.put("msg", "End Date value cannot be smaller than Start Date value");
						dateStatus.put("DateStatus", "false");
						break;
					}
					if (eMonth.getText().equals(enddatetimevalues.get("month")) && eYear.getText().equals(enddatetimevalues.get("year"))) {
						log.info("Calender selection  event Month={}  & Year = {}", eMonth.getText(), eYear.getText());
						break;
					}else {
						driver.findElement(By.cssSelector(".next > span:nth-child(1)")).click();
						Thread.sleep(2000);
					}
				}
				log.info("Day selection");
				List<WebElement> eDayTable = driver.findElements(By.xpath(EventCreationPageElements.eDay));
				for (WebElement eDay : eDayTable) {
					if (eDay.getText().equals(enddatetimevalues.get("day"))) {
						log.info("Calender selection  event Day={}.", eDay.getText());
						eDay.click();
						Thread.sleep(2000);
						dateStatus.put("DateStatus", "true");
						break;
					}
				}
				log.info("EndTime selection");
				WebElement endTimeLabel = driver.findElement(By.cssSelector(EventCreationPageElements.endTimeLabel));
				endTimeLabel.click();
				WebElement eTimeHour = driver.findElement(By.xpath(EventCreationPageElements.eTimeHour));
				eTimeHour.clear();
				eTimeHour.sendKeys(enddatetimevalues.get("hour"));
				Thread.sleep(1000);
				WebElement eTimeMin = driver.findElement(By.xpath(EventCreationPageElements.eTimeMin));
				eTimeMin.clear();
				eTimeMin.sendKeys(enddatetimevalues.get("min"));
				Thread.sleep(1000);
				WebElement eTimeMerideim = driver.findElement(By.xpath(EventCreationPageElements.eTimeMerideim));
				if (!eTimeMerideim.getText().equals(enddatetimevalues.get("meridiem"))){
					eTimeMerideim.click();
				}
				Thread.sleep(2000);
				log.info("TimeZone selection.");
				WebElement timeZoneLabel = driver.findElement(By.cssSelector(EventCreationPageElements.timeZoneLabel));
				timeZoneLabel.click();
				List<WebElement> timeZoneOptions = timeZoneLabel.findElements(By.tagName("option"));
				for (WebElement timeZone : timeZoneOptions) {
					if (timeZone.getText().equals(testdata.get("TimeZone"))) {
						log.info("Time zone selected is {}", testdata.get("TimeZone"));
						timeZone.click();
						dateStatus.put("DateStatus", "true");
						Thread.sleep(1000);
						break;
					}
				}
				
			}else {
				log.info("Could not identify the 'When' column.");
				dateStatus.put("DateStatus", "false");
			}
		}catch (Exception E) {
			 E.printStackTrace();
		}
		
		return dateStatus;
		
	}
	
	public static HashMap<String, String> getDateTime(String datetime) throws Exception{
		
		HashMap<String, String> datetimevalues = new HashMap<String, String>();
		
		//Build event start data and time from the input "testdata"
		String[] sdatetime = datetime.split("T");
		String[] sdate = sdatetime[0].split(" ");
		String[] ampm = sdatetime[1].split("([0-9]{1,2}:[0-9]{1,2})");
		String[] stime = sdatetime[1].split("([AM|PM])");
		String[] time = stime[0].split(":");
		
		datetimevalues.put("day", sdate[0]);
		datetimevalues.put("month", sdate[1]);
		datetimevalues.put("year", sdate[2]);
		datetimevalues.put("hour", time[0]);
		datetimevalues.put("min", time[1]);
		datetimevalues.put("meridiem", ampm[1]);
		return datetimevalues;
		
	}

}
