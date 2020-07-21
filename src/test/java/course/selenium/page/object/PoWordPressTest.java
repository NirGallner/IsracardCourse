package course.selenium.page.object;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import course.selenium.page.object.BasePage;
import course.selenium.webdriver.WebDriverManager;

public class PoWordPressTest {
	private static WebDriver driver;

	@BeforeEach
	public void webDriver() {
		WebDriverManager driverManage = new WebDriverManager(driver);
		driverManage.webDriverType("chrome").setUp();
		driver =WebDriverManager.getDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
	}

	@AfterEach
	public void afterAll() {
	//	driver.close();
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
		int listSizeBeforeSubmit = tags.getListSize();		
		
		tags.insertTagName(tagName).insertTagDescription(tagDescription).submit();
		
		int indexOfNewTag = tags.searchTagNameAfterNewAdded(listSizeBeforeSubmit, tagName); 
		
		assertTrue(indexOfNewTag >= 0);
		
		tags.deleteTag(tagName, indexOfNewTag);
		
		assertTrue(tags.searchTagInList(tagName) < 0);
	}
	
	@Test
	public void deleteTag() {
		
		LoginPage login = new LoginPage(driver);
		login.loginWithUserName("Admin").loginWithPass("demo123").submit();
		
		SideMenuPage sideMenu = new SideMenuPage(driver);
		sideMenu.clickOnOptionFromSubMenu("posts", "tags");

		TagsPage tags = new TagsPage(driver);
		String tagName = "New tag Name" + System.currentTimeMillis();
		String tagDescription = "My description for the new tsg created";
		int listSizeBeforeSubmit = tags.getListSize();
		
		tags.insertTagName(tagName).insertTagDescription(tagDescription).submit();
		int indexOfNewTag = tags.searchTagNameAfterNewAdded(listSizeBeforeSubmit, tagName);
		
		tags.deleteTag(tagName, indexOfNewTag);
		
		assertTrue(tags.searchTagInList(tagName) < 0);
		assertTrue(tags.tagMessage("Tags deleted."));
		
	}
}
