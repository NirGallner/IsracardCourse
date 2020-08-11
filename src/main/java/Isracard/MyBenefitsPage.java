package Isracard;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents my benefits page
 *@author Moran David
 *
 */

public class MyBenefitsPage extends BaseBenefitsPage {

	@FindBy (xpath = "//button[text()=\"ביטול הטבה\"]")
	private WebElement cancelBenefitBtn;

	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public MyBenefitsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * click on "cancel" benefit button
	 * @return
	 */
	public MyBenefitsPage cancelBenefit () {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(cancelBenefitBtn == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(cancelBenefitBtn));
		cancelBenefitBtn.click(); // click on cancel button
		try {
			WebElement alertConfirmationButton = driver.findElement(By.xpath("//button[text()=\"כן\"]"));
			alertConfirmationButton.click(); // click accept to cancel benefit
		}
		catch(Exception e) {
			return null;
		}

		return this;
	}
}
