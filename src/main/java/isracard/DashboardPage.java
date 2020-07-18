package isracard;

import org.openqa.selenium.WebDriver;

/**
 * represents dashboard page
 * @author galln
 *
 */
public class DashboardPage {

	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Dashboard"); 
	}
	
	
}
