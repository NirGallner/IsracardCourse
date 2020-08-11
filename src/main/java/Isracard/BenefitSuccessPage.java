package Isracard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents a benefit success page
 * @author Moran David
 *
 */

public class BenefitSuccessPage extends BaseBenefitsPage {
	
	public BenefitSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
