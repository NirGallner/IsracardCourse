package Isracard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents a financial home page
 * @author Moran David
 *
 */

public class FinancialHomePage extends BaseIsracardPage {

	/**
	 * constructor
	 * @param driver
	 */
	public FinancialHomePage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
