package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link HatavutPrimiumPage}
 * @author liraz
 *
 */
public class HatavutPrimiumPage {

	public HatavutPrimiumPage() {}
	
	/**
	 * Verify we are in HatavutPrimiumPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("הטבות פרימיום");
	}
	
}
