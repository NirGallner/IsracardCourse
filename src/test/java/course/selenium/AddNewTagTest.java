package course.selenium;

import java.awt.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddNewTagTest {
static WebDriver driver;
	
	@BeforeAll
	public static void BeforeAll() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		//Login to wordPress
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("demo123");
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(9000);
		driver.findElement(By.className("wp-menu-name")).click();
	}
	@Test
	public void AddNewTag () throws InterruptedException
	{
		String TagTitle = "My new Tag" + System.currentTimeMillis();

		//Find posts page
		WebElement posts = driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']"));
		
		//Go to post page 
		new Actions(driver).moveToElement(posts).perform();
		
		//Go to Tags page
		driver.findElement(By.linkText("Tags")).click();
		Thread.sleep(5000);
		
		//Add a new Tag- title
		driver.findElement(By.xpath("//*[@id='tag-name']")).sendKeys(TagTitle);
		
		//Add a new Tag- slug
		driver.findElement(By.xpath("//*[@id='tag-slug']")).sendKeys(TagTitle);
		Thread.sleep(1000);
		
		//Add a new Tag- body
		driver.findElement(By.xpath("//*[@id='tag-description']")).sendKeys("Tag body bla bla bla");
		Thread.sleep(1000);
		
		//Submit and create the tag
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		
		//Search my new tag
		driver.findElement(By.id("tag-search-input")).sendKeys(TagTitle);
		driver.findElement(By.id("search-submit")).click();
		Thread.sleep(5000);

		//Get the table
		WebElement myTag = driver.findElement(By.xpath("(.//tbody)//tr//th//input"));
		myTag.click();
		Thread.sleep(2000);
		
		//Mark my Tag
		Select categoryFilter = new Select(driver.findElement(By.id("bulk-action-selector-top")));
		categoryFilter.selectByVisibleText("Delete");
		driver.findElement(By.xpath("//*[@id='doaction']")).click();
	}

}
