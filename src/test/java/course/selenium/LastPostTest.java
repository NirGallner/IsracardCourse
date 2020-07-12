package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.Action;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LastPostTest {
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
		
		//Go to Posts page
		driver.findElement(By.xpath("//*[@class=\"wp-menu-image dashicons-before dashicons-admin-post\"]")).click();
	}
	
	@AfterAll
	public static void AfterAll()
	{
		System.out.println("After");
		driver.quit();
	}
	
	@Test
	public void LastElement ()
	{
		List<WebElement> webElements = driver.findElements(By.className("row-title"));
		System.out.println(webElements.size());
		int Index = webElements.size()-1;
		String ElementName = webElements.get(Index).getText();
		System.out.println(ElementName);
		assertEquals("Hello world!", ElementName);

	}

}
