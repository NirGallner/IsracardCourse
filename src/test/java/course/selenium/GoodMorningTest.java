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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author Nir Gallner
 * Code sample June 11th, 2020
 *
 */
public class GoodMorningTest 
{
 static WebDriver driver;
 
	
	@BeforeAll
	
	public static void start()
	{
	System.out.println("start");
	
	
	System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");

    driver = new ChromeDriver();
	}
 

	@Test
	public void test1() throws InterruptedException {
		System.out.println("In Test 1");
	
	
	// Get google
	driver.get("http://www.google.com");
	
	// Maximize window
	driver.manage().window().maximize();

	}
	
	
	@Test
	public void test2() throws InterruptedException {
		System.out.println("In Test 2");
	
	// Define objects
	WebElement e = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
	
	
	e.sendKeys("Test Automation");
	
	Thread.sleep(1000);
	WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
	search.click();
	// e.sendKeys(Keys.ENTER);
	
	Thread.sleep(5000);
	}
	
	
	
	
	@AfterAll
	
public static void finish()
{
	System.out.println("finish");	
	driver.quit();
	{
	
}
	}

 }





