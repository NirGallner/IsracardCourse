package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.course.BenefitsPage;
import selenium.course.IsracardHomePage;
import selenium.course.LogInPage;
import selenium.course.UnpluggedPage;

public class BenefitsTest {
	
static WebDriver driver;
	
	private static UnpluggedPage unpluggedPage;
	private static LogInPage logInPage;
	private static IsracardHomePage homePage;
	private static BenefitsPage benefitsPage;
	
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
		logInPage.logIn("203204086", "814066", "Aa222222");
		
		//make sure you're in home page
		if(!homePage.isThisHomePage()) {
			System.out.println("log in failed");
		}
		
		//go to benefits page
		homePage.getBenefitsTab();
		
		benefitsPage = new BenefitsPage(driver);
	}
	
	@BeforeEach
	public void beforeEach() {
		benefitsPage.scrollToFooter();
	}
	
	@Test
	public void checkKidsAndParents() {
		benefitsPage.getKidsAndParents().click();
		
		assertEquals("הורים וילדים", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkFood() {
		benefitsPage.getFood().click();
		
		assertEquals("אוכל ונשנושים", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkFun() {
		benefitsPage.getFun().click();
		
		assertEquals("תרבות ופנאי", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkFashion() {
		benefitsPage.getFashion().click();
		
		assertEquals("אופנה ואביזרים", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkVacations() {
		benefitsPage.getVacations().click();
		
		assertEquals("חופשות בארץ", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkAttractions() {
		benefitsPage.getAttractions().click();
		
		assertEquals("אטרקציות", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkPremium() {
		benefitsPage.getPremium().click();
		
		assertEquals("הורים וילדים", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkAviation() {
		benefitsPage.getAviation().click();
		
		assertEquals("המרת נקודות טיסה באל על ובריטיש איירווייס - ישראכרט", driver.findElement(By.className("aviation-title")));
	}
	
	@Test
	public void checkMoreSurprises() {
		benefitsPage.getMoreSurprises().click();
		
		assertEquals("עוד הפתעות", driver.findElement(By.className("categoryPageTitle")));
	}
	
	@Test
	public void checkHome() {
		benefitsPage.getHome().click();
		
		assertEquals("עיצוב ומוצרים לבית", driver.findElement(By.className("categoryPageTitle")));
	}

}
