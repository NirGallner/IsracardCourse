package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link MaslulTeofaPage}
 * @author liraz
 *
 */
public class MaslulTeofaPage {
	
	//c-tor
	public MaslulTeofaPage() {}
	
	/**
	 * Verify we are in MaslulTeofaPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("מסלול תעופה");
	}

}
