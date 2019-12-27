package CommonLibs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import PageFactory.LoginPage;

public class TitleVerification {
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public static boolean verify_login_title(String page_title) throws Exception {
		final String  given_title = "Login to get going." ;
		if (given_title.equals(page_title)){
			return true;
		}else {
			return false;
		}
		
	}

}
