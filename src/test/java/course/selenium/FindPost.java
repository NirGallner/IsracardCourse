package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.interactions.MoveToOffsetAction;

public class FindPost {

	private static WebDriver driver;
	

@BeforeAll
public static void OpenWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		WebElement userelement = driver.findElement(By.id("user_login"));
		userelement.sendKeys("Admin");
		WebElement passwordelement = driver.findElement(By.id("user_pass"));
		passwordelement.sendKeys("demo123");
		driver.findElement(By.id("wp-submit")).click();
}

@BeforeEach
	public void BeforeEach(){
		System.out.println("BeforeEach");
		WebElement dashbordelement = driver.findElement(By.tagName("h1"));
		String text = dashbordelement.getText();
		System.out.println(text);
		dashbordelement.click();
		
		if (driver.getTitle().contains("Dashboard") == false) {
			driver.findElement(By.cssSelector(".wp-menu-name")).click();
			System.out.println("cssSelector");
		}
}

@Test
	public void LastPost() throws InterruptedException{
	
		Thread.sleep(7000);
		
		// Go to the post
		WebElement postElement = driver.findElement(By.xpath("//*[@id = 'menu-posts']"));
		postElement.click();
	
		Thread.sleep(7000);
		
		WebElement textpostelement = driver.findElement(By.xpath("//*[@class='wp-heading-inline']"));
		String text = textpostelement.getText();
		System.out.println(text);
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle.contains("Posts"), "Posts should appear in title");
		
		// Find the last post
	
	   	WebElement allPosts = driver.findElement(By.id("the-list"));
	   	String lastPost = allPosts.findElement(By.xpath("(.//tr)[last()]//a")).getText();
		System.out.println("the last post: "+ lastPost);

   }
}