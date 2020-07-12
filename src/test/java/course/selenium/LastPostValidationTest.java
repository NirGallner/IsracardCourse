package course.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class LastPostValidationTest {

	static WebDriver driver;
	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		//Logging 
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\marina\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	  //go to page
	driver.get("http://demosite.center/wordpress/wp-login.php");
	  // Login
	WebElement user_name = driver.findElement(By.id("user_login"));
	user_name.sendKeys("admin");
	WebElement user_pass = driver.findElement(By.id("user_pass"));
	user_pass.sendKeys("demo123");  
	WebElement submit = driver.findElement(By.id("wp-submit"));
	submit.click();
	System.out.println("Log in ");	
	Thread.sleep(9000);
	}
	  //before each test - dashboard location validation
	@BeforeEach
	public void beforeEach (){
		if(driver.getTitle().contains("Dashboard")==false)
			driver.findElement(By.xpath("//div.[text()= 'Dashboard']")).click();
		System.out.println("before each");
	}
	
//	@Test
//	public void postsClick () {		
//	driver.findElement(By.linkText("Posts")).click();
//	System.out.println("Posts");
//	}
	
	@Test
	public void hoverAboveTags () throws InterruptedException {
		WebElement findPosts = driver.findElement(By.linkText("Posts")); 
		new Actions(driver).moveToElement(findPosts).perform();
	//	driver.findElement(By.linkText("Posts"));  //driver.findElement(By.linkText("Posts")).click();
		Thread.sleep(18000);
		WebElement findTags = driver.findElement(By.linkText("Tags")); 
		new Actions(driver).moveToElement(findTags).click().perform();
	}
	
	@Test
	public void postsList () {
		driver.findElement(By.linkText("Posts")).click();
		Select categoryFilter = new Select(driver.findElement(By.id("cat")));
		categoryFilter.selectByVisibleText("Uncategorized");
		driver.findElement(By.id("post-query-submit")).click();
	}


	@Test  
	public void lastPostInList () {		
		driver.findElement(By.linkText("Posts")).click();
		System.out.println("Posts");
		
		WebElement postsList = driver.findElement(By.xpath("//*[@id='the-list']"));
		String postName = postsList.findElement(By.xpath("(.//tr)[last()]//a")).getText();
		//String lastPost = postsList.getText();
		
		assertTrue(postName.equals("Hello world!"), "The last post is not hellow world...");	
		System.out.println("Hello World");

}
}