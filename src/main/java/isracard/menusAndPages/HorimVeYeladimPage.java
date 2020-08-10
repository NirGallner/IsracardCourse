package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link HorimVeYeladimPage}
 * @author liraz
 *
 */
public class HorimVeYeladimPage {

	
	//c-tor
		public HorimVeYeladimPage() {}
		
	/**
	 * Verify we are in HorimVeYeladimPage
	 * @param driver
	 * @return
	 */	
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("הורים וילדים");
	}
}