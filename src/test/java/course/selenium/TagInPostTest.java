package course.selenium;

import javax.swing.Action;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TagInPostTest {
	
	static WebDriver driver;
	@BeforeAll
	public static void BeforeAll() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		
		//Login
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys("admin");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("demo123");
		WebElement logInButton = driver.findElement(By.id("wp-submit"));
		logInButton.click();
		Thread.sleep(9000);
	}
	
//	@AfterAll
//	public static void AfterAll()
//	{
//		System.out.println("After");
//		driver.quit();
//	}
	

	@Test
	public void EnterToTag() throws InterruptedException 
	{
		WebElement posts = driver.findElement(By.id("menu-posts"));
		new Actions(driver).moveToElement(posts).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Tags")).click();
	}
	
}
