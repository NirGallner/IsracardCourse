package IsracardProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 *  Represents a Login Unified Infra Page
 * 
 *  @author Eti Kedmi
 *  
 */


public class LoginUnifiedInfraPage {

	private WebDriver driver;
	
	@FindBy (xpath = "//input[@id=\"radioID\"] [@name=\"radioIDPassport\"]")
	private WebElement tzRadioButon;
	
	@FindBy (id = "otpLoginId_ID")
	private WebElement tzInput;
	
	@FindBy (xpath = "//input[@name=\"otpLoginLastDigits_ID\"]")
	private WebElement cardDigitInput;
	
	@FindBy (xpath = "//input[@id='otpLoginPwd']")
	private WebElement passwordInput;
	
	@FindBy (xpath = "//span[contains(@ng-bind,'LoginButtonText')]")
	private WebElement loginButon;
	
	@FindBy (className = "page-title")
	private WebElement titleFront;
	
	public  LoginUnifiedInfraPage (WebDriver Driver) {
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}
	
//	public  FrontPage FrontPage () {
//		loginButon.click();
//			
//		return new FrontPage(driver);
//	}
	
	
	public void selectRadiaButtonTz()	{
		boolean selected_value = tzRadioButon.isSelected();
		if(!selected_value) 		
		tzRadioButon.click();
		
	}
	
	public static boolean isOnPage(WebDriver driver) {
		System.out.println("login");
		return driver.getTitle().contains("כניסה");
		
	}
	
	
	public FrontPage submit () {
		loginButon.click();	
		
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.visibilityOf(titleFront));
		
		return new FrontPage(driver);
		
	}
	
	public LoginUnifiedInfraPage withTz (String tz) {
		tzInput.sendKeys(tz);
		return this;
	
	}
	
	public LoginUnifiedInfraPage withCardDigit(String cardDigit) {
		cardDigitInput.sendKeys(cardDigit);
		return this;
		
	}
	
	public LoginUnifiedInfraPage withPassword(String password) {
		passwordInput.sendKeys(password);
		return this;
	
	}


	
}
