package isracard.objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * represents {@link DashboardPage}
 * @author liraz
 *
 */
public class DashboardPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id='menu-posts']//*[@class='wp-menu-name']")
	private WebElement postLink;
	
	@FindBy(linkText = "Tags")
	private WebElement tagsLink;
	
	
	//Dashboard Page Methods
	
	/**
	 * Constructor with webdriver and pageFactory
	 * @param driver
	 */
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Verify we are in Dashboard page
	 * @param driver
	 * @return
	 */
	public static boolean isInDashboardPage(WebDriver driver) {
		return driver.getTitle().contains("Dashboard");
	}
	
	/**
	 * GoTo Tags page
	 */
	public void gotoTags()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(postLink));
		new Actions(driver).moveToElement(postLink).perform();
		wait.until(ExpectedConditions.visibilityOf(tagsLink));
		tagsLink.click();
	}
}
