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
 * @author Nir Gallner Code sample June 11th, 2020
 *
 */

public class GoodMorningTest {

	private static WebDriver driver;

	@BeforeAll
	public static void OpenWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws InterruptedException {
		System.out.println("In Test 1");
	}

	@Test
	public void test2() {
		System.out.println("In Test 2");
	}

	@AfterAll

	public static void CloseWebDriver() {
		driver.close();		
}	
	@Test
	public void test3() {
		driver.get("http://demosite.center/wordpress/wp-login.php");
		WebElement e = driver.findElement(By.id("user_login"));
		e.sendKeys("ekedmi");
	}
}
