package isracardSite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.DashboardPage;

public abstract class IsracardBasePage {
	
	// Driver for all subclasses- protected = private but accessible
	protected static  WebDriver driver;

	
	/**
	 * c-tor with driver,initElements for all subclasses 
	 * @param driver
	 */
	public IsracardBasePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//Side menu
	
	  @FindBy(xpath="//div[@id=\"accordion\"]//div[@class=\"panel\"][1]")
	  public static WebElement myAccountInSideMenu;
	
	  @FindBy(xpath="//div//div[@id= \"collapse1\"]//a[@class=\"level3Simple\"][1]")
	  public static WebElement dashbordTabInSideMenu;
	  
	  
	//@FindBy (xpath = "//div//div[@id=\"collapse1\"]//a[@class=\"level3active\"]")
	//public  static WebElement sideBarPagesList;
	
	
	//@FindBy (linkText= "פעולות בחשבון")
	//public static   WebElement actionsInSideBar;
	
	
	//Top bar
	
	
	@FindBy (xpath="//div//ul[@class=\"site-header__nav-list-top-level\"]/li[5]/a")
	public static WebElement myAccountTopBar;
	
	@FindBy (xpath="//div//ul[@class=\"site-header__nav-list-top-level\"]/li[4]/a")
	public static WebElement benefitsIntopBar;
	
	// page
	
	@FindBy(className="page-title")
	public  WebElement mainPageTitle;
	
	
	@FindBy(className="main-page")
	public static  WebElement mainPage;
	
	//for all benefits - base
	
	 @FindBy(xpath="//div[@id= \"collapsibleNavbar\"]//ul//li[3]//a")
	 public static   WebElement goToMyAccountBenefitsBtn;
		 	
	//Fotter
	
	@FindBy(xpath="//div[@id=\"Digital_Footer\"]//ul[@class=\"site-footer__nav-list-top-level\"]//li[@class=\"site-footer__nav-item col-sm-4\"][5]//ul")
    public static  WebElement benefitsListFooter;
	
	@FindBy(xpath="//div[@class=\"container nocontent\"]//ul[@class=\"site-footer__nav-list-top-level\"]//li[@class=\"site-footer__nav-item col-sm-4\"][5]") 
	public static WebElement benefitsListWithHeader;	

	
	@FindBy (className ="footer-address")
	public static WebElement address;
	 
	 
	 
	
	/**
	 * verify location - dashboard
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("האיזור האישי"); 
	}
	 
	 //Top bar
	 
	
	/**
	 * Opens my account menu in top bar
	 */
	 public static void hoverMyAccountTopBar() {
		new Actions (driver).moveToElement(myAccountTopBar).perform();
	 }
	 
	 
	 /**
	  * Go to dashboard from top bar - click My account
	  */
	 public static void clickMyAccountTopBar() {
			new Actions (driver).moveToElement(myAccountTopBar).click().perform();
		 }
	 
		
	/**
	 * Go to benefits fron top bar
	 */
	 public static IsracardBenefitsPage goToBenefits() {
		 benefitsIntopBar.click();
		 return new IsracardBenefitsPage(driver);
	 }
	 
	 
	 /**
	  * Go to transaction page from top bar
	  * @return
	  */
	 public static IsracardTransactionsPage goToTransactions() {
		//new Actions (driver).moveToElement(myAccountTopBar).perform();
		hoverMyAccountTopBar();
		driver.findElement(By.linkText("פירוט חיובים ועסקאות")).click();
		return new IsracardTransactionsPage(driver);
		}
	 
	 /**
	  * Go to dashboard from top bar
	  * @return
	  */
	 public  static IsracardDashboardPage goToDashboard() {
		//new Actions (driver).moveToElement(myAccountTopBar).perform();
		WebDriverWait wait = new WebDriverWait(driver,10,10);
		hoverMyAccountTopBar();
		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ראשי")));
		dashboard.click();
		return new IsracardDashboardPage(driver);
	}
	 
	 /**
	  * Opens my account in side bar if closed and goes to dashboard
	  * @return
	  */
	 public static IsracardDashboardPage goToDashboardInSideMenu() {
		if( dashbordTabInSideMenu.isDisplayed())
			dashbordTabInSideMenu.click();
		else
			myAccountInSideMenu.click();
		    dashbordTabInSideMenu.click();

		return new IsracardDashboardPage(driver);
		 
	 }
	
	 /**
	  * Go to dashboard from benefits - click btn
	  * @return
	  */
	 public static IsracardDashboardPage goToDashboardFromBenefits() {
		IsracardBenefitsPage.goToMyAccountBenefitsBtn.click();
		return new IsracardDashboardPage(driver);
	}
	
	 /**
	  * scroll down in dashboard
	  */
	 public static void scrolldown() {
		
		WebElement page = mainPage;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", address);
		
	}
	
	
	/**
	 * Check benefits links in fotter
	 */
	 public static void goThroughBenefitsList  ( )  {
		WebDriverWait wait = new WebDriverWait(driver,10,10);
		wait.until(ExpectedConditions.visibilityOf(benefitsListWithHeader));
		scrolldown();
		//get list from WebElement that holds all links
		List<WebElement> benefitsFromList = benefitsListFooter.findElements(By.tagName("a"));
		int index = 0;
		//Go over benefits list 
		while (index < benefitsFromList.size()) {
			//Get singel benefit by index
			 WebElement benefit = benefitsFromList.get(index);
		     String benefitName = benefit.getText() ;
		     System.out.println(benefitName);
		     // click on benefit = go to benefit
		     benefit.click();
		     
		     
		    //checks if benefit page is the correct page - if not print message and continue. 
		     try {
		    	// WebElement  benefitTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("categoryPageTitle")));
		    	 String benefitPageTitle = driver.getTitle() ;
		    	 System.out.println(benefitPageTitle);
			
		    	 assertEquals(benefitName,benefitPageTitle);
		    	 System.out.println("This is the correct page "+benefitName+benefitPageTitle);
			}
		     catch(Exception e) {
				System.out.println("Error in" + benefitName + ":"  + e.getMessage());
			}
		     
			 
		    IsracardDashboardPage.goToDashboardFromBenefits();
		     
		     WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"page-title\"]")));
			 WebElement dashboardChart = driver.findElement(By.xpath("//div[@class=\"dashboard__chart-header-col\"]//h2[@class=\"dashboard__headline-primary\"]"));
			 wait.until(ExpectedConditions.visibilityOf(dashboardChart));
			 //take the same list again after return from benefits page			
			 benefitsFromList = benefitsListFooter.findElements(By.tagName("a"));
			 index++;
            
		}
		
	}
		
	
	 /**
	  * Go to password update - side menu
	  * @param driver
	  */
	 public static void goToPasswordUpdate(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,10,10);
		WebElement actionsInSideBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("פעולות בחשבון")));
		String actions = actionsInSideBar.getText();
		actionsInSideBar.click();
		System.out.println(actions);
		WebElement passUpdateTab  = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("עדכון סיסמא")));
		passUpdateTab.click();
		boolean isOnPage = IsracardPasswordUpdatePage.isOnPage(driver);
		if(!isOnPage) {
			System.out.println("You are not on Password Update page");
			}
		}
}	


