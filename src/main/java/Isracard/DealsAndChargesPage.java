package Isracard;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a deals and charges page
 * 
 *@author Moran David
 *
 */

public class DealsAndChargesPage extends BaseIsracardPage {

	private HashMap<Integer,String> digitsToHebrewMonth;
	
	/**
	 * constructor
	 * @param driver
	 */
	public DealsAndChargesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.digitsToHebrewMonth = new HashMap<Integer,String>();
		initMap();
	}
	
	private void initMap() {
		this.digitsToHebrewMonth.put(1, "ינואר");
		this.digitsToHebrewMonth.put(2, "פברואר");
		this.digitsToHebrewMonth.put(3, "מרץ");
		this.digitsToHebrewMonth.put(4, "אפריל");
		this.digitsToHebrewMonth.put(5, "מאי");
		this.digitsToHebrewMonth.put(6, "יוני");
		this.digitsToHebrewMonth.put(7, "יולי");
		this.digitsToHebrewMonth.put(8, "אוגוסט");
		this.digitsToHebrewMonth.put(9, "ספטמבר");
		this.digitsToHebrewMonth.put(10, "אוקטובר");
		this.digitsToHebrewMonth.put(11, "נובמבר");
		this.digitsToHebrewMonth.put(12, "דצמבר");
	}
	
	/**
	 *  click on "next charge", "Previous charge" and "Charge by date", then select a month
	 * @return
	 */
	public DealsAndChargesPage selectCharge (String chargeType, int numberOfMonth) throws InterruptedException {
		List<WebElement> chargesList = driver.findElements(By.xpath("//div[@class=\"transaction-details__filters-wrapper\"]/div[4]/div/div/div"));
		for (WebElement charge : chargesList) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(charge));
			charge.click();
			Thread.sleep(1000); 
			break;
		}
		Thread.sleep(1000); 
		List<WebElement> chargeList = driver.findElements(By.className("ui-select-choices-row-inner"));
		for (WebElement chargeElement : chargeList) {
			if(chargeElement.getText().equals(chargeType)) { // go through all charge elements
				if (chargeElement.getText().equals("בחירת חודש")) { // if the type we need is by choosing month, apply month with current chargeType
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOf(chargeElement));
					chargeElement.click();
					try {
						WebElement calendarIcon = driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-calendar\"]"));
						wait.until(ExpectedConditions.visibilityOf(calendarIcon));
						calendarIcon.click();
					}
					catch(Exception e) {
						return null;
					}
					List<WebElement> monthsText = driver.findElements(By.xpath("//tr/td/button/span"));
					List<WebElement> monthsButtons = driver.findElements(By.xpath("//tr/td/button"));
					if (monthsText == null || monthsText.size() == 0 || monthsButtons == null || monthsButtons.size() == 0) {
						return null;
					}
					for(int i=0; i<monthsText.size(); i++) {
						if (monthsText.get(i).getText().contentEquals(digitsToHebrewMonth.get(numberOfMonth))) {
							wait.until(ExpectedConditions.elementToBeClickable(monthsButtons.get(i)));
							JavascriptExecutor executor = (JavascriptExecutor)driver; // because the button is concealed behind 'tr' tag, 
							executor.executeScript("arguments[0].click();", monthsButtons.get(i)); // JavascriptExecutor is used to do direct click
							return this;
						}
					}
					return null;
				}
				else { // if we only choose current / previous charge, just choose charge
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOf(chargeElement));
					chargeElement.click();
					break;
				}
			}
		}
		return this;
	}
}