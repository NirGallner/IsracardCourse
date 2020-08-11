package com.Isracard.Final;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenefitsLogInPage extends DigitalBasePage {

	/**
	 * constructor of the BenefitsLogInPage 
	 * @param driver
	 */
	public BenefitsLogInPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Find by sections, of elements that always appear on this page and participate in the tests
	 */
	@FindBy (id="IdNumber")
	private WebElement benefitIDField;
	
	@FindBy (id="CardNumberSuffix")
	private WebElement benefitSixDigitsField;
	
	@FindBy (id="loginFormBtn")
	private WebElement continueButon;
	
	public boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("התחברות"); 
	}
	
	/**
	 * method that insert user's id to the user ID field
	 * @param userid
	 * @return BenefitsLogInPage - to enable chaining 
	 */
	public BenefitsLogInPage withUserID(String userid) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(benefitIDField));
		benefitIDField.sendKeys(userid);
		return this;
		}

	/**
	 * method that insert user's 6 digits to the user 6 digits field
	 * @param userdigits
	 * @return BenefitsLogInPage - to enable chaining 
	 */
	public BenefitsLogInPage withSixDigits(String userdigits) {
		benefitSixDigitsField.sendKeys(userdigits);
		return this;
		}
	
	/**
	 * method that submits the log in 
	 */
	public void submitLogIn() {
		continueButon.click();
	}
}
