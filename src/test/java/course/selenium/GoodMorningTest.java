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

//admin
//demo123



/**
 * 
 * @author Nir Gallner
 * Code sample June 11th, 2020
 *
 */
public class GoodMorningTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void before() {
		System.out.println("before");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gorsk\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
	}
	
	@AfterAll
	public static void after() {
		System.out.println("after");
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		WebElement e = driver.findElement(By.id("user_login"));
		
		e.sendKeys("Adi");
		Thread.sleep(2000);
	}

//	@Test
//	public void test1() throws InterruptedException {
//		System.out.println("In Test 1");
//		WebElement e = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
//		e.sendKeys("Test Automation");
//	}

//	@Test
//	public void test2() throws InterruptedException {
//		System.out.println("In Test 2");
//		WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
//		Thread.sleep(5000);
//		search.click();
//	}

}