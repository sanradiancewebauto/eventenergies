package ElementRepository;

public class RegistrationPageElements {

	public static String EventAttendee="//*[@id=\"signUpTypeModal\"]/div/div/div[2]/div[1]/div[2]/div";//xpath

	// page Title
	public static String RegisterTitle="EventEnergies";//

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
	public static String checkboxField="agree";

	//Navigate To Login page
	public static String SignInLabel="Already have an Account? Sign in here";

	//Submit button
	public static String SubmitButton =".btn";

	//Register exit user
	public static String InvalidRegister=".alert-info > span";




}
