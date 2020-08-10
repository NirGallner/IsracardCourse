package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link OchelVeNishnushimPage}
 * @author liraz
 *
 */
public class OchelVeNishnushimPage {
	
	//c-tor
	public OchelVeNishnushimPage() {}
	
	/**
	 * Verify we are in OchelVeNishnushimPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("אוכל ונשנושים");
	}

}
