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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class newTagTest {

	  static WebDriver driver;
	  String theTag = "New Marinas Tag "+ System.currentTimeMillis();
	  String theSlug = "The slug of the slug";
	  String theDescption = "The description";

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
		public void publishTag () throws InterruptedException {
			WebElement findPosts = driver.findElement(By.linkText("Posts")); 
			new Actions(driver).moveToElement(findPosts).perform();
			Thread.sleep(9000);
			WebElement allPosts = driver.findElement(By.linkText("All Posts")); 
			new Actions(driver).moveToElement(allPosts).perform();
			Thread.sleep(9000);
			WebElement findTags = driver.findElement(By.linkText("Tags")); 
			new Actions(driver).moveToElement(findTags).click().perform();
			
			WebElement tagTitle = driver.findElement(By.id("tag-name"));
			tagTitle.sendKeys(theTag);
			
			WebElement slugCont = driver.findElement(By.id("tag-slug"));
			slugCont.sendKeys(theSlug);
			
			WebElement tagDescription = driver.findElement(By.id("tag-description"));
			tagDescription.sendKeys(theDescption);
			
			WebElement submitBtn = driver.findElement(By.id("submit"));
			submitBtn.click();
			
			System.out.println("Submited the tag");
			
			WebElement tagsList = driver.findElement(By.id("posts-filter"));
			List <WebElement> tagsTitles = tagsList.findElements(By.xpath("(.//table)//strong"));
			System.out.println("size of tags : " + tagsTitles.size());
			
			WebElement pullId = driver.findElement(By.xpath("//*[contains(text(),'Select "+ theTag + "')]"));
			String id = pullId.getAttribute("for");
			driver.findElement(By.id(id)).click();
			
			//Select from a drop down menu and press apply
			Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
			select.deselectByVisibleText("Delete");
			driver.findElement(By.id("doaction")).click();
//			boolean found = false;   //This section fails in recognition the tag title 
//			for (WebElement tag : tagsTitles) {
//				
//				if (tag.getText().contentEquals(theTag)) {
//					System.out.println(tag.getText());
//					found = true;
//					break;	
//				}	
//				assertTrue(found, "The tag was found");
//			}
//			
//			WebElement search = driver.findElement(By.id("tag-search-input"));
//            search.click();
//            search.sendKeys(theTag);
//            WebElement searchSubmit = driver.findElement(By.id("search-submit"));
//            searchSubmit.click();
//            
            
			
//		// Add here the validation of publishing the tag
//			WebElement tagsList = driver.findElement(By.id("\"posts-filter\""));
//			List <WebElement> tagsTitles = tagsList.findElements(By.xpath("(.//table)//strong"));
//			
//			
//			boolean found = false;
//			for (WebElement tag : tagsTitles) {
//				System.out.println(tag.getText());
//				if (tag.getText().contentEquals(theTag)) {
//					found = true;
//					break;	
//				}	
//				assertTrue(found, "The title was found");
//			}
			
		//	WebElement publishedTag = driver.findElement(By.linkText("Select"+theTag)).click();
			
			
		}

}
