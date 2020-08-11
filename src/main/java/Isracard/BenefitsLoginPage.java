package Isracard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenefitsLoginPage extends BaseBenefitsPage {

	/**
	 * Represents a benefits login page
	 *@author Moran David
	 *
	 */

	@FindBy(id="IdNumber")
	private WebElement userInput;

	@FindBy(id="CardNumberSuffix")
	private WebElement sixDigitsInput;

	@FindBy(id="loginFormBtn") 
	private WebElement submitBtn;


	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public BenefitsLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * submit -go to "My benefits" page
	 * @param pageName
	 * @return 
	 * @throws InterruptedException
	 */
	public MyBenefitsPage submitToMyBenefitsHomePage(String pageName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		if(submitBtn == null) {
			return null;
		}
		submitBtn.click();
		Thread.sleep(5000);
		if(this.isOnPage(pageName)){
			return new MyBenefitsPage(driver);
		}
		else return null;
	}

	/**
	 * submit -go to success page
	 * @param pageName
	 * @return
	 * @throws InterruptedException
	 */
	public BenefitPage submitToSuccessPage(String pageName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(submitBtn == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		submitBtn.click();
		Thread.sleep(5000);
		if(this.isOnPage(pageName)){ // checks if login successed
			return new BenefitPage(driver);
		}
		else return null;
	}

	/**
	 * enter ID to the user id field
	 * @param ID
	 * @return BenefitsLoginPage
	 */
	public BenefitsLoginPage withID(int ID) {
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.elementToBeClickable(userInput));
		userInput.sendKeys(Integer.toString(ID));// insert ID
		return this;
	}

	/**
	 * enter sixDigits to the 6 card digits field
	 * @param sixDigits
	 * @return BenefitsLoginPage
	 */
	public BenefitsLoginPage withSixDigits(int sixDigits) {
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.elementToBeClickable(sixDigitsInput));
		sixDigitsInput.sendKeys(Integer.toString(sixDigits)); // insert 6 digits
		return this;
	}
}