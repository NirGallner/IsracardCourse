package course.selenium;



import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WordpressTest 
{

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
    public void goToMedia() throws InterruptedException 
    {
    	driver.findElement(By.xpath("//li[@id='menu-media']//div[@class='wp-menu-name']")).click();
    	System.out.println("by xpath");

    	Thread.sleep(5000);

    }
    
    @Test
    public void Bin() 
    {
    	driver.findElements(By.linkText("http://demosite.center/wordpress/wp-admin/edit-comments.php?comment_status=trash"));
    	
    	System.out.println("by link");

    }

    @Test
    public void byId()
    {
    	driver.findElement(By.id("menu-settings")).click();
    	System.out.println("by id");
    }
    
    
    @Test
    public void byClass()
    {
	driver.findElement(By.className("comment-count")).click();
	System.out.println("by class");
    }
    
    @Test
    public void byTagName() 
    {
	List<WebElement>allPTags = driver.findElements(By.tagName("p"));allPTags.get(18).click();
	System.out.println("by tag name");
    }
    
    @Test
    public void byPartialLink() 
    {
    driver.findElement(By.partialLinkText("Please update")).click();
	System.out.println("by partial link");
    }

    @Test
    public void byName() 
    {
	driver.findElement(By.name("save")).click();
	System.out.println("by Name");
    }
    
	@AfterEach
	public void goToDashboard() throws InterruptedException
	{
	driver.findElement(By.cssSelector("#menu-dashboard .wp-menu-name")).click();
	System.out.println("After Each css");

	Thread.sleep(5000);
	}
	
	@AfterAll
	public static void close()
	{
		driver.quit();

	}
}

