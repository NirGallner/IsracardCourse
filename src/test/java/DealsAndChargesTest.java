import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import Isracard.FinancialHomePage;
import Isracard.FinancialLoginPage;
import Isracard.DealsAndChargesPage;

class DealsAndChargesTest {

	static WebDriver driver;
	private static FinancialHomePage homePage;


	@BeforeAll
	public static void beforeAll() throws InterruptedException {

		// Logging
		System.out.println("In before all - start running");

		// New instance
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://digital.isracard.co.il/");
		homePage = new FinancialHomePage(driver);

	}

	@BeforeEach
	public void beforeEach() throws InterruptedException {

		// Logging
		System.out.println("In before each");

		// Go back to financial home page
		homePage.goToFinancialHomePage();
	}

	@Test
	void selectCharge() throws InterruptedException {

		// Logging
		System.out.println("In deals and charges test");

		FinancialLoginPage loginPage= homePage.goToDealsAndChargesPage();
		assertTrue(loginPage.isOnPage("כניסה"), "Login page cant be loaded"); 
		loginPage = loginPage.withUserID(203427901);
		loginPage = loginPage.withsixCardDigits(361290);
		// login to financial area
		DealsAndChargesPage dealsAndChargesPage = loginPage.withPassword("").submitToDeals("פירוט חיובים ועסקאות");
		// checks if you are in login page (login successed)
		assertNotEquals(null, dealsAndChargesPage, "login failed");
		//click on different charges
		dealsAndChargesPage = dealsAndChargesPage.selectCharge("מועד קרוב",0);   
		dealsAndChargesPage = dealsAndChargesPage.selectCharge("מועד קודם",0);
		//select charge by month
		dealsAndChargesPage = dealsAndChargesPage.selectCharge("בחירת חודש",6);
		assertNotEquals(dealsAndChargesPage,null,"Problem with month selection");
		
		// Logging
				System.out.println("deals and charges test ended");
	}

	@AfterAll
	public static void afterAll() {
		driver.close();
	}
}