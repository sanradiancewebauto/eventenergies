package ElementRepository;

public class EventCreationPageElements {

	// Event Button on Main Window
	public static String eventCreateButton = "/html/body/app-root/app-main-activity/app-main-navbar/div[1]/ul[2]/li[1]/a"; //Xpath
	
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

	//Venue
	public static String  VenueLabel=".row:nth-child(5) .common-header";

	public static String VenueError =".alert-info > span";

	public static String CityLabel =".col-sm-6:nth-child(5) > .ng-tns-c5-0";

	public static String  CityError="//span[contains(.,'City field is required')]";

	public static String CityField=". .ng-dirty";

	public static String CountryLabel =".mrg-btm:nth-child(3) > .ng-tns-c5-0";

	public static String CountryError=".alert-info > span";

	public static String CountryField =".col-sm-6:nth-child(3) > .popup-input-text";

	public static String StateLabel =".col-sm-6:nth-child(4) > .ng-tns-c5-0";

	public static String StateError="//span[contains(.,'State field is required')]";

	public static String StateField =".col-sm-6:nth-child(4) > .popup-input-text";

	public static String PincodeLabel =".col-sm-6:nth-child(6) > .ng-tns-c5-0";

	public static String PincodeError="//span[contains(.,'Pincode field is required')]";

	public static String PincodeField =".col-sm-6:nth-child(6) > .popup-input-text";

	//Tickets
	public static String TicketLabel =".row:nth-child(1) > .col-sm-12 > .right-header-content";

	public static String TicketError ="//span";

	public static String  TicketField="";

	public static String TicketTypeLabel =".col-md-12 > .ng-tns-c5-0";

	public static String TicketTypeError ="//span";

	public static String  TicketTypeField=".col-md-12 > .customise-select";

	public static String TicketNameLabel =".col-lg-4 > .ng-tns-c5-0";

	public static String TicketNameError ="//span";

	public static String  TicketNameField=" .popup-input-text";

	public static String 	PaymetGatewayLabel=".col-lg-5 > .ng-tns-c5-0";

	public static String  PaymetGatewayField=".customise-select:nth-child(1)";

	public static String  paymentGatewayError=".alert-info > span";

	public static String TicketQuantityLabel=".col-lg-2:nth-child(4) > .ng-tns-c5-0";

	public static String  TicketQuantityError=".alert-info > span";

	public static String TicketQuantityField ="//input[@type='number']";

	public static String  TicketMinQuantField="";

	public static String  TicketMinQuantError="";

	public static String  TicketMinQuantLabel=".col-lg-2:nth-child(5) > .ng-tns-c5-0";

	public static String  TicketMaxQuantField=".col-lg-2:nth-child(6) > .popup-input-text";

	public static String  TicketMaxQuantLabel=".col-lg-2:nth-child(6) > .ng-tns-c5-0";

	public static String  TicketMaxQuantError=".alert-info > span";

	public static String TicketMaxQuantErrors=".col-lg-2 > .ng-star-inserted";

	public static String  TicketPriceField=".col-xs-11 > .popup-input-text";

	public static String  TicketPriceLabel=".col-lg-2:nth-child(6) > .ng-tns-c5-0";

	public static String  TicketPriceError=".alert-info > span";

	//Ticket Setting
	public static String TicketSettingTitle=".col-sm-12 > .row:nth-child(1) .right-header-content";

	public static String TicketSettingLabel=".has-default:nth-child(1) > .right-header-content";

	public static String ParentTimingLabel=".has-default:nth-child(1) > .ng-tns-c5-0:nth-child(2)";

	public static String parentTimingMsg=".default-set-msg";

	public static String TicketStartTimeLabel =".ng-tns-c5-0 > .col-md-6:nth-child(2) > .ng-tns-c5-0:nth-child(1)";

	public static String TicketStartTimeError=".alert-info > span";

	public static String TicketStartDateField="ticket_start_date";

	public static String TicketStartDateLabel =".ng-tns-c5-0 > .col-md-6:nth-child(1) > .ng-tns-c5-0";

	public static String TicketStartEndError=".alert-info > span";

	public static String TicketEndTimeLabel =".ng-tns-c5-0 > .col-sm-12:nth-child(4) > .ng-tns-c5-0:nth-child(1)";

	public static String TicketEndTimeError=".alert-info > span";

	public static String TicketEndDateLabel =".ng-tns-c5-0 > .col-md-6:nth-child(3) > .ng-tns-c5-0";

	public static String TicketEndDateField="ticket_end_date";

	public static String TicketEndDateError=".alert-info > span";

	public static String TicketTimeZoneLabel=".ng-tns-c5-0 > .col-sm-12:nth-child(5) > .ng-tns-c5-0";

	public static String TicketTimeZoneField=".col-sm-12:nth-child(5) > .customise-select";

	//Tickets venue
	public static String TicketVenueLabel="has-default:nth-child(3) > .right-header-content";

	public static String TicketVenueField=".mrg-btm:nth-child(1) > .highlightEnabled";

	public static String TicketVenueError=".alert-info > span";

	public static String TicketParentVenueLabel=".has-default:nth-child(3) > .ng-tns-c5-0:nth-child(2)";

	public static String TicketParentVenueMsg=".default-set-msg";

	public static String TicketAddressLine1Error=".alert-info > span";

	public static String TicketAddressLine1Field=".ticket-venue > .col-sm-12:nth-child(2) > .ng-tns-c5-0";

	public static String TicketAddressLine1Label=".ticket-venue > .col-sm-12:nth-child(2) > .ng-tns-c5-0";

	public static String TicketCountryLabel=".ticket-venue > .col-sm-6:nth-child(4) > .ng-tns-c5-0";

	public static String TicketStateLabel=".ticket-venue > .col-sm-6:nth-child(5) > .ng-tns-c5-0";

	public static String TicketCityLabel=".ticket-venue > .col-sm-6:nth-child(6) > .ng-tns-c5-0";

	public static String TicketPincodeLabel=".mrg-btm:nth-child(7) > .ng-tns-c5-0";

	//Add tags
	public static String AddKeyTagLabel=".flex-content > .right-header-content";

	public static String NewTagLabel=".flex-content > .ng-tns-c5-0:nth-child(2)";

	public static String SelectTag=".learning-tags > .col-sm-12 > .right-header-content";


}
