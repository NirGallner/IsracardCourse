package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
//		WebElement userName = driver.findElement(By.id("user_login"));
//		userName.sendKeys("admin");
//
//		driver.findElement(By.id("user_pass")).sendKeys("demo123");
//		driver.findElement(By.id("wp-submit")).click();
//		Thread.sleep(9000);

	}

	@BeforeEach
	public void beforeEach() {

		// Logging
		System.out.println("In before each");

		// If we are not on the dashboard page - click on it
//		if (driver.getTitle().contains("Dashboard") == false)
//			driver.findElement(By.xpath("//div[text()='Dashboard']")).click();

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
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='postdivrich']//textarea")).sendKeys("My post body");

		// submit
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//*[@id='publishing-action']//input[@type='submit']")).click();

		// for example
		driver.findElement(By.xpath("//*[@id='publishing-action']//input[@type='submit']")).click();
		;

		// Wait for update
		Thread.sleep(5000);

		// submitted?
		// WebElement submit =
		WebElement submit = driver.findElement(By.xpath("//*[@id='publishing-action']//input[@type='submit']"));
		assertTrue(submit.getAttribute("value").equalsIgnoreCase("update"));

		// Goto list of posts
		driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']")).click();

		// Last enetered should be the first one

		// Get the entire table
		WebElement allPosts = driver.findElement(By.id("the-list"));

		List<WebElement> postNames = allPosts.findElements(By.xpath("(.//tr)//td//strong//a"));

		boolean found = false;
		for (WebElement element : postNames) {
			if (element.getText().contentEquals(postTitle)) {
				found = true;
				break;
			}
		}
		// Get the text of the oldest post
		// String postName = allPosts.findElement(By.xpath("(.//tr)//a")).getText();

		// assertTrue(postName.contentEquals(postTitle));
		assertTrue(found, "The title was not found");

		Thread.sleep(5000);

	}

	@Test
	public void newPostInitial() throws InterruptedException {

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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='publishing-action']//input[@type='submit']")).click();

		// Wait for update
		Thread.sleep(3000);

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

		// assertTrue(postName.contentEquals(postTitle));
		assertTrue(postName.contentEquals(postTitle));

		Thread.sleep(5000);

	}

	@Test
	public void addDeleterTag() throws InterruptedException {
		
		String tagTitle = "My Tag Title " + System.currentTimeMillis();

		// Post element
		WebElement posts = driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']"));

		// Hover
		new Actions(driver).moveToElement(posts).perform();

		// Click on new post
		driver.findElement(By.linkText("Tags")).click();

		driver.findElement(By.id("tag-name")).sendKeys(tagTitle);
		driver.findElement(By.id("tag-slug")).sendKeys("my slug");
		driver.findElement(By.id("tag-description")).sendKeys("my description");

		driver.findElement(By.id("submit")).click();

		Thread.sleep(3000);

		List<WebElement> allTags = driver.findElements(By.xpath("//*[@id='posts-filter']//table//strong"));

		WebElement foundTag = null;
		for (WebElement tag : allTags) {
			if (tag.getText().contentEquals(tagTitle)) {
				foundTag = tag;
				break;
			}
		}

		assertNotNull(foundTag, "The tag was not found on the list");

		// If we are here, then the tag was found

		Thread.sleep(14000);
		WebElement forId = driver.findElement(By.xpath("//*[contains(text(),'Select " + tagTitle + "')]"));
		String id = forId.getAttribute("for");
		driver.findElement(By.id(id)).click();

		Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
		select.selectByVisibleText("Delete");

		// Apply
		driver.findElement(By.id("doaction")).click();

	}
	
	@Test
	public void LoginTest() {
		// validation
		assertTrue(LoginPage.isOnPage((WebDriver)driver));
		
		// Login
		 LoginPage login = new LoginPage((WebDriver)driver);
		DashboardPage dashboard =  login.withUsername("admin").withPassword("demo123").submit();
		
		
		
	}

	@AfterAll
	public static void afterAll() {

		// Logging
		System.out.println("In after all");

		// Quit driver
		driver.quit();
	}
}
