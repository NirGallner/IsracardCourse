package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WpNewTag {
	
	private static WebDriver driver;

	private String title = "Gal "+System.currentTimeMillis();
	private String slug = "Gal GAl";
	private String description = "Gal Wasserman";
	
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
				Actions actions = new Actions(driver);
				WebElement Post = driver.findElement(By.id("menu-posts"));
				actions.moveToElement(Post).perform();
				WebElement Tags = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[5]/a"));
				Tags.click();
				System.out.println("ClickOnPost");
				
				// insert title		
				WebElement EnterTittle = driver.findElement(By.id("tag-name"));
				EnterTittle.sendKeys(title);
				EnterTittle.sendKeys(Keys.TAB);
				System.out.println("TittleCreated");	
				
				// insert Slug		
				WebElement EnterSlug = driver.findElement(By.id("tag-slug"));
				EnterSlug.sendKeys(slug);
				EnterSlug.sendKeys(Keys.TAB);
				System.out.println("SlugCreated");	
				
				// insert description		
				WebElement EnterDescription = driver.findElement(By.id("tag-description"));
				EnterDescription.sendKeys(description);
				EnterDescription.sendKeys(Keys.TAB);
				System.out.println("descriptionCreated");	
				
				// insert Submit		
				WebElement Submdit = driver.findElement(By.id("submit"));
				Submdit.click();
				System.out.println("Submited");
				
				//checking if draft exist
				WebElement allTags = driver.findElement(By.id("the-list"));

				List<WebElement> tag = allTags.findElements(By.id("the-list"));
				boolean found = false;
				for (WebElement element : tag) {
					try {
						WebElement draft = element.findElement(By.className("wp-list-table widefat fixed striped tags"));
						if (element.getText().equals(title) && draft.getText().equals("Gal")) {
							found = true;
							System.out.println("title exist");
							break;
						}
					}
					catch (Exception e) { continue; }
				}
						assertTrue(found);
			        }
				
				
			        
}


