import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Isracard.DashboardPage;
import Isracard.FinancialHomePage;
import Isracard.FinancialLoginPage;
import Isracard.UpdatePasswordPage;

class UpdatePasswordTest {


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
	void updatePasswordTest() throws InterruptedException {

		// Logging
		System.out.println("In update password test");

		FinancialLoginPage login= homePage.goToDashBoardPage();
		assertTrue(login.isOnPage("כניסה"), "Login page cant be loaded"); 

		//login to dashboard
		login = login.withUserID(203427901);
		login = login.withsixCardDigits(361290);
		login = login.withPassword("");
		DashboardPage dashboard = login.submitToDashboard("האיזור האישי");
		assertNotEquals(null, dashboard, "login failed");

		UpdatePasswordPage updatePasswordPage = dashboard.gotoUpdatePasswordPage();
		assertTrue(updatePasswordPage.isOnPage("עדכון סיסמא"), "Update password page cant be loaded"); 
		
		//change password
		updatePasswordPage = updatePasswordPage.insertOldPassword("");
		updatePasswordPage = updatePasswordPage.insertNewPassword("");
		updatePasswordPage = updatePasswordPage.insertNewPasswordAgain("");
		updatePasswordPage.submitNewPassword();
		assertNotEquals(null, updatePasswordPage, "Update password failed");
		updatePasswordPage.goToDashBoardPageWithoutLogin();
		assertTrue(login.isOnPage("האיזור האישי"), "Dashboard page cant be loaded"); 

		System.out.println("updatePasswordTest test ended");
	}

	@AfterAll
	public static void afterAll() {
		driver.close();
	}
}
