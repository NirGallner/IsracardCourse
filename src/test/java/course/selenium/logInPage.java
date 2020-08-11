package course.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logInPage {
	
	private WebDriver driver;
	
	//user  name
	@FindBy(id="user_login")
	private WebElement userInPut;
	
	//password
	@FindBy(id="user_pass")
	private WebElement passwordInPut;
	
	//enter button
	@FindBy(id="wp-submit")
	private WebElement submitBtn;
	
	public logInPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
			
}			