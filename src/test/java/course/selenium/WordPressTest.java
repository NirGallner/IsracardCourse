package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WordPressTest {
	
	public static WebDriver driver;
	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		System.out.println("Before All");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gorsk\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));
		WebElement loginButton = driver.findElement(By.id("wp-submit"));
		
		userName.sendKeys("admin");
		password.sendKeys("demo123");
		loginButton.click();
		
		Thread.sleep(3000);
	}
	
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		System.out.println("Before Each");
		if(driver.getTitle().contains("Deshboard") == true) {
			driver.get("http://demosite.center/wordpress/wp-admin/");
			Thread.sleep(3000);
		}
		
	}
	
	@AfterEach
	public void afterEach() throws InterruptedException {
		System.out.println("After Each");
		Thread.sleep(2000);
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("After All");
		
		driver.quit();
	}
	
	@Test
	public void classNameLocator() {
		System.out.println("class name");
		WebElement saveDraft = driver.findElement(By.className("button button-primary"));
		saveDraft.click();
	}
	
	@Test
	public void cssSelectorLocator() {
		System.out.println("css selector");
		WebElement helpButton = driver.findElement(By.cssSelector("#contextual-help-link"));
		helpButton.click();
	}
	
	@Test
	public void idLocator() {
		System.out.println("id");
		WebElement screenOptionButton = driver.findElement(By.id("show-settings-link"));
		screenOptionButton.click();
	}
	
	@Test
	public void linkTextLocator() {
		System.out.println("link text");
		WebElement rateAdInserterButton = driver.findElement(By.linkText("Rate Ad Inserter"));
		rateAdInserterButton.click();
	}
	
	@Test
	public void nameLocator() {
		System.out.println("name");
		WebElement action = driver.findElement(By.name("action"));
		
		System.out.println(action.getCssValue("post-quickdraft-save"));
	}
	
	@Test
	public void partialLinkTextLocator() {
		System.out.println("partial link text");
		WebElement header = driver.findElement(By.partialLinkText("We’ve assembled some"));
		
		System.out.println(header.getText());
	}
	
	@Test
	public void tagNameLocator() {
		System.out.println("tag name");
		WebElement header2 = driver.findElement(By.tagName("h2"));
		
		System.out.println(header2.getText());
	}
	
	@Test
	public void xpathLocator() {
		System.out.println("xpath");
		WebElement cust = driver.findElement(By.xpath("//*[class='hide-if-no-customize']//a[href='http://demosite.center/wordpress/wp-admin/customize.php?autofocus[panel]=themes']"));
		cust.click();
	}
	

}
