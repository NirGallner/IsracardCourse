package Isracard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a financial login page
 *@author Moran David
 *
 */

public class FinancialLoginPage extends BaseIsracardPage  {

	/**
	 * Represents a login page
	 * @author Moran David
	 *
	 */
	
	@FindBy(id = "otpLoginId_ID")
	private WebElement idInput;

	@FindBy(name = "otpLoginLastDigits_ID")
	private WebElement sixDigitsInput;

	@FindBy(id = "otpLoginPwd")
	private WebElement passwordInput;

	@FindBy(xpath = "//*[@id=\"otpLobbyFormPassword\"]//*[text()='כניסה לחשבון שלי']")
	private WebElement submitLoginBtn;


	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public FinancialLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * enter ID to the user ID field
	 * @param userID
	 * @return BenefitsLoginPage
	 */
	public FinancialLoginPage withUserID(int userID) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(idInput));
		idInput.sendKeys(Integer.toString(userID));
		return this;
	}

	/**
	 * enter sixDigits to the 6 card digits field
	 * @param sixDigits
	 * @return BenefitsLoginPage
	 */
	public FinancialLoginPage withsixCardDigits(int sixDigits) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(sixDigitsInput));
		sixDigitsInput.sendKeys(Integer.toString(sixDigits));
		return this; 
	}

	/**
	 * Enter password to the password field
	 * @param password
	 * @return
	 */
	public FinancialLoginPage withPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
		passwordInput.sendKeys(password);
		return this;
	}

	/**
	 * submit -goto deals and charges page
	 */
	public DealsAndChargesPage submitToDeals(String pageName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(submitLoginBtn == null) {
			return null;
		}
		//wait.until(ExpectedConditions.visibilityOf(submitLoginBtn));
		Thread.sleep(1000);
		submitLoginBtn.click(); // goto deals and charges after login
		Thread.sleep(2000); 
		if(this.isOnPage(pageName)) {
			return new DealsAndChargesPage(driver); 
		}
		else return null;
	}

	/**
	 * submit -goto DashboardPage page
	 */
	public DashboardPage submitToDashboard(String pageName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(submitLoginBtn == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(submitLoginBtn));
		submitLoginBtn.click(); // goto dashboard after login
		Thread.sleep(5000);
		if(this.isOnPage(pageName)) {
			return new DashboardPage(driver);
		}
		else return null;
	}
}