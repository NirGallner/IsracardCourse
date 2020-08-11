import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Isracard.BenefitsHomePage;
import Isracard.BenefitsLoginPage;
import Isracard.FinancialHomePage;
import Isracard.MyBenefitsPage;

class CancelBenefitTest {

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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
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
	void cancelBenefitTest() throws InterruptedException {
		
		// Logging
		System.out.println("In cancelBenefit test ");

		BenefitsHomePage benefitsHomePage = homePage.goToBenefitsPage(); // goto benefits homepage
		assertTrue(benefitsHomePage.isOnPage("אתר ההטבות"), "Benefits page page cant be loaded"); 
		BenefitsLoginPage benefitsLoginPage = benefitsHomePage.gotoMyBenefitsPage(); // goto benefits personal area
		assertTrue(benefitsLoginPage.isOnPage("התחברות"), "Benefits login page cant be loaded"); 
		//benefits login
		MyBenefitsPage myBenefitsPage = benefitsLoginPage.withID(203427901).withSixDigits(361290).submitToMyBenefitsHomePage("אזור אישי");
		assertNotEquals(null, myBenefitsPage, "login failed"); // checks if login success
		myBenefitsPage = myBenefitsPage.cancelBenefit(); // click on "cancel benefit" button.
		assertNotEquals(null,myBenefitsPage,"Cancel benefit failed");
		// Logging
		System.out.println("cancelBenefit test ended");

	}

	@AfterAll
	public static void afterAll() {
		driver.close();
	}
}


