package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link ItzovOmutzarimPage}
 * @author liraz
 *
 */
public class ItzovOmutzarimPage {
	
	//c-tor
	public ItzovOmutzarimPage() {}
	
	/**
	 * Verify we are in ItzovOmutzarimPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("עיצוב ומוצרים לבית");
	}


}
