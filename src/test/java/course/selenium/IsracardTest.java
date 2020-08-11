package course.selenium;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import isracard.project.IsracardDashBoardPage;
import isracard.project.IsracardHomePage;
import isracard.project.IsracardLogin;
import isracard.project.Transactionlist;
import isracard.project.UpdatePwd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsracardTest {
	
	static WebDriver driver;
	
	@BeforeAll
	public static void beforeAll() throws InterruptedException {

		// Logging
		System.out.println("In before all - start running");

		// New instance
		System.setProperty("webdriver.chrome.driver", "C:/Users/777/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Goto home page
		driver.get("https://digital.isracard.co.il/");
		
		//go to login page
		
		IsracardHomePage enterAccount = new IsracardHomePage(driver);
		enterAccount.click();
		//wait for page to load
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

		// Login using base page
		IsracardLogin login = new IsracardLogin(driver);
		login.withPassword("qa131313").withidInput("066130055").withsixDigitsInput("982057").submit();
		//IsracardLogin isonpage = new IsracardLogin(driver);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//assertEquals(IsracardLogin.isOnPage(driver) );
		
	
		//String handle = driver.getWindowHandle();
		
		// ended login procedure
		System.out.println("Ended before all");
	}
	
//	@BeforeEach
//	public  void beforeEach() throws InterruptedException {
//		System.out.println("now in before each ");
//		if (IsracardDashBoardPage.IsonDashBoardPage(driver) == false) {
//		} driver.get("IsracardDashBoardPage");
//		}
	
	
	@Test
	void isLoginTrue() {
	
		System.out.println("login to dashboard succeeded");
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://digital.isracard.co.il/personalarea/dashboard/"));
		String url = driver.getCurrentUrl();
		assertEquals( url,"https://digital.isracard.co.il/personalarea/dashboard/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		System.out.println("loginto client dashboard confirmed");
		
		
	}
	
	@Test
	void FilteringDates() {
		
		System.out.println("Entering TransactionList Page");
		IsracardDashBoardPage enterTransactionlist = new IsracardDashBoardPage(driver);
		enterTransactionlist.submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("starting date filtrization");
		Transactionlist openMenu = new Transactionlist(driver);
		openMenu.PickerBtn();
		System.out.println("pressed the picker");
		Transactionlist filteringnextmonth = new Transactionlist(driver);
		filteringnextmonth.nxtMonth();
		System.out.println("filtered next  month");
		Transactionlist filterpreviousmonth = new Transactionlist(driver);
		filterpreviousmonth.prvMonth();
		System.out.println("filtered previous  month");
		
		
		
	}
	
	@Test
	
	void UpdatePWD() {
		IsracardDashBoardPage openmenu = new IsracardDashBoardPage(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		openmenu.menupicker().updatepwd();
		
		
		UpdatePwd Update = new UpdatePwd(driver);
		Update.oldpwd("qa131313").newpwd("qa131312").confirmpwd("qa131312").procceedbtn();
		
		
	}
	
}
