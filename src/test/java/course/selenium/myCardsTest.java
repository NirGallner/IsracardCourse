package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myCardsTest {
	
	static WebDriver driver;
	
	private static UnpluggedPage unpluggedPage;
	private static LogInPage logInPage;
	private static IsracardHomePage homePage;
	private static MyCardsPage myCardsPage;
	private static ChargesDetailsPage chargesDetailsPage;
	
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
		myCardsPage = new MyCardsPage(driver);
		
		//go to log in page
		unpluggedPage.clickOnLoginButton();
		
		// log in 
		logInPage.logIn("203204086", "814066", "Aa222222");
		
		//make sure you're in home page
		if(!homePage.isThisHomePage()) {
			System.out.println("log in failed");
		}
		
		//go to my cards page
		homePage.getMyCardsButton().click();
		
		//go to charges details
		myCardsPage.getChargesDetails().click();
		
		chargesDetailsPage = new ChargesDetailsPage(driver);
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("start before each");
	}
	
	@Test
	public void checkNextMonthCharge() {
		chargesDetailsPage.changeToNextCharge();
		
		//test this is the right charge details
		assertEquals("סה\"כ לחיוב הבא", driver.findElement(By.xpath("//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[3]/div[1]/p[1]")).getText());
	}
	
	@Test
	public void checkFormerMonthCharge() {
		chargesDetailsPage.changeToFormerCharge();
		
		//test this is the right charge details
		assertEquals("סה\"כ חיובים קודמים", driver.findElement(By.xpath("//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[3]/div[1]/p[2]")).getText());
	}
	
	@Test
	public void checkSelectedMonth() {
		chargesDetailsPage.changeToChosenMonthCharge("1");
		
		//check the selected month appear
		assertEquals("סה\"כ לחיוב פברואר 2020", driver.findElement(By.xpath("//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[3]/div[1]/p[3]")).getText());
	}
}
