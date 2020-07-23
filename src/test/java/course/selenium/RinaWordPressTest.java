package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/*public class RinaWordPressTest {
	 
		
		public static WebDriver driver;
			
		@BeforeAll
		public static void OpenWebDriver() {
			System.setProperty("webdriver.chrome.driver", "C:/temp/chromedriver.exe");
			driver  = new ChromeDriver();
		}
			
			
		@Test
		public void Login() throws InterruptedException {
			driver.get("http://demosite.center/wordpress/wp-login.php");
			driver.manage().window().maximize();
			WebElement username = driver.findElement(By.id("user_login"));
			username.sendKeys("admin");
			WebElement userpassword = driver.findElement(By.id("user_pass"));
			userpassword.sendKeys("demo123");
			new Actions(driver).sendKeys(Keys.ENTER).perform();
			Thread.sleep(9000);
			
		}

		
	/*	@Test
		public void AddNewTag() throws InterruptedException {
			//Go to post
			WebElement PostElement = driver.findElement(By.id("menu-posts"));
			new Actions(driver).moveToElement(PostElement).perform();
			Thread.sleep(2000);
			
			//Go to add new tag
			WebElement AddNewTag = driver.findElement(By.xpath("//*[@href=\"edit-tags.php?taxonomy=post_tag\"]"));
			Thread.sleep(2000);
			new Actions(driver).moveToElement(AddNewTag).click().perform();
			Thread.sleep(2000);
			
			WebElement tagName = driver.findElement(By.name("tag-name"));
			tagName.sendKeys("Rina-this is my tag name 1");
			Thread.sleep(5000);
		
			WebElement tagSlug = driver.findElement(By.id("tag-slug"));
			tagSlug.sendKeys("tag-slug");
			Thread.sleep(5000);
		
			WebElement tagDescription = driver.findElement(By.id("tag-description"));
			tagDescription.sendKeys("tag-description");
			Thread.sleep(5000);
			
			WebElement tagSubmitButton = driver.findElement(By.xpath("//*[@value=\"Add New Tag\"]"));
			tagSubmitButton.click();
			Thread.sleep(5000);	

			// Get the entire table
			WebElement allTags = driver.findElement(By.id("the-list"));

			
			// Get the text of the tag
			String tagTitle = allTags.findElement(By.xpath("//*[@id=the-list]/tr/td")).getText();
		
			//assertTrue(tagName.contentEquals(tagTitle));
			Thread.sleep(5000);
			
		}*/
		
		
		/*@Test
		public void TestLocateElements() {
			WebElement elementA = driver.findElement(By.id("wp-version-message"));
			WebElement elementB = driver.findElement(By.className("welcome-icon welcome-widgets-menus"));
			WebElement elementC = driver.findElement(By.xpath("//*[@id=\"welcome-panel\"]/a"));	
			WebElement elementD = driver.findElement(By.name("post_title"));
			WebElement elementH = driver.findElement(By.linkText("Write your first blog post"));
		}*/
		

		/*@Test
		public void LastPost() throws InterruptedException {
			WebElement PostElement = driver.findElement(By.id("menu-posts"));
			PostElement.click();
			Thread.sleep(2000);
			WebElement AllPostElement = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]//*[@class=\"wp-menu-image dashicons-before dashicons-admin-post\"]"));
			AllPostElement.click();
			WebElement ListPost = driver.findElement(By.id("the-list"));
 			String PostName=ListPost.findElement(By.xpath("//*[@id=\"post-1\"]/td[1]/strong/a")).getText();
			assertTrue(PostName.equals("Hello world"));
		}*/
		
		
		/*@Test
		public void TestPostAndTags() throws InterruptedException {
				WebElement postelement = driver.findElement(By.id("menu-posts"));
				new Actions(driver).moveToElement(postelement).perform();
				Thread.sleep(2000);
				WebElement tagelement = driver.findElement(By.xpath("//*[@href=\"edit-tags.php?taxonomy=post_tag\"]"));
				new Actions(driver).moveToElement(tagelement).perform();
				tagelement.click();
		}*/
		
		
		/*@Test
		public void SelectUncategorised() throws InterruptedException {	
			WebElement SelectPostElement = driver.findElement(By.id("cat"));
			SelectPostElement.click();
			Select CategoryFilter = new Select(SelectPostElement);
			CategoryFilter.selectByVisibleText("Uncategorised");
			driver.findElement(By.id("post-query-submit")).click();
		}*/
			
		
		
	/*	@Test
		public void AddNewPostAndPublish() throws InterruptedException{
			
			String PostTitle = "Rina-This is my post title" + System.currentTimeMillis();
			
			//Go to post
			WebElement PostElement = driver.findElement(By.id("menu-posts"));
			new Actions(driver).moveToElement(PostElement).perform();
			Thread.sleep(4000);
			
			//Go to add new post
			WebElement AddNewElement = driver.findElement(By.xpath("//*[@href=\"post-new.php\"]"));
			Thread.sleep(2000);
			new Actions(driver).moveToElement(AddNewElement).click().perform();
			Thread.sleep(2000);
			
			//Write the title of post
			 driver.findElement(By.name("post_title")).sendKeys("Rina-This is my post title");
			Thread.sleep(7000);
			
			//Write the content of post
			WebElement AddContentPost = driver.findElement(By.id("content"));
			AddContentPost.sendKeys("Rina-This is my post content");
			Thread.sleep(5000);
			
			
			//Click the publish button
			WebElement PublishPost = driver.findElement(By.id("publish"));
			PublishPost.click();
			Thread.sleep(10000);
			
			//Go to post list
		 	WebElement AllPostElement = driver.findElement(By.xpath("//*[@href='edit.php']//*[@class='wp-menu-name']"));
			AllPostElement.click();			
			WebElement ListPost = driver.findElement(By.id("the-list"));
	 		String PostName=ListPost.findElement(By.xpath("(.//tr)//a")).getText();
				
			assertTrue(PostName.contentEquals(PostTitle));
			Thread.sleep(5000);
		}*/
	
		
		
	/*	@Test
		public void AddNewPostAndSave() throws InterruptedException{
						
			String PostTitle = "Rina-This is my post title" + System.currentTimeMillis();
			
			//Go to post
			WebElement PostElement = driver.findElement(By.id("menu-posts"));
			new Actions(driver).moveToElement(PostElement).perform();
			Thread.sleep(4000);
			
			
			//Go to add new post
			WebElement AddNewElement = driver.findElement(By.xpath("//*[@href=\"post-new.php\"]"));
			Thread.sleep(2000);
			new Actions(driver).moveToElement(AddNewElement).click().perform();
			Thread.sleep(2000);
			
			//Write the title of post
			 driver.findElement(By.name("post_title")).sendKeys("Rina-This is my post title");
			Thread.sleep(7000);
			
			//Write the content of post
			WebElement AddContentPost = driver.findElement(By.id("content"));
			AddContentPost.sendKeys("Rina-This is my post content");
			Thread.sleep(5000);
			
			
			//Click the save button
			WebElement SubmitPost = driver.findElement(By.id("submitdiv"));
			SubmitPost.click();
			Thread.sleep(10000);
			WebElement SavePost = driver.findElement(By.id("save-post"));
			SavePost.click();
			
			
			//Go to post list
		 	WebElement AllPostElement = driver.findElement(By.xpath("//*[@href='edit.php']//*[@class='wp-menu-name']"));
			AllPostElement.click();			
			WebElement ListPost = driver.findElement(By.id("the-list"));
	 		String PostName=ListPost.findElement(By.xpath("(.//tr)//a")).getText();
			
	 		//Verify my title post
			assertTrue(PostName.contentEquals(PostTitle));
			Thread.sleep(5000);
			
			//Verify the Draft
			String PostState = ListPost.findElement(By.xpath("(.//tr)//td//strong//span")).getText();
			assertTrue(PostState.contentEquals("Draft"));

		}*/
	

