package course.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FilterTest {
	static WebDriver driver;
	
	@BeforeAll
	public static void BeforeAll() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		//Login
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys("admin");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("demo123");
		WebElement logInButton = driver.findElement(By.id("wp-submit"));
		logInButton.click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@class=\"wp-menu-image dashicons-before dashicons-admin-post\"]")).click();
	}
	
	@Test
	public void Filter () 
	{
		Select categoryFilter = new Select(driver.findElement(By.id("cat")));
		categoryFilter.selectByVisibleText("Uncategorised");
		driver.findElement(By.id("post-query-submit")).click();
	}
}
