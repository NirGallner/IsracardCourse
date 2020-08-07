package IsracardProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class PasswordUpdatePage extends BaseIsracardPage {


	public PasswordUpdatePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

}
