package ElementRepository;

public class ChangePasswordPageElement {

	public static String pageTitle ="h2";

	public static String CurrentPsswordLabel =".signin-card > .row:nth-child(1) .heading";

	public static String CurrentPasswordField ="current_password";

	public static String  CurrentPasswordError="//form[@id='change_password_form']/div/div/div[2]/div/span";

	public static String NewPasswordLabel=".row:nth-child(2) .heading";

	public static String NewPasswordField="password";

	public static String NewPasswordError="//form[@id='change_password_form']/div/div[2]/div[2]/div/div";

	public static String NewPasswordError1=".row:nth-child(2) .error-mez > div";

	public static String ConfirmPasswordLabel=".row:nth-child(3) > .col-sm-12 > .heading";

	public static String ConfirmPasswordField="confirm_password";

	public static String ConfirmPasswordError="//form[@id='change_password_form']/div/div[3]/div[2]/div/div";

	public static String ConfirmPasswordError1=".row:nth-child(3) .error-mez > div";

	public static String SamePasswordError="//form[@id='change_password_form']/div/div[3]/div[2]/div";

	public static String  SubmitButton="btn-blue-color";

	public static String InvalidForm="//span[contains(.,'Current password is wrong')]";


}
