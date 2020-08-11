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

public class MonthsPaymentsTests {
	private static WebDriver driver;
	private static SignInPage signInPage;
	private static HeaderPage headerPage;
	private static Footer footerPage;
	private static HatavotPage hatavotPage;
	private static HoriveVeyeladimPage horiveVeyeladimPage;
	private static NishnushimPage nishnushimPage;
	private static MyCardsPage myCardsPage;

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
		Thread.sleep(3000);
		
		// login
		signInPage.logInToIsracardSite("031572100", "910330", "ss7000000");

		

	}
	
	
	private static void initPages() {
		signInPage = new SignInPage(driver);
		headerPage = new HeaderPage(driver);
		hatavotPage = new HatavotPage(driver);
		horiveVeyeladimPage = new HoriveVeyeladimPage(driver);
		nishnushimPage = new NishnushimPage(driver);
		myCardsPage =new MyCardsPage(driver);
	}
	
	
	@BeforeEach
	public void navigateToHatavot() {
//		signInPage.openMainUrl();
		myCardsPage.clickPerutIskaot();
	}

	@Test
	public void preMonth() {
		myCardsPage.selectPrevMonth();
		String titleText = myCardsPage.getTitleText();
		assertTrue(titleText.equals("סה\"כ חיובים קודמים"));
	}

	@Test
	public void nextNonth() {
		myCardsPage.selectNextMonth();
		String titleThisMonth = myCardsPage.getTitleTextThisMonth();
		assertTrue(titleThisMonth.equals("סה\"כ לחיוב הבא"));
	}
	
	@Test
	public void choseFromPicker() {
	myCardsPage.selectMonthFromPicker();
	String titleAprilMonth = myCardsPage.getTitleChosenCalendarMonth();
	assertTrue(titleAprilMonth.equals("סה\"כ לחיוב אפריל 2020"));
		
	}

}
