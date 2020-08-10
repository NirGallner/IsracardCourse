package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import isracard.menusAndPages.DashboardPage;

/**
 * represents {@link LoginPage}
 * @author liraz
 *
 */
public class LoginPage extends IsracardBasePage{
	
	@FindBy(id = "otpLoginId_ID")
	private WebElement customerID;
	
	@FindBy(name = "otpLoginLastDigits_ID")
	private WebElement cardNum6Digits;
	
	@FindBy(name = "otpLoginPwd")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//*[@id='otpLobbyFormPassword']//*[text()='כניסה לחשבון שלי']")
	private WebElement loginBtn;
	
	
	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Insert customer id in id filed
	 * @param customerId
	 * @return
	 */
	public LoginPage withCustomerId(String customerId)
	{
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(this.customerID));
		
		//Insert customer id in id number filed 
		this.customerID.sendKeys(customerId);
		
		return this;
	}
	
	
	/**
	 * Insert 6 last card digits
	 * @param cardNum6Digits
	 * @return
	 */
	public LoginPage withCardDigits(String cardNum6Digits)
	{
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(this.cardNum6Digits));
		
		//Insert last 6 digits in last 6 digits filed
		this.cardNum6Digits.sendKeys(cardNum6Digits);
		
		return this;
	}
	
	
	/**
	 * Insert customer password
	 * @param password
	 * @return
	 */
	public LoginPage withPassword(String password)
	{
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(this.passwordInput));
		
		//Insert user pass in password filed
		this.passwordInput.sendKeys(password);
		
		return this;
	}
	
	
	/**
	 * Click on login Btn 
	 * @param driver
	 * @return
	 */
	public DashboardPage preformLogin()
	{
			this.loginBtn.click();
			return new DashboardPage(driver);
	}
	
	
	/**
	 * Verify we are in Isracard Login page
	 * @param driver
	 */
	public static boolean isInLoginPage(WebDriver driver) {
		return driver.getTitle().contains("כניסה והרשמה לחשבון האישי - ישראכרט");
	}
}

