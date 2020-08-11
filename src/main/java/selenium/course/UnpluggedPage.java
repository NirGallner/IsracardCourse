package selenium.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnpluggedPage extends BasePage {
	
	public UnpluggedPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@href='/personalarea/Login/']//*[@class='links-name']")
	private WebElement loginButton;
	
	public void clickOnLoginButton() {
		loginButton.click();
	}

}
