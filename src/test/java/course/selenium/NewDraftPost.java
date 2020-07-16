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

public class NewDraftPost {
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
			
	// Make sure I'm on the right page
		if (driver.getTitle().contains("Dashboard") == false) {
			driver.findElement(By.cssSelector(".wp-menu-name")).click();
			System.out.println("In the dashboard page");
		}
	}

	@Test
	public void AddNewDraftPosts() throws InterruptedException {

	// Find the postElement
		WebElement postElement = driver.findElement(By.id("menu-posts"));	

	// Hover mouse on post element
		Actions action = new Actions(driver);
		action.moveToElement(postElement).build().perform();
		
	// Find the new post element in the post menu
		WebElement newpostElement = driver.findElement(By.xpath("//*[@class='wp-submenu wp-submenu-wrap']//a[@href='post-new.php']"));
		newpostElement.click();
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.contains("Add a New"), "Add a New should appear in title");
		Thread.sleep(5000);
				
	// Insert text into the title	
		WebElement titleElement = driver.findElement (By.xpath("//input[@id='title']"));
		titleElement.sendKeys("New Post Written By Eti Kedmi");
		Thread.sleep(10000);


	// Find iframe
		//WebElement editorFrame = driver.findElement(By.id("content_ifr"));
		//driver.switchTo().frame(editorFrame);
				
	// Find the editor in the iframe
		//*[@id="content"]
		WebElement editorElement = driver.findElement(By.xpath("//*[@id=\"content\"]"));
		editorElement.clear();
		editorElement.sendKeys("Hello! i'm study Automation course, hope to succeed:-)");
		Thread.sleep(5000);
	
		
	// Find the saveDraft button	
		WebElement saveDraftelement = driver.findElement(By.id("save-post"));
		saveDraftelement.click();
		System.out.println("save draft");
		
	// go to post	
		Thread.sleep(9000);
		WebElement postsElement = driver.findElement(By.id("menu-posts"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(postsElement).build().perform();
		WebElement allpostElement = driver.findElement(By.xpath( "//*[@class='wp-first-item current']//a"));
		allpostElement.click();
		
		String pageTitlepost = driver.getTitle();
		assertTrue(pageTitlepost.contains("Posts"), "Posts should appear in title");
		Thread.sleep(5000); 
		
	// Find the new post in the list
		WebElement draftelement = driver.findElement(By.className("post-state"));
		List<WebElement> allPosts =  driver.findElements(By.cssSelector("a[class='row-title']"));	
			for(WebElement ele :allPosts) {		
				if ((ele.getText().contains("By Eti Kedmi")) && (draftelement.getText().equals("Draft"))) {
					System.out.println("Find the new post: "+ ele.getText() + " "+ draftelement.getText());
				}
			}
				
	}

}
