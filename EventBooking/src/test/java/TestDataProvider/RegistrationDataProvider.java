package TestDataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import CommonLibs.Utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;


public class RegistrationDataProvider {
	static Logger log = LogManager.getLogger(EventsDataProvider.class.getName());
	public static String pwd = System.getProperty("user.dir");
	public static String JSON_Path = pwd + "\\src\\test\\java\\TestDataProvider\\RegistrationTestData.json";

	@DataProvider(name = "GET_JSON_DATA")
	public static Object[][] getDataFromDataprovider(Method m) throws FileNotFoundException {
		if (m.getName().equalsIgnoreCase("resgister_new_user_verify_email_01")) {

			String JSON_dynamicPath = Utils.separatorsToSystem(JSON_Path);
			Object[][] testdata =  EventsDataProvider.getdata(JSON_dynamicPath, "dataSet", 1, 4);
			return testdata;
	      }
		return null;
	}

	public static Object[][] getdata(String JSON_Path, String typeData, int totalDataRow, int totalColumnEntry) throws FileNotFoundException{
		@SuppressWarnings("deprecation")
		JsonParser jsonParser = new JsonParser();
		@SuppressWarnings("deprecation")
		JsonObject jsonObj = jsonParser.parse(new FileReader(JSON_Path)).getAsJsonObject();
	    JsonArray array = (JsonArray)jsonObj.get("dataSet");
	    return searchJsonElement(array, totalDataRow, totalColumnEntry);
	}

	public static Object[][] searchJsonElement(JsonArray jsonArray, int totalDataRow, int totalColumnEntry) throws NullPointerException{
		
		
		Object[][] matrix = new Object[totalDataRow][totalColumnEntry];
		int j = 0;
		int i = 0;
		for (JsonElement jsonElement : jsonArray) {
			for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
				matrix[i][j] = entry.getValue().toString().replace("\"","");
				j++;
			}
			i++;
			j=0;
		}
		return matrix;
		
	}
}