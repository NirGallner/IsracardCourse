package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WordPressNewPostTest 
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
		System.out.println("Start");
	}

	@Test
	public void goToPosts() throws InterruptedException
	{
		driver.findElement(By.id("menu-posts")).click();
	    Thread.sleep (5000);

	}
	
    @Test
    public void AddNewPost() throws InterruptedException 
    {
    	 //Click add new
	    WebElement AddNew =driver.findElement(By.className("page-title-action"));
    	new Actions(driver).moveToElement(AddNew).click().perform();
	    Thread.sleep (5000);
	    
	     //Confirm page    
	    String postPageHeader= driver.findElement(By.xpath("//div[@id='wpbody-content']//h1[@class='wp-heading-inline']")).getText();
	    assertEquals(postPageHeader,"Add a New Post");
	    Thread.sleep (8000);
	    System.out.println("Header is:" + postPageHeader);
	    
	    // Insert header+post
	    // Point publishButton =  driver.findElement(By.id("publish")).getLocation();
	    // System.out.println(publishButton);
		// Point openDraftWindow = driver.findElement(By.xpath("//div[@id='submitdiv']//span[@class='toggle-indicator']")).getLocation();
         //System.out.println(openDraftWindow);
	    
	    String header = "This is my header" + System.currentTimeMillis();
	    driver.findElement(By.id("title")).sendKeys(header);
	    Thread.sleep (5000);
	    driver.findElement(By.id("content-html")).click();
	    driver.findElement(By.id("content")).sendKeys("This is my post");
	    Thread.sleep (5000);
	   
	    
	    //out of textbox

	     WebElement textBox = driver.findElement(By.id("content"));
	     textBox.sendKeys(Keys.TAB);
		 Thread.sleep (3000);

		 driver.findElement(By.id("save-post")).click();
		 Thread.sleep (3000);

	     //(does not work because name is now + draft)  String myTitle = driver.findElement(By.id("title")).getText();
	   
          // Back to posts
	     driver.findElement(By.linkText("All Posts")).click();
    	 //did not work- driver.findElement(By.id("menu-posts")).click();
	     Thread.sleep (5000);
	    
         //Confirm post is in list
	     driver.findElement(By.id("post-search-input")).sendKeys(header); 
	     Thread.sleep (5000);

	     driver.findElement(By.id("search-submit")).click();
	     Thread.sleep (5000);

	     boolean postinList = driver.findElements(By.className("row-title")).size()!=0;
	     System.out.println(postinList);
	     Thread.sleep (3000);

	     String postStatus = driver.findElement(By.className("post-state")).getText();
	     assertEquals ("Draft",postStatus);
	     System.out.println("State is Draft");
	     Thread.sleep (2000);

   	}
    
    @AfterAll
    public static void end()
	{
		driver.quit();
		System.out.println("End");

	}


	


    }
    
  /*  @Test
    public void checkHeader() throws InterruptedException
    {
	    String postPageHeader= driver.findElement(By.xpath("//div[@id='wpbody-content']//h1[@class='wp-heading-inline']")).getText();
	   
	    assertEquals(postPageHeader,"Add a New Post");
	    Thread.sleep (8000);
	    System.out.println("Header is:" + postPageHeader);
	    

    }
    
      @Test
    public void addNewPost() throws InterruptedException
    {
	    driver.findElement(By.id("title")).sendKeys("Header");
	    Thread.sleep (5000);

	    driver.findElement(By.id("content")).sendKeys("This is my post");
	    driver.findElement(By.id("publish")).click();
	    Thread.sleep (8000);
	    System.out.println("post");

    }
    
    @Test
    public void chekPostIsInPosts()
    {
	    String myPost = driver.findElement(By.id("content")).getText();
	    driver.findElement(By.id("menu-posts")).click();
		driver.findElement(By.id("post-search-input")).sendKeys(myPost);
	    driver.findElement(By.id("search-submit")).click();
		boolean allOptionalPosts = driver.findElements(By.className("row-title")).size()!=0;
		System.out.println(allOptionalPosts);
		
    }
	
	@AfterAll
	public static void end()
	{
		driver.quit();
		System.out.println("End");

	}


}*/
    
    

