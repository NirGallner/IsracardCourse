package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
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
	private LoginUnifiedInfraPage login;

	
	/**
	 * Login to isracard site
	 * 
	 * 
	 */
	
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
		front =login.withTz("301018396").withCardDigit("262819").withPassword("Vv123789").submit();
		
		login.CheckTitlePersonalArea();
		
	}
	
	@BeforeEach
	public  void BeforeEach() {
	
		//Check before test Is the session saved		
		front.CheckLogin();
		System.out.println("BeforeEach");
		
	}
		
	
		// Go back to Front page
		
		//front.gotoFrontPage();
        //assertTrue(FrontPage.isOnPage((WebDriver)driver),"No personal page found, you are not logged in");		 
	
	
	/**
	 * Go to Details Charges page
	 *
	 */
	
	@Test
	public void DetailsCharges() {
	
	    front.gotoChargesPage();
	    
	 
	    ChargesPage chargesPage = new ChargesPage(driver);
	    //chargesPage.isOnPageCharget(driver);
	   
	    chargesPage.selectMoed();
        chargesPage.selectMonth();
	}
	  
	
	/**
	 * Update the password
	 * @throws InterruptedException 
	 *
	 */

	@Test
	public void passwordUpdate(){
	
		
		PasswordUpdatePage passwordUpdatePage = new PasswordUpdatePage(driver);
		passwordUpdatePage.goToPasswordUpdatePage();
		//passwordUpdatePage.isOnPage(driver);
	    passwordUpdatePage.OldPassword("Vv123789").NewPassword("Hh123789").RepeatNewPassword("Hh123789").submit();
	    
	}
	
//	@AfterAll
//	public static void AfterAll() {
//		driver.quit();
//		
//	}
	
	
}


