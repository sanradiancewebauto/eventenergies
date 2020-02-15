package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ElementRepository.*;
import CommonLibs.TitleVerification;
import CommonLibs.Utils;

public class EventsPage {

	public static HashMap<String, String> returnValues =  new HashMap<String, String>();
	static Logger log = LogManager.getLogger(EventsPage.class.getName());
	static String logoutValue = "no";
	

	public static Object CreateEvents(String browserName, WebDriver driver, HashMap<String, String> testdata) throws Exception  {
		log.info("Re-generate testdata values");
		testdata = regenerateDataValues(testdata);
		log.info("The new data set is {}",testdata);
		
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
			WebElement eventTitle = driver.findElement(By.cssSelector(EventCreationPageElements.eventTitle));
			log.info("Event Page Left Section Details");
			log.info("Enter the event Title as [{}]", testdata.get("EventTitle"));
			eventTitle.click();
        	Thread.sleep(1000);
        	eventTitle.sendKeys(testdata.get("EventTitle"));
        	Thread.sleep(1000);
			List<WebElement> eventElements = driver.findElements(By.xpath(EventCreationPageElements.eventInputFields));
			for (int i=0; i<eventElements.size();i++){	  
				WebElement eventAddIcon = driver.findElement(By.id(EventCreationPageElements.eventAddIcon));
				eventAddIcon.click();
				Thread.sleep(1000);
				log.info("Add event [{}] as [{}] ",eventElements.get(i).getText(), eventElements.get(i).getAttribute("title"));	        
		        Thread.sleep(1000); 
		        eventElements.get(i).click();
		        Thread.sleep(1000);
		        String isTitle = eventElements.get(i).getAttribute("title");
		        log.info("testing the text + {}", isTitle);
		        if (isTitle.matches("Add text")) {
			        log.info("Enter the event description title as [{}].",testdata.get("EventDescription"));
			        WebElement eventDescriptionTitle = driver.findElement(By.cssSelector(EventCreationPageElements.eventDescriptionTitle));
			        if (eventDescriptionTitle.isDisplayed()){
			        	eventDescriptionTitle.click();
			        	Thread.sleep(1000);
			        	eventDescriptionTitle.sendKeys(testdata.get("EventDescription"));
			        	Thread.sleep(1000);
			        	log.info("Enter the event description details as [{}].",testdata.get("EventDescriptionDetails"));
			        	WebElement eventDescriptionContents = driver.findElement(By.cssSelector(EventCreationPageElements.eventDescriptionContents));
			        	eventDescriptionContents.click();
			        	Thread.sleep(1000);
			        	eventDescriptionContents.sendKeys(testdata.get("EventDescriptionDetails"));
			        	Thread.sleep(1000);
			        	returnValues.put("EventStatus", "true");
			        }else {
			        	returnValues.put("EventStatus", "false");
			        }
		        }else if (isTitle.matches("Add images")) {
		        	log.info("Upload image to the event from system location.");
		        	CommonLibs.UploadDownloadFiles.uploadDownloadFiles(driver, "image", "1M");
					returnValues.put("EventStatus", "true");
					
		        }else if (isTitle.matches("Add video")) {
		        	log.info("Upload video to the event from system location.");
		        	CommonLibs.UploadDownloadFiles.uploadDownloadFiles(driver, "video", "1M");
		        	returnValues.put("EventStatus", "true");
		        }else if (isTitle.matches("Add pdf")) {
		        	log.info("Upload PDF file to the event from system location.");
		        	CommonLibs.UploadDownloadFiles.uploadDownloadFiles(driver, "pdf", "1M");
		        	returnValues.put("EventStatus", "true");
		        }else if (isTitle.matches("Open Camera")) { 
		        	driver.findElement(By.cssSelector(EventCreationPageElements.closeCamera)).click();
		        	log.info("Capture camera image and upload to the event.");
		        	//continue;
		        }else {
		        	log.error("Invalid event details input : {} ", isTitle);
		        	returnValues.put("EventStatus", "false");
		        }
			}
			log.info("Event Right Section");
			log.info("Step : Select the event type.");
			if (testdata.get("EventType").equals("Public")) {
				driver.findElement(By.cssSelector(EventCreationPageElements.eventTypePublic)).click();
			}else {
				driver.findElement(By.cssSelector(EventCreationPageElements.eventTypePrivate)).click();
			}
			WebElement categoryLabel = driver.findElement(By.cssSelector(EventCreationPageElements.categoryLabel));
			if (categoryLabel.getText().equals("Select category")) {
				WebElement categoryField = driver.findElement(By.id(EventCreationPageElements.categoryField));
				categoryField.click();
				WebElement categoryMenuBox = driver.findElement(By.cssSelector(EventCreationPageElements.categoryDropDownMenu));
				List<WebElement> categoryMenuItems = categoryMenuBox.findElements(By.xpath(EventCreationPageElements.categoryMenuItems));
				if (testdata.get("SelectCategory").equals("auto")){
					Collections.shuffle(categoryMenuItems);
					categoryMenuItems.get(0);
					log.info("Selecting the event category as --[{}]",categoryMenuItems.get(0).getText());
					categoryMenuItems.get(0).click(); // click the desired option
				}else {
					for (WebElement category : categoryMenuItems)
					{
						if (category.getText().equals(testdata.get("SelectCategory")))
						{
							log.info("Selecting the event category as [{}]",testdata.get("SelectCategory"));
							category.click(); // click the desired option
							break;
						}
					}	
				}
				Thread.sleep(2000);
				WebElement subCategoryMenu = driver.findElement(By.cssSelector(EventCreationPageElements.subCategoryDropDownMenu));
				List<WebElement> subCategoryMenuItems = subCategoryMenu.findElements(By.xpath(EventCreationPageElements.subCategoryMenuItems)); 
				log.info("Selecting event sub-category from the list = {}.", subCategoryMenuItems.get(0).getText());

				for ( WebElement subcategory : subCategoryMenuItems ) {
					if(testdata.get("SubCategory").equals("auto")) {
						log.info("Selecting the event subcategory as [{}]",testdata.get("SubCategory"));
						subcategory.click();
						break;
					}else if (testdata.get("SubCategory").equals("auto")) {
						log.info("Selecting event sub-category from the list as [{}]", subCategoryMenuItems.get(0).getText());
						subcategory.click();
						break;
					}
				}
			}
			log.info("Step : Date processing.");
			final Map<String, String> checkdateValues = EventsPage.dateProcessing(driver, testdata);
			returnValues.put("DateStatus", checkdateValues.get("DateStatus"));
			
			// Enter Venue details
			log.info("Step : Enter the Venue details.");
			final Map<String, String> setVenueDetails = EventsPage.setVenuDetails(driver, testdata);
			log.info("The venue details are {}",setVenueDetails);
			returnValues.put("VenueStatus", setVenueDetails.get("VenueStatus"));
			
			
			// Enter Ticket details
			log.info("Step : Enter the Ticket details.");
			final Map<String, String> setTicketDetails = EventsPage.setTicketDetails(driver, testdata);
			log.info("The Ticket details are {}",setTicketDetails);
			returnValues.put("TicketStatus", setTicketDetails.get("TicketStatus"));
			
			// Enter Tag details
			log.info("Step : Enter the Tag details.");
			final Map<String, String> setTagDetails = EventsPage.setTagDetails(driver, testdata);
			log.info("The Tag set status is {}",setTagDetails);
			returnValues.put("TagStatus", setTagDetails.get("TagStatus"));
			
			// final submit
			log.info("Click submit");
			driver.findElement(By.cssSelector(EventCreationPageElements.submit)).click();
			
			try {
				log.info("Looking for event error popup");
				if (driver.findElement(By.cssSelector(EventCreationPageElements.errorAlert)) != null) {
					log.error("Event field input error.");
					WebElement errorAlert = driver.findElement(By.cssSelector(EventCreationPageElements.errorAlert));
					returnValues.put("EventErrorMsg", errorAlert.getText());
					returnValues.put("EventStatus", "false");
				} else if (driver.findElement(By.cssSelector(EventCreationPageElements.successAlert)) != null)  {
					WebElement successAlert = driver.findElement(By.cssSelector(EventCreationPageElements.successAlert));
					returnValues.put("EventStatus", "true");
					returnValues.put("EventSuccessMsg", successAlert.getText());
	
				}else {
					returnValues.put("EventErrorMsg", "Unable to capture the event alerts.");
					returnValues.put("EventStatus", "false");
				}
			}catch (NoSuchElementException Ex)
			{
				log.error("Event error popup not found.");
			}
			Thread.sleep(300);
		}catch (Exception E) 
		{
			 E.printStackTrace();
		}
		
