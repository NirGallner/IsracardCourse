package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest {

	static WebDriver driver;
	
	@BeforeAll
	public static void BeforeAll() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		
		//Login
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys("admin");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("demo123");
		WebElement logInButton = driver.findElement(By.id("wp-submit"));
		logInButton.click();
		Thread.sleep(9000);
	}
	
	@BeforeEach
	public void BeforeEach() throws InterruptedException{
		System.out.println("Before each Test");
		
		//check if we are on Dashboard page
			if (driver.getTitle().contains("Dashboard") == false)
				driver.findElement(By.xpath("//*[@id=\"menu-dashboard\"]/a/div[2]")).click();
			Thread.sleep(3000);
			}
	
	@AfterAll
	public static void AfterAll()
	{
		System.out.println("After");
		driver.quit();
	}
	
	
	@Test
	public void LocatorByClassName() {
		driver.findElement(By.className("count")).click();
		System.out.println("Find element by class name");
	}
	
	@Test
	public void LocatorByXpath() {
		driver.findElement(By.xpath("//*[@href=\"http://demosite.center/wordpress/wp-admin/edit-comments.php?comment_status=spam\"]")).click();
		System.out.println("Find element by xpath");
	}
	
	@Test
	public void LocatorByCssSelectot() {
		driver.findElement(By.cssSelector(".all,href")).click();
		System.out.println("Find element by CssSelectot");
	}
	
	@Test
	public void LocatorById() {
		driver.findElement(By.id("show-settings-link")).click();
		System.out.println("Find element by Id");
	}
	
	@Test
	public void LocatorByLinkText() {
		driver.findElement(By.linkText("Arcade Basic")).click();
		System.out.println("Find element by LinkText");
	}
	
	@Test
	public void LocatorByName() {
		driver.findElement(By.name("post_title")).click();
		System.out.println("Find element by Name");
	}
	
	@Test
	public void LocatorByTagName() {
		driver.findElement(By.tagName("button")).click();
		System.out.println("Find element by Tag Name");
	}
	
	@Test
	public void LocatorByprtialLinkText() {
		driver.findElement(By.partialLinkText("Arcade")).click();
		System.out.println("Find element by Partioal Link Text");
	}
	
}
