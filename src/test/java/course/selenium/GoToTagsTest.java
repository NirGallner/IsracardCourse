package course.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GoToTagsTest
{
	
	
	static WebDriver driver;
	 
	@BeforeAll
	public static void start() throws InterruptedException
	{
		
    System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
	
	driver = new ChromeDriver();

	
	driver.get("http://demosite.center/wordpress/wp-login.php");
	
	// Maximize window
	driver.manage().window().maximize();
	
	WebElement user = driver.findElement(By.id("user_login"));
	user.sendKeys("admin");
	driver.findElement(By.id("user_pass")).sendKeys("demo123");
	driver.findElement(By.id("wp-submit")).click();
	Thread.sleep(5000);
	}

	@Test
	public void GoToTags() throws InterruptedException
	
	{
	WebElement Posts = driver.findElement(By.id("menu-posts"));
	Posts.click();
	//new Actions(driver).moveToElement(Posts).perform();
	Thread.sleep(5000);
	//driver.findElement(By.linkText("Tags")).click();
	
		
	}
	
	//@Test
	//public void WritePost() throws InterruptedException
	
	//{
	// driver.findElement(By.className("page-title-action")).click();
	//Thread.sleep(5000);
	//driver.findElement(By.id("title-prompt-text")).sendKeys("hellooooo");
	
	//}

	@Test
	public void chooseFromList()
	{
		Select CategoriesDropDown = new
		Select(driver.findElement(By.id("cat")));
		CategoriesDropDown.selectByVisibleText("Uncategorised");
		driver.findElement(By.id("post-query-submit")).click();
		
	}
}
