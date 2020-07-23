package isracard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * represents dashboard page
 * @author galln
 *
 */
public class DashboardPage extends BaseWpPage{

	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Dashboard"); 
	}
	
	
	
	
	
	
	
}
