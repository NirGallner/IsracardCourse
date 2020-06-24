/**
 * Selenium WebDriver course code samples.
 * June 202, 
 * @author Nir Gallner
 */
package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Nir Gallner
 * Code sample June 11th, 2020
 *
 */
public class GoodMorningTest {

private static WebDriver driver;
	
	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Temp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test1() throws InterruptedException {

		driver.get("http://www.google.com");
		WebElement e = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		e.sendKeys("Test Atomation");
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
		search.click();
		// e.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

//		driver.quit();
	}

	@Test
	public void test2() throws InterruptedException {

		driver.get("https://buyme.co.il/");
		Thread.sleep(5000);
		WebElement e = driver.findElement(By.xpath("//*[@id=\"ember660\"]/div/ul[1]/li[3]/a/span[1]"));
		e.click();
		Thread.sleep(3000);
		WebElement mail = driver.findElement(By.xpath("//*[@id=\"ember1153\"]"));
		mail.sendKeys("gal_wasserman@hotmail.com");
		WebElement next = driver.findElement(By.xpath("//*[@id=\"ember1145\"]"));
		next.click();
		WebElement pw = driver.findElement(By.xpath("//*[@id=\"ember1155\"]"));
		pw.sendKeys("Galw2552");
		WebElement enter = driver.findElement(By.xpath("//*[@id=\"ember1145\"]/button"));
		enter.click();
		// e.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	@Test
	public void test3() throws InterruptedException {

		driver.get("http://demosite.center/wordpress/wp-login.php");
		Thread.sleep(5000);
		WebElement button = driver.findElement(By.id("user_login"));
		button.sendKeys("gal_wasserman@hotmail.com");
	}
	
		@AfterAll
		public static void teardown() {
		driver.quit();
	}
}
