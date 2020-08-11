package Isracard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a dashboard page
 *@author Moran David
 *
 */

public class DashboardPage extends BaseIsracardPage {

	/**
	 * constructor
	 * @param driver
	 */
	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * update the user password
	 * @return
	 * @throws InterruptedException
	 */
	public UpdatePasswordPage gotoUpdatePasswordPage () throws InterruptedException {

		try {
			WebElement clickOnOperationsInAccountCollapse = driver.findElement(By.xpath("//div[1]/a[contains(text(),'פעולות בחשבון')]"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(clickOnOperationsInAccountCollapse));
			clickOnOperationsInAccountCollapse.click(); // click on operations in account (open this collapse)
			Thread.sleep(5000); 
			WebElement clickOnUpdatePassLink = driver.findElement(By.xpath("//div/a[contains(text(),'עדכון סיסמא')]")); 
			wait.until(ExpectedConditions.visibilityOf(clickOnUpdatePassLink));
			clickOnUpdatePassLink.click(); // Click on update pass
			Thread.sleep(5000);
			return new UpdatePasswordPage(driver);
		}
		catch(Exception e) {
			return null;
		}

	}

}
