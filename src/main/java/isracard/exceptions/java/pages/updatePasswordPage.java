package isracard.exceptions.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class updatePasswordPage extends BasePage{
	

	//Account operations link
	@FindBy(linkText="פעולות בחשבון")
	private WebElement accountOperations;
	
	//update password link 
	@FindBy(xpath="//*[@id=\"collapse2\"]/div/a[7]")
	private WebElement updatePwLink;
	
	//insert old pw
	@FindBy(className="form-control login-form__control ng-pristine ng-invalid ng-invalid-user-password ng-invalid-required ng-valid-maxlength ng-touched")
	private WebElement oldPw;
	
	//insert new Pw
	@FindBy(xpath="//*[@id=\"newPassword\"]")
	private WebElement newPw;
	
	//insert new Pw 2
	@FindBy(className="form-control login-form__control ng-pristine ng-isolate-scope ng-invalid ng-invalid-user-password ng-valid-not-equal-to ng-invalid-required ng-valid-maxlength ng-touched")
	private WebElement newPwSecondField;
	
	//submit BT
	@FindBy(xpath="//*[@id=\"wholePageExport\"]/div[5]/div/div/div/form[1]/div[6]/button")
	private WebElement button;
	
	//check if Pw Updated 
	@FindBy(linkText="הסיסמה עודכנה בהצלחה")
	private WebElement pwUpdated;
	
	//tap on continue button 
	@FindBy(xpath="//*[@id=\"wholePageExport\"]/div[5]/div/div/div/form[2]/div[2]/button")
	private WebElement continiueBt;
	
	
	//check if it is update password page  
	@FindBy(linkText="סיסמה ישנה")
	private WebElement checkPwPage;
	
	public updatePasswordPage (WebDriver driver) {
		super(driver);
		
    //this method will create all webelements
		PageFactory.initElements(driver, this);

	}
	//tap on account operations
	public void clickAccountOperations() {
		accountOperations.click();
	}
	//click on PWupdate
	public void clickOnUpdatePw() {
		updatePwLink.click();
	}
	
	//set old  PW  in text box
	public void setOldPassword (String strpw) {
		oldPw.sendKeys(strpw);
	}
			
	//set new password
	public void setNewPassWord (String strnpw) {
		newPw.sendKeys(strnpw);
	}
	
	//set second new PW
	public void setNewPassWordSec(String strnpws) {
		newPwSecondField.sendKeys(strnpws);
	}
	
	//tap on continue BT
	public void clickOnContinueBT() {
		continiueBt.click();
	}
	
		
}



