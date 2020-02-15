package ElementRepository;

public class EventCreationPageElements {

	// Event Button on Main Window
	public static String eventCreateButton = "/html/body/app-root/app-main-activity/app-main-navbar/div[1]/ul[2]/li[2]/a"; //Xpath
	
	//Title of the page
	public static String eventPageTitle ="/html/body/app-root/app-create-story/div[1]/div[2]"; //xpath

	//  labels of the page
	public static String eventLabel ="Design your event" ;// text string
			
	// + symbol id 
	public static String eventAddIcon="first"; // by id
	
	// Event description
	public static String eventInputFields="/html/body/app-root/app-create-story/div[2]/div[1]/div[2]/div/div/div[4]/div/div[2]/ul/li" ; //xpath
	
	//Event Title
	public static String eventTitle ="#mce_0"; //CSS 

	//Event Description
	public static String eventDescriptionTitle="#mce_2"; //CSS 
	public static String eventDescriptionContents="#mce_3"; //CSS
	
	//Camera
	public static String closeCamera = "#camera_first > div:nth-child(2) > div:nth-child(1) > a:nth-child(3) > img:nth-child(1)"; //CSS
	
	//Select Event Type
	
	public static String eventTypePublic =".col-sm-5:nth-child(1) > .radio-inline"; //CSS
	public static String eventTypePublicHelp  = "div.col-sm-5:nth-child(1) > label:nth-child(1) > a:nth-child(2)"; //CSS

	public static String  eventTypePrivate =".col-sm-5:nth-child(2) > .radio-inline"; //CSS
	public static String eventTypePrivateHelp  = "div.common-padding:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > label:nth-child(1) > a:nth-child(2)"; //CSS
	
	
	//Buttons
	public static String publishButton ="Publish";

	public static String SaveButton ="Save & Preview";

	public static String CancelButoon ="Cancel";

	public static String DeleteButton ="Delete";

	public static String showMenu="showMenu";

	public static String MenuName="showMenu";

	public static String AddTicketsButton=".btn-customise";

	

	//Event Description
	public static String DescriptionError1=".alert-info > span";

	public static String DescriptionError2=".alert-info > span";

	public static String Descriptionfield1="mce_2";

	public static String DescriptionField2="mce_3";

	//Add image
	public static String AddImageError =".alert-info > span";

	public static String ImagesLabel=".row:nth-child(1) > .col-sm-12 > .common-header";

	public static String ImagesSubLabel="sub-common-header";

	

	//Select Category

	public static String categoryLabel="div.common-padding:nth-child(4) > div:nth-child(1) > div:nth-child(1)";   //CSS
	public static String categoryField="category"; // ID 
	public static String categoryDropDownMenu="ul.custom-dropdown-menu"; // ID 
	public static String categoryMenuItems="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[4]/div[1]/div[2]/ul/li/a"; // CSS

	public static String subCategoryLabel="div.col-md-12:nth-child(2) > div:nth-child(1)"; //CSS
	public static String subCategoryField="subcategory"; //ID 
	public static String subCategoryDropDownMenu=".custom-dropdown-menu2"; //CSS
	public static String subCategoryMenuItems="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[4]/div[2]/div[2]/ul/li/a"; // CSS
											   

	// when 
	public static String whenLabel ="div.common-padding:nth-child(5) > div:nth-child(1)"; //CSS

	public static String startDateLabel="div.col-lg-3:nth-child(2) > input:nth-child(2)"; //CSS
	public static String sMonth="button.current:nth-child(2) > span:nth-child(1)"; // CSS
	public static String sYear="button.current:nth-child(3) > span:nth-child(1)"; // CSS
	public static String sDay="/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr/td"; //xpath
	
	public static String startTimeLabel ="div.col-lg-3:nth-child(3) > input:nth-child(2)";
	public static String sTimeHour="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[5]/div[3]/div/timepicker/table/tbody/tr[2]/td[1]/input"; //xpath
	public static String sTimeMin= "/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[5]/div[3]/div/timepicker/table/tbody/tr[2]/td[3]/input"; //xpath
	public static String sTimeMerideim="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[5]/div[3]/div/timepicker/table/tbody/tr[2]/td[5]/button"; //xpath

