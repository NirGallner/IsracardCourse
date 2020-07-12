/**
 * Selenium WebDriver course code samples.
 * June 202,
 * @author Nir Gallner
 */
package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Time;

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

/**
 * Test class of Word Press demo site
 * 
 * @author Nir Gallner
 *
 */

public class WordPressTest {

	// Define a static driver - to be initialized in @BeforeAll
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
		Thread.sleep(9000);
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

	 @Test
	public void inDashboardPage() {

		// Check if the title contains the word - Dashboard
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.contains("Dashboard"), "Dashboard should appear in title");
	}

	 @Test
	public void lastPost() {

		// Goto posts list
		driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']")).click();

		// Get the entire table
		WebElement allPosts = driver.findElement(By.id("the-list"));

		// Get the text of the oldest post
		String postName = allPosts.findElement(By.xpath("(.//tr)[last()]//a")).getText();

		// Check the name
		assertTrue(postName.equals("Hello world!"), "Post is not hellow world...");

	}

	@Test
	public void newPost() throws InterruptedException {

		String postTitle = "My Post Title " + System.currentTimeMillis();
		// Post element
		WebElement posts = driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']"));

		// Hover
		new Actions(driver).moveToElement(posts).perform();

		// Click on new post
		driver.findElement(By.linkText("Add New")).click();

		// Title
		driver.findElement(By.xpath("//*[@id='titlewrap']//input")).sendKeys(postTitle);

		// Body
		driver.findElement(By.xpath("//*[@id='postdivrich']//textarea")).sendKeys("My post body");

		// submit
		driver.findElement(By.xpath("//*[@id='publishing-action']//input[@type='submit']")).click();

		// Wait for update
		Thread.sleep(9000);

		// submitted?
		WebElement submit = driver.findElement(By.xpath("//*[@id='publishing-action']//input[@type='submit']"));
		assertTrue(submit.getAttribute("value").equalsIgnoreCase("update"));
		
		// Goto list of posts
		driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']")).click();

		// Last enetered should be the first one

		// Get the entire table
		WebElement allPosts = driver.findElement(By.id("the-list"));

		// Get the text of the oldest post
		String postName = allPosts.findElement(By.xpath("(.//tr)//a")).getText();
		
		assertTrue(postName.contentEquals(postTitle));
		
		Thread.sleep(5000);

	}

	@AfterAll
	public static void afterAll() {

		// Logging
		System.out.println("In after all");

		// Quit driver
		driver.quit();
	}
}
