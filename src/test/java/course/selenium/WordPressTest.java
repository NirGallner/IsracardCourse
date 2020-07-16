package course.selenium;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WordPressTest {

	// Define a static driver - to be initialized in @BeforeAll
	static WebDriver driver;

	@BeforeAll
	public static void beforeALL() throws InterruptedException {

		// Logging
		System.out.println("In before all - start running");

		// New instance
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Goto page
		driver.get("http://demosite.center/wordpress/wp-login.php");

		// Login
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("demo123");
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(2000);
	}

	@BeforeEach
	public void beforeEach() {

		// Logging
		System.out.println("In before each");

		// if we are not in dashboard page - click on it
		if (driver.getTitle().contains("Dashboard") == false)
			driver.findElement(By.xpath("//div[text()='Dashboard']")).click();	
	}

	@AfterEach
	public void afterEach() {

		// Logging
		System.out.println("In after each");

		// Back to dashboard
		driver.findElement(By.xpath("//div[text()='Dashboard']")).click();
	}



	// exercise 3(Homework lesson3):
	/*
	@Test 
	public void CheckLastPost () throws InterruptedException {
		// Logging
		System.out.println("In test 1 - check last post");

		Thread.sleep(5000);
		String postTitle = "Hello world!";
		// Click on Posts
		driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']")).click();
		Thread.sleep(5000);

		// Get the entire table
		WebElement allPosts = driver.findElement(By.id("the-list"));

		List<WebElement> postNames = allPosts.findElements(By.xpath("(.//tr)//td//strong//a"));

		boolean found = false;
		int index = 0;
		for (WebElement element : postNames) {
			if (element.getText().equals(postTitle) && index == postNames.size()-1) {
				found = true;
				System.out.println(" 'Hello World!' is the last post");
				break;
			}
			index++;
		}

	}

	// Homework lesson 4 (2.7)
	@Test 
	public void AddNewPost () throws InterruptedException {

		// Logging
		System.out.println("In Test 2 - Add new post");
		String postTitle = "My Post Title :)" + System.currentTimeMillis();

		// Click on Posts
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);

		// Click on 'Add New' button
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("title")).sendKeys(postTitle);
		Thread.sleep(2000);

		driver.findElement(By.id("content")).sendKeys("Hello, my name is Shraga and i love Isracard!");
		// click on publish
		Thread.sleep(2000);

		// Cancel the hidden menu if the button is not clicked
		WebElement sideButton = driver.findElement(By.id("qt_content_dfw"));
		if (sideButton.getAttribute("class").contentEquals("ed_button qt-dfw active")) {
			sideButton.click();
		}
		Thread.sleep(2000);

		// Click on publish
		driver.findElement(By.id("publish")).click();
		Thread.sleep(5000);
		// Goto Allposts
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a")).click();

		Thread.sleep(2000);
		// check if the post published
		// Get the entire table

		WebElement allPosts = driver.findElement(By.id("the-list"));

		List<WebElement> postNames = allPosts.findElements(By.xpath("(.//tr)//td//strong//a"));

		boolean found = false;
		for (WebElement element : postNames) {
			if (element.getText().contentEquals(postTitle)) {
				found = true;
				System.out.println("Your post exists! Yay");
				break;
			}

		}
		assertTrue(found);

	}

	// Class workout 12.7
	@Test
	public void AddNewTag () throws InterruptedException {

		// Logging
		System.out.println("In Test 3- Add new tag");
		Thread.sleep(2000);		

		String TagTitle = "My new tag" + System.currentTimeMillis();

		// Click on Posts
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);

		// Click on Tags
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[3]/ul/li[5]/a")).click();
		Thread.sleep(2000);

		// Add name
		driver.findElement(By.id("tag-name")).sendKeys(TagTitle);
		Thread.sleep(2000);

		// Add slug
		driver.findElement(By.id("tag-slug")).sendKeys(TagTitle);
		Thread.sleep(2000);

		// Add description
		driver.findElement(By.id("tag-description")).sendKeys("Bla Bla Bla");
		Thread.sleep(2000);

		// submit
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);

		// Delete
		driver.findElement(By.id("tag-search-input")).sendKeys(TagTitle);
		Thread.sleep(2000);
		driver.findElement(By.id("search-submit")).click();
		Thread.sleep(2000);
		Select drpAction = new Select (driver.findElement(By.id("bulk-action-selector-top")));
		drpAction.selectByVisibleText("Delete");
		Thread.sleep(2000);

	}*/

	// Homework lesson 5 (12.7, sunday)
	@Test 
	public void savePostAsDraft () throws InterruptedException {
		// Logging
		System.out.println("In Test 4- Save post as draft");
		Thread.sleep(2000);

		String postTitle = "My Post Title :)" + System.currentTimeMillis();

		// Click on Posts
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);

		// Click on 'Add New' button
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("title")).sendKeys(postTitle);
		Thread.sleep(2000);

		driver.findElement(By.id("content")).sendKeys("Hello, my name is Shraga and i love Isracard!");
		// click on publish
		Thread.sleep(2000);

		// Cancel the hidden menu if the button is not clicked
		WebElement sideButton = driver.findElement(By.id("qt_content_dfw"));
		if (sideButton.getAttribute("class").contentEquals("ed_button qt-dfw active")) {
			sideButton.click();
		}
		Thread.sleep(2000);

		// Click on "Save draft"
		driver.findElement(By.id("save-post")).click();
		Thread.sleep(5000);

		// Goto Allposts
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a")).click();

		Thread.sleep(5000);
		// check if the post published
		// Get the entire table

		WebElement allPosts = driver.findElement(By.id("the-list"));

		List<WebElement> postNames = allPosts.findElements(By.xpath("(.//tr)//td//strong//a"));
		//WebElement draft = driver.findElement(By.xpath("//*[@id=\"post-69\"]/td[1]/strong/span"));

		boolean found = false;

		for (WebElement element : postNames) {
			try {
				WebElement draft = element.findElement(By.xpath("../span"));
				if (element.getText().equals(postTitle) && draft.getText().equals("Draft")) {
					found = true;
					System.out.println("Whoop whoop, your post saved as draft");
					break;
				}
			}
			catch (Exception e) { continue; }
		}
		assertTrue(found); // If "found" is still "false" - let me know.


	}

	@AfterAll
	public static void afterAll() {

		//logging
		System.out.println("In after all");

		// Quit driver
		driver.quit();
	}
}