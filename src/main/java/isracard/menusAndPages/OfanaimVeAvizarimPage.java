package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link OfanaimVeAvizarimPage}
 * @author liraz
 *
 */
public class OfanaimVeAvizarimPage {

	//c-tor
	public OfanaimVeAvizarimPage() {}
	
	/**
	 * Verify we are in OfanaimVeAvizarimPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("אופנה ואביזרים");
	}
}
