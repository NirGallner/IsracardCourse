package course.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class PublishThePostTest {
	
	    static WebDriver driver;
	    String theTitle = "alef alef"+ System.currentTimeMillis();
	    String thePostBody = "Hey, you are now using 3 Ad Inserter code blocks. I would really appreciate it if you could give the plugin a 5-star rating on WordPres.Positive reviews are a great incentive to fix bugs and to add new features for better monetization of your website. Thank you! - Igor"; 
	    						
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
		
		@AfterAll
		public static void afterAll() {
			// close the driver
			driver.quit();	
		}
		
		@Disabled
		@Test
		public void pullPosts () {
			driver.findElement(By.linkText("Posts")).click();
			WebElement postsList = driver.findElement(By.xpath("//*[@class='wp-list-table widefat fixed striped posts']"));
			List <WebElement> posts = postsList.findElements(By.xpath("(.//tr)//strong//a"));
			System.out.println("size of posts : " + posts.size());
		} 
		
		
		@Test
		public void createPost() throws InterruptedException {
			driver.findElement(By.linkText("Posts")).click();
			driver.findElement(By.xpath("//*[@class=\"page-title-action\"]")).click();
		//	Enter the title
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
			WebElement title = driver.findElement(By.id("title"));
			title.clear();
            title.sendKeys(theTitle);
        //  Enter the body  
            
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content_ifr")));
            driver.switchTo().frame("content_ifr");
			driver.findElement(By.id("tinymce")).sendKeys(thePostBody + " " +Keys.ESCAPE);
			Thread.sleep(1200);
			driver.switchTo().defaultContent(); 

		//	Thread.sleep(900);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("publish")));
			WebElement publishBtn = driver.findElement(By.id("publish"));
			Actions pressPublishBtn = new Actions(driver);
			pressPublishBtn.moveToElement(publishBtn).click().build().perform();
		//  publishing validation	
//			assertTrue(publishBtn.getAttribute("value").equalsIgnoreCase("update")); //This section fails, why?
//			System.out.println("the post was published");
		
			//check for the post
			//WebDriverWait waitForPots = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("All Posts")));
			WebElement allPosts = driver.findElement(By.linkText("All Posts"));
			Actions allPostsBtn = new Actions(driver);
			allPostsBtn.moveToElement(allPosts).click().build().perform();
			
			Thread.sleep(900);
//			WebElement postsList = driver.findElement(By.xpath("//*[@id='the-list']"));
			WebElement postsList = driver.findElement(By.xpath("//*[@class='wp-list-table widefat fixed striped posts']"));
			List <WebElement> posts = postsList.findElements(By.xpath("(.//tr)//strong//a"));
		
			
			System.out.println("size of posts : " + posts.size());
			boolean found = false;
			for (WebElement post : posts) {
				
				if (post.getText().contentEquals(theTitle)) {
					System.out.println(post.getText());
					found = true;
					break;	
				}	
				assertTrue(found, "The post was found");
			}
		}
			
	    	@Disabled
			@Test
			public void createDraft() throws InterruptedException {
				driver.findElement(By.linkText("Posts")).click();
				driver.findElement(By.xpath("//*[@class=\"page-title-action\"]")).click();
				
			//	Enter the title
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
				WebElement title = driver.findElement(By.id("title"));
				title.clear();
	            title.sendKeys(theTitle);
	            
	        //  Press save the draft
   		    	WebElement saveDraftBtn = driver.findElement(By.id("save-post"));
   		    	saveDraftBtn.click();
				Thread.sleep(900);
				System.out.println("the post was drafted");
			//  Find my draft	
				driver.findElement(By.linkText("All Posts")).click();	
				Thread.sleep(900);
				WebElement search = driver.findElement(By.id("post-search-input"));
                search.click();
                search.sendKeys(theTitle);
                WebElement searchSubmit = driver.findElement(By.id("search-submit"));
                searchSubmit.click();
            //  Validate the state    
                WebDriverWait waitForPostState = new WebDriverWait(driver, 10);
                waitForPostState.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"post-state\"]")));
                WebElement postState = driver.findElement(By.xpath("//*[@class=\"post-state\"]"));
                assertTrue(postState.getText().equals("Draft"), "My post-draft was not found");
             //   assertTrue(postState.getAttribute("value").equalsIgnoreCase("draft")); // WHY THIS LINE GETS NULL POINTER EXCEPTION?
			}
}
//                
//                boolean found = false;
//                if (postState.getText().contentEquals("Draft")) {
//					System.out.println(postState.getText() + postState );
//				found = true;
//                }
//                assertTrue(found, "The fraft was found");
//			}
//			
//}

           //     equals(postState.getAttribute("value").equalsIgnoreCase("draft"));
                
                
			//	WebElement myPostDraft = driver.findElement(By.partialLinkText(theTitle + "Draft"));
			//	System.out.println(myPostDraft);
			//	WebElement postsList = driver.findElement(By.xpath("//*[@class='wp-list-table widefat fixed striped posts']"));	
			//	List <WebElement> posts = postsList.findElements(By.xpath("(.//tr)//strong//a"));
			//	WebElement postState = driver.findElement(By.xpath("//*[@class=\"post-state\"]"));
//			
//				boolean found = false;
//				for (WebElement post : posts) {  ////*[@class="post-state"]
//					
//					if (post.getText().contentEquals(theTitle) && (postState.getAttribute("value").contains("Draft"))) {
//						System.out.println(post.getText() + postState );
//						found = true;
//						break;	
//					}	
//					assertTrue(found, "The post was found");
//				}
			//	class="post-state" = Draft
				
				
				//add here the publishing validation
				
			
	
			
//			
//			String postName = postsList.findElement(By.xpath(".//tr//a")).getText();
//			System.out.print("the post name: " + postName);
//			assertTrue(postName.equals(theTitle), "The last post is not Marina's first post...");			
	

