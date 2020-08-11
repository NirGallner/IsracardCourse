package course.selenium;


	


	
	import java.util.List;
	import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.Assertions;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;






	public class ItzikPageObject {

		static WebDriver driver;

		@BeforeAll
		static void testStart() throws InterruptedException {
			System.out.println("Testing cycle Start");
			System.setProperty("webdriver.chrome.driver", "C:/Users/777/chromedriver.exe");
			driver =  new ChromeDriver();

			driver.get("http://demosite.center/wordpress/wp-login.php");
			driver.manage().window().maximize();
			
			Thread.sleep(5000);
		}

		@BeforeEach
		void testRestart() throws InterruptedException {
			WebElement search = driver.findElement(By.xpath("//*[@id=\"menu-dashboard\"]/ul/li[2]/a"));
			search.click();
			System.out.println("Test Cycle Initlized");
			Thread.sleep(5000);
		}

		@AfterAll
		static void tetsEnd() {
			Assertions.assertTrue(driver.findElement(By.id("footer-thankyou")).isDisplayed());
			System.out.println("Test Cycle Ended succesfuly");
			//driver.quit();
		}
		@Test
		public void login() {
			
			//validation is on page 
			//assertTrue(LoginPage.isOnPage((WebDriver) driver));
			
			//login
			LoginPage login = new LoginPage((WebDriver) driver);
			login.WithUserName("admin");
			
			
			
		}
		

		

	}


