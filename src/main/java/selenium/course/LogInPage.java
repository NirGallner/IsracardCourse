package selenium.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {
	
	public LogInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="otpLoginId_ID")
	private WebElement idField;
	
	@FindBy(xpath="//*[@name=\"otpLoginLastDigits_ID\"]")
	private WebElement cardDigits;
	
	@FindBy(id="otpLoginPwd")
	private WebElement passField;
	
	@FindBy(xpath="//*[@id=\"otpLobbyFormPassword\"]/button")
	private WebElement enterButton;
	
	public void logIn(String id, String last6Digits, String password) {
		idField.sendKeys(id);
		cardDigits.sendKeys(last6Digits);
		passField.sendKeys(password);
		
		enterButton.click();
	}
}
