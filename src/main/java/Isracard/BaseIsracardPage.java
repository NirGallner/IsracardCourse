package Isracard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Represents a base isracard page
 * @author Moran David
 *
 */

public class BaseIsracardPage {

	protected WebDriver driver;

	@FindBy(xpath = "//a[@class=\"site-header__logo-link\"]")
	private WebElement homePageLink; 

	@FindBy (linkText = "החשבון שלי")
	private WebElement dashboardLink; 

	@FindBy(xpath = "//ul[@class=\"bottom-links\"]/li[2]/a")
	private WebElement dealsAndChargesLink; 

	@FindBy(linkText = "הטבות")
	private WebElement benefitsPageLink;

	// Benefits list
	@FindBy (xpath = "//ul[@class=\"site-footer__nav-list-top-level\"]/li[5]/ul/li/a")
	private List<WebElement> benefitsList; 

	/** constructor
	 * 
	 * @param driver
	 */
	public BaseIsracardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Gets into a list all the names of the categories from the footer
	 * @param linksText
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean goOverBenefitsFooter(List<String> linksText, String homepageHandle) throws InterruptedException { 

		if (linksText.size() == 0 || benefitsList.size() == 0 || linksText == null || benefitsList == null)
			return false;

		boolean passed = true;
		for (int i=1;i<benefitsList.size()+1;i++) {
			Thread.sleep(2000); 
			// Gets the names of the benefits category from the footer into a list
			try {
				WebElement benefitListElement = driver.findElement(By.xpath("//ul[@class=\"site-footer__nav-list-top-level\"]/li[5]/ul/li[" + i +"]/a"));
				String category = benefitListElement.getText();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(benefitListElement));
				benefitListElement.click(); // click on a category
				Thread.sleep(5000); 
				// checks if the correct page opened
				if (!linksText.contains(driver.getTitle())) {
					passed = false;
					System.out.println(String.format("Problem on %s\n", category));
				}
				Thread.sleep(2000); 
				WebElement goBackToFinancialHomePage = driver.findElement(By.xpath("//a[text()=\"מעבר לחשבון שלי\"]"));
				wait.until(ExpectedConditions.visibilityOf(goBackToFinancialHomePage)); 
				// go back to financial home page
				goBackToFinancialHomePage.click();
				Thread.sleep(5000); 
			}
			catch (Exception e) {
				return false;
			}
		}

		return passed;
	}

	/**
	 * go to dashboard by click on "Enter my account" button (on the right menu)
	 * @return
	 */
	public FinancialLoginPage goToDashBoardPage () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// checks if the element founded
		if(dashboardLink == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(dashboardLink));
		dashboardLink.click();
		Thread.sleep(5000); 
		return new FinancialLoginPage(driver);
	}

	/**
	 * click on deals and charges link (on the right menu)
	 * @return
	 * @throws InterruptedException 
	 */
	public FinancialLoginPage goToDealsAndChargesPage () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// checks if the element founded
		if(dealsAndChargesLink == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(dealsAndChargesLink));
		dealsAndChargesLink.click();
		Thread.sleep(5000); 
		return new FinancialLoginPage(driver);
	}

	/**
	 * click on Isracard logo link (on the header)
	 * @return
	 * @throws InterruptedException 
	 */
	public FinancialHomePage goToFinancialHomePage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// checks if the element founded
		if(homePageLink == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(homePageLink));
		homePageLink.click();
		Thread.sleep(5000); 
		return new FinancialHomePage(driver); 
	}

	/**
	 * click on benefits link (on the header)
	 * @return
	 * @throws InterruptedException 
	 */
	public BenefitsHomePage goToBenefitsPage () throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// checks if the element founded
		if(benefitsPageLink == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(benefitsPageLink));
		benefitsPageLink.click();
		Thread.sleep(5000);
		return new BenefitsHomePage (driver);
	}

	/**
	 * checks if you are in the correct page
	 * @param pageName
	 * @return true if you are if the correct page, else return false
	 */
	public boolean isOnPage(String pageName) {
		String title = driver.getTitle();
		if (title.contains(pageName)) {
			return true;
		}
		return false;
	}
}