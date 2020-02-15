package CommonLibs;

import java.io.File;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import PageFactory.LoginPage;

public class Utils {
	
	static Logger log = LogManager.getLogger(LoginPage.class.getName());
	private static final int HOW_MANY_CHAR = 10;
	public String prefix = ""; 
	public String suffix = "";

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

	public static String randomGenerator(String randtype, String prefix, String suffix) {
		log.info("Generating random values.");
		if (randtype == "number") {
			return prefix + RandomStringUtils.random(HOW_MANY_CHAR) + suffix;
		} else if (randtype == "string"){
			return prefix + "-" + RandomStringUtils.randomAlphabetic(HOW_MANY_CHAR) + "-" + suffix ;
		} else if (randtype == "uuid"){
			return UUID.randomUUID().toString() ;
		} else if (randtype == "raw"){
			return prefix + "-" + suffix + "-" + RandomStringUtils.random(HOW_MANY_CHAR);
		} else {
			log.error("Invalid input to the random generator.");
			return null;
			}
		}

}
