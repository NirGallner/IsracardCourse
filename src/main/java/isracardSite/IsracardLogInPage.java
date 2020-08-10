package isracardSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IsracardLogInPage extends IsracardBasePage  {
	
	/**
	 * C-tor with WebDriver
	 * @param driver
	 */
	public IsracardLogInPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(className="btn-login-header-desctop")
    private  WebElement myAccountBtn;
	
	@FindBy(id="otpLoginId_ID")
	private  WebElement idNumber;
	
	@FindBy(xpath="//div[@class=\"form-group col-sm-12\"]/input[@name=\"otpLoginLastDigits_ID\"]")
	private  WebElement cardLastDigits;
	
	@FindBy(xpath="//div[@class=\"form-group form-group-last col-sm-12\"] //input[@id=\"otpLoginPwd\"]")
	private  WebElement password;
	
	@FindBy(xpath= "//button[@class=\"btn btn-default center-block btn-send col-sm-12\"]/span[@ng-bind=\"vm.epiData.LoginButtonText\"]")
	private WebElement submitBtn;
	
	
	/**
	 * vrify location - log in page
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("כניסה והרשמה לחשבון האישי - ישראכרט"); 
	}
	
	 /**
	  * Go to log in page
	  */
	public void goToLogin() {
		myAccountBtn.click();
	}
	
	/**
	 * sendKeys to id field in log on page
	 * @param id
	 * @return
	 */
	public IsracardLogInPage enterId(String id) {
		this.idNumber.sendKeys(id);
		return this; 
	}
	
	/**
	 * sendKeys to six digits field in log on page
	 * @param sixDigits
	 * @return
	 */
	public IsracardLogInPage enterCardSixDigits(String sixDigits) {
		this.cardLastDigits.sendKeys(sixDigits);
		return this;
	}
	
	/**
	 * sendKeys to password field
	 * @param password
	 * @return
	 */
	public IsracardLogInPage enterPass(String password) {
		this.password.sendKeys(password);
		return this;
	}
	
	/**
	 * Click submit-Log in to dashboard
	 * @return
	 */
	public IsracardDashboardPage clickSubmit() {
		this.submitBtn.click();
		return new IsracardDashboardPage (driver);
	}
}