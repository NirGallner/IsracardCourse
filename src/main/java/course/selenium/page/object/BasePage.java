package course.selenium.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import course.selenium.webdriver.WebDriverManager;

public class BasePage extends WebDriverManager{

	private static WebElement pageH1Title;

	public BasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static void waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static boolean checkH1PageTitle(String h1Title) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		pageH1Title = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("wp-heading-inline"))));
		
		return pageH1Title.getText().equalsIgnoreCase(h1Title);
	}

	public static boolean isOnPage(WebDriver driver, String title) {
		return driver.getTitle().toLowerCase().contains(title.toLowerCase());
	}
	

}
