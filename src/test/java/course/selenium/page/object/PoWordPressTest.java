package course.selenium.page.object;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import course.selenium.page.object.BasePage;
import course.selenium.webdriver.WebDriverManager;

public class PoWordPressTest {
	private static WebDriver driver;

	@BeforeAll
	public static void webDriver() {
		WebDriverManager driverManage = new WebDriverManager(driver);
		driverManage.webDriverType("chrome").setUp();
		driver =WebDriverManager.getDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
	}

	@AfterAll
	public static void afterAll() {
		//driver.close();
	}

	
	@Test
	public void addTag() {
		LoginPage login = new LoginPage(driver);
		login.loginWithUserName("Admin").loginWithPass("demo123").submit();
	
		assertTrue(BasePage.isOnPage(driver, "Dashboard"));

		SideMenuPage sideMenu = new SideMenuPage(driver);
		sideMenu.clickOnOptionFromSubMenu("posts", "tags");

		assertTrue(BasePage.isOnPage(driver, "tags"));
		assertTrue(BasePage.checkH1PageTitle("tags"));
		
		TagsPage tags = new TagsPage(driver);		
		assertTrue(BasePage.checkH1PageTitle("tags"));
		assertTrue(BasePage.isOnPage(driver, "tags"));
		
		String tagName = "New tag Name" + System.currentTimeMillis();
		String tagDescription = "My description for the new tsg created";
		tags.insertTagName(tagName).insertTagDescription(tagDescription).submit();
		
		//checks if the new added tag is on the list 
		assertTrue(tags.searchTagInList(tagName));
		
		tags.deleteTag();
		assertTrue(tags.tagMessage("Tags deleted."));
		//check that the tag was deleted and is not on the list
		assertTrue(!tags.searchTagInList(tagName));
	}
}
