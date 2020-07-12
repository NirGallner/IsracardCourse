package course.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class PublishThePostTest {
	
	    static WebDriver driver;
	    String theTitle = "Marina's first post";

		@BeforeAll
		public static void beforeAll() throws InterruptedException {
			//Logging 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\marina\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		  //go to page
		driver.get("http://demosite.center/wordpress/wp-login.php");
		  // Login
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
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
		
		@Test
		public void createPost() throws InterruptedException {
			driver.findElement(By.linkText("Posts")).click();
		//	WebElement postsList = driver.findElement(By.id("the-list"));
//			List<WebElement> allPosts = postsList.findElements(By.xpath(".//tr//a"));
//			System.out.println(postsList);
//			System.out.println(allPosts);
//			
//			for ( WebElement post: allPosts) { 
//				assertTrue(post.equals(theTitle), "The post is not exists...");
			
			driver.findElement(By.xpath("//*[@class=\"page-title-action\"]")).click();
			Thread.sleep(1200);
			WebElement title = driver.findElement(By.name("post_title"));
			title.click();
            title.sendKeys(theTitle);
            
//            WebElement locateIFrame = driver.findElement(By.id("content"));
//        	driver.switchTo().frame(locateIFrame);
//        	
//        	WebElement textEditor = driver.findElement(By.id("content"));
//        	textEditor.clear();
//        	textEditor.sendKeys("Hey, you are now using 3 Ad Inserter code blocks.\"\r\n" + 
//        			"					+ \" I would really appreciate it if you could give the plugin a 5-star rating on WordPres.\\r\\n\" + \r\n" + 
//        			"					\"Positive reviews are a great incentive to fix bugs and to add new features for better \"\r\n" + 
//        			"					+ \"monetization of your website. Thank you! - Igor");
//

			driver.findElement(By.id("content")).sendKeys("Hey, you are now using 3 Ad Inserter code blocks."
					+ " I would really appreciate it if you could give the plugin a 5-star rating on WordPres.\r\n" + 
					"Positive reviews are a great incentive to fix bugs and to add new features for better "
					+ "monetization of your website. Thank you! - Igor");
			Thread.sleep(1200);
			WebElement publishBtn = driver.findElement(By.id("publish"));
			publishBtn.click();
			Thread.sleep(900);
			System.out.println("the post was published");
			
			//check for the post
			driver.findElement(By.linkText("Posts")).click();
			Thread.sleep(900);
//			WebElement postsList = driver.findElement(By.xpath("//*[@id='the-list']"));
    	WebElement postsList = driver.findElement(By.id("the-list"));
//			List<WebElement> allPosts = postsList.findElements(By.tagName("tr"));
//			System.out.println(postsList);
//			System.out.println(allPosts);
			
		//	for ( WebElement post: allPosts) { 
			//	assertTrue(post.equals(theTitle), "The post is not exists...");
			//	if(post.getText().contains(theTitle)) {
				
			
			
//			String postName = postsList.findElement(By.xpath("(.//tr)[last()]//a")).getText();
			String postName = postsList.findElement(By.xpath(".//tr//a")).getText();
			System.out.print("the post name: " + postName);
			assertTrue(postName.equals(theTitle), "The last post is not Marina's first post...");			
		}
		
	}


