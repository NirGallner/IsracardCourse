package Isracard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a benefit category page 
 *@author Moran David
 *
 */

public class CategoryPage extends BaseBenefitsPage {
	
	@FindBy(xpath = "//div[@class=\"row category-items-row\"]/button")
	private List<WebElement> benefitsList;
	
	@FindBy(xpath = "//div[@class=\"row category-items-row\"]/button/div/div[2]/div/div[2]")
	private List<WebElement> benefitsListTexts;
	
	/**
	 * constructor
	 * @param driver
	 */
	public CategoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * click on a specific benefits name
	 * @return true if the specific benefit found, else: false
	 * @throws InterruptedException 
	 */
	public BenefitPage getBenefitsList (String benefitName) throws InterruptedException {
		if(benefitsList == null) {
			return null;
		}
		// Gets all of the names & buttons of the benefits into a list and click on the benefit you want to enter
		for (int i =0; i<benefitsList.size(); i++) {
			String benefitText = benefitsListTexts.get(i).getText();
			if(benefitText.contains(benefitName)) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(benefitsList.get(i)));
				benefitsList.get(i).click();
				Thread.sleep(5000); 
				return new BenefitPage(driver);
			}
		}
		return null;
	}

}
