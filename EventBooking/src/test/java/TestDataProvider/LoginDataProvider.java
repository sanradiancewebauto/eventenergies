package TestDataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	 @DataProvider(name="SearchProvider", parallel = true)
     public static Object[][] getDataFromDataprovider(Method m){
		 if (m.getName().equalsIgnoreCase("verification_of_valid_login_credentials_test01")) {
			 return new Object[][] {
//	             { "chaithra.s@sanradiance.com", "chaithra@sanradiance.com" },
	             { "storageblues@gmail.com", "Kingstone@123" },
	             { "nj3k4fs60z@getnada.com", "1lzKgsG3nH"}
	         }; 
	      }else {
	    	  return new Object[][] {
	              { "chaithra.s@sanradiance.com", "invalidPassword" },
	              { "arif.k@sanradiance.com", "invalidPassword" }
	          }; 
	      }
          
	 }

}
