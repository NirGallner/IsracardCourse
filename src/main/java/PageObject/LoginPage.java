package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

	private WebDriver Driver;
	
	@FindBy (id = "user_login")
	private WebElement userInput;
	
	@FindBy (id = "user_pass")
	private WebElement passwordInput;
	
	@FindBy (id = "wp-submit")
	private WebElement submitbuton;
	
	public LoginPage(WebDriver driver) {
		// אתחול לdriver
		this.Driver = driver;
		// PageFactory יעבור על כל @FindBy ויאתחל  אותו?
		PageFactory.initElements(driver, this);
	}
	
	
	public  DashboardPage Submit(){
		submitbuton.click();
		return new DashboardPage(Driver);		
	}
		
		
	public LoginPage WithUsername (String username) {
		userInput.sendKeys(username);
		return this;
		//return (LoginPage)userInput;
	}
	
	public LoginPage WithPassword(String password) {
		passwordInput.sendKeys(password);
		return this;
		//return (LoginPage)passwordInput;
	}
	
	public boolean IsOnPage (WebDriver driver) {
		System.out.println(driver.getTitle());
	 return driver.getTitle().contains("Log In ‹ Wordpress Demo Site at Demo.Center — WordPress");	
	}

}
