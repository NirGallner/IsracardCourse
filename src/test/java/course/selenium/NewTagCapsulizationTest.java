package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo_site.pom.login.LogInPage;
import demo_site.poms.TagsPage;

public class NewTagCapsulizationTest {
	private static WebDriver driver;
	String myTagTitle = "New Marinas Tag "+ System.currentTimeMillis();
	String myTagCont = "The slug of the slug";
	String myTagDescr = "The description";

	/**
	 * Preparation for the test cycle: Driver's exe source, opens the Chrome browser,
	 * maximize it and get the URL
	 */
	@BeforeAll
	public static void beforeAll(){
		//Logging 

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\marina\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//go to page
		driver.get("http://demosite.center/wordpress/wp-login.php");
	}

	/**
	 * Validates that the user on log in page - if true, performs login
	 */
	@BeforeEach
	public void logInPerform () {
		assertTrue(LogInPage.isOnPage((WebDriver)driver));
		LogInPage login = new LogInPage((WebDriver)driver);
		login.withUserName("admin").withPassword("demo123").submit();		
	}
	/**
	 * Test: finds the tags area and fills in the tag-post fields and publishing the tag
	 */
	@Test
	public void tagPostNew() {
		TagsPage tags = new TagsPage((WebDriver)driver);
		tags.hoverAbovePosts();

		//Lazy elements
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("All Posts")));
		WebElement allPosts = driver.findElement(By.linkText("All Posts")); 
		new Actions(driver).moveToElement(allPosts).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Tags")));
		WebElement findTags = driver.findElement(By.linkText("Tags")); 
		new Actions(driver).moveToElement(findTags).click().perform();
		// fill in the tag fields and press submit
		tags.insertTagTitle(myTagTitle).insertTagContent(myTagCont).insertTagDescription(myTagDescr).tagSubmit();
		//Find my tag in the list
		WebElement tagsList = driver.findElement(By.id("posts-filter"));
		List <WebElement> tagsTitles = tagsList.findElements(By.xpath("(.//table)//strong"));
		System.out.println("size of tags : " + tagsTitles.size());
		WebElement pullId = driver.findElement(By.xpath("//*[contains(text(),'Select "+ myTagTitle +"')]"));
		String id = pullId.getAttribute("for");
		driver.findElement(By.id(id)).click();
		//Delete my tag
		tags.deleteTheTag();
	}
	
//	@AfterAll
//	public static void afterAll() {
//		driver.quit();
//	}
}



//New Post
//	dashboard.gotoPosts();
//	dashboard.insertTitle("My new post");