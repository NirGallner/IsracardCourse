package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountActionsTest {
	
	private static WebDriver driver;
	
	private static UnpluggedPage unpluggedPage;
	private static LogInPage logInPage;
	private static IsracardHomePage homePage;
	private UpdatePasswordPage updatePasswordPage;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("start - before all");
		
		//set the driver - chrome driver
		System.setProperty("webdriver.chrome.driver", "C:/Users/galln/Downloads/ChromeDriver83/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//go to isracard page
		driver.get("https://digital.isracard.co.il/");
		
		unpluggedPage = new UnpluggedPage(driver);
		logInPage = new LogInPage(driver);
		homePage = new IsracardHomePage(driver);
		
		//go to log in page
		unpluggedPage.clickOnLoginButton();
		
		// log in 
		logInPage.logIn("203204086", "814066", "Aa111111");
		
		//make sure you're in home page
		if(!homePage.isThisHomePage()) {
			System.out.println("log in failed");
		}
		
		// go to update password screen
				homePage.clickOnUpdatePassword();
		
	}
	
	@Test
	public void updatePassword() {
		System.out.println("start testing update password");
		
		//init password page
		updatePasswordPage = new UpdatePasswordPage(driver);
		
		//update password
		updatePasswordPage.updatePassword("Aa222222", "Aa333333");
		
		//test password changed
		assertTrue(updatePasswordPage.isPasswordChanged());
	}
}
