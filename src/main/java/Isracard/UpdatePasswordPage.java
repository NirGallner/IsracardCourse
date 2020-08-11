package Isracard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a update password page
 *@author Moran David
 *
 */

public class UpdatePasswordPage extends BaseIsracardPage {

	@FindBy (id = "oldPassword")
	private WebElement oldPasswordInput;

	@FindBy (name = "newPassword")
	private WebElement newPasswordInput;

	@FindBy (id = "repeatNewPassword")
	private WebElement repeatNewPasswordInput;

	@FindBy (xpath = "//form[1]/div[6]/button")
	private WebElement submitChangePassBtn;

	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public UpdatePasswordPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * insert an old pass
	 * @param oldPassword
	 * @return
	 */
	public UpdatePasswordPage insertOldPassword (String oldPassword) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(oldPasswordInput));
		oldPasswordInput.sendKeys(oldPassword);
		return this;
	}

	/**
	 * insert a new pass
	 * @param newPassword
	 * @return
	 */
	public UpdatePasswordPage insertNewPassword (String newPassword) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(newPasswordInput));
		newPasswordInput.sendKeys(newPassword);
		return this;

	}

	/**
	 * insert new pass again
	 * @param repeatNewPassword
	 * @return
	 */
	public UpdatePasswordPage insertNewPasswordAgain (String repeatNewPassword) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(repeatNewPasswordInput));
		repeatNewPasswordInput.sendKeys(repeatNewPassword);
		return this;
	}

	/**
	 * click to change pass and finish 
	 * @return
	 * @throws InterruptedException
	 */
	public UpdatePasswordPage submitNewPassword () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(submitChangePassBtn == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(submitChangePassBtn));
		submitChangePassBtn.click();
		Thread.sleep(1000); 
		try {
			WebElement confirmationBtn = driver.findElement(By.xpath("//form[2]/div[2]/button"));
			return this;
		}
		catch(Exception e){
			return null;
		}
	} 

	/**
	 * click on button "to dashboard" after password changed
	 * @return
	 * @throws InterruptedException
	 */
	public DashboardPage goToDashBoardPageWithoutLogin () throws InterruptedException {

		try {
			WebElement toDashboardBtn = driver.findElement(By.xpath("//form[2]/div[2]/button"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(toDashboardBtn));
			toDashboardBtn.click(); 
			Thread.sleep(1000);// 
			return new DashboardPage(driver);
		}
		catch(Exception e) {
			return null;
		}
	} 

}
