//
package TestManager;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
////import java.util.concurrent.TimeUnit;
//
////import java.util.concurrent.TimeUnit;
//
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import PageFactory.LognPage;
//
//public class loginTest {
//
//	@Test
//	public void verifyValidLogin() throws IOException {
//
//		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://www.eventenergies.com");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//	LognPage LognPage= new LognPage(driver);
//		
//		LognPage.loginToEventEnergies("lokeshbabu@gmail.com", "lokeshbabu@gmail.com");
//
//	}
//
//}
//



 
import java.io.FileInputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
 
//How to read excel files using Apache POI
public class loginTest {
 public static void main (String [] args) throws IOException{
                        //I have placed an excel file 'Test.xlsx' in my D Driver 
 FileInputStream fis = new FileInputStream("D:\\eventenergies\\EventBooking\\src\\test\\java\\TestManager\\Login .xlsx");
 
 XSSFWorkbook workbook = new XSSFWorkbook(fis);
 
 XSSFSheet sheet = workbook.getSheetAt(0);
 Row row = sheet.getRow(0);
 Cell cell = row.getCell(1);
 for(int i=1; i<=sheet.getLastRowNum(); i++) { 

	// Import data for Email. 

	cell = sheet.getRow(i).getCell(1); 
	
	System.out.println(sheet.getRow(i).getCell(0));

//	driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue()); 

	// Import data for password. 

	cell = sheet.getRow(i).getCell(2); 
	
	System.out.println(sheet.getRow(i).getCell(1));




//	driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue()); 

	} 


 } 
}


