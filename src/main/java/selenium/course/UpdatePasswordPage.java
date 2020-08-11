package selenium.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UpdatePasswordPage extends BasePage {
	
	private WebDriver driver;

	public UpdatePasswordPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private Actions actions = new Actions(driver);
	
	@FindBy(id="oldPassword")
	private WebElement oldPassField;
	
	@FindBy(id="newPassword")
	private WebElement newPassField;
	
	@FindBy(id="repeatNewPassword")
	private WebElement repeatPassField;
	
	@FindBy(className="btn btn-login")
	private WebElement nextButton;
	
	@FindBy(xpath="//*[@name=\"successPasswordForm\"]")
	private WebElement changedSuccessfuly;
	
	public void updatePassword(String oldPass, String newPass) {
		oldPassField.sendKeys(oldPass);
		newPassField.sendKeys(newPass);
		repeatPassField.sendKeys(newPass);
		
		//scroll to button
		actions.moveToElement(nextButton);
		
		nextButton.click();
	}
	
	public boolean isPasswordChanged() {
		boolean isIt = false;
		
		if(changedSuccessfuly.isDisplayed()) {
			isIt = true;
		}
		
		return isIt;
	}

}
