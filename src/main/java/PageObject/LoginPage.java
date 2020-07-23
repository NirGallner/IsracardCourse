package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy (id="user_login")
	private WebElement userInput;
	
	@FindBy (id="user_pass")
	private WebElement passInput;
	
	@FindBy (id="wp-submit")
	private WebElement submitBtn;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage withUserName (String username) {
		//driver.findElement(By.id("user_login")).sendKeys(username);
		userInput.sendKeys(username);
		return this;
	}
	
	public LoginPage withPassword (String pass) {
		//driver.findElement(By.id("user_pass")).sendKeys(pass);
		passInput.sendKeys(pass);
		return this;
	}
	
	
	/*public void submit() {
		driver.findElement(By.id("wp-submit")).click();
	}*/
	public DashboardPage submit() {
		//driver.findElement(By.id("wp-submit")).click();
		submitBtn.click();
		return new DashboardPage(driver);
	}
	
	
	public static boolean isOnPageLogin (WebDriver driver) {
		return driver.getTitle().contains("Log In");
	}
	
}
