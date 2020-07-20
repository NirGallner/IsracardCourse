package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	private WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeAll
	public static void webDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron\\temp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterAll
	public static void afterAll() {
		//driver.close();
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

	@Disabled
	@Order(2)
	@Test
	public void validateLastPost() throws InterruptedException{
		WebElement posts = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(posts).perform();
		posts.click();

		List<WebElement> postsList =driver.findElements(By.xpath("//*[@id='the-list']//*[contains(@class, 'title column-title')]/*/a"));

		WebElement postsListLastElement = postsList.get(postsList.size() - 1);		
		// TODO add an if that if there are more than one page on the posts table get the last one and validate the last post
		assertEquals("Hello world!", postsListLastElement.getText());	
		Thread.sleep(2000);
	} 

	@Disabled
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

	@Disabled
	@Order(5)
	@Test 
	public void WritePost() throws InterruptedException {
		//Click on "Add new" button to add a new post
		WebElement addNewBtn = driver.findElement(By.xpath("//*[@class='page-title-action' and text()='Add New']"));
		addNewBtn.click();
		
		//Check the currrent url and the page H1 title is as expected
		String url = driver.getCurrentUrl();
		assertEquals("http://demosite.center/wordpress/wp-admin/post-new.php", url);

		String title = driver.getTitle();
		//assertTrue(title.contains("add a new post"));
		assertTrue(title.equalsIgnoreCase("Add a New Post ‹ Wordpress Demo Site at Demo.Center — WordPress"));

		//enter the post title into the "Enter title here" field and check the default field of the title
		WebElement enterTitleTxt = driver.findElement(By.id("title-prompt-text"));
		assertTrue(enterTitleTxt.getText().equalsIgnoreCase("enter title here"));

		WebElement enterTitle = driver.findElement(By.xpath("//*[@name='post_title']"));
		String titleTxt = "My post Title" + System.currentTimeMillis();
		enterTitle.sendKeys(titleTxt);
		enterTitle.sendKeys(Keys.TAB);
		
		//Enter the content of the post
		WebElement postContent =wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='content']"))); 

		String contentTxt = "some text that i wanted to write and bla bla bla";
		postContent.sendKeys(contentTxt);

		// Click on publish 
		WebElement publishBtn = driver.findElement(By.id("publish"));
		
		//before clicking on the publish button check the value of the button
		assertTrue(publishBtn.getAttribute("value").equalsIgnoreCase("publish"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html")).click();

		publishBtn.click(); 

		//check after clicking the "publish" button the value of the button changes to "Update"
		WebElement updateBtn  = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='publish'][@name='save']")));
//		btnValue = updateBtn.getAttribute("value").toLowerCase();
//		assertEquals("update", btnValue);
		assertTrue(updateBtn.getAttribute("value").equalsIgnoreCase("update"));

		//After publishing the post check the link to the view post option
		WebElement viewPost = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View post']")));
		viewPost.click();

		//check the h1 title of the page
		WebElement entryTitle = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='entry-title']")));
		assertEquals(titleTxt, entryTitle.getText());

		WebElement contentViewPost = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='entry-content description clearfix']/p")));
		assertEquals(contentTxt, contentViewPost.getText());

		// go back to the add new page
		driver.navigate().back();

		WebElement posts = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
		posts.click();

		// Check that the new post exists on the posts table
		WebElement postsTbl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("the-list")));

		List<WebElement> postsList =driver.findElements(By.xpath("//*[@id='the-list']//*[contains(@class, 'title column-title')]/*/a"));
		
		boolean flag = false;
		for (WebElement post : postsList) {
			if (post.getText().contentEquals(titleTxt)) {
				flag = true;
				break;
			}
		}
		
		assertTrue(flag);
	}

	@Disabled
	@Order(6)
	@Test

	public void addNewTag() throws InterruptedException {
		
		//pre condition to be on dashboard page
		WebElement dashboard = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-dashboard']"));
		dashboard.click();
		
		//Hover over Posts on side menu 
		WebElement posts = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(posts).perform();

		//find Tags option and click on it
		WebElement tagsElement = driver.findElement(By.xpath("//*[@href='edit-tags.php?taxonomy=post_tag']"));		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='edit-tags.php?taxonomy=post_tag']")));  

		tagsElement.click();

		//check is on page "Tags" by current url and by page H1 title 
		assertEquals("http://demosite.center/wordpress/wp-admin/edit-tags.php?taxonomy=post_tag", driver.getCurrentUrl());
		assertTrue("Tags".equalsIgnoreCase(driver.findElement(By.className("wp-heading-inline")).getText()));
		
		//Insert the new tag name
		WebElement tagName = driver.findElement(By.id("tag-name"));

		String tagNameInsert = "The tag " + System.currentTimeMillis();
		tagName.sendKeys(tagNameInsert);

		//click on submit 
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();

		Thread.sleep(2000);
		//check that the new tag name title exists on the table
		List<WebElement> tagsList = driver.findElements(By.xpath("//table//*[@class='row-title']"));

		int index = 0;
		boolean check = false;

		Thread.sleep(2000);
		for (WebElement tags : tagsList) {
			if (tags.getText().contentEquals(tagNameInsert)) {
				index = tagsList.indexOf(tags);				
				check = true;
				break;
			}
		}

		assertTrue(check); 

		Thread.sleep(2000);
		
		//find the checkbox of the new tag and check it
		List<WebElement> checkBox = driver.findElements(By.xpath("//table//*[@name='delete_tags[]']"));
		checkBox.get(index).click();

		Thread.sleep(4000);

		//choose from the menu on the table the option to delete the tag 
		Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
		select.selectByVisibleText("Delete");

		WebElement apply = driver.findElement(By.id("doaction"));
		apply.click();
	}
	
	@Test 
	public void savePostAsDraft() throws InterruptedException {
		//pre condition to be on dashboard page
		WebElement dashboard = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-dashboard']"));
		dashboard.click();
				
		//Hover over Posts on side menu 
		WebElement posts = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(posts).perform();
		
		//find "Add new" option and click on it
		WebElement addNewpost = driver.findElement(By.xpath("//*[@href='post-new.php']"));		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='post-new.php']")));  

		addNewpost.click();

		//check is on page "Add a new post" by current url and by page H1 title 
		assertEquals("http://demosite.center/wordpress/wp-admin/post-new.php", driver.getCurrentUrl());
		assertTrue("Add a New Post".equalsIgnoreCase(driver.findElement(By.className("wp-heading-inline")).getText()));
		
		//Enter post title
		WebElement enterTitle = driver.findElement(By.xpath("//*[@name='post_title']"));
		String titleTxt = "My post Title" + System.currentTimeMillis();
		enterTitle.sendKeys(titleTxt);
		enterTitle.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		//Enter the content of the post
		WebElement postContent =wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='content']"))); 

		String contentTxt = "some text that i wanted to write and bla bla bla";
		postContent.sendKeys(contentTxt);
		postContent.sendKeys(Keys.TAB);
		
		//Save the post as a draft
		WebElement saveDraft = driver.findElement(By.xpath("//*[@value='Save Draft']"));
		wait.until(ExpectedConditions.elementToBeClickable(saveDraft));
		saveDraft.click();
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.className("wp-heading-inline")).getText());
		assertTrue(driver.findElement(By.className("wp-heading-inline")).getText().equalsIgnoreCase("edit post"));
		
		//Click on all post from the side menu
		WebElement allPost = driver.findElement(By.linkText("All Posts"));
		allPost.click();
		
		//get the "All posts" table by title
		List<WebElement> postsList =driver.findElements(By.xpath("//*[@id='the-list']//*[contains(@class, 'title column-title')]/*/a"));
		
		int index = 0;
		boolean flag = false;
		for (WebElement post : postsList) {
			if (post.getText().contentEquals(titleTxt)) {
				flag = true;
				index = postsList.indexOf(post);
				System.out.println(index);
				break;
			}
		}
		
		assertTrue(flag);
		
		WebElement draftExists = postsList.get(index).findElement(By.xpath("following-sibling::span[1]"));
		assertTrue(draftExists.getText().equalsIgnoreCase("draft"));
	}
}
