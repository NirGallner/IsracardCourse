package selenium.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCardsPage extends BasePage {

	public MyCardsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="/personalarea/transaction-list/?cardIndex=0")
	private WebElement chargesDetails;
	
	public WebElement getChargesDetails() {
		return chargesDetails;
	}
	
	

}
