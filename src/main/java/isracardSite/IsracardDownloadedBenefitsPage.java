package isracardSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsracardDownloadedBenefitsPage extends IsracardBasePage{

	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public IsracardDownloadedBenefitsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (className = "col-lg-6 single-coupon")
	private static WebElement benefitCoupon;

	@FindBy (xpath = "//div//button[@class=\"cancel-btn text-right\"]")
	private static WebElement deleteBenefitBtn;

	@FindBy(className ="//div/div//span[@class=\"bonusToUse\"]")
	private WebElement numberOfBenefitsForUse;
	
	@FindBy (linkText ="קייקי כפר בלום - שייט 1+1")
	private static WebElement couponNameBefore;

	
	@FindBy (id = "IdNumber")
	private  WebElement idField;
	
	@FindBy (name = "CardNumberSuffix")
	private  WebElement sixDigitsField;
	
	@FindBy (xpath = "//div//div/input[@id=\"loginFormBtn\"]")
	private  WebElement continueBtn;
	
	
	
	/**
	 * verify location - downloaded Benefits Page
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("אזור אישי"); 
	}
	
	
	
	/**
	 * Delete benefit 
	 */
	public static void deleteBenefit() {
	  WebDriverWait wait = new WebDriverWait(driver,10,10);
	  
	  wait.until(ExpectedConditions.visibilityOf(benefitCoupon));
	  boolean couponName = couponNameBefore.isDisplayed();
	  System.out.println(couponName);
	  deleteBenefitBtn.click();
	  WebElement cancelBenefitPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("benefit-failed-title-coupon")));
	 
	  WebElement cancelBtn = driver.findElement(By.className("btn btn-blue cancel_btn"));
	  cancelBtn.click();
	  boolean couponNameAfter = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("קייקי כפר בלום - שייט 1+1")));
	  System.out.println(couponNameAfter);

	}
	
	/**
	 * sendkeys to id field in login to benefits world page
	 * @param id
	 * @return
	 */
	public  IsracardDownloadedBenefitsPage enterId(String id) {
		this.idField.sendKeys(id);
		return this; 
	}

	/**
	 * sendKeys to six digits field in login to benefits world page
	 * @param sixDigits
	 * @return
	 */
	public IsracardDownloadedBenefitsPage enterSixDigits (String sixDigits) {
		this.sixDigitsField.sendKeys(sixDigits);
		return this;
	}
	
	/**
	 * Click on continue btn in login to benefits world page
	 */
	public void clickContinue() {
		continueBtn.click();
	}
	
	/**
	 * Go back to all benefits page after benefit download
	 * @return
	 */
	public static IsracardBenefitsPage backToBenefitsPage() {
	  WebDriverWait wait = new WebDriverWait(driver,10,10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'בחזרה לדף הבית')]"))).click();
	  return new IsracardBenefitsPage(driver);
	
	}
}





