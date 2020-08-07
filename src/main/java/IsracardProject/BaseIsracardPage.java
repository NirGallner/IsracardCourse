package IsracardProject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a Base Page
 * 
 * @author Eti Kedmi
 *
 */

public class BaseIsracardPage {
	
	protected WebDriver driver;

	
	@FindBy (linkText = "החשבון שלי")
	private WebElement myCountLink;

	@FindBy (xpath = "//*[@class=\"btn-login-account logged\"]/a")
	private WebElement exit;
	
	
	@FindBy (partialLinkText =  "חיובים ועסקאות")
	private WebElement chargesLink;
	
//	@FindBy (xpath =  "//*[@title=\"עדכון סיסמא\"]")
//	private WebElement passwordLink;
//	
	@FindBy (linkText =  "עדכון סיסמא")
	private WebElement passwordLink;

	@FindBy (className = "page-title")
	private WebElement titleFront;
	
	@FindBy (className = "credit-cards__select-boxes-wrapper credit-cards__select-boxes-wrapper-new")
	private WebElement dashbordMain;
	
	
	public BaseIsracardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	/**
	 * Check before test Is the session saved 
	 */
	
	public void CheckLogin() {
		
		 assertTrue((exit.getText().contains("יציאה")),"You are not logged in");
		
	}
	
	
	/**
	 * Click on the mycount link fromn the top menu for the main page
	 */
	
	public FrontPage gotoFrontPage() {
		
		new Actions(driver).moveToElement(myCountLink).perform();
		
		myCountLink.click();
		
	   // wait for BeforeEach, if open this page from anther page,  
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.visibilityOf(titleFront));
		
     	return new FrontPage (driver);
	 
	}
	
	
	
	
	/**
	 * Click on the Details of charges and transactions
	 */
	
	public ChargesPage gotoChargesPage() {

		// Hover
		new Actions(driver).moveToElement(myCountLink).perform();
		chargesLink.click();
		return new ChargesPage(driver);

	}
	
	
    public PasswordUpdatePage goToPasswordUpdatePage() {
	 
	 	new Actions(driver).moveToElement(myCountLink).perform();
	 	
	 	WebDriverWait wait = new WebDriverWait(driver,30,3000);
 	    wait.until(ExpectedConditions.visibilityOf(myCountLink));
 	    
	 	WebElement password= driver.findElement (By.linkText("עדכון סיסמא"));
	 	
 	    wait.until(ExpectedConditions.elementToBeClickable(password));
 	
 	   password.click();
		
		return new PasswordUpdatePage(driver);
		
		   
//	    WebElement myCountLink = driver.findElement(By.linkText("החשבון שלי"));
//	    Actions action = new Actions(driver);
//		action.moveToElement(myCountLink).perform();
//		
//		
//		WebElement passwordLink = driver.findElement (By.linkText("עדכון סיסמא"));
//		passwordLink.click();
//		
		
	//	new Actions(driver).moveToElement(myCountLink).perform();
		
		
//	    WebDriverWait wait = new WebDriverWait(driver,100,3000);
//    	wait.until(ExpectedConditions.visibilityOf(myCountLink));
//	
	 
//   	Actions action = new Actions(driver);
//		action.moveToElement(myCountLink).build().perform();
////    
//    	Actions action = new Actions(driver);
//		action.moveToElement(myCountLink).build().perform();
		
    	
    	
		//WebElement passwordLink = driver.findElement (By.xpath("//*[@class=\"clearfix\"]//ul//li/a[@title=\"עדכון סיסמא\"]"));
		
//		
    }

}
