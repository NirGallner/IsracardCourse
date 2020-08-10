package demo_site.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div.[text()= 'Dashboard']")
	private WebElement dashboardLink;

	@FindBy(linkText="Posts")
	//xpath="//*[@class='wp-menu-name']//*[(contains(text(),'Posts')]"
	////*[@id='adminmenu']//*[contains(text(),'Posts')]
	private WebElement postsLink;
	
	/**
	 * access to the dashboard page 
	 * @return new dashboard page
	 */
	public DashboardPage gotoDashboardPage () {
		dashboardLink.click();
        return new DashboardPage(driver);
	}
	/**
	 * performs a hover over the posts to show the hidden menu and then press the tags link
	 * @return new tags page 
	 */
	public TagsPage gotoTagsPage() {
		//Hover
		new Actions(driver).moveToElement(postsLink).perform();
		
		//Click on tags - use lazy
		driver.findElement(By.linkText("Tags")).click();
		
		return new TagsPage(driver);	
	}
	/**
	 * waits until the postslink appears and press it to forward to the posts page
	 */
	public void gotoPostsPage() {
		WebDriverWait wait = new WebDriverWait(driver ,30);
		wait.until(ExpectedConditions.visibilityOf(postsLink));
		postsLink.click();
	}
	
}
