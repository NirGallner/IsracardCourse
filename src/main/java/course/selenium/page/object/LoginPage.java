package course.selenium.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import course.selenium.page.object.DashboardPage;

public class LoginPage extends BasePage {

	private WebDriver driver;

	@FindBy(id= "user_login")
	private WebElement userName;

	@FindBy(id= "user_pass")
	private WebElement userPasswword;

	@FindBy(id= "wp-submit")
	private WebElement submitBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage loginWithUserName(String username) {
		userName.sendKeys(username);
		return this;
	}

	public LoginPage loginWithPass(String password) {
		userPasswword.sendKeys(password);
		return this;
	}

	public LoginPage submit() {
		submitBtn.click();
		return this;
	}
}
