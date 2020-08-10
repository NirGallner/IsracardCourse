package isracardSite;

import org.openqa.selenium.WebDriver;

public class IsracardDashboardPage extends IsracardBasePage {

	
	
	/**
	 * c-tor with driver
	 * @param driver
	 */
	public  IsracardDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Verify location
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("האיזור האישי"); 
	}
}	
	


