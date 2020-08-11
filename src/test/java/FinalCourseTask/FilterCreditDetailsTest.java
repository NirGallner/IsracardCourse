package FinalCourseTask;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Isracard.Final.CreditDetailsPage;
import com.Isracard.Final.DigitalBasePage;
import com.Isracard.Final.IsracardLogInPage;
import com.Isracard.Final.PersonalAreaPage;

public class FilterCreditDetailsTest {
	
	static WebDriver driver;
	
	//the order of the tests: previous, choosen, current - did not understand why.. Nir? ))

	/**
	 * static fields for the current test usage
	 */
	static String userid = "321124430";
	static String userdigits = "002534";
	static String userpassword = "q1234567";
	
	/**
	 * set the driver, exe, open the correct URL - make a log in and go to the credit details page
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
		login.withUserID(userid).withSixDigits(userdigits).withUserPassword(userpassword + " " +Keys.ENTER);		
		PersonalAreaPage personal = new PersonalAreaPage(driver);
		personal.gotoCreditDetailsPage();
	}
	
	@AfterAll
	    public static void afterAll(){
	    driver.quit();
	}
	
	/**
	 * the test that compares the displayed date to the current 
	 * 
	 */
	
	@Test 
	public void afiltersOfCurrentPaymentCheck() {
		CreditDetailsPage details = new CreditDetailsPage(driver);
		details.filterByCurrentPayment();
	}
	
	/**
	 * the test that sets the display to previous month and compares the displayed date to the expected date
	 */
	@Test
	public void bfiltersOfPreviousPaymentCheck() {
		CreditDetailsPage details = new CreditDetailsPage(driver);
		details.filterByPreviousPayment();
	}

	/**
	 * the test that sets the display to October month and compares the displayed date to the expected date
	 * can be modified according the the specification (what month to display)
	 */
	@Test
	public void cfiltersOfChhosenPaymentDateCheck() {
		CreditDetailsPage details = new CreditDetailsPage(driver);
		details.filterByChosenDate();
	}
}