		log.info("Complete data to be returned = {}",returnValues);
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
	
	public static HashMap<String, String> setVenuDetails(WebDriver driver, HashMap<String, String> testdata) throws Exception{
		HashMap<String, String> venueStatus = new HashMap<String, String>() ;
		WebElement venueLabel = driver.findElement(By.cssSelector(EventCreationPageElements.venueLabel));
		if (!venueLabel.getText().equals("Venue")) {
			log.error("Venue section not found.");
			venueStatus.put("VenueStatus", "false");
		}else {
			log.info("Venue title visible.");
			log.info("Step : Enter venue details.");
			WebElement venueLocation = driver.findElement(By.cssSelector(EventCreationPageElements.venueLocation));
			venueLocation.sendKeys(testdata.get("Venue"));
			venueLocation.sendKeys(Keys.TAB);
			// Enter Address line 1
			log.info("Enter address line1 details.");
			WebElement addressLine1 = driver.findElement(By.xpath(EventCreationPageElements.addressLine1));
			log.info("Address Line1 is [{}]",testdata.get("AddressLine"));
			addressLine1.sendKeys(testdata.get("AddressLine"));
			Thread.sleep(1000);
			log.info("Enter address line2 details.");
			WebElement addressLine2 = driver.findElement(By.cssSelector(EventCreationPageElements.addressLine2));
			log.info("Address Line2 is [{}]",testdata.get("AddressLine2"));
			addressLine2.sendKeys(testdata.get("AddressLine2"));
			Thread.sleep(1000);
			log.info("Enter city name.");
			WebElement cityValue = driver.findElement(By.cssSelector(EventCreationPageElements.cityValue));
			log.info("City entered is is [{}]",testdata.get("City"));
			cityValue.sendKeys(testdata.get("City"));
			Thread.sleep(1000);
			log.info("Enter state name.");
			WebElement stateValue = driver.findElement(By.cssSelector(EventCreationPageElements.stateValue));
			log.info("State entered is [{}]",testdata.get("State"));
			stateValue.sendKeys(testdata.get("State"));
			Thread.sleep(1000);
			log.info("Enter country name.");
			WebElement countryValue = driver.findElement(By.cssSelector(EventCreationPageElements.countryValue));
			log.info("Country entered is [{}]",testdata.get("Country"));
			countryValue.sendKeys(testdata.get("Country"));
			Thread.sleep(1000);
			log.info("Enter pincode details.");
			WebElement pincodeValue = driver.findElement(By.cssSelector(EventCreationPageElements.pincodeValue));
			log.info("Pincode entered is [{}]",testdata.get("PinCode"));
			pincodeValue.sendKeys(testdata.get("PinCode"));
			Thread.sleep(2000);
			venueStatus.put("VenueStatus", "true");
			
		}
		return venueStatus;
	}
	
