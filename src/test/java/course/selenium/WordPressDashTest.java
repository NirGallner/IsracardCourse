package course.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class WordPressDashTest {

	//Define a static driver - to be initialization
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
		
		@BeforeEach
		public void beforeEach (){
			if(driver.getTitle().contains("Dashboard")==false)
				driver.findElement(By.xpath("//div.[text()= 'Dashboard']")).click();
			System.out.println("before each");
		}
		
		
		@Test
		public void byId () {		
		WebElement welcomePanel = driver.findElement(By.id("welcome-panel"));
		boolean flag = welcomePanel.isDisplayed();
		Assertions.assertTrue(flag);
		System.out.println("ID");
		}
		
		@Test
		public void byXpath () { //press rate the inserter
			driver.findElement(By.xpath("//*[@class=\"ai-notice-dismiss\"]")).click();
			System.out.println("xpath");
		}
		
		@Test 
		public void byLink(){ 
			driver.findElement(By.linkText("Please update now")).click();
			System.out.println("byLink");
		}
		
		@Test
		public void byPartialLink() { 
			driver.findElement(By.partialLinkText("Bangkok’s best")).click();
			System.out.println("partialLink");	
		}
		
		@Test
		public void byCssSElector() { //#save-post
			driver.findElement(By.cssSelector("#save-post")).click();
			System.out.println("cssSelector");
		}
		
		@Test 
		public void byName() {
			driver.findElement(By.name("post_title")).click();
			System.out.println("name");
		}
		@Test 
		public void byTag() {
			driver.findElement(By.tagName("h1")).click();
			System.out.println("Tag");
		}
		
		
		@AfterAll
		public static void afterAll() {
			// close the driver
			driver.quit();	
			System.out.println("After All");
		}
		
	}

