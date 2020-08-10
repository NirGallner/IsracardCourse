package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * represents {@link DashboardPage}
 * @author liraz
 *
 */
public class DashboardPage extends IsracardBasePage {
		
	@FindBy (css = ".page-title")
	private WebElement dashboardTitle;
	
	
	
	/**
	 * c-tor
	 * @param driver
	 */
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Verify if the correct page
	 * @param driver
	 * @return
	 */
	public static boolean isInDashboardPage(WebDriver driver) {
		return driver.getTitle().contains("האיזור האישי");
	}

	
	
	/**
	 * Wait till the page is loaded
	 */
	public void loadPage() {
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
	}
	

}
