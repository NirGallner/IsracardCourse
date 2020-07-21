package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	
	private WebDriver driver;

	
	@FindBy(id="menu-posts")
	 public WebElement posts;
	
	/**
	 * c-tor with WebDriver. initiate
	 * @param driver
	 */
	
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * verification
	 * @param driver
	 * @return
	 */
	
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Dashboard"); 
	}
	
	/**
	 * Click tags in menu
	 */
	public void clickTags() {
		new Actions (driver).moveToElement(posts).perform();
		driver.findElement(By.linkText("Tags")).click();
	}
}
