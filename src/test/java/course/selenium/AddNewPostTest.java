package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class AddNewPostTest {
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
	
	@Disabled
	@Test
	public void AddPost() throws InterruptedException {
		driver.findElement(By.id("menu-posts")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("page-title-action")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("title")).sendKeys("Liraz Post");
		Thread.sleep(5000);
		driver.findElement(By.id("content-html")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("content")).sendKeys("Liraz Post");
		driver.findElement(By.id("side-sortables")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("publish")).click();
		Thread.sleep(3000);
		System.out.println("Post published");

		//Search My post
		driver.findElement(By.linkText("All Posts")).click();
		driver.findElement(By.id("post-search-input")).sendKeys("Liraz Post");
		driver.findElement(By.id("search-submit")).click();
		Thread.sleep(5000);
		
		//Verify the post is exist
		List<WebElement> webElements = driver.findElements(By.className("row-title"));
		int Index = webElements.size();
		if (Index > 0) {
			for (int i=0; i<Index; i++) {
				String ElementName = webElements.get(i).getText();
				if (ElementName.equals("Liraz Post"))
				{
					System.out.println("The post is here");
					System.out.println(i);
				}
			}
		}
		else
			System.out.println("Somthing went wrong");
				
		}
	
	@Test
	public void DraftPost() throws InterruptedException {
		
		String postTitle = "My new Post" + System.currentTimeMillis();
		
		//Find posts page
		driver.findElement(By.id("menu-posts")).click();
		Thread.sleep(2000);
		
		//Goto add new post
		driver.findElement(By.className("page-title-action")).click();
		Thread.sleep(5000);
		
		//Insert post title
		driver.findElement(By.id("title")).sendKeys(postTitle);
		Thread.sleep(5000);
		
		 
		driver.findElement(By.id("content-html")).click();
		Thread.sleep(1000);
		
		//Insert post body
		driver.findElement(By.id("content")).sendKeys(postTitle);
		Thread.sleep(2000);

		//Clock on Tab to find the save Draft button
		WebElement webElement = driver.findElement(By.xpath("//*[@id='content']"));
		webElement.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='save-post']")).click();
		Thread.sleep(3000);
		System.out.println("Post published - Draft");
		
		//Goto all posts page
		driver.findElement(By.linkText("All Posts")).click();
		Thread.sleep(1000);
		
		//Search My new post
		driver.findElement(By.id("post-search-input")).sendKeys(postTitle);
		driver.findElement(By.id("search-submit")).click();
		Thread.sleep(5000);
		
		//Find my post
		WebElement draft = driver.findElement(By.xpath("(.//tbody)//tr//strong/span"));
		String myDraft = draft.getText();
		
		//Verify the word Draft appears
		assertEquals(myDraft, "Draft");
	}
	
	@AfterAll
	public static void AfterAll()
	{
		System.out.println("After");
		driver.quit();
	}
	
}
