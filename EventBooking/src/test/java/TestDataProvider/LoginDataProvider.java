package TestDataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	 @DataProvider(name="SearchProvider")
     public static Object[][] getDataFromDataprovider(Method m){
		 System.out.printf("The test name is %s", m.getName());
		 if (m.getName().equalsIgnoreCase("verification_of_valid_login_credentials_test01")) {
			 return new Object[][] {
	             { "chaithra.s@sanradiance.com", "chaithra@sanradiance.com" },
	             { "storageblues@gmail.com", "Kingstone@123" }
	         }; 
	      }else {
	    	  return new Object[][] {
	              { "chaithra.s@sanradiance.com", "invalidPassword" },
	              { "arif.k@sanradiance.com", "invalidPassword" }
	          }; 
	      }
          
	 }

}
