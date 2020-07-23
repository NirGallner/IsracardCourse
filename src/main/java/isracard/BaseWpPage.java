package isracard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseWpPage {

	protected WebDriver driver;

	public BaseWpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Dashboard']")
	private WebElement dashboardLink;

	@FindBy(xpath = "//*[@id='menu-posts']//*[@class='wp-menu-name']")
	private WebElement posts;

	@FindBy(xpath = "//*[@id='menu-posts']//*[@class='wp-menu-name']")
	private WebElement postLnk;

	/**
	 * Click on the dashboard link from the menu
	 */
	public DashboardPage gotoDashboardPage() {
		dashboardLink.click();
		return new DashboardPage(driver);
	}

	public TagPage gotoTagsPage() {

		// Hover
		new Actions(driver).moveToElement(posts).perform();

		// Click on the tags - use lazy
		driver.findElement(By.linkText("Tags")).click();

		return new TagPage(driver);

	}

	public void gotoPostsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(postLnk));
		postLnk.click();
	}

	public static boolean isOnPage(WebDriver driver, String pageName) {
		String xpath = "//h1[text()='" + pageName + "']";
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements.size() > 0;
	}
	
	public boolean isOnPage(String pageName) {
		String xpath = "//h1[text()='" + pageName + "']";
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements.size() > 0;
	}
	
	

}
