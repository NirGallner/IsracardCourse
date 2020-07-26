package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.DashboardPage;
import PageObject.LoginPage;
import PageObject.TagsPage;

public class WordPressNewTest {
	
	public static WebDriver driver;
	
	@BeforeAll
	public static void OpenWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/temp/chromedriver.exe");
		driver  = new ChromeDriver();
	}
		
	
	
	@Test
	public void AddNewTag() throws InterruptedException {
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		assertTrue(LoginPage.isOnPageLogin(driver));
		LoginPage login = new LoginPage (driver);
		DashboardPage dashboard = login.withUserName("admin").withPassword("demo123").submit();
		assertTrue(dashboard.isOnPageDashboard("Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress" ));
		dashboard.GoToTagsPage();
		
		assertTrue(TagsPage.isOnPageTags(driver,"Tags"));
		TagsPage tags = new TagsPage(driver);
		tags.withTagName("Rina-my tag name").withTagSlug("Rina-my tag slug").withTagDescription("Rina-my tag description").submitTag();
	} 
	

	
	/*@AfterAll
	public static void AfterAll() {
		driver.quit();
	}*/
}
