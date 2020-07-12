package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	private static WebDriver driver;
	
	@BeforeAll
	public static void webDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron\\temp\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterAll
	public static void afterAll() {
		driver.close();
	}
	
//	@Test
//	public void fillterPost() throws InterruptedException {
//		WebElement catagoriesSelect = driver.findElement(By.id("cat"));
//		Select allCategories = new Select(catagoriesSelect);
//		Thread.sleep(2000);
//		allCategories.selectByVisibleText("Uncategorised");
//		
//		WebElement fillterBtn = driver.findElement(By.id("post-query-submit"));
//		fillterBtn.click();
//	}
	

	//		
	//		ac.moveToElement(posts);
	//		Thread.sleep(2000);
	//		
	//		WebElement addNewInPost= driver.findElement(By.xpath("//a[@href='post-new.php']"));
	//		addNewInPost.click();
	//		WebElement textArea = driver.findElement(By.xpath("//div[@id='wp-content-editor-container']/textarea"));
	//		textArea.sendKeys("Some Sample Text Here");

	@Disabled
	@org.junit.jupiter.api.Test
	public void isracardFindElements() throws InterruptedException {
		driver.get("http://wwww.digital.isracard.co.il");
		WebElement enterMyAccountBtn = driver.findElement(By.xpath("//a[@class='btn-login-account']"));

		assertTrue(enterMyAccountBtn.isDisplayed());

		enterMyAccountBtn.click();

		WebElement userNameInput = driver.findElement(By.xpath("//input[@id='otpLoginId_ID']"));
		assertTrue(userNameInput.isDisplayed());

		WebElement suffixInput = driver.findElement(By.xpath(""));
		assertTrue(suffixInput.isDisplayed());

		WebElement passwordInput= driver.findElement(By.xpath("//a[@class='btn-login-account']"));
		assertTrue(passwordInput.isDisplayed());

	}

}
