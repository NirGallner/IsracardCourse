package course.selenium;

	
	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

	import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.TagsPage;

	public class AddNewTagTest {
	
		
 //Using Page object
		
			static WebDriver driver;
			 
			@BeforeAll
			public static void start() throws InterruptedException
			{
				
		    System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
			
			driver = new ChromeDriver();

			
			driver.get("http://demosite.center/wordpress/wp-login.php");
			
			// Maximize window
			driver.manage().window().maximize();
			
			//assertTrue(LoginPage.isOnPage(driver));
			
			
			}
			
		
			@Test
			public void login() {
				//Login
				LoginPage login = new LoginPage(driver);
				login.userInput("admin").userPassword("demo123").clickSubmit();
				
			}
			
			@Test
			public void goToTags() {
				DashboardPage dashboard = new DashboardPage(driver);
				assertTrue(DashboardPage.isOnPage(driver));
				//Open posts
				WebDriverWait wait = new WebDriverWait(driver,5,10);
				WebElement posts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-posts")));
				
				// Click tags
				dashboard.clickTags();
				WebElement tag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tags")));

			
				TagsPage tags = new TagsPage(driver);	
			//	WebElement tag_Header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tag-name")));

				//Add tag
		     	String tagHeader = "My tag"+ System.currentTimeMillis();
				tags.tag_Name(tagHeader).tag_Slug("aaa").tag_description("This is my tag").addNew();
			
                //Search tag
			    tags.searchTag(tagHeader).clickSearchBtn();
				WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("delete_tags[]")));
				checkBox.click();

		        // Delete tag
				tags.deleteTag();
				tags.clickApply();
		
				WebElement listIsEmpty = wait.withMessage("Could not find the element")
						.until(ExpectedConditions.visibilityOfElementLocated(By.className("no-items")));
				
			}
					
			@AfterAll
			public static void done()
				
				{
					driver.quit();
				}
	}
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*static WebDriver driver;
		 
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
		public void addNewTag() throws InterruptedException
		{
			WebElement posts = driver.findElement(By.id("menu-posts"));
			new Actions(driver).moveToElement(posts).perform();
			driver.findElement(By.linkText("Tags")).click();
			String myTag="My new tag"+System.currentTimeMillis();
			driver.findElement(By.id("tag-name")).sendKeys(myTag);
		  	driver.findElement(By.id("tag-slug")).sendKeys("My new Slug");
		    driver.findElement(By.id("tag-description")).sendKeys("My description");

		    driver.findElement(By.id("submit")).click();
		    Thread.sleep(5000);
		    
		    
		    driver.findElement(By.id("tag-search-input")).sendKeys(myTag);
		    Thread.sleep(3000);
		    driver.findElement(By.id("search-submit")).click();
		    Thread.sleep(5000);

		  driver.findElement(By.xpath("(.//tbody)//tr//th//input")).click();;
		   
		   Select categoryFilter = new Select (driver.findElement(By.id("bulk-action-selector-top")));
		   categoryFilter.selectByVisibleText("Delete");
		   Thread.sleep(3000);
		   driver.findElement(By.id("doaction")).click();
		}
			
		@AfterAll
		public static void done()
		
		{
			driver.quit();
		}
	}*/
		




