package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WpTest {

private static WebDriver driver;
	
	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Temp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test1() throws InterruptedException {

		driver.get("http://demosite.center/wordpress/wp-login.php");
		WebElement userName = driver.findElement(By.id("user_login"));
		userName.sendKeys("admin");
		WebElement passw = driver.findElement(By.id("user_pass"));
		passw.sendKeys("demo123");
		WebElement checkBox = driver.findElement(By.id("rememberme"));
		checkBox.click();
		WebElement enterButton = driver.findElement(By.id("wp-submit"));
		enterButton.click();
		Thread.sleep(5000);
		WebElement DB = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/h1"));
		Assertions.assertEquals("Dashboard", DB.getText());
		
	}


	@AfterAll
		public static void teardown() {
		driver.quit();
	}
}




