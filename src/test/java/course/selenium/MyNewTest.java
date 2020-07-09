package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MyNewTest {

static WebDriver driver;
 
	
	@BeforeAll
	
	public static void Start()
	{
	System.out.println("BeforeAll");
	
	
	System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");

    driver = new ChromeDriver();
    
	}
  
	@BeforeEach
	
	public void BeforeMethod ()
	{
	System.out.println("BeforeEach");
	}
	
	@AfterEach
	public void AfterMethod ()
	{
		System.out.println("AfterEach");
	}
	
	@Test
	public void test1() 
	{
		System.out.println("In Test 1");
	
	}
	
	
     driver.get("http://demosite.center/wordpress/wp-login.php");
	
	

	
	// Maximize window
	driver.manage().window().maximize();

	
	@AfterAll
	public static void  End()
	{
		System.out.println("AfterAll");
	}	
}
