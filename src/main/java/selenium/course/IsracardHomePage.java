package selenium.course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IsracardHomePage extends BasePage{
	
	public IsracardHomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="#collapse1 > div > a:nth-child(2)")
	private WebElement myCardsButton;
	
	@FindBy(linkText="#collapse2")
	private WebElement accountActions;
	
	@FindBy(className="dashboard__box dashboard__box-new ng-scope")
	private WebElement dashboard;
	
	@FindBy(css="#collapse2 > div > a:nth-child(7)")
	private  WebElement updatePasswordButton;
	
	@FindBy(linkText="https://benefits.isracard.co.il/")
	private WebElement benefitsTab;
	
	public WebElement getMyCardsButton() {
		return myCardsButton;
	}
	
	public WebElement getAccountActions() {
		return accountActions;
	}
	
	public WebElement getBenefitsTab() {
		return benefitsTab;
	}
	
	public boolean isThisHomePage() {
		boolean isIt = false;
		
		if(dashboard.isDisplayed()) {
			isIt = true;
		}
		
		return isIt;
	}
	
	public void clickOnUpdatePassword() {
		accountActions.click();
		updatePasswordButton.click();
	}
	

}
