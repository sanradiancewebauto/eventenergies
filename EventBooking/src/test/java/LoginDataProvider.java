

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	 @DataProvider(name="SearchProvider")
     public static Object[][] getDataFromDataprovider(Method m){
		 if (m.getName().equalsIgnoreCase("verification_of_loginpage_element_view_test01")) {
			 return new Object[][] {
	             { "chaithra.s@sanradiance.com", "chaithra@sanradiance.com" },
	             { "arif.k@sanradiance.com", "arif@sanradiance.com" },
	         }; 
	      }else {
	    	  return new Object[][] {
	              { "chaithra.s@sanradiance.com", "invalidPassword" },
	              { "arif.k@sanradiance.com", "invalidPassword" },
	          }; 
	      }
          
	 }

}
