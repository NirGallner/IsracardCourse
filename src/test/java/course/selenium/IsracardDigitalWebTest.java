package course.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import isracard.menusAndPages.DashboardPage;
import isracard.menusAndPages.HatavotPage;
import isracard.menusAndPages.IdkunSismaPage;
import isracard.menusAndPages.KfarBlumPage;
import isracard.menusAndPages.LoginPage;
import isracard.menusAndPages.PerutHiuvimPage;



public class IsracardDigitalWebTest {
	
static WebDriver driver;

public static DashboardPage dashboard;

	
	@BeforeAll
	public static void BeforeAll() throws InterruptedException {
		
		System.out.println("Now we are start- Before All");
		
		//Set property webDriver
		System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
				
		//Driver definition
		driver = new ChromeDriver();
		
		//Go to login page in Isracard website
		driver.get("https://digital.isracard.co.il/personalarea/Login/");
		
		//Maximized the window
		driver.manage().window().maximize();
		
		//Verify we are in the login page
		assertEquals(true, LoginPage.isInLoginPage(driver), "Login page is here");
		
		//Login to Isracard
		LoginPage login = new LoginPage(driver);
		dashboard = login.withCustomerId("303043699").withCardDigits("403385").withPassword("a1111111").preformLogin();
		dashboard.loadPage();
	}
	
	
	
	@BeforeEach
	public void BeforeEach() {
		
		System.out.println("Before each test");
		
		
		//Check we are in DashboardPage if not go back to DashboardPage
		if (DashboardPage.isInDashboardPage(driver) == false) {
			
			//dashboard.gotoDashboardFromEzorIshi();
			if (driver.getCurrentUrl().startsWith("https://digital.isracard.co.il/personalarea")) 
				dashboard.gotoDashboardFromEzorIshi();
			
			else if (driver.getCurrentUrl().startsWith("https://benefits.isracard.co.il/"))
				dashboard.gotoDashboardFromHatavot();
		}
	}
	
	
	
	//Test number 1 - Click on Hatavut Links from footer
	@Test
	public void verifyHatavotLinksInFooterTest() throws Throwable{
		
		System.out.println("Verify Hatavot links in footer");
		
		//Click on Hatavot Links from footer and verify the correct page is opened
		dashboard.clickOnHatavotLinksOnFooter();		
	}
	
	
	
	
	//Test number 2 - Sunan Muaadim
	@Test
	public void perutHiuvimTest() throws Throwable {
		
		System.out.println("Use SUNANIM of the Mua'dim in this page");
		
		PerutHiuvimPage perutHiuvim = dashboard.gotoPerutHiuvimPage();
		
		if(PerutHiuvimPage.isInPerutHiuvimPage(driver) == true) {			
			
			perutHiuvim.clickOnMoedAndVeify("מועד קרוב");
			
			perutHiuvim.clickOnMoedAndVeify("מועד קודם");
			
			perutHiuvim.clickOnMoedAndVeify("בחירת חודש");
			
		}else
			Assertions.fail("The page: " + perutHiuvim.getPageName() +  " was not fount");

	}
	
	
	
	//Test number 3 - Page Idkun Sisma
	@Test
	public void idkunSismaTest() {
		
		System.out.println("Goto IdkunSisma");
		
		//Goto Idkun Sisma Page 
		IdkunSismaPage idkunPage = dashboard.gotoIdkunSismaPageFromSideMenu();
		
		//Verify the correct page is opened if not throw a message
		if(IdkunSismaPage.isOnIdkunSismaPage(driver) == false)
			Assertions.fail("The page: " + idkunPage.getPageName() +  " was not fount");
	}
	
	
	
	
	//Test number 4 - Hatavat Kfar Blum
	@Test
	public void hatavaKfarBlumTest() throws Throwable {
		
		HatavotPage hatavotPage = dashboard.gotoHatavotPage(driver);
		
		if(HatavotPage.isInHatavotPage(driver)==false)
			Assertions.fail("The page: " + hatavotPage.getPageName() +  " was not fount");
		
		else {
			
			KfarBlumPage hatava = hatavotPage.clickOnHatavatKfarBlum();
			
			//Check if hatava is premium
			hatava.isPrimium();
			
			//Open website of this Hatava 
			hatava.checkWebsite();
			
			//Click on continue riding and Tnaiim VeHagbalut
			hatava.clickOnContinueRiding();
			
			
			
			//My work is ending here :)
			//hatava.horadatHatava();
			
			}
		}
	

	
	
	@AfterAll
	public static void AfterAll() {
		System.out.println("We are finished here");
		driver.close();
	}
}

