package pageObject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="user_login")
     private WebElement userName;
	
	@FindBy(id="user_pass")
    private WebElement userPass;
	
	@FindBy(id="wp-submit")
    private WebElement submitBtn;
	
	
	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verification
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Log in"); 
	}
	
	/**
	 * sendKeys to Username field
	 * @param user
	 * @return
	 */
	public LoginPage userInput(String user) {
		this.userName.sendKeys(user);
		return this;
	}
	
	/**
	 * sendKeys to Password field
	 * @param password
	 * @return
	 */
	public LoginPage userPassword (String password) {
		this.userPass.sendKeys(password);
		return this;
	}
	
	/**
	 * Click submit - Login 
	 */
	public  void clickSubmit () {
	    this.submitBtn.click();
	}

	
	}
		
	

