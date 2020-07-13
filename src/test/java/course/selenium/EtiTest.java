package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtiTest {

	private static WebDriver driver;

		@BeforeAll
		public static void OpenWebDriver() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		@Test
		public  void User() throws InterruptedException{
			driver.get("http://demosite.center/wordpress/wp-login.php");
			WebElement userelement = driver.findElement(By.id("user_login"));
			userelement.sendKeys("Admin");
			WebElement passwordelement = driver.findElement(By.id("user_pass"));
			passwordelement.sendKeys("demo123");
			driver.findElement(By.id("wp-submit")).click();
			Thread.sleep(7000);
			
			WebElement dashbordelement = driver.findElement(By.tagName("h1"));
			String text = dashbordelement.getText();
			System.out.println(text);
					
			}	
		@AfterAll
		public static void CloseWebDriver() {
			driver.close();	
		}
}
		


	


