package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.exec.LogOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import isracard.objectPages.DashboardPage;
import isracard.objectPages.LoginPage;
import isracard.objectPages.TagsPage;

public class NewTagWithPageObjectTest {

	
	static WebDriver driver;
	
	@BeforeAll
	public static void BeforeAll() throws InterruptedException {
		
		//set property webDriver
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
		
		//Driver definition
		driver = new ChromeDriver();
		
		//Open wordpress website
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		//Maximized the window
		driver.manage().window().maximize();
		
		//Verify we are in the login page
		assertEquals(true, LoginPage.isInLoginPage(driver), "Login page is here");
		
		//Login to wordPress
		LoginPage login = new LoginPage(driver);
		login.withUsername("admin").withPassword("demo123").submit(driver);
		
	}
	
	@BeforeEach
	public void BeforeEach () {
		System.out.println("beforeEach");
		
		//Check if the Dashboard page is open
		if(DashboardPage.isInDashboardPage(driver) == false)
			driver.findElement(By.xpath("//div[text()='Dashboard']")).click();;
	}
	
	
	@Test
	public void AddNewTag() throws InterruptedException {
		
		System.out.println("Test");
		
		//Define tag title
		String TagTitle = "My new Tag" + System.currentTimeMillis();
		
		//Create a new Dashboad page
		DashboardPage dashboard = new DashboardPage(driver);
		
		//GoTo tags page
		dashboard.gotoTags();
		
		//Verify we are in tags page in case it's true- crate a tag
		if(TagsPage.isInTagsPage(driver) == true)
		{
			TagsPage tag = new TagsPage(driver);
			tag.insertTitle(TagTitle).insertSlug(TagTitle).insertBody("bla bla").createNewTag();
			tag.searchTag(TagTitle);
			System.out.println("New tag was added");
		}
		else
			System.out.println("Something go wrong");
	}
	
	
}
