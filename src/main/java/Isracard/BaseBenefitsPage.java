package Isracard;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a base benefits page
 * @author Moran David
 *
 */

public class BaseBenefitsPage {

	protected WebDriver driver;

	@FindBy(xpath = "//div[2][@class =\"desktop-menu d-none d-md-block d-lg-block\"]/ul/li/a")
	private List<WebElement> benefitsCategoryList;

	@FindBy (id = "PersonalAreaLink")
	private WebElement myBenefitsLink;

	/**
	 * constructor
	 * @param driver
	 */
	public BaseBenefitsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * click on a specific category on the benefits header
	 * @param categoryName
	 * @return true if the specific category found, else: false
	 * @throws InterruptedException 
	 */
	public CategoryPage getCategoryList(String categoryName) throws InterruptedException {

		//Checks if benefitsCategoryList element is null
		if(benefitsCategoryList == null) {
			return null;
		}

		//gets category names into a list
		for (int i=0 ; i< benefitsCategoryList.size(); i++) {
			// checks if the category name i want to click on equals to one of the category name on the list
			if (benefitsCategoryList.get(i).getText().contentEquals(categoryName)) { 
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(benefitsCategoryList.get(i)));
				// click on the category name i wanted to click on
				benefitsCategoryList.get(i).click();
				Thread.sleep(5000);
				return new CategoryPage(driver);
			}
		}
		return null; 
	}

	/**
	 * goto benefits login page page
	 */
	public BenefitsLoginPage gotoMyBenefitsPage () throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (myBenefitsLink == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(myBenefitsLink));
		myBenefitsLink.click();
		Thread.sleep(5000);
		return new BenefitsLoginPage(driver);
	}

	/**
	 * checks if you are on the correct page
	 * @param pageName
	 * @return true if you are on the correct page, else false
	 */
	public boolean isOnPage(String pageName) {
		String title = driver.getTitle();
		if (title.contains(pageName)) {
			return true;
		}
		return false;
	}

}