package isracard.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IsracardHomePage extends BasePage {

	private WebDriver driver;

	@FindBy(className="btn-login-header-desctop")
	private WebElement loginbtn;
	
	public IsracardHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public IsracardLogin click() {
		loginbtn.click();
		return new IsracardLogin(driver);
	}
	

	

}
