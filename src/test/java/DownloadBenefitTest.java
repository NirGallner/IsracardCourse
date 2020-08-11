import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Isracard.BenefitPage;
import Isracard.BenefitsHomePage;
import Isracard.BenefitsLoginPage;
import Isracard.CategoryPage;
import Isracard.FinancialHomePage;

class DownloadBenefitTest {

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
	void kayakBenefitTest() throws InterruptedException {	
		// Logging
		System.out.println("In kayakBenefitTest test");

		BenefitsHomePage benefitsHomePage = homePage.goToBenefitsPage();
		assertTrue(benefitsHomePage.isOnPage("אתר ההטבות"), "Benefits home page cant be loaded"); 
		CategoryPage categoryPage = benefitsHomePage.getCategoryList("אטרקציות");
		assertNotEquals(null, categoryPage, "Category page can't be loaded or not found"); // if categoryPage is null, test fails

		BenefitPage benefitPage = categoryPage.getBenefitsList("קייקי כפר בלום");
		assertNotEquals(null, benefitPage, "Benefit page can't be loaded or not found"); // if categoryPage is null, test fails

		assertTrue(benefitPage.isPremium(), "Benefit is not a premium one"); // if benefit is not premium, test fails

		assertTrue(benefitPage.checkBusinessSite("כפר בלום"), "Business site not found");
		benefitPage.clickOnReadMore();

		benefitPage.clickOnTermsAndConditions();

		BenefitsLoginPage benefitsLoginPage = benefitPage.downloadBenefit();// download benefit
		benefitPage = benefitsLoginPage.withID(203427901).withSixDigits(361290).submitToSuccessPage("כפר בלום"); 
		assertNotEquals(null, benefitPage, "login failed"); // checks if login successed
		
		System.out.println("kayakBenefitTest test ended");
	}

	@AfterAll
	public static void afterAll() {

		// Logging
		System.out.println("In After all");
		driver.quit();
	}
}
