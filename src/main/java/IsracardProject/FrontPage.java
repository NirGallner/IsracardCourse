package IsracardProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage extends BaseIsracardPage{

	public FrontPage (WebDriver driver) {
	super (driver);
	
	}
	
	
	public static boolean isOnPage(WebDriver driver) {
		
		return driver.getTitle().contains("אישי"); 
	}
	
	
}
