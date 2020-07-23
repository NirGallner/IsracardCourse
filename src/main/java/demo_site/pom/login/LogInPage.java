package demo_site.pom.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo_site.poms.DashboardPage;

/**
 * 
 * @author marina
 *
 */
public class LogInPage {
	
	private WebDriver driver;
	
	@FindBy(id = "user_login")
	private WebElement userInput;

	@FindBy(id = "user_pass")
	private WebElement passwordInput;

	@FindBy(id = "wp-submit")
	private WebElement submitBtn;
	
	public LogInPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	/**
	 * Validates that the driver on log in page
	 * @param driver
	 * @return true or false by comparing the page title to the "Log In" string 
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Log In");
		
	}
	
	/**
	 * enter the user name into user field at login page
	 * @param username - 
	 * @return LogInPage
	 */
	public LogInPage withUserName(String username) {
	WebDriverWait wait = new WebDriverWait(driver, 40);
	wait.until(ExpectedConditions.elementToBeClickable(userInput));
	userInput.sendKeys(username);
	return this;
	}
	/**
	 * enter the user password into user field at login page 
	 * @param password
	 * @return LogInPage
	 */
	public LogInPage withPassword(String password) {
	passwordInput.sendKeys(password);	
	return this;
	}
	/**
	 * press the submit button to perform log in at log in page
	 * @return DashboardPage
	 */
	public DashboardPage submit() {
	submitBtn.click();
	return new DashboardPage(driver);
	}

}
