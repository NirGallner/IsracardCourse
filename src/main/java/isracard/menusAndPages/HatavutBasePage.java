package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HatavutBasePage {

	protected WebDriver driver;
	

	@FindBy (xpath = "//*[@href='9308']")
	private WebElement hatavaKfarBlum;
	
	

	/**
	 * c-tor with WebDriver and pageFactory
	 * @param driver
	 */
	public HatavutBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		

	/**
	 * Click on hatavat Kfar Blum
	 * @return
	 */
	public KfarBlumPage clickOnHatavatKfarBlum() {
		
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(this.hatavaKfarBlum));
		
		//click on Hatava
		hatavaKfarBlum.click();
		
		return new KfarBlumPage(driver);
		
	}
	
	
	
	
	
	
}
