package demo_site.poms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * dashboard page that extends the base page - includes all the relevant elements on dashboard page 
 * @author marina
 *
 */
public class DashboardPage extends BasePage {
	
	public DashboardPage (WebDriver driver) {
		super(driver);
	}
	/**
	 * checks is the driver on dashboard page
	 * @param driver
	 * @return true/ false by comparing the page title to the "Dashboard" string
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Dashboard");
	}
	
	}
	
	
	
	//This sectoion should be inside the posts page
//	
//	@FindBy(id="title")
//	private WebElement titleField;
//	
//	public void insertTitle(String myTitle) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(titleField));
//		titleField.clear();
//		titleField.sendKeys();
//	}
//	
	
	  


