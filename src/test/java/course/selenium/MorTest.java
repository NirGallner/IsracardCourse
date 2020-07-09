package course.selenium;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MorTest 
{

	
	static WebDriver driver;
	 
	@BeforeAll
	public static void start()
	{
		
    System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
	
	driver = new ChromeDriver();
	
	}
	
	@Test
	public void signInDemoSite() {
	
	
	driver.get("http://demosite.center/wordpress/wp-login.php");
	
	// Maximize window
	driver.manage().window().maximize();
	
	WebElement user = driver.findElement(By.id("user_login"));
	user.sendKeys("admin");
	driver.findElement(By.id("user_pass")).sendKeys("demo123");
	driver.findElement(By.id("wp-submit")).click();

	}
	
	@Test
	public void checkDashboard() throws InterruptedException {
		Thread.sleep(5000);
		
	//String title = driver.getTitle();
    //System.out.println(title);
    //assertEquals("Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress",title);

	WebElement DashboardPageTitle =	driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/h1"));
	String title1 = DashboardPageTitle.getText();
	System.out.println(title1);
	assertEquals("Dashboard",title1);
	}
		
		@AfterAll
		public static void finish() {
			driver.quit();
			System.out.println("done");

	}
}
