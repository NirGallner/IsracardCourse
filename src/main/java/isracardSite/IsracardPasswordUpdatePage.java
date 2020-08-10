package isracardSite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

public class IsracardPasswordUpdatePage extends IsracardBasePage {
	
	/**
	 * c-tor with driver
	 * @param driver
	 */
	public  IsracardPasswordUpdatePage(WebDriver driver) {
		super(driver);
	}


	

	
	
	/**
	 * Verify location
	 * @param driver
	 * @return
	 */
	public static  boolean isOnPage(WebDriver driver) {
	return driver.getTitle().contains("עדכון סיסמא");
	
	}


	
	
}

