package course.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id='menu-posts']//*[@class='wp-menu-name']")
	private WebElement postLink;
	
	public DashboardPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static boolean isOnPage (WebDriver driver) {
		return driver.getTitle().contains("Dashboard");
	}
	
	public void gotoPost() {
		WebDriverWait wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOf(postLink));
		postLink.click();
	}
}
