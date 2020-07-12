package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MarinaTest {
	//Define a static driver - to be initialization
	static WebDriver driver;
	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {
		//Logging 
	System.out.println("LOg in ");	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\marina\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	  //go to page
	driver.get("http://demosite.center/wordpress/wp-login.php");
	  // Login
	WebElement user_name = driver.findElement(By.id("user_login"));
	user_name.sendKeys("admin");
	WebElement user_pass = driver.findElement(By.id("user_pass"));
	user_pass.sendKeys("demo123");  
	WebElement submit = driver.findElement(By.id("wp-submit"));
	submit.click();
	Thread.sleep(9000);
	}
	
	@BeforeEach
	public void beforeEach (){
		System.out.println("before each");
		
		if(driver.getTitle().contains("Dashboard")==false)
			driver.findElement(By.xpath("//div.[text()= 'Dashboard']")).click();
	}
	
	
	@Test
	public void logIn() {
				
	WebElement welcomePanel = driver.findElement(By.id("welcome-panel"));
	boolean flag = welcomePanel.isDisplayed();
	Assertions.assertTrue(flag);
	
	//additional way - if the driver will not find this element to click on it - the test will fail
	//driver.findElement(By.xpath("//div.[text()= 'Dashboard']")).click();  
	
	}
	
	@AfterAll
	public static void afterAll() {
		// close the driver
		driver.quit();	
	}
	

}
