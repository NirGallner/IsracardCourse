package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private static  WebDriver driver;
	
	@FindBy (xpath="//*[@id='menu-posts']//*[@class='wp-menu-name']")
	private WebElement postsBtn;
	
	@FindBy (xpath="//*[@href='edit-tags.php?taxonomy=post_tag']")
	private WebElement tagsBtn;
	
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public static boolean isOnPageDashboard (String title) {
		return driver.getTitle().toLowerCase().contains(title.toLowerCase());
		}
		
		
	
	public void GoToTagsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(postsBtn));
		new Actions(driver).moveToElement(postsBtn).perform();
		wait.until(ExpectedConditions.visibilityOf(tagsBtn));
		new Actions(driver).moveToElement(tagsBtn).click().perform();
	} 
	
	
}
