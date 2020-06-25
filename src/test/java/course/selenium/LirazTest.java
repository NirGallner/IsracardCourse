package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LirazTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void BeofreAll() {
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void LoginTest() throws InterruptedException {
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();		
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys("admin");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("demo123");
		WebElement LogInButton = driver.findElement(By.id("wp-submit"));
		LogInButton.click();
		Thread.sleep(1000);
		WebElement DashboardPage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/h1"));
		String Title = DashboardPage.getText();
		System.out.println(Title);
		assertEquals("Dashboard", Title);
		System.out.println("passed");
	}
}
