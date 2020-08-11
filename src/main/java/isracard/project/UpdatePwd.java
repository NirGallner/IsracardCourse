package isracard.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * Represents an Update Password Page
 */
public class UpdatePwd extends BasePage {

	private WebDriver driver;
// elements on page
	@FindBy(id="oldPassword")
	private WebElement oldpwd;

	@FindBy(id="newPassword")
	private WebElement newpwd;

	@FindBy(id="repeatNewPassword")
	private WebElement confirmpwd;

	@FindBy(xpath="//*[@id=\"wholePageExport\"]/div[5]/div/div/div/form[1]/div[6]/button")
	private WebElement procceedbtn;

/*
 * Initilize elemtns
 */
	public UpdatePwd(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// sendin the old password 

	public UpdatePwd oldpwd(String pwd) {
		oldpwd.sendKeys(pwd);
		return this;
	}
	// typing the new password
	public UpdatePwd newpwd(String npwd) {
		newpwd.sendKeys(npwd);
		return this;
	}
	// typing the new password in the confirmation field
	public UpdatePwd confirmpwd(String cpwd) {
		confirmpwd.sendKeys(cpwd);
		return this;
	}
	// pressing the proceed button 
		public UpdatePwd procceedbtn() {
			procceedbtn.click();
			return new UpdatePwd(driver);
		}
	
}	 
