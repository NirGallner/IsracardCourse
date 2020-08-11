import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Isracard.BaseIsracardPage;
import Isracard.BenefitsLoginPage;
import Isracard.FinancialHomePage;

class BenefitsFooterTest {

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
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
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

	@AfterEach
	public void afterEach() {

		// Logging
		System.out.println("In after each");

	}

	@Test
	void testBenefitsInFooter() throws InterruptedException {

		// Logging
		System.out.println("In benefits footer test");

		BaseIsracardPage mainPage = new BaseIsracardPage(driver);
		String isracardHomepageHandle = driver.getWindowHandle();
		ArrayList<String> linksText = new ArrayList<String>(); // list of category names from thr benefits footer
		String[] text = {"הורים וילדים","אוכל ונשנושים","תרבות ופנאי","אופנה ואביזרים","חופשות וטיולים","אטרקציות","הטבות פרימיום","מסלול תעופה","עוד הפתעות","עיצוב ומוצרים לבית"};
		linksText.addAll(Arrays.asList(text));
		boolean testResult = mainPage.goOverBenefitsFooter(linksText,isracardHomepageHandle);

		assertTrue(testResult);
		
		// Logging
		System.out.println("benefits footer test ended");
	}

	@AfterAll
	public static void afterAll() {
		driver.close();
	}
}
