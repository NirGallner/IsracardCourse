package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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
import demo_site.poms.BasePage;
import demo_site.poms.DashboardPage;
import demo_site.poms.TagsPage;

public class NewTagCapsulizationTest {
	static WebDriver driver;
	private static DashboardPage dashboard;
 
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
		//login
		assertTrue(LogInPage.isOnPage((WebDriver)driver));
		LogInPage login = new LogInPage((WebDriver)driver);
		dashboard = login.withUserName("admin").withPassword("demo123").submit();		
	}

	/**
	 * Validates that the user on log in page - if true, performs login
	 */
	@BeforeEach
	public void backtoDashboard () {
	//	DashboardPage dashboard = new DashboardPage((WebDriver)driver);
		if(driver.getTitle().contains("Dashboard")==false)
			dashboard.gotoDashboardPage();
	}
		
	/**
	 * Test: finds the tags area and fills in the tag-post fields and publishing the tag
	 */
	@Test
	public void tagPostNew() {
		TagsPage tags = dashboard.gotoTagsPage();
				
		int originalListsize = tags.getTagsListSize();
		tags.insertTagTitle(myTagTitle).insertTagContent(myTagCont).insertTagDescription(myTagDescr).tagSubmit();
		//First step to check wherever the amount of tags raised by one, thus we added a new tag
		assertEquals(originalListsize +1, tags.getTagsListSize(), "there should be a new tag in list");
		//Second step to check if the new tag is ours, by comparing the title
		assertTrue(tags.isTagOnList(myTagTitle) > -1, "Specific tag should be on the list");
	}	
	
	@Test
	public void deleteTag() {
		TagsPage tags = dashboard.gotoTagsPage();
		
		int originalListsize = tags.getTagsListSize();
		
		if(originalListsize == 0)
			Assertions.fail("No tags to delete");
		
		String tagNameToDelete = tags.getTag(0).getText();
		tags.deleteTag(0);
		
		assertEquals(originalListsize - 1, tags.getTagsListSize(), "there should be lass tags in the list");
		
		assertTrue(tags.isTagOnList(tagNameToDelete) == -1, "Specific tag should not be on the list");
	}

}
		
	//	tags.searchTheTag(myTagTitle).searchSubmit();
//		WebElement tagsList = driver.findElement(By.id("posts-filter"));
//		List <WebElement> tagsTitles = tagsList.findElements(By.xpath("(.//table)//strong"));
//		System.out.println("size of tags : " + tagsTitles.size());
//		WebElement pullId = driver.findElement(By.xpath("//*[contains(text(),'Select "+ myTagTitle +"')]"));
//		String id = pullId.getAttribute("for");
//		driver.findElement(By.id(id)).click();
		//Delete my tag
	//	tags.deleteTheTag();
//	}
//	@AfterAll
//	public static void afterAll() {
//		driver.quit();
//	}
//}
//New Post
//	dashboard.gotoPosts();
//	dashboard.insertTitle("My new post");