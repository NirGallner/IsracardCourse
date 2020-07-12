package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;	
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(OrderAnnotation.class)

public class LironTestWordPress {

	private static WebDriver driver;

	@BeforeAll
	public static void webDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron\\temp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterAll
	public static void afterAll() {
		driver.close();
	}

	@Order(1)
	@Test
	public void login() throws InterruptedException {
		driver.get("http://demosite.center/wordpress/wp-login.php");
		WebElement userName = driver.findElement(By.id("user_login"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("demo123");
		WebElement loginBtn = driver.findElement(By.id("wp-submit"));
		loginBtn.click();
		Thread.sleep(2000);
		WebElement dashboard = driver.findElement(By.xpath("//*/h1[contains(text(), 'Dashboard')]"));
		assertTrue(dashboard.isDisplayed());
	}

	@Order(2)
	@Test
	public void validateLastPost() throws InterruptedException{
		WebElement posts = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(posts).perform();
		posts.click();

		List<WebElement> postsList =driver.findElements(By.xpath("//*[@id='the-list']//*[contains(@class, 'title column-title')]/*/a"));

		WebElement postsListLastElement = postsList.get(postsList.size() - 1);		
		assertEquals("Hello world!", postsListLastElement.getText());	
		Thread.sleep(2000);
	} 

	@Order(3)
	@Test
	public void fillter() {
		Select catagoriesSelect = new Select(driver.findElement(By.id("cat")));
		catagoriesSelect.selectByVisibleText("Uncategorised");
	}

	@Disabled
	@Order(4)
	@Test 
	public void tags() {
		WebElement tagsInPost= driver.findElement(By.xpath("//a[@href='edit-tags.php?taxonomy=post_tag']"));
		tagsInPost.click();
	}

	@Order(5)
	@Test 
	public void WritePost() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement addNewBtn = driver.findElement(By.xpath("//*[@class='page-title-action' and text()='Add New']"));
		addNewBtn.click();
		String url = driver.getCurrentUrl();
		assertEquals("http://demosite.center/wordpress/wp-admin/post-new.php", url);

		String title = driver.getTitle().toLowerCase();

		assertTrue(title.contains("add a new post"));

		WebElement enterTitleTxt = driver.findElement(By.id("title-prompt-text"));
		String getEnterTitlePromtTxt = enterTitleTxt.getText().toLowerCase();

		assertEquals("enter title here", getEnterTitlePromtTxt);

		WebElement enterTitle = driver.findElement(By.xpath("//*[@name='post_title']"));
		String titleTxt = "My post Title";
		enterTitle.sendKeys(titleTxt);
		enterTitle.sendKeys(Keys.TAB);

		WebElement postContent =wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='content']"))); 

		String contentTxt = "some text that i wanted to write and bla bla bla";
		postContent.sendKeys(contentTxt);
		postContent.sendKeys(Keys.TAB);

		WebElement publishBtn = driver.findElement(By.id("publish"));
		String btnValue = publishBtn.getAttribute("value").toLowerCase();
		assertEquals("publish", btnValue);
		Thread.sleep(2000);
		publishBtn.click(); 


		WebElement updateBtn  = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='publish'][@name='save']")));
		btnValue = updateBtn.getAttribute("value").toLowerCase();
		assertEquals("update", btnValue);

		WebElement viewPost = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View post']")));
		viewPost.click();

		WebElement entryTitle = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='entry-title']")));
		assertEquals(titleTxt, entryTitle.getText());

		WebElement contentViewPost = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='entry-content description clearfix']/p")));
		assertEquals(contentTxt, contentViewPost.getText());

		driver.navigate().back();

		WebElement posts = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
		posts.click();

		WebElement postsTbl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("the-list")));

		List<WebElement> postsList =driver.findElements(By.xpath("//*[@id='the-list']//*[contains(@class, 'title column-title')]/*/a"));
		assertEquals(titleTxt, postsList.get(0).getText());	
	}
}
