package FinalCourseTask;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Isracard.Final.DigitalBasePage;
import com.Isracard.Final.IsracardLogInPage;
import com.Isracard.Final.PersonalAreaPage;
import com.Isracard.Final.UpdatePasswordPage;

public class PasswordUpdateTest {
	/**
	 * static fields for the current test usage
	 */
	static WebDriver driver;
	static String userid = "321124430";
	static String userdigits = "002534";
	static String userpassword = "h1234567";
	static String usernewpassword = "q1234567";
	
	/**
	 * set the driver, exe, open the correct URL - make a log in 
	 */
	@BeforeAll
	public static void beforeAll(){
		//Get the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\marina\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		//go to page
		driver.get("https://digital.isracard.co.il/");
	//	String originalHandle = driver.getWindowHandle();
		DigitalBasePage base = new IsracardLogInPage(driver);
		base.gotoLogInpage();
		//login
		assertTrue(IsracardLogInPage.isOnPage((WebDriver)driver));
		IsracardLogInPage login = new IsracardLogInPage((WebDriver)driver);
		login.withUserID(userid).withSixDigits(userdigits).withUserPassword(userpassword+ " " +Keys.ENTER);
	}
	/**
	 * After all test the window will close
	 */
	@AfterAll
	public static void afterAll(){
	driver.quit();
	}
	
	/**
	 * the test that updates the password- will pass if the update succeed 
	 */
	@Test
	public void updateThePass() {
	 PersonalAreaPage personal = new PersonalAreaPage(driver);
	 personal.openAccountFunctions();
     personal.gotoUpdatePassPage();
     UpdatePasswordPage update = new UpdatePasswordPage(driver);
     update.insertOldPass(userpassword).insertNewPass(usernewpassword).confirmNewPass(usernewpassword).submitPassUpdate();
     update.confirmSucsess();
	}
	
}

