package isracardSite;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsracardAttractionsBenefits extends IsracardBasePage {

	/**
	 * c-tor with WebDriver 
	 * @param driver
	 */
	public  IsracardAttractionsBenefits(WebDriver driver) {
		super(driver);
	}
	
	
   
	 @FindBy (xpath = "//div//div[@class=\"action-zone col-12\"]//a[@href =\"https://www.kayaks.co.il/\"]")
	  private static WebElement businesswebsiteBtn;
	  
	//@FindBy(xpath="//div//div[@class=\"benefit-execution\"]/button[@class=\"read-more-btn position-relative collapsed\"]")
	//  private static WebElement readMoreBtn1;

	//@FindBy(xpath="//div//div[@class=\"position-relative business-info mt-3\"]/button")
	//  private static WebElement readMoreBtn2;
	
	//@FindBy(css =".conditions-wrapper")
	//  private static WebElement conditions;

	//@FindBy(xpath="//div//button[@id=\"invokeAcquire\"]")
	//  private static WebElement benefitDownloadBtn;

	//@FindBy(className="leftHeaderItemMyBenefit")
	//  private static WebElement downloadedBenefitsBtn;

	
	/**
	 * Verify location 
	 * @param driver
	 * @return
	 */
	 public static boolean isOnPage(WebDriver driver) {
			return driver.getTitle().contains("קייקי כפר בלום"); 
		}
	 
	 /**
	  * Verify  benefit is premium
	  * @param driver
	  * @return
	  */
	 public static boolean isPremium(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver,10,10);
			WebElement primiumBenefit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("premium-benefit")));
			boolean primium = primiumBenefit.isDisplayed();
			return primium;
				  
	 }
	 
	 
	 
	  /**
	   * click go to business website from benefit page
	   * @param driver
	   */
	  public static void goToBusinessWebsite(WebDriver driver) {
		  driver.findElement(By.xpath("//div//div[@class=\"action-zone col-12\"]/span//a[@href=\"https://www.kayaks.co.il/\"]")).click();
		  System.out.println("Change page");
    }
	
	  
	  
	  /**
	   * Switch to business website - verifay location - go back to benefit page
	   */
	  public static void switchToBusinessWebsitePage() {
		  WebDriverWait wait = new WebDriverWait(driver,10,10);

		  String originalHandle = driver.getWindowHandle();
		  goToBusinessWebsite(driver);
		  
		  try {
	
			for (String windowHandle : driver.getWindowHandles()) {
					
				if (!windowHandle.equals(originalHandle)) {
					driver.switchTo().window(windowHandle);
					System.out.println(driver.getTitle());
				}	
			}

			try { 
				 assertEquals("קיאקים בנהר הירדן - קייקי כפר בלום", driver.getTitle());

			}finally {
				driver.close();
			}
			
		  }finally {
			  driver.switchTo().window(originalHandle);
			  System.out.println(driver.getTitle());
			
			}	
		 
	  }	    

	  
	  /**
	   * Click on read more and conditions buttons in benefit page
	   * @param driver
	   */
	  public static void moreInfoBtns(WebDriver driver) {
		  WebDriverWait wait = new WebDriverWait(driver,10,10);
		  WebElement readMoreBtn1 = driver.findElement(By.xpath("//div//div[@class=\"benefit-execution\"]/button[@class=\"read-more-btn position-relative collapsed\"]"));
		  readMoreBtn1.click();
		  WebElement readMoreBtn2 = driver.findElement(By.xpath("//div//div[@class=\"position-relative business-info mt-3\"]/button"));
		  readMoreBtn2.click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@id=\"businessDetails\"]//strong[2] ")));
		  WebElement conditions = driver.findElement(By.cssSelector(".conditions-wrapper"));
		  conditions.click();
		 
	  }
		  
	  /**
	   * click on download benefit btn.
	   * @return
	   */
	  public static IsracardDownloadedBenefitsPage clickdownloadBenefit() {
		  WebDriverWait wait = new WebDriverWait(driver,10,10);

		  WebElement benefitDownloadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='invokeAcquire'][type='button']")));
		  benefitDownloadBtn.click();
		  
		  return new IsracardDownloadedBenefitsPage(driver);
		  
		  
		  
		   
		  
	  }
		  
		  
		  
		 
		  
	//  }
	  
  }




