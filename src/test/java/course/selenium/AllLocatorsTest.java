
/**
 * Selenium WebDriver course code samples.
 * July 2020,
 * @author Nir Gallner
 */
package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsTest {

	static WebDriver driver;

	@BeforeAll
	public static void beforeAll() {

		// Logging
		System.out.println("In before all - start running");

		// New instance
		System.setProperty("webdriver.chrome.driver", "C:/Users/galln/Downloads/ChromeDriver83/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterAll
	public static void afterAll() {
		driver.quit();

	}

	@BeforeEach
	public void getReady() {
		// Goto page
		driver.get("https://www.ynet.co.il/home/0,7340,L-8,00.html");
	}

	@Test
	public void byClassName() {

		// Click the main article
		driver.findElement(By.className("subtitle")).click();
	}

	@Test
	public void byCssSelector() {
		driver.findElement(By.cssSelector(".news_ticker_title p")).click();
	}

	@Test
	public void byId() {
		driver.findElement(By.id("promolightboxmvc-1")).click();
	}

	@Test
	public void byLinkText() {
		driver.findElement(By.linkText("דואר אדום")).click();
	}

	@Test
	public void byName() throws InterruptedException {
		driver.findElement(By.linkText("דואר אדום")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("info")).sendKeys("חשוב לי שתדעו ש");
		Thread.sleep(3000);
	}

	@Test
	public void byPartialLinkText() {
		driver.findElement(By.partialLinkText("דואר אד")).click();
	}

	@Test
	public void byTagName() {

		// How many images are in the title?
		WebElement headerLinks = driver.findElement(By.id("hdr_main_links"));
		List<WebElement> allImagesInHeader = headerLinks.findElements(By.tagName("img"));
		int numOfImagesInHeader = allImagesInHeader.size();
		assertEquals(numOfImagesInHeader, 25, "The number should be 25");
	}

	@Test
	public void byXpath() {
		driver.findElement(By.xpath("//*[@class='news_ticker_title']//p")).click();
	}

}