	public static HashMap<String, String> setTicketDetails(WebDriver driver, HashMap<String, String> testdata) throws Exception {
		HashMap<String, String> ticketStatus = new HashMap<String, String>() ;
		WebElement venueLabel = driver.findElement(By.cssSelector(EventCreationPageElements.ticketLabel));
		log.info("Here is my venue details {}",venueLabel.getText());
		if (!venueLabel.getText().equals("Tickets")) {
			log.error("Ticket section not found.");
			ticketStatus.put("TicketStatus", "false");
		}else {
			log.info("Ticket title visible.");
			log.info("Step : Enter Ticket details.");
			WebElement ticketType = driver.findElement(By.cssSelector(EventCreationPageElements.ticketType));
			ticketType.click();
			Thread.sleep(1000);
			List<WebElement> ticketTypeOptions = ticketType.findElements(By.tagName("option"));
			Collections.shuffle(ticketTypeOptions);
			WebElement selectedTicketOption = ticketTypeOptions.get(0);
			log.info("Ticket type selected is [{}]", selectedTicketOption.getText());
			for (WebElement ticketype : ticketTypeOptions) {
				if (ticketype.getText().equals(selectedTicketOption.getText())) {
					ticketype.click();
					ticketStatus.put("TicketStatus", "true");
					Thread.sleep(1000);
					break;
				}
			}	
			Thread.sleep(1000);
			WebElement ticketName = driver.findElement(By.cssSelector(EventCreationPageElements.ticketName));
			ticketName.sendKeys(testdata.get("TicketName"));
			WebElement paymetGateway = driver.findElement(By.cssSelector(EventCreationPageElements.paymetGateway));
			paymetGateway.click();
			List<WebElement> paymentGatewayOptions = paymetGateway.findElements(By.tagName("option"));
			if (testdata.get("PaymentGateway").equals("auto")){
				Collections.shuffle(paymentGatewayOptions);
				log.info("Payment gateway selected as {}",paymentGatewayOptions.get(0).getText());
				Collections.shuffle(paymentGatewayOptions);
				paymentGatewayOptions.get(0);
				log.info("Selecting the payment gateway as --[{}]",paymentGatewayOptions.get(0).getText());
				paymentGatewayOptions.get(0).click(); // click the desired option
			}else {
				for (WebElement category : paymentGatewayOptions)
				{
					if (category.getText().equals(testdata.get("PaymentGateway")))
					{
						log.info("Selecting the payment gateway as [{}]",testdata.get("PaymentGateway"));
						category.click(); // click the desired option
						break;
					}
				}	
			}
			Thread.sleep(1000);
			WebElement ticketQuantity = driver.findElement(By.cssSelector(EventCreationPageElements.ticketQuantity));
			ticketQuantity.clear();
			log.info("Ticket quantitiy set as [{}]",testdata.get("Quantity"));
			ticketQuantity.sendKeys(testdata.get("Quantity"));
			Thread.sleep(1000);
			WebElement ticketMinQuantity = driver.findElement(By.cssSelector(EventCreationPageElements.ticketMinQuantity));
			log.info("Ticket Min purchase quantity set as [{}]",testdata.get("MinQty"));
			ticketMinQuantity.sendKeys(testdata.get("MinQty"));
			Thread.sleep(1000);
			WebElement ticketMaxQuantity = driver.findElement(By.cssSelector(EventCreationPageElements.ticketMaxQuantity));
			log.info("Ticket Max purchase quantity set as [{}]",testdata.get("MaxQty"));
			ticketMaxQuantity.click();
			ticketMaxQuantity.sendKeys(testdata.get("MaxQty"));
			Thread.sleep(1000);
			WebElement ticketPrice = driver.findElement(By.cssSelector(EventCreationPageElements.ticketPrice));
			ticketPrice.clear();
			log.info("Ticket Price set as [{}]",testdata.get("Price"));
			ticketPrice.sendKeys(testdata.get("Price"));
			Thread.sleep(1000);
			WebElement currencyType = driver.findElement(By.cssSelector(EventCreationPageElements.currencyType));
			currencyType.click();
			Thread.sleep(1000);
			List<WebElement> currencyTypeOptions = currencyType.findElements(By.tagName("option"));
			for (WebElement currencytype : currencyTypeOptions) {
				if (currencytype.getText().equals(testdata.get("Currency"))) {
					currencytype.click();
					ticketStatus.put("TicketStatus", "true");
					log.info("Currency type set as {}", testdata.get("Currency"));
					Thread.sleep(1000);
					break;
				}
			}
			log.info("Ticket pickup setting.");
			WebElement timeSettingBtn = driver.findElement(By.cssSelector(EventCreationPageElements.timeSettingBtn));
			timeSettingBtn.click();
			WebElement timeSettingLabel = driver.findElement(By.cssSelector(EventCreationPageElements.timeSettingLabel));
			if (!timeSettingLabel.getText().equals("Ticket settings"));{
				log.info("Ticket setting menu is not visible");
				ticketStatus.put("TicketStatus", "false");
			}
			testdata.put("TimeSetting", "disabled");
			if (!testdata.get("TimeSetting").contentEquals("enabled")) {
				log.info("Pick parent time/venu setting disabled");
				WebElement timePickParentCheckbox = driver.findElement(By.cssSelector(EventCreationPageElements.timePickParentCheckbox));
				timePickParentCheckbox.click();
				WebElement venuPickParentCheckbox = driver.findElement(By.cssSelector(EventCreationPageElements.venuPickParentCheckbox));
				venuPickParentCheckbox.click();	
				ticketStatus.put("TicketStatus", "true");
			}
		}
		return ticketStatus;
		
	}
	
	
	public static HashMap<String, String> setTagDetails(WebDriver driver, HashMap<String, String> testdata) throws Exception {
		HashMap<String, String> tagStatus = new HashMap<String, String>() ;
		boolean select_tag = false;
		try {
			// Create instance of Javascript executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			WebElement addKeyTagLabel = driver.findElement(By.cssSelector(EventCreationPageElements.addKeyTagLabel));
			log.info("Here is my tag title {}",addKeyTagLabel.getText());
			je.executeScript("arguments[0].scrollIntoView(true);",addKeyTagLabel);
			if (!addKeyTagLabel.getText().equals("Key tags in event")) {
				log.error("Tag section not found.");
				tagStatus.put("TagStatus", "false");
			}else {
				log.info("Tag title visible.");
				log.info("Step : Add new tag.");
				Thread.sleep(1000);
			    List<WebElement> selectTagList = driver.findElements(By.xpath(EventCreationPageElements.selectTagList));
			    for (WebElement selectTag : selectTagList) {
			    	if (selectTag.getText().equals(testdata.get("TagName"))){
			    		log.info("Selecting tag from list {}", testdata.get("TagName"));
			    		selectTag.click();
			    		select_tag = true;
			    	}
			    }
			    if (select_tag == true) {
			    	tagStatus.put("TagStatus", "true");
			    	//return tagStatus;
			    }else {
					log.info("Tag not available in the list creating a new tag [{}]", testdata.get("TagName"));
					driver.findElement(By.xpath(EventCreationPageElements.newTag)).click();
					Thread.sleep(2000);
					log.info("I have clicked tag....");
					WebElement newTagPage = driver.findElement(By.xpath(EventCreationPageElements.newTagPageTitle));
					if (TitleVerification.verify_title(newTagPage.getText()) == true) {
						log.info("Navigation to Add New Tag page successful");
						driver.findElement(By.id("learning_tag_name")).click();
						Thread.sleep(1000);
						driver.findElement(By.id("learning_tag_name")).sendKeys(testdata.get("TagName"));
						driver.findElement(By.id("learning_tag_description")).click();
						Thread.sleep(1000);
						driver.findElement(By.id("learning_tag_description")).sendKeys(testdata.get("Description"));
						driver.findElement(By.cssSelector(EventCreationPageElements.addTagSubmit)).click();
						Thread.sleep(2000);
						List<WebElement> selectTagListNew = driver.findElements(By.xpath(EventCreationPageElements.selectTagList));
						for (WebElement selectTag : selectTagListNew) {
							if (selectTag.getText().equals(testdata.get("TagName"))){
								log.info("Selecting tag from list {}", testdata.get("TagName"));
								selectTag.click();
							}
						}
						tagStatus.put("TagStatus", "true");
					}else {
						log.error("Navigation to Add New Tag page failed.");
						tagStatus.put("TagStatus", "false");
					}
				}

			    
			}
		}catch (Exception E) {
			 E.printStackTrace();
		} 
		
		return tagStatus;
		
	}


	public static HashMap<String, String> regenerateDataValues(HashMap<String, String> testdata) {
		
		for (String key : testdata.keySet()) { 
			if ((key.equals("EventTitle")) &&  (testdata.get(key).equals("auto"))) {
				String value = Utils.randomGenerator("raw", testdata.get("EventTitle"), "title");
				testdata.put(key, value);
			}else if ((key.equals("EventDescription")) &&  (testdata.get(key).equals("auto"))) {
				String value = Utils.randomGenerator("raw", testdata.get("EventTitle"), "description");
				testdata.put(key, value);
			}else if ((key.equals("EventDescriptionDetails")) &&  (testdata.get(key).equals("auto"))) {
				String value = Utils.randomGenerator("raw", testdata.get("EventTitle"), "detailed description");
				testdata.put(key, value);
			}else if ((key.equals("EventType")) &&  (testdata.get(key).equals("auto"))) {
				List<String> list = new ArrayList<String>(){
					private static final long serialVersionUID = 1L;
					{ 	this.add("public");
						this.add("private");
					}
				};
				Collections.shuffle(list);
				testdata.put(key, list.get(0));
			}
		}
		return testdata;
		
	}


}
