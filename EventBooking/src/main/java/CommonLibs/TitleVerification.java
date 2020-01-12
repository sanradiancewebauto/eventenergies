package CommonLibs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import PageFactory.LoginPage;

public class TitleVerification {
	
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	public static final String  loginpage_title_text = "Login to get going." ;
	public static final String  invalid_user_popup_text = "Username or password wrong" ;
	public static final String  event_title = "Add Event Details";
	public static final String  event_lable = "Design your event";
	
	public static boolean verify_title(String verify_title) throws Exception {
		log.info("Verifying of title string [{}]",verify_title);
		if (loginpage_title_text.equals(verify_title)){
			return true;
		}else if (invalid_user_popup_text.equals(verify_title)){
			return true;
		}else if (event_title.equals(verify_title)) {
			return true;
		}else if (event_lable.equals(verify_title)) {
			return true;
		}else {
			return false;
		}
		
	}

}
