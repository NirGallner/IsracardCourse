package Isracard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

/**
 * Represents a benefits home page
 * 
 * @author Moran David
 *
 */
public class BenefitsHomePage extends BaseBenefitsPage {

	/**
	 * Constructor
	 * @param driver
	 */
	public BenefitsHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}