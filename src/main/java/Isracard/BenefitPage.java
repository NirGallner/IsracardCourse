package Isracard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a benefit page
 * @author Moran David
 *
 */

public class BenefitPage extends BaseBenefitsPage  {

	@FindBy(xpath = "//button[@id=\"invokeAcquire\"]")
	private WebElement downloadBenefitBtn;

	@FindBy(xpath = "//div[@class=\"action-zone col-12\"]/span[2]/a[text()=\"לאתר בית העסק\"]")
	private WebElement businessSiteLink;

	@FindBy(xpath = "//button[text()=\"המשך קריאה\"]")
	private WebElement readMoreBtn;

	@FindBy(xpath = "//div[@class=\"col-12 benefit-info-text\"]/div[4]/button")
	private WebElement termAndConditionsBtn;

	@FindBy(xpath = "//div[@class=\"premium-benefit\"]")
	private WebElement premiumBenefitTag;

	/**
	 * constructor
	 * @param driver
	 */
	public BenefitPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * checks if this benefits had a premium tag
	 * @return
	 */
	public boolean isPremium () {
		if (this.premiumBenefitTag == null) {
			return false;
		}
		else if (this.premiumBenefitTag.getText().contentEquals("פרימיום")) {
			return true;
		}
		return false;
	}

	/**
	 * click on business site and check if the correct site opened
	 * @param titleToCheck
	 * @return
	 */
	public boolean checkBusinessSite (String titleToCheck) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(businessSiteLink == null) {
			return false;
		}
		wait.until(ExpectedConditions.visibilityOf(businessSiteLink));
		String originalHandle = driver.getWindowHandle();
		businessSiteLink.click();
		String siteTitle = driver.getTitle();
		if (siteTitle.contains(titleToCheck)) { // check if titles are equals
			driver.switchTo().window(originalHandle); // back to benefit page
			return true;
		}
		driver.switchTo().window(originalHandle); // back to benefit page
		return false;
	}

	/**
	 * click on "read more" link
	 * @return
	 */
	public BenefitPage clickOnReadMore() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(readMoreBtn == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(readMoreBtn));
		readMoreBtn.click();
		return this;
	}

	/**
	 * click on terms and conditions
	 * @return
	 */
	public BenefitPage clickOnTermsAndConditions() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(termAndConditionsBtn == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(termAndConditionsBtn));

		termAndConditionsBtn.click();
		return this;
	}

	/**
	 * click on "download benefit" button
	 * @return
	 * @throws InterruptedException
	 */
	public BenefitsLoginPage downloadBenefit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(downloadBenefitBtn == null) {
			return null;
		}
		wait.until(ExpectedConditions.visibilityOf(downloadBenefitBtn));
		downloadBenefitBtn.click();
		Thread.sleep(5000);
		return new BenefitsLoginPage(driver);
	}
}