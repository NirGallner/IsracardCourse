/**
 * Selenium WebDriver course code samples.
 * June 202, 
 * @author Nir Gallner
 */
package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoodMorningTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void BeforeAll()
	{
		// Create a new ChromDriver instance
		System.out.println("Before");
		
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();		
	}
	
	
	@Test
	public void test1() throws InterruptedException {
				
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		driver.manage().window().maximize();
		
		WebElement e = driver.findElement(By.id("user_login"));
		
		Thread.sleep(1000);
		e.sendKeys("LHagag");
		Thread.sleep(1000);
		
		//WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
		//search.click();
				
	}

	
	
	@Test
	public void test2() throws InterruptedException {
		
	}
	
	@AfterAll
	public static void AfterAll()
	{
		System.out.println("After");
		driver.quit();
		driver = null;
	}

}
