package IsracardProject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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
	BaseIsracardPage category;
	String textNameCategory;
	
	//FindBy for login
	@FindBy (linkText = "החשבון שלי")
	private WebElement myCountLink;

	@FindBy (xpath = "//*[@class=\"btn-login-account logged\"]/a")
	private WebElement exit;
	
	//FindBy for chargesLink
	@FindBy (partialLinkText =  "חיובים ועסקאות")
	private WebElement chargesLink;
	
	//FindBy for password Link
	
//	@FindBy (xpath =  "//*[@title=\"עדכון סיסמא\"]")
//	private WebElement passwordLink;
//	
	@FindBy (linkText =  "עדכון סיסמא")
	private WebElement passwordLink;
	
	@FindBy (className = "page-title")
	private WebElement titleFront;
	
	@FindBy (css = ".credit-cards__select-boxes-wrapper credit-cards__select-boxes-wrapper-new")
	private WebElement dashbordMain;
	
	//FindBy for benefits
	@FindBy (linkText = "הטבות")
	private WebElement lnkHatavot;
	
	@FindBy (xpath ="//*[@class='site-footer__nav-item col-sm-4'][5]//*[@class='site-footer__nav-list-second-level']")		
	private WebElement listElement;
	
	@FindBy(css = ".footer-wrapper")
	private WebElement footer;
	
	
	 // Constractor for driver
	BaseIsracardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Check before the test run If the session saved 
	 */
	
	public void CheckLogin() {
		//lasy exit
		 assertTrue((exit.getText().contains("יציאה")),"You are not logged in");
		 System.out.println(exit.getText());
		
	}
	
	
	/**
	 * Click on the mycount link fromn the top menu for the main page
	 * 
	 * *  @return new FrontPage
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
	 * 
	 *  @return new PasswordUpdatePage
	 */
	
	public ChargesPage gotoChargesPage() {

			// Hover
			new Actions(driver).moveToElement(myCountLink).perform();
			chargesLink.click();
			return new ChargesPage(driver);

	}
	
	/**
	 * Click on the Password Update link
	 * 
	 * @return new PasswordUpdatePage
	 */
	
    public PasswordUpdatePage goToPasswordUpdatePage() {
	 
	    	WebDriverWait wait = new WebDriverWait(driver,30,3000);
	    	
	    	WebElement myAccount = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("החשבון שלי"))));
	 	    
		 	Actions ac = new Actions(driver);
	    	ac.moveToElement(myAccount).perform();
		 	
		 	
	 	    WebElement updatePasswordLink = driver.findElement(By.linkText("עדכון סיסמא"));
	 	    
		 	wait.until(ExpectedConditions.visibilityOf(updatePasswordLink));
	 	
		 	updatePasswordLink.click();
			
			return new PasswordUpdatePage(driver);
	   
    }
    
   
	/**
	 * list for benefits link, click on the links in the footer
	 * 
	 * @return new category
	 */
    
	public void goToCategory()  {
			
	String textNameCategory;
	System.out.println(listElement.getSize());
	 
	for (int i=0; i < 10 ; i++) {
			
		List <WebElement> allLink = listElement.findElements(By.tagName("a"));
			
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfAllElements(allLink));
			
		textNameCategory = (allLink.get(i).getText());
		
		// click on the link in list 
		
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(allLink.get(i)));
			
			allLink.get(i).click();
			
			wait.until(ExpectedConditions.urlContains("benefits.isracard.co.il"));
			//wait.until(ExpectedConditions.visibilityOf(driver.getTitle()));
			
			System.out.println (driver.getTitle()+" driver");
			System.out.println (textNameCategory+ "textNameCategory");
			
			// Check if the name link equals to title in the category to be opened
			if  (driver.getTitle().contentEquals(textNameCategory))	{
				
				// New instance category
			    new Category (driver,textNameCategory);
				
			}	
				//If the page that opens is incorrect to be accepted error
			else {
				assertTrue(driver.getTitle().equals(textNameCategory),"The page that opens does not match the category " +textNameCategory+ " you clicked");
				System.out.println("The page that opens does not match the category " +textNameCategory+ " you clicked");
			}	
		}
			
		finally 
		{
			//Go back to Home Page
			driver.navigate().back();
		}
				 
	}

 }
}
