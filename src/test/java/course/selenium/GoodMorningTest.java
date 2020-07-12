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
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoodMorningTest {
	private static WebDriver driverChrome;
	
	@BeforeAll
	public static void openWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron\\temp\\chromedriver.exe");
		driverChrome = new ChromeDriver();
		driverChrome.manage().window().maximize();
	}

	/**
	 * 
	 * @author Nir Gallner
	 * Code sample June 11th, 2020
	 *
	 */
	@Test
	public void test1()  {
		driverChrome.get("http://demosite.center/wordpress/wp-login.php");
		WebElement login = driverChrome.findElement(By.id("user_login"));
		login.sendKeys("Liron");
	}

	@Test
	public void test2() {
		System.out.println("In Test 2");
	}
	
	/**
	 * 
	 * 
	 * @author liron
	 * 
	 */
	@AfterAll
	public static void closeWebDriver() {
		driverChrome.close();
	}
}
