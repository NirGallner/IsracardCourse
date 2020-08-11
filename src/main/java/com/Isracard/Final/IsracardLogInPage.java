package com.Isracard.Final;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsracardLogInPage extends DigitalBasePage{
	/**
	 * constructor of the IsracardLogInPage
	 * @param driver
	 */
	public IsracardLogInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id ="otpLoginId_ID")
	private WebElement idField;
	
	@FindBy (name ="otpLoginLastDigits_ID")
	private WebElement sixDigitsField;
	
	@FindBy (id ="otpLoginPwd")
	private WebElement passwordField;
	
	@FindBy (css ="global-error-div global-alert1-div")
	private static WebElement errorMessage;
    /**
     * checks if the driver on the correct page
     * @param driver
     * @return true - if it on isracard log in page ; otherwise - false
     */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("כניסה והרשמה לחשבון האישי - ישראכרט"); 
	}
	/**
	 * checks if an error appears (not activated)
	 * @param driver
	 * @return true- if there is no error ; false - if the message appears 
	 */
	public static boolean isErrorAccured(WebDriver driver) {
		return ((WebElement)errorMessage != null);
	}
	/**
	 * waits until the userId field appears and insert the content
	 * @param userid
	 * @return IsracardLogInPage to enable chaining
	 */
	public IsracardLogInPage withUserID(String userid) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(idField));
		idField.sendKeys(userid);
		return this;
		}
	
	/**
	 * inserts the 6 digits to the suitable filed 
	 * @param userid
	 * @return IsracardLogInPage to enable chaining
	 */
	public IsracardLogInPage withSixDigits(String userdigits) {
		sixDigitsField.sendKeys(userdigits);
		return this;
		}
	
	/**
	 * inserts the correct password to the suitable field 
	 * @param userid
	 * @return IsracardLogInPage to enable chaining
	 */
	public IsracardLogInPage withUserPassword(String userpassword) {
		passwordField.sendKeys(userpassword);
		//return new PersonalAreaPage(driver);
		return this;
		}
	
//	public PersonalAreaPage submitLogIn() {
//		List<WebElement> buttonsList = driver.findElements(By.cssSelector("button")); 
//		for (WebElement button : buttonsList) {
//		    if (button.getAttribute("type").equals("submit")) {   
//	     	button.click();
//		    }
//	}	
//		return new PersonalAreaPage (driver);
//}

	
	
}


