package course.selenium;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WorldPresTest {

//		private static final String Select = null;
		private static WebDriver driver;
			
			@BeforeAll
			public static void setup() throws InterruptedException {
				
				System.setProperty("webdriver.chrome.driver", "C:\\Windows\\Temp\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				driver.get("http://demosite.center/wordpress/wp-login.php");
				WebElement userName = driver.findElement(By.id("user_login"));
				userName.sendKeys("admin");
				WebElement passw = driver.findElement(By.id("user_pass"));
				passw.sendKeys("demo123");
				WebElement checkBox = driver.findElement(By.id("rememberme"));
				checkBox.click();
				WebElement enterButton = driver.findElement(By.id("wp-submit"));
				enterButton.click();
				Thread.sleep(9000);
			}

			//private Object categoryFilter;
			
			
			@BeforeEach
			public  void dashboard() throws InterruptedException {
				WebElement DashBoard = driver.findElement(By.xpath("//*[@id=\"menu-dashboard\"]/a/div[2]"));
				DashBoard.click();
				Thread.sleep(9000);
			}

			
			@Test
			public void test1() throws InterruptedException {
				WebElement Users = driver.findElement(By.xpath("//*[@id=\"menu-users\"]"));
				Users.click();
				System.out.println("TEST1");
				Thread.sleep(9000);
			}


			@Test
			public void test2() throws InterruptedException {
				WebElement SaveDraft = driver.findElement(By.xpath("//*[@id=\"save-post\"]"));
				SaveDraft.click();
				System.out.println("TEST2");
				Thread.sleep(9000);
			}
			
			
			@Test
			public void test3() throws InterruptedException {
				WebElement Tools = driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/a/div[2]"));
				Tools.click();
				System.out.println("TEST3");
				Thread.sleep(9000);
				
			}
			
			
		
			@Test
			public void test4() throws InterruptedException {
				
				// click on Post 
				WebElement List = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[2]"));
				List.click();
				
				WebElement allPosts = driver.findElement(By.id("the-list"));
				String post = allPosts.findElement(By.xpath("//*[@id=\"post-1\"]//a")).getText();
				assertTrue(post.equals("Hello world!"), "Post is not hellow world...");
				System.out.println("TEST4");
				}
				
			@Test
			public void test5() throws InterruptedException {
				
				WebElement Post = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
				new Actions (driver).moveToElement(Post).click().perform();
				Thread.sleep(18000);
				
				
			}
				
			@Test
			public void test6() throws InterruptedException {
				
				WebElement Post = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
				Post.click();
				Select  category = new Select (driver.findElement(By.id("cat")));
				category.selectByVisibleText("Uncategorised");
				}
				
			

			@AfterAll
				public static void teardown() {
				driver.quit();
			}
	
}

