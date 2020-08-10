package isracardSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsracardBenefitsPage extends IsracardBasePage{
	
	
	/**
	 * C-tor with WebDriver
	 * @param driver
	 */
	public  IsracardBenefitsPage(WebDriver driver) {
		super(driver);
	}
	
	
	  @FindBy(xpath="//div//a/span[@class=\"iconPersonal\"]")
	  private static WebElement downloadedBenefitsBtn;
	
	  @FindBy (partialLinkText ="כפר בלום")
	  private static WebElement kfarBlumBenefit;
	
	  
	  
	  
	  
	  

	//@FindBy(xpath="//div[@id= \"collapsibleNavbar\"]//ul//li[3]//a")
	//private static   WebElement goToMyAccountBenefitsBtn;
 	
	
	
	
	
	  
	  
	  /**
	   * 
	   * @return
	   */
	  public static IsracardDownloadedBenefitsPage clickDownloadedBenefits() {
		WebDriverWait wait = new WebDriverWait(driver,15,10);
		wait.until(ExpectedConditions.elementToBeClickable(downloadedBenefitsBtn)).click();
		return new IsracardDownloadedBenefitsPage(driver);
		  
	  }
	 
	  /**
	   * Select benefit in all benefits page
	   */
	  public static void selectkfarBlumBenefit() {
		WebDriverWait wait = new WebDriverWait(driver,15,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("כפר בלום"))).click();
	  }
	
	  
	  
	
}
