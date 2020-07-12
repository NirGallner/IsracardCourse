package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LironTest {

	private static WebDriver driver;

	@BeforeAll
	public static void webDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron\\temp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
		
		@AfterAll
		public static void afterAll() {
			driver.close();
		}

	@Test
	public void login() throws InterruptedException {
		driver.get("http://demosite.center/wordpress/wp-login.php");
		WebElement userName = driver.findElement(By.id("user_login"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("demo123");
		WebElement loginBtn = driver.findElement(By.id("wp-submit"));
		loginBtn.click();
		Thread.sleep(2000);
		WebElement dashboard = driver.findElement(By.xpath("//*/h1[contains(text(), 'Dashboard')]"));
		assertTrue(dashboard.isDisplayed());
	}
}
