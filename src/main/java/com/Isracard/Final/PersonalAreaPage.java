package com.Isracard.Final;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAreaPage extends DigitalBasePage{
	/**
	 * constructor of the PersonalAreaPage
	 * @param driver
	 */
	public PersonalAreaPage(WebDriver driver) {
		super(driver);
	}
	
   @FindBy (linkText ="פעולות בחשבון")
   private WebElement accountFunctionsLink;
   
   @FindBy (linkText ="פירוט חיובים ועסקאות")
   private WebElement creditDetailsLink;
   
   /**
    * waits until the account Function link appears and clicks on it to get an access to the secondary menu bar
    */
   public void openAccountFunctions() {
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	   wait.until(ExpectedConditions.elementToBeClickable(accountFunctionsLink));
	   accountFunctionsLink.click();
   }
   
   /**
    * waits until the link appears and clicks on it to forward the user to the update password page
    */
   public void gotoUpdatePassPage() {
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='collapse2']//*[contains(text(),'עדכון סיסמא')]"))));
		WebElement updatePassLink = driver.findElement(By.xpath("//*[@id='collapse2']//*[contains(text(),'עדכון סיסמא')]"));
		updatePassLink.click();
	}
   /**
    * waits until the link appears and clicks on it to forward the user to the credit details page
    * @return Credit Details page 
    */
   public CreditDetailsPage gotoCreditDetailsPage() {
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	   wait.until(ExpectedConditions.elementToBeClickable(creditDetailsLink));
	   creditDetailsLink.click();
	   return new CreditDetailsPage(driver);
   }
   
   
   
}
