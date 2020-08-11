package course.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import IsracardProject.Category;
import IsracardProject.ExeptionHandling;
import IsracardProject.LoginUnifiedInfraPage;

public class FooterTest {
	
	public static WebDriver driver;
	
	
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
		
	}
	
	@BeforeEach
	public void BeforeEach(){
		
		assertTrue(LoginUnifiedInfraPage.isOnPage((WebDriver)driver),"No login page found");
		
	}
	
	
	/**
	 * over all the benefit link in the footer 
	 * 
	 * 
	 */
	
	@Test
	public void FooterBenefitsPage() throws InterruptedException, ExeptionHandling {
		
		Category  category = new Category(driver);
		
		category.goToCategory();
		
		
	}	
	
}
