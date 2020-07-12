package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WorldPressNewPostTest {
	
	private static WebDriver driver;

	private String title = "Gal Post";
	private String Body = "Gal Wasserman";
	
		@BeforeAll
		public static void setup() throws InterruptedException {
			
			
	
			System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Temp\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
	
			driver.get("http://demosite.center/wordpress/wp-login.php");
			WebElement userName = driver.findElement(By.id("user_login"));
			userName.sendKeys("admin");
			WebElement passw = driver.findElement(By.id("user_pass"));
			passw.sendKeys("demo123");
			WebElement checkBox = driver.findElement(By.id("rememberme"));
			checkBox.click();
			WebElement enterButton = driver.findElement(By.id("wp-submit"));
			enterButton.click();
			
		
		}
		
			@Test
			//click on posts
			public void NewPost() throws InterruptedException {
			WebElement Post = driver.findElement(By.id("menu-posts"));
			Post.click();
			System.out.println("ClickOnPost");
			
		
		    //click on add new button 
			WebElement AddNew = driver.findElement(By.className("page-title-action"));
			AddNew.click();
			System.out.println("Click on AddNew");
			
		

            // insert title		
			WebElement EnterTittle = driver.findElement(By.id("title"));
			EnterTittle.sendKeys(title);
			EnterTittle.sendKeys(Keys.TAB);
			System.out.println("TittleCreated");
			
		
		    //insert text in text frame
			WebElement EnterText = driver.findElement(By.id("content"));
			EnterText.sendKeys(Body);
			System.out.println("TextCreated");
			
		
		
		    // click on publish button 
			WebElement Publish = driver.findElement(By.id("publish"));
			Publish.click();;
			System.out.println("Published");
			
		
		    //back to posts table
			WebElement Postt = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
			Postt.click();
			
            // check is this post exist
			List<WebElement>  allPostTitleList = driver.findElements(By.xpath("//*[@id='the-list']//td[contains(@class, 'title')]"));
			
			boolean valueFound = false;
			for (WebElement checkList : allPostTitleList) {
				if (checkList.getText().equals(title)) {
					valueFound = true;
					break;
				}
			}
			
			assertTrue(valueFound, "Post exisit");
			
			System.out.println("Postexistornotexist");
		
		}

			
				
			
		@AfterAll
		public static void teardown() {
		driver.quit();
	}
		
}
		



