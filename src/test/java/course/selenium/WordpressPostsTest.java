package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WordpressPostsTest {
	
	static WebDriver driver;
	 
	@BeforeAll
	public static void start()
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
	}
	
	@Test
	public void goToPosts()
	{
		driver.findElement(By.id("menu-posts")).click();
		
		//WebElement lastPost = driver.findElement(By.linkText("http://demosite.center/wordpress/wp-admin/post.php?post=1&action=edit"));
		//String thirdPost=lastPost.getText();
		//System.out.println(thirdPost);
		//assertEquals ("Hello world!",thirdPost);
		
	}
	
		@Test
		public void findPost()
		{
		List<WebElement> elementsList = driver.findElements(By.className("row-title"));
	    //System.out.println(elementsList.get(elementsList.size() - 1).getText());
        String lastPost = elementsList.get(elementsList.size() - 1).getText();
        assertEquals ("Hello world!",lastPost);
		System.out.println(lastPost);
		
		}
		
		@AfterAll
		public static void close()
		{
			driver.quit();

		}
		

	}
	
	
	


