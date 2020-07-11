package course.selenium;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class itzikHomeWork {

	static WebDriver driver;

	@BeforeAll
	static void testStart() throws InterruptedException {
		System.out.println("Testing cycle Start");
		System.setProperty("webdriver.chrome.driver", "C:/Users/777/chromedriver.exe");
		driver =  new ChromeDriver();

		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		WebElement e = driver.findElement(By.id("user_login"));
		e.sendKeys("admin ");
		WebElement d = driver.findElement(By.id("user_pass"));
		d.sendKeys("demo123 ");

		WebElement search = driver.findElement(By.id("wp-submit"));
		search.click();
		Thread.sleep(5000);
	}

	@BeforeEach
	void testRestart() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//*[@id=\"menu-dashboard\"]/ul/li[2]/a"));
		search.click();
		System.out.println("Test Cycle Initlized");
		Thread.sleep(5000);
	}

	@AfterAll
	static void tetsEnd() {
		Assertions.assertTrue(driver.findElement(By.id("footer-thankyou")).isDisplayed());
		System.out.println("Test Cycle Ended succesfuly");
		driver.quit();
	}

	@Test
	public void testOne() {
		WebElement f = driver.findElement(By.id("title"));
		f.sendKeys("Test one Completed ");

	}

	@Test
	public void testTwo() {
		WebElement g = driver.findElement(By.className("mceEditor"));
		g.sendKeys("Test two Completed ");

	}
	@Test
	public void testThree() {
		WebElement search = driver.findElement(By.xpath("//*[@id=\"welcome-panel\"]/div/div/div[1]/a[1]"));
		//search.click();
		System.out.println("test 3 done");
	}

	@Test
	public void Hovermenu() throws InterruptedException {
		WebElement post = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[2]"));
		new Actions(driver).moveToElement(post).perform();
		post.click();
		Thread.sleep(5000);
		Select categoryFilter = new Select(driver.findElement(By.id("cat")));
		categoryFilter.selectByVisibleText("Uncategorised");
		System.out.println("Uncategorised selected in menu");

		WebElement allPosts = driver.findElement(By.id("the-list"));
		String postName = allPosts.findElement(By.xpath("(.//tr)[last()]//a")).getText();
		assertTrue(postName.equals("Hello world!"), "Post is not hello world...");
		System.out.println("test 4 done");

	}

	@Test
	public void writePost() throws InterruptedException {
		WebElement post = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[2]"));
		new Actions(driver).moveToElement(post).perform();
		post.click();
		Thread.sleep(5000);
		WebElement addpost = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/a"));
		addpost.click();
		Thread.sleep(5000);

		WebElement postTitle = driver.findElement(By.id("title"));
		postTitle.sendKeys("Itzik Post ");
		WebElement postContent = driver.findElement(By.id("content"));
		postContent.sendKeys("Itzik Post ");

		WebElement publish = driver.findElement(By.id("publish"));
		publish.click();
		System.out.println("post published");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='menu-posts']//*[@class='wp-menu-name']")).click();
		WebElement allPosts = driver.findElement(By.id("the-list"));
		String myPost = allPosts.findElement(By.className("row-title")).getText();
		assertTrue(myPost.equals("Itzik Post"), "Oops somthing i wrong");
		driver.findElement(By.partialLinkText("Itzik")).click();
		Thread.sleep(5000);
		System.out.println("done class4 HW");
	}


}


