import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		// Tell WebDriver where is the chromeDriver.exe
		System.setProperty("webdriver.chrome.driver", "C:/Users/galln/Downloads/ChromeDriver83/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:/Users/galln/Downloads/ChromeDriver83/geckodriver.exe");
		
		// Create a new ChromDriver instance
		WebDriver driver = new ChromeDriver();
		
		// Get google
		driver.get("http://www.google.com");
		
		// Maximize window
		driver.manage().window().maximize();
		
		// Define objects
		WebElement e = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		
		
		e.sendKeys("Test Automation");
		
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
		search.click();
		// e.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
