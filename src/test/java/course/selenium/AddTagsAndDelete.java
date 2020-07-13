package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class AddTagsAndDelete {

	private static WebDriver driver;
	
		@BeforeAll
		public static void OpenWebDriver() {

		// New instance
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		// Go to page
			driver.get("http://demosite.center/wordpress/wp-login.php");
			WebElement userelement = driver.findElement(By.id("user_login"));
			
		// Login to wordpress
			userelement.sendKeys("Admin");
			WebElement passwordelement = driver.findElement(By.id("user_pass"));
			passwordelement.sendKeys("demo123");
			driver.findElement(By.id("wp-submit")).click();
			
		}

		@BeforeEach
		public void BeforeEach() throws InterruptedException	{
			System.out.println("BeforeEach");
			Thread.sleep(7000);
			WebElement dashbordelement = driver.findElement(By.tagName("h1"));
			dashbordelement.click();
			String text = dashbordelement.getText();
			System.out.println(text);
		}
		
		@Test
		public void HoverPosts() throws InterruptedException {

		// Find the postElement
			WebElement postElement = driver.findElement(By.id("menu-posts"));	

		// Hover mouse on post element
			Actions action = new Actions(driver);
			action.moveToElement(postElement).build().perform();
			
		// Find the tags element in the post menu
			WebElement tagsElement = driver.findElement(By.xpath("//a[@href='edit-tags.php?taxonomy=post_tag']"));
			System.out.println(tagsElement.getText());
			tagsElement.click();
			System.out.println("In the tags page");
			Thread.sleep(5000);
			
		// Find the name tags element and insert text
			WebElement nameTagsElement = driver.findElement(By.id("tag-name"));
			nameTagsElement.clear();
			nameTagsElement.sendKeys("My tags 123");

		//Find the slug tags element and insert text
			WebElement slugTagsElement = driver.findElement(By.id("tag-slug"));
			slugTagsElement.clear();
			slugTagsElement.sendKeys("My slug 123");
			
		//Find the description tags element and insert text
			WebElement descriptionTagsElement = driver.findElement(By.id("tag-description"));
			descriptionTagsElement.clear();
			descriptionTagsElement.sendKeys("My description 123");
	
		//Find the button and click
			WebElement submitElement = driver.findElement(By.id("submit"));
			submitElement.click();
			
				
			
		// Find the new tags in the list
			
			WebElement formelement = driver.findElement(By.id("posts-filter"));
			List<WebElement> alltags =  formelement.findElements(By.xpath("(.//tr)//td//strong//a"));	
			
			Boolean find = false;
			while (find	== false){
			//List<WebElement> alltags =  driver.findElements(By.xpath("(.//tr//td//strong//a"));	
				for(WebElement ele :alltags) {
					//System.out.println(ele.getText());
					if (ele.getText().contains("123")) {
					 System.out.println("Find the new tags");
					 find = true;
					}
				}
			}
			//
			WebElement checboxelement = driver.findElement(By.id("cb-select-17"));
			checboxelement.click();	
			
			
		}
		
}	

	
			

