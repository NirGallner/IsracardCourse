package demo_site.poms;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//*@id='menu-posts']//*[@class='wp-menu-name']")
	private WebElement postLink;
	
	
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * checks is the driver on dashboard page
	 * @param driver
	 * @return true/ false by comparing the page title to the "Dashboard" string
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Dashboard");
	}
	/**
	 * finds the Posts element and clicks on it 
	 */
	public void gotoPosts() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOf(postLink));
		postLink.click();
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
	
	  

}
