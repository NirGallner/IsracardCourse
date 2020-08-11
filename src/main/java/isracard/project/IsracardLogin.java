package isracard.project;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a login page

 *
 */
public class IsracardLogin extends BasePage {

	private WebDriver driver;

	@FindBy(xpath="//*[@id=\"otpLoginId_ID\"]")
	private WebElement idInput;

	@FindBy(xpath="//*[@id=\"otpLobbyFormPassword\"]/div[4]/input")
	private WebElement sixDigitsInput;

	@FindBy(id="otpLoginPwd")
	private WebElement pwdInput;

	@FindBy(xpath="//*[@id=\"otpLobbyFormPassword\"]/button/span[2]")
	private WebElement submitBtn;

	public IsracardLogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * submit goto StatmentPage
	 */
	public IsracardLogin submit() {
		submitBtn.click();
		return new IsracardLogin(driver);
	}

	/** login with sixdigits
	 * @param sixDigits
	 * @return
	 */
	public IsracardLogin withsixDigitsInput(String sixDigits) {
		sixDigitsInput.sendKeys(sixDigits);
		return this;
	}
	/** login with user id
	 * 
	 * @param id
	 * @return
	 */
	public IsracardLogin withidInput(String id) {
		idInput.sendKeys(id);
		return this;
	}

	/**
	 * Enter password to the password field
	 *@param password
	 * @return
	 */
	public IsracardLogin withPassword(String password) {
		pwdInput.sendKeys(password);
		return this;
	}

		
	public static  String isOnPage(WebDriver driver) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://digital.isracard.co.il/personalarea/dashboard/"));
		String url = driver.getCurrentUrl();
		return url;
		
	}
}



