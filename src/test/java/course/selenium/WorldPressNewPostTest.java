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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WorldPressNewPostTest {
	
	private static WebDriver driver;

	private String bodyText = "Gal Post";
	
		@BeforeAll
		public static void setup() throws InterruptedException {
			
			
	
			System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Temp\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
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
			public void NewPost() throws InterruptedException {
			WebElement Post = driver.findElement(By.id("menu-posts"));
			Post.click();
			System.out.println("ClickOnPost");
			
		
		
			WebElement AddNew = driver.findElement(By.className("page-title-action"));
			AddNew.click();
			System.out.println("Click on AddNew");
			
		

		
			WebElement EnterTittle = driver.findElement(By.id("title"));
//			String title = "Gal Post";
			EnterTittle.sendKeys(bodyText);
			System.out.println("TittleCreated");
			
		
		
			WebElement EnterText = driver.findElement(By.id("content"));
			String BodyText = "Gal Wasserman";
			EnterText.sendKeys(BodyText);
			System.out.println("TextCreated");
			
		
		
		
			WebElement Publish = driver.findElement(By.id("publish"));
			Publish.click();;
			System.out.println("Published");
			
		
		
			WebElement Postt = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
			Postt.click();
			Thread.sleep(5000);
			
		
		


		
			
			//WebElement allPosts = driver.findElement(By.id("the-list"));
			List<WebElement>  allPostTitleList = driver.findElements(By.xpath("//*[@id='the-list']//td[contains(@class, 'title')]"));
			
			boolean valueFound = false;
			for (WebElement e : allPostTitleList) {
				if (e.getText().equals(bodyText)) {
					valueFound = true;
					break;
				}
			}
			
			assertTrue(valueFound, "Post exisit");
			
			System.out.println("Postexistornotexist");
		
			
			
	
		}

			private void checkValueExists(List<WebElement> allPostTitleList, String string) {
				// TODO Auto-generated method stub
				
			}
		//@AfterAll
	//	public static void teardown() {
	//	driver.quit();
	}
		

		



