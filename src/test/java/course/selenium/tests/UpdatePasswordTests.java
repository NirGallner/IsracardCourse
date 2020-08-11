package course.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import course.selenium.HomePage;
import isracard.exceptions.java.pages.Footer;
import isracard.exceptions.java.pages.HatavotPage;
import isracard.exceptions.java.pages.HeaderPage;
import isracard.exceptions.java.pages.HoriveVeyeladimPage;
import isracard.exceptions.java.pages.MyCardsPage;
import isracard.exceptions.java.pages.NishnushimPage;
import isracard.exceptions.java.pages.SignInPage;
import isracard.exceptions.java.pages.updatePasswordPage;

public class UpdatePasswordTests {
	private static WebDriver driver;
	private static SignInPage signInPage;
	private static HeaderPage headerPage;
	private static Footer footerPage;
	private static HatavotPage hatavotPage;
	private static HoriveVeyeladimPage horiveVeyeladimPage;
	private static NishnushimPage nishnushimPage;

	@BeforeAll
	public static void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Temp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Init all the pages
		initPages();

		signInPage.openMainUrl();
//		Thread.sleep(3000);
		
		// login
		signInPage.logInToIsracardSite("031572100", "910330", "ss7000000");

		

	}
	
	@BeforeEach
	public void navigateToHatavot() {
		signInPage.openMainUrl();
		headerPage.clickOnHatavotTab();
	}

	private static void initPages() {
		signInPage = new SignInPage(driver);
		headerPage = new HeaderPage(driver);
		hatavotPage = new HatavotPage(driver);
		horiveVeyeladimPage = new HoriveVeyeladimPage(driver);
		nishnushimPage = new NishnushimPage(driver);
	}

	@Test
	public void horimYeladimLinkTest() {
		hatavotPage.clickHorimVeyeladimLink();
		String titleText = horiveVeyeladimPage.getTitleText();
		assertTrue(titleText.equals("הורים וילדים"));
	}
	
	@Test
	public void nishnushimLinkTest() {
		hatavotPage.clickNishnushimLink();
		String titleText = nishnushimPage.getTitleText();
		assertTrue(titleText.equals("אוכל ונשנושים"));
	}

}
