package CommonLibs;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import PageFactory.LoginPage;

public class Utils {
	
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public static String separatorsToSystem(String path) {
	if (path==null) return null;
	if (File.separatorChar=='\\') {
	    // From Windows to Linux/Mac
	    return path.replace('/', File.separatorChar);
	} else {
	    // From Linux/Mac to Windows
	    return path.replace('\\', File.separatorChar);
	    }
	}
}
