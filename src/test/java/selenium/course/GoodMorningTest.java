package selenium.course;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoodMorningTest {
	
	@Test
	public void test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gorsk\\Downloads\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		WebElement e;
		
		e = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
		
		e.sendKeys("Test Automation");
		
		Thread.sleep(1000);
		search.click();
		
		Thread.sleep(5000);
		
		driver.quit();
	}
	
	@Test
	public void test2() {
		System.out.println("in test 2");
	}

}
