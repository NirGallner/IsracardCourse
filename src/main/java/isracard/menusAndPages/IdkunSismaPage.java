package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * represents {@link IdkunSismaPage}
 * @author liraz
 *
 */
public class IdkunSismaPage extends IsracardBasePage{

	@FindBy (linkText = "עדכון סיסמא")
	private WebElement pageName;
	
	
	//c-tor
	public IdkunSismaPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Verify we are in IdkunSismaPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnIdkunSismaPage(WebDriver driver) {
		
		//return true if the correct page opened else return false, the missing א/ה is because the page name appears in different ways
		return driver.getTitle().contains("עדכון סיסמ");
	}
	
	
	/**
	 * return the page name
	 * @return
	 */
	public String getPageName() {
		return pageName.getText();
	}

}
