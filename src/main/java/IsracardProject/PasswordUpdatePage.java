package IsracardProject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

/**
 * Represents a Update Page
 * 
 * @author Eti Kedmi
 *
 */


public class PasswordUpdatePage extends BaseIsracardPage {

	@FindBy (id = "oldPassword")
	private WebElement oldPasswordInput;

	@FindBy (id =  "newPassword")
	private WebElement newPasswordInput;

	@FindBy (id = "repeatNewPassword")
	private WebElement repeatNewPasswordInput;

	@FindBy (xpath = "//*[@class = \"btn btn-login\"]/ span[contains(text(),'äîùê')]")
	private WebElement continueBåutton;
	

	@FindBy (xpath = "//form[@name=\\\"successPasswordForm\\")
	private WebElement successPassword;
	
	
	

	public PasswordUpdatePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * Check is on page
	 * @param driver
	 * @return getTitle contains "ñéñîà"
	 */
	
	public void  isOnPage(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("oldPasswordInput"))));
		}catch (Exception e) {}

		assertTrue((driver.getTitle().contains("ñéñîà")),"No Update password page found");
		
//		System.out.println(driver.getTitle());
//		return driver.getTitle().contains("ñéñîà");
	}

	/**
	 * Enter oldPassword
	 * @param oldPassword to be Enter
	 * @return this object
	 */
	
		
	public PasswordUpdatePage OldPassword (String oldPassword) {
		
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.visibilityOf(oldPasswordInput));
		
		oldPasswordInput.clear();
		oldPasswordInput.sendKeys(oldPassword);
		
		return this;	
	
	}
	
	/**
	 * Enter NewPassword
	 * @param NewPassword to be Enter
	 * @return this object
	 */
	
	public PasswordUpdatePage NewPassword(String newPassword) {	
		
		newPasswordInput.clear();
		newPasswordInput.sendKeys (newPassword);
		
		return this;	
	}
	
	/**
	 * Enter repeatNewPassword
	 * @param repeatNewPassword to be Enter
	 * @return this object
	 */
	
	public PasswordUpdatePage RepeatNewPassword(String repeatNewPassword) {	
		
		repeatNewPasswordInput.clear();
		repeatNewPasswordInput.sendKeys(repeatNewPassword);
		
		return this;	
	}
	
	
	/**
	 * Click on radio continue and check if open success
	 * @throws InterruptedException 
	 *
	 */
	
	public void submit() {	
	      
       continueBåutton.click();
       
      WebDriverWait wait = new WebDriverWait(driver,30);

   	try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@name=\"successPasswordForm\"]"))));
		}catch (Exception e) {}
		
       assertTrue(successPassword.getText().contains("äöìçä"), "Password update not performed");              
	
   }
}	
	