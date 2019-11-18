package ElementRepository;

public class RegistrationPageElements {
	
	//OPEN URL
	public static final String baseURL = "https://www.storytwinkle.com";

	// Register Now
	public static final String registerButton = "li:nth-child(1) > .register-button";
	public static final String RegisterPage = ".col-sm-6:nth-child(2) .popup-blog-image";
	
	
	//LOGIN FIELDS
	public static final String loginbox = "UserName";
	public static final String passbox = "Password";

	//LOGIN DATA
	public static final String username = "test";
	public static final String password = "test";
	public static final String loginbt = "btnsubmit";
	



		public static final String baseURL = "https://www.storytwinkle.com";

		// Register Now
		public static final String registerButton = "li:nth-child(1) > .register-button";

		public static final String RegisterPage = ".col-sm-6:nth-child(2) .popup-blog-image";

		// page Title
		public static String RegisterTitle="EventEnergies";

		public static String RegisterSubTitle=".container > .row > .col-sm-12 > h2";

		//Register name
		public static String RegisterFirstNameLabel=".row:nth-child(1) > .col-sm-12 > .heading";

		public static String RegisterFirstNamefield="first_name";

		public static  String RegisterFirstNameError="//p[contains(.,'First Name is required')]";

		public static String RegisterLastNamefield="last_name";

		public static String RegisterLastNameError=".error-mez";

		//contact phone number
		public static String RegisterPhonelabel=".row:nth-child(2) > .col-sm-12 > .heading";

		public static String RegisterPhonefield="phone";

		public static String RegisterPhoneError=".error-mez > div";

		public static String RegisterPhoneInvalidError=".error-mez > div";

		//Email address
		public static String EmailLabel=".row:nth-child(3) .heading";

		public static String EmailField="email";

		public static String EmailRequiredError=".error-mez > div";

		public static String EmailInvalidError="//div[2]/div/div";

		//choose password
		public static String PasswordLabel=".row:nth-child(4) .heading";

		public static String PasswordField="password";

		public static String PasswordError=".error-mez > div";

		public static String PasswordErrors=".error-mez > div";


		//Checkbox
		public static String CheckboxLabel =".checkbox > label";

		public static String CheckboxError=".error-mez";

		//Navigate To Login page
		public static String SignInLabel="Already have an Account? Sign in here";

		//Submit button
		public static String SubmitButton =".btn";

		//Register exit user
		public static String InvalidRegister=".alert-info > span";


	

}
