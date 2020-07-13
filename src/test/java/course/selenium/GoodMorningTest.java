//Homework lesson1
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
	static WebDriver driver; //הייתה שם ארור שזה חייב להיות סטטי
	
	@BeforeAll
	public static void beforeAll() {
		// Tell WebDriver where is the chromeDriver.exe
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:/Users/galln/Downloads/ChromeDriver83/geckodriver.exe");
			// Create a new ChromDriver instance
			driver = new ChromeDriver();
	}
	@Test
	public void test1() throws InterruptedException {
		System.out.println("In Test 1");
		// Get google
		driver.get("http://www.google.com");
		
		// Maximize window
		driver.manage().window().maximize();
		
		// Define objects
		WebElement e = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		
		
		e.sendKeys("Test Automation");
		
		// e.sendKeys(Keys.ENTER);
	}

	@Test
	public void test2() throws InterruptedException {
		System.out.println("In Test 2");
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
		search.click();
	}
	
	@AfterAll
	public static void afterAll() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