	public static String endDateLabel ="div.col-sm-12:nth-child(4) > input:nth-child(2)";
	public static String eMonth="button.current:nth-child(2) > span:nth-child(1)"; // CSS
	public static String eYear="button.current:nth-child(3) > span:nth-child(1)"; // CSS
	public static String eDay="/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr/td"; //xpath
	
	public static String endTimeLabel ="div.col-sm-12:nth-child(5) > input:nth-child(2)";
	public static String eTimeHour="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[5]/div[5]/div/timepicker/table/tbody/tr[2]/td[1]/input"; //xpath
	public static String eTimeMin= "/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[5]/div[5]/div/timepicker/table/tbody/tr[2]/td[3]/input"; //xpath
	public static String eTimeMerideim="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[5]/div[5]/div/timepicker/table/tbody/tr[2]/td[5]/button"; //xpath

	public static String timeZoneLabel ="div.col-sm-12:nth-child(6) > select:nth-child(2)";
	
	public static String timeSettingBtn = ".fa-cog"; //CSS
	public static String timeSettingLabel = "div.ng-touched:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h3:nth-child(1)"; //CSS
	
	public static String timePickParentCheckbox = "#enable-custom-purchase-timing";
												
	public static String venuPickParentCheckbox = "div.has-default:nth-child(4) > input:nth-child(3)"; //css
	//Venue
	public static String venueLabel=".row:nth-child(6) .common-header";
	public static String venueLocation="input.highlightEnabled:nth-child(1)";
	public static String venueError =".alert-info > span";
	public static String addressLine1="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[6]/div[3]/div/div[1]/input";
	public static String addressLine2="div.row:nth-child(6) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)";
	
	
	public static String cityValue ="div.mrg-btm:nth-child(3) > input:nth-child(2)";
	public static String cityError="//span[contains(.,'City field is required')]";
	
	public static String stateValue ="div.mrg-btm:nth-child(4) > input:nth-child(2)";
	public static String stateError="//span[contains(.,'State field is required')]";
	public static String stateField =".col-sm-6:nth-child(4) > .popup-input-text";

	public static String countryValue ="div.mrg-btm:nth-child(5) > input:nth-child(2)";
	public static String countryError=".alert-info > span";
	public static String countryField =".col-sm-6:nth-child(3) > .popup-input-text";

	public static String pincodeValue ="div.mrg-btm:nth-child(6) > input:nth-child(2)";
	public static String pincodeError="//span[contains(.,'Pincode field is required')]";
	public static String pincodeField =".col-sm-6:nth-child(6) > .popup-input-text";

	//Tickets
	public static String ticketLabel ="form.ng-tns-c18-0 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)";
	

	public static String ticketType =".col-md-12 > .customise-select"; // public static String  TicketTypeField=".col-md-12 > .customise-select";
	
	public static String ticketName =".col-lg-4 > input:nth-child(2)";   

	public static String paymetGateway=".customise-select:nth-child(1)";

	public static String ticketQuantity ="div.col-lg-2:nth-child(4) > input:nth-child(2)";

	public static String ticketMinQuantity="div.col-lg-2:nth-child(5) > input:nth-child(2)";

	public static String ticketMaxQuantity="div.col-lg-2:nth-child(6) > input:nth-child(2)";

	public static String ticketPrice="div.col-lg-2:nth-child(7) > input:nth-child(2)";
	
	public static String currencyType="div.col-lg-3:nth-child(8) > select:nth-child(2)";

	//Add tags
	public static String addKeyTagLabel="div.row:nth-child(8) > div:nth-child(1) > div:nth-child(1) > h3:nth-child(1)";
	public static String newTag="//h3[@class='btn btn-primary']";

	public static String newTagPageTitle = "//h4[@class='heading']";
	public static String newTagPage = "//input[@id='learning_tag_name']";
	public static String newTagDesc = "//textarea[@id='learning_tag_description']";
    
	public static String addTagSubmit = ".modal-footer:nth-child(3) > .custom-btn";
	public static String selectTagList="/html/body/app-root/app-create-story/div[2]/div[2]/div/div/div[8]/div[2]/ul/li";
	
	public static String submit = ".nav-links > li:nth-child(1) > a:nth-child(1)";
	
	public static String errorAlert = ".alert-message-popup > .alert-info";  //CSS
	
	public static String successAlert = ".alert-success"; //CSS


}
