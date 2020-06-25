package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MarinaTest {
	
	
	@Test
	public void logIn() {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\marina\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://demosite.center/wordpress/wp-login.php");
	driver.manage().window().maximize();
	WebElement user_name = driver.findElement(By.id("user_login"));
	user_name.sendKeys("admin");
	WebElement user_pass = driver.findElement(By.id("user_pass"));
	user_pass.sendKeys("demo123");  
	WebElement submit = driver.findElement(By.id("wp-submit"));
	submit.click();
	
	
	WebElement welcomePanel = driver.findElement(By.id("welcome-panel"));
	boolean flag = welcomePanel.isDisplayed();
	
	Assertions.assertTrue(flag);
	
	}
	
//	@AfterAll
//	public static void afterAll() {
//		
//		driver.quit();
//		
//	}
//	

}
