package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import isracard.DashboardPage;
import isracard.LoginPage;
import isracard.TagPage;

public class TagPageTest {

	static WebDriver driver;

	private static DashboardPage dashboard;

	@BeforeAll
	public static void beforeAll() throws InterruptedException {

		// Logging
		System.out.println("In before all - start running");

		// New instance
		System.setProperty("webdriver.chrome.driver", "C:/Users/galln/Downloads/ChromeDriver83/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Goto login page
		driver.get("http://demosite.center/wordpress/wp-login.php");

		// Login
		LoginPage login = new LoginPage(driver);
		dashboard = login.withUsername("admin").withPassword("demo123").submit();
		
		String handle = driver.getWindowHandle();
		
		 
		
		
		
	}

	@BeforeEach
	public void beforeEach() {

		// Logging
		System.out.println("In before each");

		// Go back to dashboard page
		dashboard.gotoDashboardPage();
	}

	@AfterEach
	public void afterEach() {

		// Logging
		System.out.println("In after each");

	}

	@Test
	public void addTag() {
		String tagTitle = "My Tag Title " + System.currentTimeMillis();

		TagPage tagPage = dashboard.gotoTagsPage();

		int originalListsize = tagPage.getTagsListSize();

		tagPage.withName(tagTitle).withSlug("").withDescription("tag description").submit();
		
		
		// A - make sure a new tag was added to the list
		assertEquals(originalListsize + 1, tagPage.getTagsListSize(), "there should be a new tag in list");

		// B - make sure that the tag is ours
		assertTrue(tagPage.isTagOnList(tagTitle) > -1, "Specific tag should be on the list");
	}

	@Test
	public void deleteTag() {
		
		TagPage tagPage = dashboard.gotoTagsPage();

		int originalListsize = tagPage.getTagsListSize();

		if (originalListsize == 0)
			Assertions.fail("No tags to delete");
		

		String tagNameToDelete = tagPage.getTag(0).getText();
		tagPage.deleteTag(0);

		// A - make sure the tag was deleted
		assertEquals(originalListsize - 1, tagPage.getTagsListSize(), "there should be 1 less tag in list");

		// B - make sure that the tag we deleted is actually deleted
		assertTrue(tagPage.isTagOnList(tagNameToDelete) == -1, "Specific tag should NOT be on the list");
	}
	
	
}
