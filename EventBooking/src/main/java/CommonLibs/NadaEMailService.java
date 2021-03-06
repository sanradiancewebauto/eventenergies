package CommonLibs;

import java.io.IOException;
import java.util.Objects;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class NadaEMailService {
	
	static Logger log = LogManager.getLogger(ConditionChecks.class.getName());
	private static final String NADA_EMAIL_DOMAIN = "@getnada.com";
    private static final String INBOX_MESSAGE_KEY_NAME = "msgs";
    private static final String EMAIL_ID_ROUTE_PARAM = "email-id";
    private static final int EMAIL_CHARS_LENGTH = 10;
    private static final int PASSWORD_CHARS_LENGTH = 10;
    
    private String emailId;
	private String password;
	String msgId;


    private void generateEmailId(){
        this.emailId = RandomStringUtils.randomAlphanumeric(EMAIL_CHARS_LENGTH).toLowerCase().concat(NADA_EMAIL_DOMAIN);
    }
    
    private void generatePassword(){
        this.password = RandomStringUtils.randomAlphanumeric(PASSWORD_CHARS_LENGTH);
    }

    //generates a random email for the first time.
    //call reset for a new random email
    public String getEmailId(){
        if(Objects.isNull(this.emailId)){
            this.generateEmailId();
        }
        return this.emailId;
    }
    
    public String getPassword(){
        if(Objects.isNull(this.password)){
            this.generatePassword();
        }
        return this.password;
    }

    //to re-generate a new random email id
    public void reset(){
        this.emailId = null;
    }


	public String initMailID(String mailID) throws JSONException, UnirestException, JsonParseException, 
											JsonMappingException, IOException {
    	
    	log.info("Initializing the autogenerated Email Id : [{}]",mailID);

	   	Unirest.get("https://getnada.com/api/v1/inboxes/{email-id}")
									.routeParam(EMAIL_ID_ROUTE_PARAM, mailID)
									.asJson()
									.getBody()
									.getObject()
									.getJSONArray(INBOX_MESSAGE_KEY_NAME);
		return mailID;
    
    }


	public Boolean readMessages(String mailID) throws JsonParseException, JsonMappingException, UnirestException, IOException {
		Boolean msgStatus = null;
	   	JSONArray jsonResponseMsgs = Unirest.get("https://getnada.com/api/v1/inboxes/{email-id}")
				.routeParam(EMAIL_ID_ROUTE_PARAM, mailID)
				.asJson()
				.getBody()
				.getObject()
				.getJSONArray(INBOX_MESSAGE_KEY_NAME);
    	int i = 0;
    	if (jsonResponseMsgs != null && jsonResponseMsgs.length() > 0) {
    		while(i < jsonResponseMsgs.length()) {
                String msgId = jsonResponseMsgs.getJSONObject(i).optString("uid");
                log.info("Captured message ID is [{}]", msgId);
                JSONObject messageDetails = getMessageById(msgId);
                if ((messageDetails.get("fe").equals("admin@eventenergies.com")) && 
                		(messageDetails.get("s").equals("You are Singed-up. Here is your Email Confirmation link"))){
                	String messageHTML = (String) messageDetails.get("html");
                	Document doc = Jsoup.parse(messageHTML);	//Parsing and traversing a HTML Document 
                	String confirmURL = doc.body().getElementsByClass("mcnButtonContent").select("a").first().attr("href"); // capturing the confirmation URL from the HTML body
                	log.info("Captured comfirmation url [{}]",confirmURL);
                	String regConfirmStatus = Unirest.get(confirmURL).asString().getStatusText();
                	log.info("Confirmation  status: {}",regConfirmStatus);
                	if (regConfirmStatus.equals("OK")) {
                		log.info("Registered user email verification successful.");
                		msgStatus = true;
                	}else {
                		log.error("Registered user email verification failed.");
                		msgStatus = false;
                		break;
                	}
                	
                }
                i = i + 1;
            }
        }
    	return msgStatus;
	}

	public JSONObject getMessageById(String messageId) throws UnirestException, JsonParseException, JsonMappingException, IOException {
		log.info("Getting message detail of message ID [{}]",messageId);
    	JSONObject messageDetails = Unirest.get("https://getnada.com/api/v1/messages/" + messageId)
    											.asJson()
    											.getBody()
    											.getObject();
    	return messageDetails;
    }

	public JSONObject triggerGetMethod(String url) {
		JSONObject getResponseObject = null;
		try {
			getResponseObject = Unirest.get(url)
										.asJson()
										.getBody()
										.getObject();
			return getResponseObject;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getResponseObject;
	}


}

