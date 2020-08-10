package isracard.menusAndPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * represents {@link HatavotPage}
 * @author liraz
 *
 */
public class HatavotPage extends HatavutBasePage {
		
	@FindBy (linkText = "ישראכרט אתר ההטבות")
	private WebElement pageName;
	

	
	/**
	 * c-tor
	 * @param driver
	 */
	public HatavotPage(WebDriver driver) {
		super(driver);
		
	}

	/**
	 * Verify we are in HatavotPage
	 * @param driver
	 * @return
	 */
	public static boolean isInHatavotPage(WebDriver driver) {
		return driver.getTitle().contains("ישראכרט אתר ההטבות");
	}
	
	
	public String getPageName() {
		return pageName.getText();
	}
	
}
