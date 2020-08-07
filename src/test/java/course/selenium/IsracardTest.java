package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import IsracardProject.ChargesPage;
import IsracardProject.FrontPage;
import IsracardProject.LoginUnifiedInfraPage;
import IsracardProject.PasswordUpdatePage;

/*
 * Test class of Isracard site
 * 
 *  @author Eti Kedmi
 *  
 */

public class IsracardTest {
	
	public static WebDriver driver;
	private static FrontPage front;
	
	@BeforeAll
	public static void OpenWebDriver() {

		// New instance
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Go to isracard login page
		
		driver.get("https://digital.isracard.co.il/personalarea/Login/");
		
		//Login
		
		LoginUnifiedInfraPage login = new LoginUnifiedInfraPage(driver);
		
		assertTrue(LoginUnifiedInfraPage.isOnPage((WebDriver)driver),"No login page found");
		
		login.selectRadiaButtonTz();
		front = login.withTz("301018396").withCardDigit("262819").withPassword("Ee123789").submit();
		
		
		//To Do new function
		WebElement title = driver.findElement(By.className("page-title"));
		WebDriverWait wait = new WebDriverWait(driver,30,3000);
		wait.until(ExpectedConditions.visibilityOf(title));
		System.out.println(title.getText());
		assertTrue((title.getText().contains("אישי")),"No personal page found, you are not logged in");
	
		
		
	}
	
	@BeforeEach
	public void BeforeEach() {
	
		//Check before test Is the session saved
		
		front.CheckLogin();
		System.out.println("BeforeEach");
		
		
		// Go back to Front page
		
		//front.gotoFrontPage();
//		assertTrue(FrontPage.isOnPage((WebDriver)driver),"No personal page found, you are not logged in");
		
		// new
		
//		 WebElement exzit = driver.findElement(By.xpath("//*[@class=\"btn-login-account logged\"]/a"));
//		 System.out.println(exzit.getText());
		 
	}
	
	@Test
	public void DetailsCharges() {
	
	    front.gotoChargesPage();
	    
	//   assertTrue(ChargesPage.isOnPage((WebDriver)driver));
	
	    ChargesPage chargesPage = new ChargesPage(driver);
	    chargesPage.selectMoed();
	    chargesPage.selectMonth();
	 
	    
	    // Go to password Update in the one test
	    
//	    WebElement myCountLink = driver.findElement(By.linkText("החשבון שלי"));
//	    Actions action = new Actions(driver);
//		action.moveToElement(myCountLink).perform();
//		
//		
//		WebElement passwordLink = driver.findElement (By.linkText("עדכון סיסמא"));
//		passwordLink.click();
	}

	@Test
	public void passwordUpdate(){
	
		PasswordUpdatePage passwordUpdatePage = new PasswordUpdatePage(driver);
	    passwordUpdatePage.goToPasswordUpdatePage();
    
	    
	    
	    
	    
	    
	    
	    
	    
//	    WebElement myCountLink = driver.findElement(By.linkText("החשבון שלי"));
//	    Actions action = new Actions(driver);
//		action.moveToElement(myCountLink).perform();
//		
//		
//		WebElement passwordLink = driver.findElement (By.xpath("//*[@class=\"clearfix\"]//ul//li/a[@title=\"עדכון סיסמא\"]"));
//		
//		WebDriverWait wait = new WebDriverWait(driver,120);
//		wait.until(ExpectedConditions.elementToBeClickable(passwordLink));
//		
//		//driver.findElement (By.linkText("עדכון סיסמא"));
//		passwordLink.click();
//		
	}
}


