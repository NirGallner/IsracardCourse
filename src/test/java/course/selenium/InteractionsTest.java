package course.selenium;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

public class InteractionsTest {

	static WebDriver driver;

	@BeforeAll
	public static void beforeAll() throws InterruptedException {

		// Logging
		System.out.println("In before all - start running");

		// New instance
		System.setProperty("webdriver.chrome.driver", "C:/Users/galln/Downloads/ChromeDriver83/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Goto page
		driver.get("http://demosite.center/wordpress/wp-login.php");

		// Login
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("demo123");
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(4000);

	}

	@AfterAll
	public static void afterAll() {
		driver.quit();

	}

	@BeforeEach
	public void beforeEach() {

		// Logging
		System.out.println("In before each");

		// If we are not on the dashboard page - click on it
		if (driver.getTitle().contains("Dashboard") == false)
			driver.findElement(By.xpath("//div[text()='Dashboard']")).click();
		

	}

	@AfterEach
	public void afterEach() {

		// Logging
		System.out.println("In after each");
		
	
		

	}
	
	// @Test
	public void sendKeysExample() throws InterruptedException {
		WebElement content  = driver.findElement(By.id("title"));
		content.sendKeys("this is my content");
		Thread.sleep(3000);
		content.clear();
		Thread.sleep(3000);
		content.sendKeys("my new content");
		Thread.sleep(3000);
	}
	
	//@Test
	public void actionsExample() throws InterruptedException {
		WebElement posts = driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']"));
		new Actions(driver).moveToElement(posts).perform();
		Thread.sleep(3000);
		
		// WRONG!!
		//WebElement byTags = posts.findElement(By.linkText("Tags"));
		
		WebElement byTags = driver.findElement(By.linkText("Tags"));
		new Actions(driver).moveToElement(byTags).click().perform();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void xyLocations() throws InterruptedException {
		WebElement posts = driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']"));
		new Actions(driver).moveToElement(posts).perform();
		
		// How to get the coordinates?
		System.out.println("posts location" + posts.getLocation());
		WebElement byTags = driver.findElement(By.linkText("Tags"));
		System.out.println("tags location" + byTags.getLocation());
		
		new Actions(driver).moveToElement(posts, 180, 90).click().perform();
		Thread.sleep(3000);
		
	}
}
