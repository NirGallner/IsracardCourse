package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

/**
 * Represents a login page
 * @author Nir Gallner
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
	
	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * submit -goto dashboard page
	 */
	public DashboardPage submit() {
		submitBtn.click();
		return new DashboardPage(driver);
	}
	
	/**
	 * enter username to the user name field
	 * @param username
	 * @return
	 */
	public LoginPage withUsername(String username) {
		userInput.sendKeys(username);
		return this;
	}
	
	/**
	 * Enter password to the password field
	 * @param password
	 * @return
	 */
	public LoginPage withPassword(String password) {
		passwordInput.sendKeys(password);
		return this;
	}
	
	/**
	 * Checks whthter the driver is set to the login page
	 * @param driver
	 * @return true if the driver is located on the login page
	 * false - otherwise
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Log In");
	}
	
}
