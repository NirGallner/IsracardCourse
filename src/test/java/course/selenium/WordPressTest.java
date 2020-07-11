package course.selenium;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class WordPressTest {

	// Define a static driver - to be initialized in @BeforeAll
	static WebDriver driver;

	@BeforeAll
	public static void beforeALL() throws InterruptedException {

		// Logging
		System.out.println("In before all - start running");

		// New instance
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Goto page
		driver.get("http://demosite.center/wordpress/wp-login.php");

		// Login
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("demo123");
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(2000);
	}

	@BeforeEach
	public void beforeEach() {

		// Logging
		System.out.println("In before each");

		// if we are not in dashboard page - click on it
		if (driver.getTitle().contains("Dashboard") == false)
			driver.findElement(By.xpath("//div[text()='Dashboard']")).click();	
	}

	@AfterEach
	public void afterEach() {

		// Logging
		System.out.println("In after each");

		// Back to dashboard
		driver.findElement(By.xpath("//div[text()='Dashboard']")).click();
	}

	@Test
	public void AddNewPost () throws InterruptedException {

		// Logging
		System.out.println("In Test");


		// Click on Posts
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		// Click on 'Add New' button
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).sendKeys("I <3 ISRACARD");
		Thread.sleep(2000);
		driver.findElement(By.id("content")).sendKeys("Hello, my name is Shraga and i love Isracard!");
		// click on publish
		Thread.sleep(2000);
		// Cancel the hidden menu if the button is not clicked
		WebElement sideButton = driver.findElement(By.id("qt_content_dfw"));
		if (sideButton.getAttribute("class").contentEquals("ed_button qt-dfw active")) {
			sideButton.click();
		}
		Thread.sleep(2000);
		// Click on publish
		driver.findElement(By.id("publish")).click();
		Thread.sleep(5000);
		// Goto Allposts
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a")).click();

		Thread.sleep(2000);
		// check if the post published
		WebElement postTitle = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form[1]/table/tbody/tr[3]/td[1]/strong/a"));
		WebElement author = driver.findElement(By.xpath("//*[@id=\"post-62\"]/td[2]/a"));
		
		assert(postTitle.getText().equals("I <3 ISRACARD") && author.getText().equals("admin"));
		System.out.println(postTitle.getText());
	}

	@AfterAll
	public static void afterAll() {

		//logging
		System.out.println("In after all");

		// Quit driver
		driver.quit();
	}
}