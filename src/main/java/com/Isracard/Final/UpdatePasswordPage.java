package com.Isracard.Final;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdatePasswordPage extends DigitalBasePage{
	/**
	 * constructor of the UpdatePasswordPage
	 * @param driver
	 */
	public UpdatePasswordPage (WebDriver driver) {
		super(driver);
	}
	/**
	 * page factory elements 
	 */
	@FindBy(id ="oldPassword")
	private WebElement oldPassFiels;
	
	@FindBy(id ="newPassword")
	private WebElement newPassFiels;
	
	@FindBy(id ="repeatNewPassword")
	private WebElement confirmPassFiels;
	
	@FindBy(xpath="//*[@class='btn btn-login']//*[contains(text(),'המשך')]")
	private WebElement submitButton;
	
	/**
	 * method that verifies if the correct page opened 
	 * @param driver
	 * @return true - if the expected page (update password) opened ; otherwise - false
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("עדכון סיסמא"); 
	}
	/**
	 * inserts current user's password to the old password field
	 * @param userpassword
	 * @return UpdatePasswordPage to enable chaining
	 */
	public UpdatePasswordPage insertOldPass(String userpassword) {
		oldPassFiels.sendKeys(userpassword);
		return this;
		}
	
	/**
	 * inserts a new user's password to the new password field
	 * @param userpassword
	 * @return UpdatePasswordPage to enable chaining
	 */
	public UpdatePasswordPage insertNewPass(String usernewpassword) {
		newPassFiels.sendKeys(usernewpassword);
		return this;
		}
	
	/**
	 * inserts a new user's password again to the confirm a new password field
	 * @param userpassword
	 * @return UpdatePasswordPage to enable chaining
	 */
	public UpdatePasswordPage confirmNewPass(String usernewpassword) {
		confirmPassFiels.sendKeys(usernewpassword);
		return this;
		}
	
	/**
	 * clicks on the submit button
	 */
	public void submitPassUpdate() {
		submitButton.click();
	}
	
	/**
	 * checks if the process succeed
	 * @return true - if the "הסיסמה עודכנה בהצלחה" appears on page ; otherwise - false 
	 */
	public boolean confirmSucsess() {
		return driver.findElement(By.xpath("//*[@class='login-form__notes']//*[contains(text(),'הסיסמה עודכנה בהצלחה')]")) != null;
      }
	
	
}

//
//	try {
//		WebElement pageH1 = driver.findElement(By.tagName("h1"));
//		System.out.println(pageH1.getText());
//		Assertions.assertEquals("הורים וילדים", driver.getTitle() ,"The title should be הורים וילדים");
//		}
//		catch (NoSuchElementException notFound){
//		throw new NoSuchElementException ("The extpected title was not found" + driver.getCurrentUrl());	
//} 
	

//First Option
//public boolean confirmSucsess() {
//	return driver.findElement(By.xpath("//*[@class='login-form__notes']//*[contains(text(),'הסיסמה עודכנה בהצלחה')]")) != null;
//}

