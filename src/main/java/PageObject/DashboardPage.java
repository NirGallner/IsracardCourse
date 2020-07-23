package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * represents dashboard page
 * @author galln
 *
 */
public class DashboardPage {

	private WebDriver driver;

	@FindBy(xpath="//*[@id='menu-posts']//*[@class='wp-menu-name']");
	private WebElement posts;
	
	@FindBy(linkText = "Tags")
	private WebElement tags;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Methods:

	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Dashboard"); 
	}
	
	public void gotoTags()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100, 5000);
		wait.until(ExpectedConditions.visibilityOf(posts));
		new Actions(driver).moveToElement(posts).perform();
		wait.until(ExpectedConditions.visibilityOf(tags));
		tags.click();
	}
}