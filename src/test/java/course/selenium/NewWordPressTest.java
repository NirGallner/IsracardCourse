package course.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PageObject.DashboardPage;
import PageObject.LoginPage;
import PageObject.TagPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class NewWordPressTest {
	private static WebDriver driver;

	@BeforeAll
	public static void OpenWebDriver() {

	// New instance
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	// Go to page
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		LoginPage login = new LoginPage((WebDriver)driver);
		assertTrue(login.IsOnPage(driver));
		
		DashboardPage dashboard = login.WithUsername("Admin").WithPassword("demo123").Submit();
		assertTrue(DashboardPage.IsOnPage((WebDriver)driver));
	}
	
	@Test
	public void addTag() throws InterruptedException{
		
		TagPage tagPage = new TagPage (driver);
		
		tagPage.goToTagPage();

		assertTrue(TagPage.IsOnPage((WebDriver)driver));
		tagPage.withName("name 123").Withslugtags("slug 123").WithDescription("Description123").submit();
		
		tagPage.searchNewTag();
			
	}

}
