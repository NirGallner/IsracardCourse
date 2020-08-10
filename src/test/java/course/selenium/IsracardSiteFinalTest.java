package course.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import isracardSite.IsracardAttractionsBenefits;
import isracardSite.IsracardBenefitsPage;
import isracardSite.IsracardDashboardPage;
import isracardSite.IsracardDownloadedBenefitsPage;
import isracardSite.IsracardLogInPage;
import isracardSite.IsracardPasswordUpdatePage;
import isracardSite.IsracardTransactionsPage;

public class IsracardSiteFinalTest {
	
	static WebDriver driver;
	
	private static IsracardDashboardPage dashboard;
	 
	@BeforeAll
	public static void start() 
	{
		
    System.setProperty("webdriver.chrome.driver", "C:/Windows/Temp/chromedriver_win32/chromedriver.exe");
	
	driver = new ChromeDriver();

	
	driver.get("https://digital.isracard.co.il");
	
	// Maximize window
	driver.manage().window().maximize();
	
	//Login
	IsracardLogInPage login = new IsracardLogInPage(driver);
	
	login.goToLogin();
	boolean isOnPage = login.isOnPage(driver);
	assertEquals(true,isOnPage);
		
	
	dashboard = login.enterId("039625868").enterCardSixDigits("118628").enterPass("mo252525").clickSubmit();
	//wait for page to upload
	WebDriverWait wait = new WebDriverWait(driver,10);
	WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title" )));
	System.out.println(title.getText());
	
	
	
	}
	
    @BeforeEach
    public void beforeEach() {
    	boolean isOnPage = dashboard.isOnPage(driver);
    	if(!isOnPage) {
    		 dashboard.clickMyAccountTopBar();
    	 }
    		
    	System.out.println("Before each");
    }
    	
   
	
	@AfterAll
	public static void close()	
	{
		driver.quit();
	}
	
	
    //Click on benefits from list in footer and verify location
	
	@Test
	public void verifyBenefitsLinks() {
		dashboard.goThroughBenefitsList();
	
	}
	
	//Select all view options in transactions page.
	
	@Test
	public void transactionsByDate() {
		IsracardTransactionsPage transactionsPage = dashboard.goToTransactions();
		transactionsPage.selectdateToView(driver);
		
	}
	
	//Go to password update from side menu

	@Test
	public void passwordUpdate() {
		dashboard.goToPasswordUpdate(driver);
		assertTrue (IsracardPasswordUpdatePage.isOnPage(driver));
		System.out.println("עדכון סיסמא");
	} 
	
	
	// select benefit from all benefits page - check if primium,switch to page,more info btns and download.
	
	@Test
	public void Checkselectedbenefitpage() {
		
		dashboard.goToBenefits();
		
		//select benefit in all benefits page
		IsracardBenefitsPage.selectkfarBlumBenefit();
		IsracardAttractionsBenefits.isOnPage(driver);
		System.out.println("kfar blum benefit page");
		
		//check if primium
		IsracardAttractionsBenefits.isPremium(driver);
		System.out.println("Primium benefit");
		
		//switch pages
	//	IsAttractionsBenefits.goToBusinessWebsite(driver);
		IsracardAttractionsBenefits.switchToBusinessWebsitePage();
		System.out.println("Back to benefits");
		
		IsracardAttractionsBenefits.moreInfoBtns(driver);
		IsracardAttractionsBenefits.clickdownloadBenefit();
		IsracardDownloadedBenefitsPage benefitsLoginPage = new IsracardDownloadedBenefitsPage(driver);
		benefitsLoginPage.enterId("039625868").enterSixDigits("118628").clickContinue();
		IsracardDownloadedBenefitsPage.backToBenefitsPage();
		IsracardBenefitsPage.goToDashboardFromBenefits();
		
	
	}
	
	
	// delete downloded benefit
	
	@Test
	public void deleteDownlodedBenefit() {
		dashboard.goToBenefits();
		IsracardBenefitsPage.clickDownloadedBenefits();
		IsracardDownloadedBenefitsPage benefitsLoginPage = new IsracardDownloadedBenefitsPage(driver);
		benefitsLoginPage.enterId("039625868").enterSixDigits("118628").clickContinue();
		benefitsLoginPage.isOnPage(driver);
		benefitsLoginPage.deleteBenefit();
	}

}
