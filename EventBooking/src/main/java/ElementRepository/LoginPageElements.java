package ElementRepository;



public class LoginPageElements {



	//Login Now
	public static String Login ="/html/body/app-root/app-home-page/section[1]/div/div[2]/ul/li[3]/a/input";

	//Login page title
	public static String LoginTitle ="a > div";

	public static String LoginText ="//h3";

	//Email Address
	public static String LoginUserName = "email";

	public static String LoginEmailAddresslabel="row:nth-child(1) .heading";

	public static String RequiredEmailError ="//*[@id=\"Login\"]/div/div[1]/div[2]/div/div";

	public static String InvalidEmailError ="//*[@id=\"Login\"]/div/div[1]/div[2]/div/div";

	//Password
	public static String LoginPassword="password";

	public static String LoginPasswordlabel ="nth-child(2) .heading";

	public static String  RequiredPasswordError=".error-mez:nth-child(3)";

	public static String  LoginPasswordVisible =".fa";

	//Submit button
	public static String loginButton = "//*[@id=\"Login\"]/div/div[3]/div/input";

	//Login with mobile number page
	public static String  LoginWithMobile ="Or Sign in with mobile number";

	//Forgot password
	public static String  LoginForgotPassword ="Forgot your password?";

	//Navigate to Register page
	public static String LoginFreeTrail="Start a free trail";

	//Login with invalid data
	public static String LoginUnsuccessful =".alert-info > span";

	


}



