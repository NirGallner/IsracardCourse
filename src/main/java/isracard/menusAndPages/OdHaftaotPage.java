package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link OdHaftaotPage}
 * @author liraz
 *
 */
public class OdHaftaotPage {
	
	//c-tor
	public OdHaftaotPage() {}
	
	/**
	 * Verify we are in OdHaftaotPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("עוד הפתעות");
	}
	

}
