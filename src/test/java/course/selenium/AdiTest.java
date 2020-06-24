package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdiTest {
static WebDriver driver;
	
	@BeforeEach
	public void before() throws InterruptedException {
		System.out.println("before");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gorsk\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		Thread.sleep(1000);
	}
	
	@AfterEach
	public void after() {
		System.out.println("after");
		driver.quit();
	}
	
	@Test
	public void loginToWordPress() throws InterruptedException {
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.id("user_login"));
		WebElement password = driver.findElement(By.id("user_pass"));
		WebElement loginButton = driver.findElement(By.id("wp-submit"));
		
		userName.sendKeys("admin");
		password.sendKeys("demo123");
		loginButton.click();
		
		Thread.sleep(2000);
		
		WebElement dashboardHeader = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[4]/h1"));
		
		Assertions.assertEquals("Dashboard", dashboardHeader.getText());
	}
	
	@Tag("isracard") 
	@Test
	public void checkElementsInIsracard() throws InterruptedException {
		driver.get("https://digital.isracard.co.il/");
		driver.manage().window().maximize();
		
		WebElement goToLoginButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[4]/ul[1]/li[1]/a/span[1]"));
		
		goToLoginButton.click();
		
		WebElement idField = driver.findElement(By.xpath("//*[@id=\"otpLoginId_ID\"]"));
		WebElement cardDigits = driver.findElement(By.xpath("//*[@id=\"otpLobbyFormPassword\"]/div[4]/input"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"otpLoginPwd\"]"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"otpLobbyFormPassword\"]/button"));
		
		idField.sendKeys("203204086");
		cardDigits.sendKeys("814066");
		password.sendKeys("Aa111111");
		
		loginButton.click();
		
		Thread.sleep(7000);
		
		////*[@id=\"collapse1\"]//a[2]  //a[@href='http://demo.guru99.com/']
	//	WebElement myCardsButton = driver.findElement(By.xpath("//a[@href='/personalarea/cardlist/']"));
	//	WebElement chatButton = driver.findElement(By.xpath("//*[@id=\"wizSideBarSpecial\"]//button"));
	//	WebElement billingInfo = driver.findElement(By.xpath("//a[@href='/personalarea/billing-charges/']"));
	//	WebElement accessibility = driver.findElement(By.xpath("//*[@title='לחץ לקבלת תפריט הנגישות']"));
		WebElement accessibility = driver.findElement(By.xpath("//*[@aria-label='כל הלקוחות activate']"));
		
		accessibility.click();
		Thread.sleep(5000);
		
	}
}
