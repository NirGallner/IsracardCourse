package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link TarbutVePnaiPage}
 * @author liraz
 *
 */
public class TarbutVePnaiPage {
	
	//c-tor
	public TarbutVePnaiPage() {}
	
	/**
	 * Verify we are in TarbutVePnaiPage page
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("תרבות ופנאי");
	}

}
