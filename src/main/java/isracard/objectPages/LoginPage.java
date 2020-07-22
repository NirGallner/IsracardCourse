package isracard.objectPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represent a login page
 * @author liraz
 *
 */
public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="user_login")
	private WebElement userInput;
	
	@FindBy(id="user_pass")
	private WebElement passwordInput;
	
	@FindBy(id="wp-submit")
	private WebElement submitBtn;
	
	
	//Login Page Methods
	
	/**
	 * Constructor with webdriver and pageFactory
	 * @param driver
	 */
	public LoginPage (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Insert username
	 * @param username
	 * @return LoginPage object
	 */
	public LoginPage withUsername(String username)
	{
		this.userInput.sendKeys(username);
		return this;
	}
	
	/**
	 * Insert password
	 * @param password
	 * @return LoginPage object
	 */
	public LoginPage withPassword(String password)
	{
		this.passwordInput.sendKeys(password);
		return this;
	}
	
	/**
	 * Submin - Goto Dashboard page
	 * @param driver
	 * @return Dashboard page
	 */
	public DashboardPage submit(WebDriver driver)
	{
		this.submitBtn.click();
		return new DashboardPage(driver);
	}
	
	/**
	 * Verify we are in Login page
	 * @param driver
	 */
	public static boolean isInLoginPage(WebDriver driver) {
		return driver.getTitle().contains("Log In");
	}
}
