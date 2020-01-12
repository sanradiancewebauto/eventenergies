package TestDataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;


public class EventsDataProvider {
	static Logger log = LogManager.getLogger(EventsDataProvider.class.getName());
	@DataProvider(name="fetchData_JSON")
     public static Object[][] getDataFromDataprovider(Method m) throws FileNotFoundException {
		 if (m.getName().equalsIgnoreCase("verification_of_events_creation_test01")) {
			String JSON_Path = "/Users/arif/Documents/Git_Repos/eventenergies/EventBooking/src/test/java/TestDataProvider/EventTestData.json";
			Object[][] testdata =  EventsDataProvider.getdata(JSON_Path, "dataSet", 1, 28);
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