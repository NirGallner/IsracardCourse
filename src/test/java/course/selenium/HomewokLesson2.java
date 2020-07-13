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
import org.openqa.selenium.support.ui.Select;

public class HomewokLesson2 {

	// Define a static driver - to be initialized in @BeforeAll
	static WebDriver driver;
	
	// Exercise 1:
	@Test
	public static void exercise1() throws InterruptedException {

		// Logging
		System.out.println("Login");

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

		// Logging
		System.out.println("Check if you are on Dashboard");

		// if we are not in dashboard page - click on it
		if (driver.getTitle().contains("Dashboard") == false)
			driver.findElement(By.xpath("//div[text()='Dashboard']")).click();	
		
		//logging
		System.out.println("quit");

		// Quit driver
		driver.quit();
	}
	
	/*
	 * Exercise 2: 5 xpath elements from Isracard's site:
	 *  1. Absolute: /html/body/div[2]/div[2]/div/div[4]/ul[1]/li[1]/a
	 *  2. Relative: //div/ul[2]/li[1]/a
	 *  3. //span[@class=‘links-name’]
	 *  4. //img[@id=‘LayoutLogoImage’]
	 *  5. //*[contains(@src,’/globalassets/isracard/home-page---new/icons/money.png’)
	 *  
	 */
	
	
	// Exercise 3: לפתוח בראנץ בגיט- בוצע
	

}

