package course.selenium;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectors {

	private static WebDriver driver;

@BeforeAll
public static void OpenWebDriver() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	// Login
	driver.get("http://demosite.center/wordpress/wp-login.php");
	
	// By id
	WebElement userelement = driver.findElement(By.id("user_login"));
	userelement.sendKeys("Admin");
	WebElement passwordelement = driver.findElement(By.id("user_pass"));
	passwordelement.sendKeys("demo123");
	driver.findElement(By.id("wp-submit")).click();
}

@BeforeEach
public void BeforeEach() throws InterruptedException{
	
	// By tagName
	Thread.sleep(5000);
	WebElement dashbordelement = driver.findElement(By.tagName("h1"));
	String text = dashbordelement.getText();
	System.out.println(text);
	dashbordelement.click();
	
	
	
	// By cssSelector
	if (driver.getTitle().contains("Dashboard") == false) {
		driver.findElement(By.cssSelector(".wp-menu-name")).click();
		System.out.println("cssSelector");
		Thread.sleep(7000);
	}
}

@Test
	public void elementPost() throws InterruptedException{
	
	 	
	WebElement postElement = driver.findElement((By.id("menu-posts")));
	postElement.click();
	System.out.println("Post");
	Thread.sleep(7000);
	
	// By className
	WebElement addelement = driver.findElement(By.className("page-title-action"));
		
	// By xpath
	WebElement textpostelement = driver.findElement(By.xpath("//*[@class='wp-heading-inline']")); 
	
	WebElement postElement2 = driver.findElement((By.id("menu-posts")));
	Actions action = new Actions(driver);
	action.moveToElement(postElement2).build().perform();
	
	
	// By partialLinkText
	WebElement allPostElement = driver.findElement(By.partialLinkText("All"));
	
	WebElement postElement3 = driver.findElement((By.id("menu-posts")));
	action.moveToElement(postElement3).build().perform();
	
	// By linkText
	WebElement categoriesElement = driver.findElement(By.linkText("Categories"));
	
	
	}

}