package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link AtraktziutPage}
 * @author liraz
 *
 */
public class AtraktziutPage {

	//c-tor
	public AtraktziutPage() {}
	
	/**
	 * Verify we are in AtraktziutPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("אטרקציות");
	}
	
}
